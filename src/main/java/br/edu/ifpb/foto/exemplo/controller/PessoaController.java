/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.foto.exemplo.controller;

import br.edu.ifpb.foto.exemplo.domain.Pessoa;
import br.edu.ifpb.foto.exemplo.infra.FotoManagement;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.servlet.http.Part;

/**
 *
 * @author recursivejr
 */

@Named
@RequestScoped
public class PessoaController {
    
    private Pessoa pessoa = new Pessoa();
    private Part foto;
    @Inject
    private EntityManager manager;
    
    public String salvar() throws IOException {
        pessoa.setFoto(FotoManagement.encodeFoto(foto));
        manager.getTransaction().begin();
        manager.persist(pessoa);
        manager.getTransaction().commit();
        FotoManagement.decodeFoto(pessoa.getFoto());
        return null;
    } 

    public Part getFoto() {
        return foto;
    }

    public void setFoto(Part foto) {
        this.foto = foto;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
    public List<Pessoa> todos() {
        return manager.createQuery("FROM Pessoa p", Pessoa.class).getResultList();
    }
    
}
