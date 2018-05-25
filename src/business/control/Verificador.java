/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.control;

/**
 *
 * @author marti
 */
public class Verificador {
    
    public boolean verificarLogin (String login) throws ExcecoesLogin
    {
        
        if(login == "") {
            throw new ExcecoesLogin("Login invalido, digite alguma coisa.");
        }
        
        if(login.length() > 15) {
            throw new ExcecoesLogin(login + " e um login invalido, o tamanho maximo do login permitido é de apenas 15 digitos.");
        }
        
        if( login.matches(".*\\d.*") ) {
            throw new ExcecoesLogin(login + " e um login invalido, apenas letras sao permitidas no login de usuario.");    
        }
        
        return true;
        
    }
    
    public boolean verificarSenha (String senha) throws ExcecoesSenha 
    {
        
        if(senha.length() > 18) {
            throw new ExcecoesSenha(senha + " e uma senha invalida, o tamanho maximo permitido para a senha e de 18 digitos.");
        }
        
        if(senha.length() < 6) {
            throw new ExcecoesSenha(senha + " e uma senha invalida, o tamanho minimo permitido para a senha e de 6 digitos.");
        }
        
        //contador para numero e letra
        int d = 0, c = 0;
        for(int i = 0; i < senha.length(); i++) {
            if( Character.isDigit(senha.charAt(i)) ) {
                d++;
            }
            else if( Character.isAlphabetic(senha.charAt(i)) ) {
                c++;
            }
        }
        
        if(d < 2 ) {
            throw new ExcecoesSenha(senha + " e uma senha invalida, digite pelo menos 2 numeros na senha.");
        }
        
        if(c == 0) {
            throw new ExcecoesSenha(senha + " e uma senha invalida, digite pelo menos uma letra na senha.");
        }
        
        return true;
    }
    
}
