/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

import business.model.ModeloUsuario;
import infra.Arquivo;
import business.model.Usuario;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import view.Tela;

/**
 *
 * @author marti
 */
public class ControleLogin {
    ModeloUsuario model;
    Arquivo arquivo;
    Verificador verificador;

    public ControleLogin() throws IOException {
        this.arquivo = new Arquivo("..\\MPSlab_Login\\usuarios.txt");
        this.model = new ModeloUsuario(arquivo.carregarUsuarios());
        this.verificador = new Verificador();
    }
    
    
    
    public void criarUsuario(String login, String senha) {
        
        try{
            
            if ( model.existeUsuario(login) != -1 ) {
                System.out.println(login + " e um nome de usuario ja cadastra");
             
            } else {
                verificador.verificarLogin(login);
                verificador.verificarSenha(senha);
            
                Usuario usuario = new Usuario(login, senha);
                model.cadastrarUsuario(usuario);
            }
            
        } catch (ExcecoesLogin | ExcecoesSenha ex) {
            System.err.print(ex);
            //Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
              
    }
    
    //apenas para buscar
    public boolean buscarUsuario (String login) {
        if(model.existeUsuario(login) != -1) {
            return true;
        }
        return false;
    }
    
    //solicitar senha antes de remover
    public int solicitarRemocao(String login, String senha) {
     
        int pos = model.existeUsuario(login);
        //se posicao == -1, entao nao foi encontrado usuario
        if ( pos != -1 ) {
            if ( model.conferirSenhaUsuario(pos, senha)) {
                return pos;
            }
        }
        return -1;
    }
    
    //mmetodo de remover usuario conhecendo a posicao
    public void removerUsuario(int pos) {
        model.descadastrarUsuario(pos);
        System.out.println("Usuario removido \n");
             
    }
    
    //mudar metodo, colocar o verificador no solicitar remocao
    public void removerUsuario(String login, String senha, int pos) {
        try {
            verificador.verificarLogin(login);
            verificador.verificarSenha(senha);
            
            //model.descadastrarUsuario(login, senha);
            model.descadastrarUsuario(pos);
            System.out.println("Usuario removido \n");
        } catch (ExcecoesLogin | ExcecoesSenha ex) {
            System.err.print(ex);
            //Logger.getLogger(ControleLogin.class.getName()).log(Level.SEVERE, null, ex);
        }     
    }
    
    public void salvar () throws IOException {
        arquivo.guardarUsuarios(model.getUsuarios());
    }

    public void listarUsuarios () {
        System.out.println(model.listarUsuarios());
    }

    
    
}
