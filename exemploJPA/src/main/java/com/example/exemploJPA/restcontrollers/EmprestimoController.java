package com.example.exemploJPA.restcontrollers;

import com.example.exemploJPA.db.entity.EmpLivro;
import com.example.exemploJPA.db.entity.Emprestimo;
import com.example.exemploJPA.db.entity.Livro;
import com.example.exemploJPA.db.repository.EmprestimoRepository;
import com.example.exemploJPA.db.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/emprestimo")
public class EmprestimoController {
    @Autowired
    private EmprestimoRepository repo;

    @GetMapping("buscar_id/{id}")
    public ResponseEntity<Object> buscarTodos(@PathVariable("id") Long id)
    {
        Optional<Emprestimo> oemprestimo=repo.findById(id);
        if(oemprestimo.isEmpty())
            return ResponseEntity.badRequest().body("emprestimo não encontrado");
        else
            return ResponseEntity.ok(oemprestimo.get());
    }

    @PostMapping(value = "realizar-emprestimo")
    public ResponseEntity<Object> realizarEmprestimo(@RequestBody Emprestimo emp)
    {
        List<Emprestimo> emprestimo = repo.findAll();
        for (Emprestimo e : emprestimo) {
            List<EmpLivro> listLivro = e.getLivros();
            for(EmpLivro el : listLivro) {
                if(emp.getLivros().contains(el.getLivro())) {
                   return ResponseEntity.badRequest().body("Livro "+el.getLivro().getTitulo()+" já emprestado");
                }
            }
        }
        repo.save(emp);
        return ResponseEntity.ok(emp);
    }
}
