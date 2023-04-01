package controler;

import model.*;

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
        int anio, opcionPlataforma;
        Formato formato;
        Plataforma[] plataformas = new Plataforma[4];

        System.out.println("Introduce el titulo del videojuego: ");
        titulo = sc.nextLine();
        System.out.println("Introduce el autor del videojuego: ");
        autor = sc.nextLine();
        System.out.println("Introduce el anio del videojuego: ");
        anio = sc.nextInt();
        formato = elegirFormato(sc);
        do {
            System.out.println("Introduce el formato: " +
                    "1.PS5 2.XBOX 3.NINTEND0_SWITCH 4.PC");
            opcionPlataforma = sc.nextInt();
            switch (opcionPlataforma){
                case 1:
                    plataformas[0] = Plataforma.PS5;
                    break;
                case 2:
                    plataformas[1] = Plataforma.XBOX;
                    break;
                case 3:
                    plataformas[2] = Plataforma.NINTEND0_SWITCH;
                    break;
                case 4:
                    plataformas[3] = Plataforma.PC;
                case 0:

            }
        }while (opcionPlataforma != 0);
        multimedias.add(new Videojuego(titulo, autor, formato, anio, plataformas));
    }

    public static Formato elegirFormato(Scanner sc){
        int opcionFormato;
        do {
            System.out.println("Introduce el formato: " +
                    "1.CD 2.DVD 3.BLU_RAY 4.ARCHIVO");
            opcionFormato = sc.nextInt();
            switch (opcionFormato){
                case 1:
                    return Formato.CD;
                case 2:
                    return Formato.DVD;
                case 3:
                    return Formato.BLU_RAY;
                case 4:
                    return Formato.ARCHIVO;
            }
        }while (opcionFormato < 1 || opcionFormato > 4);
        return null;
    }

}
