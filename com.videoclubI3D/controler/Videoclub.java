package controler;

import model.Multimedia;
import model.Socio;

import java.time.LocalDate;
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
                socios.add(altaSocio(sc));
                break;

            case 2: break;

            case 3: break;

        }
    }

    public static Socio altaSocio(Scanner sc) {
        byte mesSocio, diaSocio;
        int anioSocio;
        String nif, nombre, poblacion;

        System.out.println("Introduce el nif del socio");
        nif = sc.nextLine();
        System.out.println("Introduce el nombre del socio");
        nombre = sc.nextLine();
        System.out.println("Introduce el dia de nacimiento del socio");
        diaSocio = sc.nextByte();
        sc.nextLine();
        System.out.println("Introduce el mes de nacimiento del socio");
        mesSocio = sc.nextByte();
        sc.nextLine();
        System.out.println("Introduce el año de nacimiento del socio");
        anioSocio = sc.nextInt();
        sc.nextLine();
        System.out.println("Introduce la población del socio");
        poblacion = sc.nextLine();

        return new Socio(LocalDate.of(anioSocio, mesSocio, diaSocio), nombre, poblacion, nif);
    }
}
