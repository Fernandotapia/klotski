package linkedlist;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.Scanner;
import java.util.*;

/**
 *
 * @author Fernando
 */
public class leerArchivo {
    
   Scanner teclado = new Scanner(System.in);
    public static  String A1 = " ";
    public  static String A2 = " ";
    public static  String A3 = " ";
    public static  String A4 = " ";

    public static  String B1 = " ";
    public static  String B2 = " ";
    public static  String B3 = " ";
    public static  String B4 = " ";

    public static  String C1 = " ";
    public static  String C2 = " ";
    public static  String C3 = " ";
    public static  String C4 = " ";

    public static String D1 = " ";
    public static  String D2 = " ";
    public static String D3 = " ";
    public static  String D4 = " ";


   void classArchivo() {
        try {
           

 System.out.println("Ingrese el numero de nivel");
 System.out.println("nivel 1:");
 System.out.println("nivel 2:");
 System.out.println("nivel 3:");
 System.out.println("nivel 4:");
 System.out.println("nivel 5:");
  System.out.println("----------------------------------------------");
           
           String numero = teclado.nextLine();

int nivel = Integer.parseInt(numero);
            Properties propiedades = new Properties();
                
            switch (nivel) {
  
               case 1:
                propiedades.load(new FileInputStream("C:\\Users\\Fernando\\Desktop\\linkedlist\\src\\linkedlist\\niveles\\nivel1.txt")); 
               break;
               case 2:
              propiedades.load(new FileInputStream("C:\\Users\\Fernando\\Desktop\\linkedlist\\src\\linkedlist\\niveles\\nivel2.txt")); 
               break;
                case 3:
              propiedades.load(new FileInputStream("C:\\Users\\Fernando\\Desktop\\linkedlist\\src\\linkedlist\\niveles\\nivel3.txt")); 
               break;
                 case 4:
              propiedades.load(new FileInputStream("C:\\Users\\Fernando\\Desktop\\linkedlist\\src\\linkedlist\\niveles\\nivel4.txt")); 
               break;
                 case 5:
              propiedades.load(new FileInputStream("C:\\Users\\Fernando\\Desktop\\linkedlist\\src\\linkedlist\\niveles\\nivel5.txt")); 
               break;
               default:
               System.out.println("------------");
               break;
  
  }
               
           
         
            String va1 = propiedades.getProperty("vA1");
            String va2 = propiedades.getProperty("vA2");
            String va3 = propiedades.getProperty("vA3");
            String va4 = propiedades.getProperty("vA4");
            
            String vb1 = propiedades.getProperty("vB1");
            String vb2 = propiedades.getProperty("vB2");
            String vb3 = propiedades.getProperty("vB3");
            String vb4 = propiedades.getProperty("vB4");
            
            String vc1 = propiedades.getProperty("vC1");
            String vc2 = propiedades.getProperty("vC2");
            String vc3 = propiedades.getProperty("vC3");
            String vc4 = propiedades.getProperty("vC4");
            
            String vd1 = propiedades.getProperty("vD1");
            String vd2 = propiedades.getProperty("vD2");
            String vd3 = propiedades.getProperty("vD3");
            String vd4 = propiedades.getProperty("VD3");
            
            
            A1 = va1;
            A2 = va2;
            A3 = va3;
            A4 = va4;

            B1 = vb1;
            B2 = vb2;
            B3 = vb3;
            B4 = vb4;

            C1 = vc1;
            C2 = vc2;
            C3 = vc3;
            C4 = vc4;

            D1 = vd1;
            D2 = vd2;
            D3 = vd3;
            D4 = vd4;

        
        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
        }
    }
   
}
