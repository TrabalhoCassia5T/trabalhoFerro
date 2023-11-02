package com.example.exemploJPA.restcontrollers;

import com.example.exemploJPA.db.entity.Cliente;
import com.example.exemploJPA.db.entity.Editora;
import com.example.exemploJPA.db.repository.ClienteRepository;
import com.example.exemploJPA.db.repository.EditoraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
@RestController
@RequestMapping("/api/cliente")
public class ClienteController
{
        @Autowired
        private ClienteRepository repo;
        @GetMapping("buscar_todos")
        public ResponseEntity<Object> buscarTodos()
        {
            return ResponseEntity.ok(repo.findAll());
        }
        @GetMapping("buscar_id/{id}")
        public ResponseEntity<Object> buscarTodos(@PathVariable("id") Long id)
        {
            Optional<Cliente> cliente=repo.findById(id);
            if(cliente.isEmpty())
                return ResponseEntity.badRequest().body("cliente não encontrado");
            else
                return ResponseEntity.ok(cliente.get());
        }
        @GetMapping("buscar_nome/{nome}")
        public ResponseEntity<Object> buscarNome(@PathVariable("nome") String nome)
        {
            return ResponseEntity.ok(repo.findAllByNome(nome));
        }

        @PostMapping("incluir")
        public ResponseEntity<Object> incluir(@RequestBody Cliente cliente)
        {
            return ResponseEntity.ok(repo.save(cliente));
        }

        @PostMapping("alterar")
        public ResponseEntity<Object> alterar(@RequestBody Cliente cliente)
        {
            return ResponseEntity.ok(repo.save(cliente));
        }
        @GetMapping("apagar/{id}")
        public void apagar(@PathVariable Long id)
        {
            repo.deleteById(id);
        }

}
