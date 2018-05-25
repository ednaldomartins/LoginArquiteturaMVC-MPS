/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package loginexception_mpslab;

import business.control.ControleLogin;
import business.model.ModeloUsuario;
import java.io.IOException;
import java.util.Scanner;
import view.Tela;

/**
 *
 * @author marti
 */
public class MPSlab_Login {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        Scanner scan = new Scanner(System.in); 
        String login = "", senha = "";
        Tela tela = new Tela(); 
        ControleLogin control = new ControleLogin();
        
        int opcao;
        do{
            System.out.print(tela.menuPrincipal() + "\n");
            opcao = scan.nextInt();
            
            switch (opcao) {
                case 1:
                    System.out.print(tela.loginTela());
                    login = scan.next();
                    if (!control.buscarUsuario(login)) {
                        System.out.print(tela.senhaTela());
                        senha = scan.next();
                        control.criarUsuario(login, senha);
                    } else {
                        System.out.println(login + " e um nome de usuario ja cadastra");
                    }
                    
                    
                    break;
                    
                case 2:
                    System.out.print(Tela.loginTela());
                    login = scan.next();
                    System.out.print(Tela.senhaTela());
                    senha = scan.next();
                    int pos = control.solicitarRemocao(login, senha);
                    if (pos != -1) {
                        System.out.println("O usuario foi encontrado e a senha conferem: \n"
                                + "1. para descastrar \n"
                                + "2. para cancelar \n");
                        opcao = scan.nextInt();
                        if(opcao == 1) {
                            control.removerUsuario(pos);
                        }
                        else if (opcao == 2) {
                            System.out.println("Operacao cancelada, o usuario nao foi removido.");
                        } 
                        else {
                            System.out.println("Opcao invalida.");
                            
                        }
                        //corrigir opcao inicial escolhida por usuario
                        opcao = 2;
                        
                    } 
                    else {
                        System.out.println("O usuario nao foi encontrado ou a senha esta errada");
                    }
                    
                    break;
                 
                case 3:
                    control.salvar();
                    System.out.print(tela.menuSalvar());
                    break;
                    
                case 4:
                    System.out.print(tela.menuSair());
                    break;
                    
                default:
                    System.out.print(tela.menuOpcaoInvalida());
            }

            System.out.print("\n\n");
        } while(opcao != 4);


    }
    
}
