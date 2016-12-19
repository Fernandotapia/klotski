/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package linkedlist;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.*;

/**
 *
 * @author Fernando
 */
public class Linkedlist {

    public static final String BLACK = "\033[30m";
    public static final String RED = "\033[31m";
    public static final String GREEN = "\033[32m";
    public static final String YELLOW = "\033[33m";
    public static final String BLUE = "\033[34m";
    public static final String PURPLE = "\033[35m";
    public static final String CYAN = "\033[36m";
    public static final String WHITE = "\033[37m";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//--------------------------VARIABLES --------------------------------------------------------------------------------------------------------------------     
        String str = "\t";
        int XP = 6;
        int XL = 6;
        Scanner sc = new Scanner(System.in);
        leerArchivo leerArchivo = new leerArchivo();
        leerArchivo.classArchivo();
        Scanner teclado = new Scanner(System.in);
//--------------------------LECTURA DEL ARCHIVO DE TEXTO-----------------------------------------------------------------------------------------------------         
        try {
            Properties propiedades = new Properties();
            propiedades.load(new FileInputStream("C:\\Users\\Fernando\\Desktop\\linkedlist\\src\\linkedlist\\niveles\\nivel1.txt"));
            String VXP = propiedades.getProperty("VXP");
            String VXL = propiedades.getProperty("VXL");
            XP = Integer.parseInt(VXP);
            XL = Integer.parseInt(VXL);
        } catch (FileNotFoundException e) {
            System.out.println("Error, El archivo no exite");
        } catch (IOException e) {
            System.out.println("Error, No se puede leer el archivo");
        }
        //----------------------------------- LISTA MULTI DIMENCIONAL---------------------------------------------------------------------------  
        Matrix M = new Matrix(XP, XL);
//--------------------------LADO IZQ-----------------------------------------------------------------------------------------------------
        for (int I = 0; I < XL; ++I) {
            for (int J = 0; J < 1; ++J) {
                M.SetValue(J, I, 35);
            }
        }
        //--------------------------LADO ARRIBA-----------------------------------------------------------------------------------------------------
        for (int J = 0; J < XP; ++J) {
            M.SetValue(J, 0,35);
        }
        //--------------------------LADO ABAJO-----------------------------------------------------------------------------------------------------
        for (int I = 0; I < XP; ++I) {
            M.SetValue(I, XL, 35);
        }
         M.SetValue((XP / 2), XL, 45);

        //--------------------------LADO DERECHO-----------------------------------------------------------------------------------------------------          
        for (int I = 0; I < XP; ++I) {
            M.SetValue(XP - 1, I, 35);
        }
        char x1 = leerArchivo.A1.charAt(0);
        int xf1 = (int) x1;

        char x2 = leerArchivo.A2.charAt(0);
        int xf2 = (int) x2;

        char x3 = leerArchivo.A3.charAt(0);
        int xf3 = (int) x3;

        char x4 = leerArchivo.A4.charAt(0);
        int xf4 = (int) x4;

        char x5 = leerArchivo.B1.charAt(0);
        int xf5 = (int) x5;

        char x6 = leerArchivo.B2.charAt(0);
        int xf6 = (int) x6;

        char x7 = leerArchivo.B3.charAt(0);
        int xf7 = (int) x7;

        char x8 = leerArchivo.B4.charAt(0);
        int xf8 = (int) x8;

        char x9 = leerArchivo.C1.charAt(0);
        int xf9 = (int) x9;

        char x10 = leerArchivo.C2.charAt(0);
        int xf10 = (int) x10;

        char x11x = leerArchivo.C3.charAt(0);
        int xf11 = (int) x11x;

        char x12x = leerArchivo.C4.charAt(0);
        int xf12 = (int) x12x;

        char x13x = leerArchivo.D1.charAt(0);
        int xf13 = (int) x13x;

        char x14x = leerArchivo.D2.charAt(0);
        int xf14 = (int) x14x;

        char x15x = leerArchivo.D3.charAt(0);
        int xf15 = (int) x15x;

        M.SetValue(1, 1, xf1);
        M.SetValue(1, 2, xf2);
        M.SetValue(1, 3, xf3);
        M.SetValue(1, 4, xf4);

        M.SetValue(2, 1, xf5);
        M.SetValue(2, 2, xf6);
        M.SetValue(2, 3, xf7);
        M.SetValue(2, 4, xf8);

        M.SetValue(3, 1, xf9);
        M.SetValue(3, 2, xf10);
        M.SetValue(3, 3, xf11);
        M.SetValue(3, 4, xf12);

        M.SetValue(4, 1, xf13);
        M.SetValue(4, 2, xf14);
        M.SetValue(4, 3, xf15);
      
        //--------------------------IMPRIMIR-----------------------------------------------------------------------------------------------------    
        int contador = 0;
        for (int I = 0; I < M.GetHeight(); ++I) {
            for (int J = 0; J < XP; ++J) {
                char ch = (char) M.GetValue(J, I);

                System.out.print(ch + " ");

                str = "\t";
            }
            System.out.println();
        }
        System.out.println("Movimientos: " + contador);

        int madresita = 0;

        do {
            System.out.println("\033[34mIngrese la letra que desea mover");

            String letra = teclado.nextLine();
            char c = letra.charAt(0);

            int i = (int) c;
            for (int x = 0; x < M.GetWidth(); x++) {
                for (int y = 0; y < M.GetHeight(); y++) {
                    if (M.GetValue(x, y) == c) {
                        int arr, aba, izq, der;
                        arr = M.GetValue(x, y - 1);
                        aba = M.GetValue(x, y + 1);
                        izq = M.GetValue(x + 1, y);
                        der = M.GetValue(x - 1, y);

                        if (aba == -1) {
                            contador += 1;
                            M.SetValue(x, y + 1, M.GetValue(x, y));
                            M.SetValue(x, y, -1);
                            for (int I = 0; I < M.GetHeight(); ++I) {
                                for (int J = 0; J < XP; ++J) {
                                    char ch = (char) M.GetValue(J, I);

                                    System.out.print(ch + " ");

                                    str = "\t";
                                }
                                System.out.println();
                            }
                            c = 0;
                        }

                        if (arr == -1) {
                            contador += 1;
                            M.SetValue(x, y - 1, M.GetValue(x, y));
                            M.SetValue(x, y, -1);
                            for (int I = 0; I < M.GetHeight(); ++I) {
                                for (int J = 0; J < XP; ++J) {
                                    char ch = (char) M.GetValue(J, I);

                                    System.out.print(ch + " ");

                                    str = "\t";
                                }
                                System.out.println();
                            }
                            c = 0;
                        }
                        if (izq == -1) {
                            contador += 1;
                            M.SetValue(x + 1, y, M.GetValue(x, y));
                            M.SetValue(x, y, -1);
                            izq = 0;
                            for (int I = 0; I < M.GetHeight(); ++I) {
                                for (int J = 0; J < XP; ++J) {
                                    char ch = (char) M.GetValue(J, I);

                                    System.out.print(ch + " ");

                                    str = "\t";
                                }
                                System.out.println();
                            }
                            c = 0;
                        }
                        if (der == -1) {
                            contador += 1;
                            M.SetValue(x - 1, y, M.GetValue(x, y));
                            M.SetValue(x, y, -1);
                            der = 0;
                            for (int I = 0; I < M.GetHeight(); ++I) {
                                for (int J = 0; J < XP; ++J) {
                                    char ch = (char) M.GetValue(J, I);

                                    System.out.print(ch + " ");

                                    str = "\t";
                                }
                                System.out.println();
                            }
                            c = 0;
                        }
                    }
                }
            }
            System.out.println("\033[32mMovimientos: " + contador);
            madresita = M.GetValue(3, 4);
        } while (madresita != 43);
        System.out.println("\033[31mHAS GANADO!!!!!!!!!!!");
    }

}
