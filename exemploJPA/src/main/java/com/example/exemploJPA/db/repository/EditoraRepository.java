package com.example.exemploJPA.db.repository;


import com.example.exemploJPA.db.entity.Editora;
import com.example.exemploJPA.db.entity.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EditoraRepository extends JpaRepository<Editora, Long>
{
    public List<Editora> findAllByNome(String Nome);
}
