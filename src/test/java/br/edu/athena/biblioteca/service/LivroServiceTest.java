
package br.edu.athena.biblioteca.service;

import br.edu.athena.biblioteca.model.Livro;
import br.edu.athena.biblioteca.repository.LivroRepository;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LivroServiceTest {
    private final LivroRepository livroRepository = new LivroRepository();
    private final LivroService livroService = new LivroService(livroRepository);

    @Test
    void deveCadastrarLivroComDadosValidos() {
        Livro livro = new Livro("O Hobbit", "J. R. R. Tolkien", 3);

        Livro resultado = livroService.cadastrar(livro);

        assertEquals("O Hobbit", resultado.getTitulo());
        assertEquals(3, resultado.getQuantidade());
    }

    @Test
    void naoDeveCadastrarLivroComQuantidadeMenorQueUm() {
        Livro livro = new Livro("O Hobbit", "J. R. R. Tolkien", 0);

        assertThrows(IllegalArgumentException.class,
                () -> livroService.cadastrar(livro));
    }

    @Test
    void naoDeveCadastrarLivroSemTitulo() {
        Livro livro = new Livro(" ", "J. R. R. Tolkien", 1);

        assertThrows(IllegalArgumentException.class,
                () -> livroService.cadastrar(livro));
    }

    @Test
    void livroCadastradoDeveAparecerNaBusca() {
        livroService.cadastrar(
                new Livro("Alice no País das Maravilhas", "Lewis Carroll", 2));

        List<Livro> encontrados =
                livroService.buscarPorTitulo("Alice");

        assertEquals(1, encontrados.size());
        assertEquals("Alice no País das Maravilhas",
                encontrados.get(0).getTitulo());
    }
}
