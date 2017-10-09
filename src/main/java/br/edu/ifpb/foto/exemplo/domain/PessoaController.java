/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifpb.foto.exemplo.domain;

import br.edu.ifpb.foto.exemplo.infra.EntityManagerProducer;
import br.edu.ifpb.foto.exemplo.infra.FotoManagement;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.EntityManager;

/**
 *
 * @author recursivejr
 */

@Named
@RequestScoped
public class PessoaController {
    
    private Pessoa pessoa = new Pessoa();
    private File foto;
    @Inject private EntityManager manager;
    
    public String salvar() throws IOException {
        pessoa.setFoto(FotoManagement.encodeFoto(foto));
        manager.persist(pessoa);
        FotoManagement.decodeFoto(pessoa.getFoto());
        return null;
    } 

    public File getFoto() {
        return foto;
    }

    public void setFoto(File foto) {
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
