package com.example.exemploJPA.db.repository;

import com.example.exemploJPA.db.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long>
{
    public List<Cliente> findAllByNome(String Nome);


}
