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
public class ExcecoesSenha extends Exception{

    public ExcecoesSenha() 
    {
        super("Erro na senha");
    }

    public ExcecoesSenha(String mensagem) 
    {
        super(mensagem);
    }
       
}
