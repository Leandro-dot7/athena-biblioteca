package br.edu.athena.biblioteca.repository;

import br.edu.athena.biblioteca.model.Livro;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LivroRepository {
    private final List<Livro> livros = new ArrayList<>();

    public Livro salvar(Livro livro) {
        livros.add(livro);
        return livro;
    }

    public List<Livro> buscarPorTitulo(String termo) {
        List<Livro> encontrados = new ArrayList<>();

        if (termo == null || termo.isBlank()) {
            return encontrados;
        }

        for (Livro livro : livros) {
            if (livro.getTitulo() != null
                    && livro.getTitulo().toLowerCase().contains(termo.toLowerCase())) {
                encontrados.add(livro);
            }
        }

        return encontrados;
    }
}