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
public class ExcecoesArquivo extends Exception {

    public ExcecoesArquivo() 
    {
        super("Erro no carregamento de usuarios");
    }

    public ExcecoesArquivo(String mensagem) 
    {
        super(mensagem);
    }
    
    
}
