/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

/**
 *
 * @author marti
 */
public class Tela {

    public Tela() {
        System.out.println(">>>Atividade de excecoes de MPS<<<");
    }
    
    public static String loginTela() {
        return "Login: ";
    }
    
    public static String senhaTela() {
        return "Senha: ";
    }

    public String menuPrincipal() {
        return "1. Cadastrar Usuario\n"
             + "2. Remover Usuario\n"
             + "3. Salvar Mudancas\n"
             + "4. Sair";
    }
    
    public String menuCadastrar() {
        return loginTela();
                
    }
    
    public String menuRemover() {
        return "\nDigite o Login do Usuario que deseja remover: ";
    }
    
    public String menuRemoverConfirmar() {
        return "\nDigite a senha do usuario para Confirmar: ";
    }
    
    public String menuSalvar () {
        return "\nMudancas salvas com sucesso";
    }
    
    public static String menuOpcaoInvalida () {
        return "\nDigite uma opcao Valida";
    }

    public String menuSair() {
        return "Saindo do programa";
    }
}
