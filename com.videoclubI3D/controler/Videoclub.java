package controler;

import model.Formato;
import model.Multimedia;
import model.Pelicula;
import model.Socio;

import java.util.ArrayList;
import java.util.Scanner;

public class Videoclub {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<Socio> socios = new ArrayList<>();
        ArrayList<Multimedia> multimedias = new ArrayList<Multimedia>();

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
                altasPeliculas(sc, multimedias, socios);
                break;
            case 3:
                break;
        }
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
    System.out.println("Introduce la duración de la película: ");
    int duracion = sc.nextInt();
    System.out.println("Introduce el nombre del actor principal: ");
    String actorPrincipal = sc.nextLine();
    System.out.println("Introduce el nombre de la actriz principal: ");
    String actrizPrinciapl = sc.nextLine();

    multimedias.add(new Pelicula(titulo, autor, formato, anio, duracion, actorPrincipal, actrizPrinciapl));
}

}
