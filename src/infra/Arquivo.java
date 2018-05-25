/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package infra;

/**
 *
 * @author marti
 */
import business.model.Usuario;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

/**
 *
 * @author marti
 * Classe Arquivo para carregar parametros do processo e guardar resultados.
 */
public class Arquivo {
    private Path savePath;
    private Charset utf8 = StandardCharsets.UTF_8;
    
    //construtor para destinar o caminho
    public Arquivo (String savePath) {
        this.savePath = Paths.get(savePath);
    }
    
    public void guardarUsuarios (ArrayList <Usuario> usuarios) throws IOException {
        BufferedWriter writer = null;
        try {
            writer = Files.newBufferedWriter(savePath, utf8);
            for(Usuario usuario:usuarios) {
                writer.write(usuario.getLogin() + ";" + usuario.getSenha() + "\r\n");
            }
            writer.flush();
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(writer != null) {
                writer.close();
            }
            System.out.println("SALVAMENTO CONCLUIDO");
        }
    }
    
    
    public ArrayList<Usuario> carregarUsuarios() throws IOException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        try (BufferedReader reader = Files.newBufferedReader(savePath, utf8)){            
            String line = null;
            while((line = reader.readLine()) != null) {
                String[] separador = line.split(";");
                
                Usuario usuario = new Usuario(separador[0] , separador[1]);
                usuarios.add(usuario); 
            }
            reader.close();         
        }
        catch(FileNotFoundException ex) {System.err.println("Arquivo não encontrado");                
        }
        catch(IOException ex) {System.err.println("Erro de leitura");
            ex.printStackTrace();
        }
        catch(NumberFormatException ex) {System.err.println("Erro de formato de numeros");}
        
        return usuarios;
    }
    
    
}