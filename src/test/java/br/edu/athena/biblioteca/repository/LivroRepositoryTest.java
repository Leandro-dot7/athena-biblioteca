package br.edu.athena.biblioteca.repository;

import br.edu.athena.biblioteca.model.Livro;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertTrue;

class LivroRepositoryTest {
    @Test
    void buscaDeveContinuarQuandoOutroLivroForCadastrado() throws Exception {
        LivroRepository repository = new LivroRepository();
        CountDownLatch buscaIniciada = new CountDownLatch(1);
        CountDownLatch continuarBusca = new CountDownLatch(1);
        Livro livroComBuscaPausada = new Livro("Livro 1", "Autora", 1) {
            @Override
            public String getTitulo() {
                buscaIniciada.countDown();
                try {
                    if (!continuarBusca.await(5, TimeUnit.SECONDS)) {
                        throw new IllegalStateException("Busca nao foi liberada a tempo");
                    }
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    throw new IllegalStateException("Busca interrompida", e);
                }
                return super.getTitulo();
            }
        };
        repository.salvar(livroComBuscaPausada);
        repository.salvar(new Livro("Livro 2", "Autora", 1));

        ExecutorService executor = Executors.newSingleThreadExecutor();
        try {
            Future<List<Livro>> busca = executor.submit(() -> repository.buscarPorTitulo("Livro"));
            assertTrue(buscaIniciada.await(5, TimeUnit.SECONDS), "A busca nao iniciou");
            repository.salvar(new Livro("Livro 3", "Autora", 1));
            continuarBusca.countDown();

            List<Livro> encontrados = assertDoesNotThrow(() -> busca.get(5, TimeUnit.SECONDS));
            assertTrue(encontrados.size() >= 2);
        } finally {
            continuarBusca.countDown();
            executor.shutdownNow();
        }
    }
}