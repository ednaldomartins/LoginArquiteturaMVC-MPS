/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.model;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author marti
 */
public class ModeloUsuario {

    HashMap < String, Usuario > u;
    ArrayList <Usuario> usuarios;

    //Construtor apenas para intanciar
    public ModeloUsuario() {
        this.usuarios = new ArrayList();
    }

    //Construtor para Instanciar e carregar usuarios do arquivo
    public ModeloUsuario(ArrayList<Usuario> usuarios) {
        this.usuarios = new ArrayList();
        this.usuarios.addAll(usuarios);
    }
    
    //verficar usuario
    public int existeUsuario(String login) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login) ) {
                return i;
            }
        }
        return -1;
    }
    
    //conferir senha conhecendo a posicao do usuario
    public boolean conferirSenhaUsuario(int pos, String senha) {
        if(usuarios.get(pos).getSenha().equals(senha) )
            return true;
        
        return false;
    }
    
    //conferir senha com login e senha
    public boolean conferirSenhaUsuario(String login, String senha) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login) ) {
                if(usuarios.get(i).getSenha().equals(senha) )
                return true;
                
            }
        }
        return false;
    }

    //cadastrar usuario apos passar na verificacao
    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }
    
    //descadastrar usuario conhecendo a posicao
    public void descadastrarUsuario(int pos) {
        usuarios.remove(pos);
    }
    
    public void descadastrarUsuario(String login, String senha) {
        for(int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getLogin().equals(login) ) {
                usuarios.remove(i);
                i = usuarios.size();
            }
        }
    }
    
    
    /*geralmente usado apenas para teste*/
    
    //pegar o array de usuarios
    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    //setar o array de usuarios
    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    public String listarUsuarios() {
        String loginUsuario = "";
        for (Usuario usuario:this.usuarios) {
            loginUsuario = loginUsuario + usuario.getLogin() + "\n";
        }
        return loginUsuario;
    }

    
}
