package service;
import br.edu.athena.biblioteca.model.Livro;
import br.edu.athena.biblioteca.repository.LivroRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroService(LivroRepository livroRepository) {
        this.livroRepository = livroRepository;
    }

    public Livro cadastrar(Livro livro) {
        validar(livro);
        return livroRepository.salvar(livro);
    }

    public List<Livro> buscarPorTitulo(String termo) {
        return livroRepository.buscarPorTitulo(termo);
    }

    private void validar(Livro livro) {
        if (livro == null) {
            throw new IllegalArgumentException("Os dados do livro são obrigatórios.");
        }

        if (livro.getTitulo() == null || livro.getTitulo().isBlank()) {
            throw new IllegalArgumentException("Informe o título do livro.");
        }

        if (livro.getAutor() == null || livro.getAutor().isBlank()) {
            throw new IllegalArgumentException("Informe o autor do livro.");
        }

        if (livro.getQuantidade() < 1) {
            throw new IllegalArgumentException("A quantidade deve ser maior ou igual a 1.");
        }
    }
}
