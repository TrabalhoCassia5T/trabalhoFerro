package com.example.exemploJPA.db.entity;

import jakarta.persistence.*;

@Entity
@Table(name="editora")
public class Editora {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="edi_id")
    private Long id;
    @Column(name="edi_nome")
    private String nome;
    @Column(name="edi_local")
    private String local;

    public Editora() {
    }

    public Editora(Long id, String nome, String local) {
        this.id = id;
        this.nome = nome;
        this.local = local;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
