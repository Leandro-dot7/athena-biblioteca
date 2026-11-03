package br.edu.athena.biblioteca.controller;

import br.edu.athena.biblioteca.model.Livro;
import br.edu.athena.biblioteca.service.LivroService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {
    private final LivroService livroService;

    public LivroController(LivroService livroService) {
        this.livroService = livroService;
    }

    @PostMapping
    public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro) {
        Livro cadastrado = livroService.cadastrar(livro);
        return ResponseEntity.status(HttpStatus.CREATED).body(cadastrado);
    }

    @GetMapping
    public ResponseEntity<List<Livro>> buscarPorTitulo(
            @RequestParam("titulo") String titulo) {
        return ResponseEntity.ok(livroService.buscarPorTitulo(titulo));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<String> tratarDadosInvalidos(
            IllegalArgumentException erro) {
        return ResponseEntity.badRequest().body(erro.getMessage());
    }
}