package com.jvtavares.horariosescolares.model;

import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.util.List;

@Entity
public class Professor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String materia;
    private int maxAulas;

    @ElementCollection
    private List<String> disponibilidade; // agora é uma lista de strings

    public Professor() {
    }

    public Professor(String nome, String materia, List<String> disponibilidade, int maxAulas) {
        this.nome = nome;
        this.materia = materia;
        this.disponibilidade = disponibilidade;
        this.maxAulas = maxAulas;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public List<String> getDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(List<String> disponibilidade) {
        this.disponibilidade = disponibilidade;
    }

    public void setMaxAulas(int maxAulas) {
        this.maxAulas = maxAulas;
    }

    public int getMaxAulas() {
        return maxAulas;
    }
}