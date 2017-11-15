/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import datos.ProgramaEcontinuada;
import datos.SedeTecnologica;
import datos.Universidad;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Estudiante
 */
public class LogicaUniversidad {
    private Universidad u; 

    public LogicaUniversidad() {
      this.u = new Universidad();
    }

    public Universidad getU() {
        return u;
    }
    
    public void cargar(String ruta){
      
       File lectura = new File(ruta);
       Scanner flujoEntrada = null;
       if(lectura.exists()){
           try {
               flujoEntrada = new Scanner(lectura);
               flujoEntrada.useDelimiter(",");
               String tipo = null;
               tipo = flujoEntrada.next().trim();
               while(flujoEntrada.hasNext()){
                   tipo = flujoEntrada.next().trim();
                   if(tipo.equals("SE")){
                       String nombre = flujoEntrada.next().trim();
                       String direccion = flujoEntrada.next().trim();
                       int telefono = flujoEntrada.nextInt();
                       int area = flujoEntrada.nextInt();
                       SedeTecnologica st = new SedeTecnologica(nombre,direccion,telefono,area);
                       while (!(flujoEntrada.next().trim().equals("SP")||flujoEntrada.next().trim().equals("ST"))){
                           tipo = tipo = flujoEntrada.next().trim();
                           switch(tipo){
                               case "PE":
                                   ProgramaEcontinuada p= new ProgramaEcontinuada(true);
                                   break;
                               case "PF:":
                                   break;
                               case "PT:":
                                   break;
                           }
                       }
                           
                       
                       
                   }else if(tipo.equals("SP")){

                   }else if(tipo.equals("ST")){
                   
                   }
                   //Solo para prueba
                  
               }
               
               
           } catch (FileNotFoundException ex) {
               System.out.println("Archivo de datos no Encontrado");
           }
          
        
       }
    
    }
}
