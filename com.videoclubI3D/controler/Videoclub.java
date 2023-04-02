package controler;

import model.*;

import java.time.LocalDate;
import java.time.Period;
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

        switch (opcionAltas) {
            case 1:
                sc.nextLine();
                socios.add(altaSocio(sc));
                break;
            case 2:
                altasPeliculas(sc, multimedias, socios);
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
        } while (opcionFormato < 1 || opcionFormato > 4);
        return null;
    }
public static void altasPeliculas(Scanner sc, ArrayList<Multimedia> multimedias, ArrayList<Socio> socios){
    System.out.println("Introduce el título de la película: ");
    String titulo = sc.nextLine();
    System.out.println("Introduce el nombre del director de la película: ");
    String autor = sc.nextLine();
    System.out.println("Introduce el formato de la película: ");
    Formato formato = Formato.CD;
    System.out.println("Introduce el anio de la película: ");
    int anio = sc.nextInt();
    sc.nextLine();
    System.out.println("Introduce la duración de la película: ");
    int duracion = sc.nextInt();
    sc.nextLine();
    System.out.println("Introduce el nombre del actor principal: ");
    String actorPrincipal = sc.nextLine();
    System.out.println("Introduce el nombre de la actriz principal: ");
    String actrizPrinciapl = sc.nextLine();

    multimedias.add(new Pelicula(titulo, autor, formato, anio, duracion, actorPrincipal, actrizPrinciapl));
}
    public static Socio altaSocio(Scanner sc) {
        byte mesSocio, diaSocio;
        int anioSocio;
        String nif, nombre, poblacion;
        Period periodo;

        System.out.println("Introduce el nif del socio");
        nif = sc.nextLine();
        System.out.println("Introduce el nombre del socio");
        nombre = sc.nextLine();

        do {
            System.out.println("Introduce el dia de nacimiento del socio");
            diaSocio = sc.nextByte();
            sc.nextLine();
            System.out.println("Introduce el mes de nacimiento del socio");
            mesSocio = sc.nextByte();
            sc.nextLine();
            System.out.println("Introduce el año de nacimiento del socio");
            anioSocio = sc.nextInt();
            periodo = Period.between(LocalDate.of(anioSocio, mesSocio, diaSocio), LocalDate.now());

            if (periodo.getYears() < 18)
                System.out.println("No puedes darte de alta, eres menos de edad");
        } while (periodo.getYears() < 18);

        sc.nextLine();
        System.out.println("Introduce la población del socio");
        poblacion = sc.nextLine();

        return new Socio(LocalDate.of(anioSocio, mesSocio, diaSocio), nombre, poblacion, nif);
    }
}
