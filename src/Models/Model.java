
package models;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import Views.View;



public class Model {
    private String nombre = "";
    private String email = "";
    private String path = "C:\\Users\\76053\\Documents\\Escuela\\4 Cuatrimestre\\Aplicaciones II\\Texto\\base.csv";
    boolean bandera = true;
    
    View view;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
    public void readFile(){
        try{
                String row; 
            try (FileReader file = new FileReader(path); BufferedReader bufferedReader = new BufferedReader(file)){
                while ((row = bufferedReader.readLine()) != null){    
                    String [] campos = row.split(",");
                    nombre = campos[0];
                    email = campos[1]; 
                }
            } 
        }catch (FileNotFoundException ex) {
                JOptionPane.showMessageDialog(view,"No se encuentra el archivo" + ex.getMessage());
        } catch (IOException ex) {
                JOptionPane.showMessageDialog(view,"Error" + ex.getMessage());
        }
    }
    
    public void writeFile(){
        try{
                File file = new File(path);
                FileWriter fileWriter = new FileWriter (file,bandera);
                try (PrintWriter printWriter  = new PrintWriter(fileWriter)){
                        ArrayList<String> nuevo = new ArrayList<>();
                        nuevo.add(nombre);
                        nuevo.add(email);
                        printWriter.print(nombre + "," + email);
                        printWriter.close();
                        JOptionPane.showMessageDialog(view,"Se modifico correctamente");
            }
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(view,"Error" + ex.getMessage());
                }
            }
}

