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
public class ExcecoesLogin extends Exception {

    public ExcecoesLogin() 
    {
        super("Erro no Login.");
    }
    
    public ExcecoesLogin (String mensagem) 
    {
        super(mensagem);
    }
}
