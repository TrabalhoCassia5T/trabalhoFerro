package com.example.exemploJPA.restcontrollers;

import com.example.exemploJPA.db.entity.Editora;
import com.example.exemploJPA.db.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/editora")
public class EditoraController
{
    @Autowired
    private EditoraRepository repo;
    @GetMapping("buscar_todos")
    public ResponseEntity<Object> buscarTodos()
    {
        return ResponseEntity.ok(repo.findAll());
    }
    @GetMapping("buscar_id/{id}")
    public ResponseEntity<Object> buscarTodos(@PathVariable("id") Long id)
    {
        Optional<Editora> editora=repo.findById(id);
        if(editora.isEmpty())
            return ResponseEntity.badRequest().body("editora não encontrado");
        else
            return ResponseEntity.ok(editora.get());
    }
    @GetMapping("buscar_nome/{nome}")
    public ResponseEntity<Object> buscarTitulo(@PathVariable("nome") String nome)
    {
        return ResponseEntity.ok(repo.findAllByNome(nome));
    }

    @PostMapping("incluir")
    public ResponseEntity<Object> incluir(@RequestBody Editora editora)
    {
        return ResponseEntity.ok(repo.save(editora));
    }

    @PostMapping("alterar")
    public ResponseEntity<Object> alterar(@RequestBody Editora editora)
    {
        return ResponseEntity.ok(repo.save(editora));
    }
    @GetMapping("apagar/{id}")
    public void apagar(@PathVariable Long id)
    {
        repo.deleteById(id);
    }
}
