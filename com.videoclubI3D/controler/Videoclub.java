package controler;

import model.Multimedia;
import model.Socio;

import java.util.ArrayList;
import java.util.Scanner;

public class Videoclub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Socio> socios = new ArrayList<>();
        ArrayList<Multimedia> multimedias = new ArrayList<>();
        int opcionAltas = 0;
        System.out.println("""
                Altas:
                1 Alta de Socio
                2 Alta de película
                3 Alta de videojuego
                4 Alta de disco
                0 Salir
                """);
        opcionAltas = sc.nextInt();

        switch (opcionAltas){
            case 1:
                break;
            case 2:
                break;
            case 3:
                altaVideojuego(multimedias, sc);
                break;
        }
    }

    public static void altaVideojuego(ArrayList<Multimedia> multimedias, Scanner sc){
        String titulo, autor;
        int fecha;

        System.out.println("Introduce el titulo del videojuego:");
        titulo = sc.nextLine();
        System.out.println("Introduce el autor del videojuego:");
        autor = sc.nextLine();
    }

}
