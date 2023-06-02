/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_junniorsauceda;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author Junnior Sauceda
 */
public class Lab7P1_JunniorSauceda {

    static Scanner sc = new Scanner(System.in);
    static Random ran = new Random();
    static int score1=0;
    static int score2=0;
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean seguir = true;
        do {
            System.out.println("1.-She shoot, she scores!");
            System.out.println("2.-Pieda, papel o...");
            System.out.println("3.-Salir");
            int opcion = sc.nextInt();
            switch (opcion) {
                case 1: {
                    boolean valido = false;
                    int elementos;
                    int n=0;
                    int m=0;
                    int tiro;
                    do {
                        try {
                            System.out.println("Ingrese el numero de filas: ");
                            n = sc.nextInt();
                            while(n<2){
                                System.out.println("Ingrese un numero mayor que 1");
                                n=sc.nextInt();
                            }
                        }catch(Exception e){
                            System.out.println("No es numero");
                        }
                        try {
                            System.out.println("Ingrese el numero de columnas: ");
                            m = sc.nextInt();
                            while(m<2){
                                System.out.println("Ingrese un numero mayor que 1");
                                m=sc.nextInt();
                            }
                        }catch(Exception e){
                            System.out.println("No es numero");
                        }
                        
                        elementos = n * m;
                    } while (validezelements(elementos)==false);
                    do {
                        System.out.println("Ingrese el numero de tiros de cada usuario: ");
                        tiro = sc.nextInt();
                    } while (valideztiros(elementos, tiro)==false);
                    
                    int[][] tablero = new int[n][m];
                    tablero = Lectura(n, m,elementos);
                    int tirosp1=tiro;
                    int tirosp2=tiro;
                    int puntos1=0;
                    int puntos2=0;
                    while(tirosp1>0&&tirosp2>0){
                        System.out.println("Tablero para jugar");
                        Imprimir(tablero);
                        System.out.println("Elige que numero disparar Jugador 1!");
                        int J1=sc.nextInt();
                        Imprimir(tirador1(tablero,J1));
                        tirosp1--;
                        if(puntos(tablero,J1)){
                            puntos1+=J1;
                        }
                        System.out.println("Tiros restantes:"+tirosp1);
                        System.out.println("Elige que numero disparar Jugador 2!");
                        int J2=sc.nextInt();
                        Imprimir(tirador2(tablero,J2));
                        tirosp2--;
                        System.out.println("Tiros restantes:"+tirosp2);
                        if(puntos(tablero,J2)){
                            puntos1+=J2;
                        }
                    }
                    if(puntos1>puntos2){
                        System.out.println("El jugador 1 Ganó con un total de "+score1+" puntos");
                        System.out.println("El jugador 2 Perdió con un total de "+score2+" puntos");
                    }
                    else if(puntos2>puntos1){
                        System.out.println("El jugador 2 Ganó con un total de "+score2+" puntos");
                        System.out.println("El jugador 1 Perdió con un total de "+score1+" puntos");
                    }
                    else{
                        System.out.println("Ambos jugadores empataron. Ambos con un total de "+score1+" puntos");
                    }
                }
                break;
                case 2: {
                    System.out.println("1.Tijeras");
                    System.out.println("2.Piedra");
                    System.out.println("3.Spock");
                    System.out.println("4.Pejelagarto");
                    System.out.println("5.Papel");
                    System.out.println("Eliga que quiere usar: ");
                    int eleccion=sc.nextInt();
                    while(eleccion<0||eleccion>5){
                        System.out.println("Elija una opcion valida");
                        eleccion=sc.nextInt();
                    }
                    
                    int[][] matriz = new int [][] {{0,3,3,1,1},
                                                   {1,0,3,1,3},
                                                    {1,1,0,3,3},
                                                    {3,3,1,0,1},
                                                    {3,1,1,3,0}};
                    int maquina= ran.nextInt(5) + 1;
                    switch(maquina){
                        case 1:{//Scissors
                            System.out.println("La maquina eligió Tijeras");
                        }
                        break;
                        case 2:{//rock
                            System.out.println("La maquina eligió Piedra");
                        }
                        break;
                        case 3:{//lizard
                            System.out.println("La maquina eligió Pejelagarto");
                        }
                        break;
                        case 4:{//Spock
                            System.out.println("La maquina eligió a Spock");
                        }
                        break;
                        case 5:{//paper
                            System.out.println("La maquina eligió Papel");
                        }
                        break;
                    }
                    
                    int pelea=matriz[eleccion-1][maquina-1];
                    System.out.println(pelea);
                    if(pelea==1){
                        System.out.println("¡Jugador Gana!");
                    }
                    else if(pelea==0){
                        System.out.println("¡Es un Empate!");
                    }
                    else{
                        System.out.println("¡La Maquina Gana!");
                    }
                }
                break;
                case 3: {
                    seguir = false;
                }
                break;
            }

        } while (seguir);
        // TODO code application logic here
    }
    public static int [][] tirador1(int[][]matriz,int num){
        int[][]nvo_tablero=matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int tabla=matriz[i][j];
                    if(num==tabla){
                        score1+=num;
                        nvo_tablero[i][j]=99;
                    }
            }//fin for columna
        }
        return nvo_tablero;
    }
    public static int [][] tirador2(int[][]matriz, int num){
        int[][]nvo_tablero=matriz;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int tabla=matriz[i][j];
                    if(num==tabla){
                        score2+=num;
                        nvo_tablero[i][j]=88;
                    }
            }//fin for columna
        }
        return nvo_tablero;
    }
    
    public static boolean puntos(int[][]matriz,int numero){
       boolean puntos=false;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                    if(numero==matriz[i][j]){
                        puntos=true;
                        break;
                    }
            }//fin for columna
        }
        return puntos;
    }
    
    public static boolean valideztiros(int num, int tiros) {
        boolean val = true;
        if (tiros > num / 2) {
            val = false;
        }
        return val;
    }

    public static boolean valideznum(int num) {
        char carac = (char) num;
        System.out.println(carac);
        boolean val = true;
        if (carac < 48 || carac > 57) {
            val = false;
        }
        return val;
    }

    public static boolean validezelements(int num) {
        boolean val = true;
        if (num > 87) {
            val = false;
        }
        return val;
    }

    public static int[][] Lectura(int f, int c,int cantidad) {

        int[][] temporal = new int[f][c];
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                int num = ran.nextInt(cantidad) + 1;
                while (matrizval(temporal, f, c, num)) {
                    num = ran.nextInt(cantidad) + 1;
                }
                temporal[i][j] = num;
            }//fin for columna
        }//fin for fila

        return temporal;
    }

    public static boolean matrizval(int[][] matriz, int f, int c, int num) {
        boolean esta = false;
        for (int i = 0; i < f; i++) {
            for (int j = 0; j < c; j++) {
                if (num == matriz[i][j]) {
                    esta = true;
                }
            }//fin for columna
        }//fin for fila

        return esta;
    }

    public static void Imprimir(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print("[" + matriz[i][j] + "]");
            }//for columnas
            System.out.println("");
        }//for filas
    }//Fin metodo Imprimir
   
}
