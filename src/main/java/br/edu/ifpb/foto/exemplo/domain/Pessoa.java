/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.foto.exemplo.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

/**
 *
 * @author recursivejr
 */

@Entity
@SequenceGenerator(name = "pessoa_seq", sequenceName = "pessoa_seq")
public class Pessoa implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "pessoa_seq")
    private int id;
    @Column(length = 40, nullable = false, unique = true)
    private String nome;
    @Column(columnDefinition = "VARCHAR")
    private String foto;

    public Pessoa() {
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
}
