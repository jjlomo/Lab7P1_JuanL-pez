/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab7p1_juanlópez;
import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author jjlm1
 */
public class Lab7P1_JuanLópez {
static Scanner leer=new Scanner(System.in);
static Random rand=new Random();
    /**
     * @param args the command line arguments
     */
//    FILA 1 PUESTO 13
    
    public static void main(String[] args){
        System.out.println("*********EJERCICIOS*********");
        System.out.println("");
        System.out.println("1. Tres en raya");
        System.out.println("2. Puntos de silla");
        System.out.println("");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.println("Ingrese ejrecicio:");
        int ejer=leer.nextInt();
        while (ejer<3&&ejer>0){
            switch (ejer){
                case 1:
                    char resp='s';
                    while (resp=='s'||resp=='S'){
                    System.out.println("***TRES EN RAYA***");
                    System.out.println("");
                    System.out.println("");
                    int control=0;
                    char[][] xo=new char[3][3];
                    llenartablero(xo);
                    imprimir(xo);
                    System.out.println("Ingrese coordenada x [0,1,2]:");
                    int fila=leer.nextInt();
                    System.out.println("Ingrese coordenada y [0,1,2]:");
                    int columna=leer.nextInt();
                    boolean win=false,winmaq=false, draw=false;
                    while (winmaq==false&&control<9&&fila<3&&fila>=0&&columna<3&&columna>=0&&win==false&&draw==false){
                        boolean posible=verificarmov(xo,fila,columna);
                        System.out.println("");
                        System.out.println(posible);
                        if (fila<0||fila>=3||columna<0||columna>=3){
                            System.out.println("Alguno de los datos es inválido");
                            System.out.println("Intente de nuevo :P");
                            fila=0;
                            columna=0;
                            
                        } if (posible==true){
                            System.out.println("EL usuario escogió la posicion:"+fila+","+columna);
                            xo=tachar(xo,fila, columna);
                            imprimir(xo);
                            
                            
                            control+=2;
                            tacharmaq(xo,control);
                            imprimir (xo);
                        }else{
                            System.out.println("Casilla ocupada");
                            imprimir(xo);
                        }
                        win=winusuario(xo,'X');
                        winmaq=winmaq(xo,'O');
                        draw=empate(control);
                        if (control<9&&win==false&&winmaq==false&&draw==false){
                        System.out.println("Ingrese coordenada x [0,1,2]:");
                        fila=leer.nextInt();
                        System.out.println("Ingrese coordenada y [0,1,2]:");
                        columna=leer.nextInt();
                        }
                        if(win==true){
                        System.out.println("El usuario ha ganado");
                    }else if(winmaq==true){
                        System.out.println("Ha ganado la máquina (en serio perdiste?)");
                    }else if(draw==true){
                            System.out.println("Ha habido un empate");
                    }
                        
                    }
                    System.out.println("Desea volver a jugar? [s,n]");
                        resp=leer.next().charAt(0);
                    
                    }

                    break;
                
                case 2:
                    System.out.println("***Punto de silla***");
                    System.out.println("");
                    System.out.println("INgrese alto de la matriz:");
                    int alto=leer.nextInt();
                    System.out.println("Ingrese largo de la matriz");
                    int largo=leer.nextInt();
                    while(alto!=largo){
                        System.out.println("Ingrese valores de mismo valor para proceder :P");
                        System.out.println("");
                        System.out.println("INgrese alto de la matriz:");
                        alto=leer.nextInt();
                        System.out.println("Ingrese largo de la matriz");
                        largo=leer.nextInt();
                    }
                    int[][]matriz=llenar(alto,largo);
                    System.out.println("");
                    print(matriz);
                    System.out.println("");
                    puntosilla(matriz,alto,largo);
                    System.out.println("");
                    break;
                default:break;
                
                
            }
            
            
            
           System.out.println("*********EJERCICIOS*********");
        System.out.println("");
        System.out.println("1. Tres en raya");
        System.out.println("2. Puntos de silla");
        System.out.println("");
        System.out.println("3. Salir");
        System.out.println("");
        System.out.println("Ingrese ejrecicio:");
        ejer=leer.nextInt(); 
        }
    }//FIN DEL MAIN************
    
    
    public static char[][] llenartablero(char[][] xo){
        for (int i=0;i<xo.length;i++){
            for (int j=0;j<xo.length;j++){
                xo[i][j]=' ';
            }
        }
        return xo;
    }
    
    public static void imprimir(char[][] xo){
        for (int i=0;i<xo.length;i++){
            for (int j=0;j<xo.length;j++){
                System.out.print("["+xo[i][j]+"]");
            }
            System.out.println("");
        } 
        System.out.println("");
    }
    
    public static boolean verificarmov(char[][] xo, int fila, int columna){
        boolean posible;
        if (xo[fila][columna]==' '){
            return posible=true;
        }else{
            return posible=false;
        }
    }
    public static char[][]tachar(char[][]xo,int fila, int columna){
        boolean posible=verificarmov(xo,fila,columna);
        if (posible==true){
            xo[fila][columna]='X';
        }
        return xo;
    }
    public static char[][]tacharmaq(char[][]xo,int control){
        int fila=rand.nextInt(3-0);
        int columna=rand.nextInt(3-0);
        boolean posible=verificarmov(xo,fila,columna);
        if (posible==true){
            xo[fila][columna]='O';
        }
        if (control<9){
        while (posible==false){
                fila=rand.nextInt(3-0);
                columna=rand.nextInt(3-0);
                posible=verificarmov(xo,fila,columna);
            }
            xo[fila][columna]='O';
        }
       
        System.out.println("La maquina ha tachado la posicion:"+fila+","+columna);
        return xo;
    }
    public static boolean winmaq(char[][] xo,char signo){
        boolean win;
        if (xo[0][0]==signo&&xo[0][1]==signo&&xo[0][2]==signo){
            win=true;
        }else if(xo[1][0]==signo&&xo[1][1]==signo&&xo[1][2]==signo){
            win=true;
        }else if (xo[2][0]==signo&&xo[2][1]==signo&&xo[2][2]==signo){
            win=true;
        }else if (xo[0][0]==signo&&xo[1][0]==signo&&xo[2][0]==signo){
            win=true;
        }else if (xo[0][1]==signo&&xo[1][1]==signo&&xo[2][1]==signo){
            win=true;
        }else if (xo[0][2]==signo&&xo[1][2]==signo&&xo[2][2]==signo){
            win=true;
        }else if (xo[0][0]==signo&&xo[1][1]==signo&&xo[2][2]==signo){
            win=true;
        }else if (xo[2][0]==signo&&xo[1][1]==signo&&xo[0][1]==signo){
            win=true;
        }else{
            win=false;
        }
        return win;
    }
    public static boolean winusuario(char[][] xo,char signo){
        boolean win;
        if (xo[0][0]==signo&&xo[0][1]==signo&&xo[0][2]==signo){
            win=true;
        }else if(xo[1][0]==signo&&xo[1][1]==signo&&xo[1][2]==signo){
            win=true;
        }else if (xo[2][0]==signo&&xo[2][1]==signo&&xo[2][2]==signo){
            win=true;
        }else if (xo[0][0]==signo&&xo[1][0]==signo&&xo[2][0]==signo){
            win=true;
        }else if (xo[0][1]==signo&&xo[1][1]==signo&&xo[2][1]==signo){
            win=true;
        }else if (xo[0][2]==signo&&xo[1][2]==signo&&xo[2][2]==signo){
            win=true;
        }else if (xo[0][0]==signo&&xo[1][1]==signo&&xo[2][2]==signo){
            win=true;
        }else if (xo[2][0]==signo&&xo[1][1]==signo&&xo[0][1]==signo){
            win=true;
        }else{
            win=false;
        }
        return win;
    }
    public static boolean empate(int control){
        boolean draw;
        if (control>9){
            draw=true;
        }else{
            draw=false;
        }
        return draw;
    }
    //FIN DE METODOS DEL PRIMER PROBLEMA
    
    public static int[][] llenar(int alto, int largo){
        int [][]matriz=new int[alto][largo];
        for (int i=0;i<alto;i++){
            for(int j=0;j<largo;j++){
                matriz[i][j]=rand.nextInt((98-0)+1)+1;   
        }
    }
        return matriz;
}
    public static void print(int[][] matriz){
        for (int i=0;i<matriz.length;i++){
            for(int j=0;j<matriz[i].length;j++){
                System.out.print("["+matriz[i][j]+"]");     
        }
            System.out.println("");
    }
    }
    public static void puntosilla(int[][] matriz, int alto, int largo){
       int[]array=new int[alto];
       int[]array1=new int[largo];
       int[]array2=new int[alto];
        int menor=100;
        int mayor=0;
        for (int i=0;i<alto;i++){
            for(int j=0;j<largo;j++){
                if(matriz[i][j]<menor){
                    menor=matriz[i][j]; 
                    array[i]=menor;
                }     
        }
           
            menor=100;
    }
        for (int i=0;i<largo;i++){
            for(int j=0;j<alto;j++){
                if(matriz[j][i]>mayor){
                    mayor=matriz[j][i]; 
                    array1[i]=mayor;
                }  
               
        }
             
            mayor=0;
    }

        for (int i=0;i<array.length;i++){
            for(int j=0;j<array1.length;j++){
                if(array[i]==array1[j]){
                    array2[i]=array1[j];
                    System.out.println(array[i]+" es un punto de silla");
                }
            }

        }
    }
}