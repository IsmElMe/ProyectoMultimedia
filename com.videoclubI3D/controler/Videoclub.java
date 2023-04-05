package controler;

import model.*;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Videoclub {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		ArrayList<Socio> socios = new ArrayList<>();
		ArrayList<Multimedia> multimedias = new ArrayList<>();

		int opcion;

		do {
			System.out.println("""
					1 Altas
					2 Alquilar multimedia a socio
					3 Devolver multimedia de socio
					4 Listar
					0 Salir""");
			opcion = sc.nextInt();
			sc.nextLine();

			switch (opcion) {
				case 1 -> altas(sc, socios, multimedias);

				case 2 -> alquilarMultimedia(sc, socios.get(0), multimedias);
					/*
					 * Solo pueden ser socios los mayores de edad.
					 *
					 * Un socio podrá alquilar tantos objetos multimedia como desee mientras no tenga recargos pendientes de pagar
					 *
					 * Los elementos multimedia se alquilan a los socios durante un periodo máximo de 3 días.
					 *
					 * El alquiler tendrá un precio base de 4 €.
					 *
					 * El alquiler se ve rebajado 1 € si la película es anterior al año 2012, si el disco tiene una duración
					 * menor a 30 minutos o si el videojuego es anterior al año 2010. Se verá aumentado si la película
					 * es de este mismo año en el caso de las películas y los videojuegos.
					 *
					 * Finalmente, cuando el socio devuelve el objeto multimedia se debe comprobar que está dentro del plazo de alquiler de
					 * 3 días. Por cada día que pase del mencionado periodo, el socio deberá pagar un recargo de 2 €.
					 * */

				case 3 -> devolverMultimedia(sc, socios.get(0), multimedias);

				case 4 -> listas(sc, multimedias, socios);
			}
		} while (opcion != 0);
	}

	public static void altas(Scanner sc, ArrayList<Socio> socios, ArrayList<Multimedia> multimedias) {
		int opcionAltas;

		do {
			System.out.println("""
					Altas:
					1 Alta de Socio
					2 Alta de Película
					3 Alta de Videojuego
					4 Alta de Disco
					0 Salir
					""");
			opcionAltas = sc.nextInt();
			sc.nextLine();

			switch (opcionAltas) {
				case 1 -> socios.add(altaSocio(sc));

				case 2 -> altasPeliculas(sc, multimedias, socios);

				case 3 -> altaVideojuego(multimedias, sc);

				case 4 -> /*método alta disco*/{}

				case 0 -> System.out.println("Has salido de altas");
			}
		} while (opcionAltas != 0);
	}

	public static void listas(Scanner sc, ArrayList<Multimedia> multimedias, ArrayList<Socio> socios) {
		int opcionLista;
		ArrayList<Pelicula> peliculas = sacarPeliculas(multimedias);
		ArrayList<Videojuego> videojuegos = sacarVideojuegos(multimedias);

		do {
			System.out.println("""
					1. Listado de todos los objetos multimedia
					2. Listado de todas las películas ordenadas por título
					3. Listado de todas las canciones de un disco por duración
					4. Listado de todos los videojuegos ordenados por año
					5. Listado de los alquileres actuales de un socio
					6. Listado de los socios con recargos pendientes
					0. Salir""");
			opcionLista = sc.nextInt();
			sc.nextLine();

			switch (opcionLista) {
				case 1 -> System.out.println(mostrarMultimedia(multimedias));

				case 2 -> {
					Collections.sort(peliculas);
					System.out.println(mostrarPelicula(peliculas));
				}

				case 4 -> {
					videojuegos.sort(new Videojuego.ComparatorFecha());
					System.out.println(mostrarVideojuego(videojuegos));
				}
			}
		} while (opcionLista != 0);
	}

	public static void altaVideojuego(ArrayList<Multimedia> multimedias, Scanner sc) {
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

			switch (opcionPlataforma) {
				case 1 -> plataformas[0] = Plataforma.PS5;

				case 2 -> plataformas[1] = Plataforma.XBOX;

				case 3 -> plataformas[2] = Plataforma.NINTEND0_SWITCH;

				case 4 -> plataformas[3] = Plataforma.PC;
			}
		} while (opcionPlataforma < 1 || opcionPlataforma > 4);

		multimedias.add(new Videojuego(titulo, autor, formato, anio, plataformas));
	}

	public static Formato elegirFormato(Scanner sc) {
		int opcionFormato;

		do {
			System.out.println("Introduce el formato: " +
					"1.CD 2.DVD 3.BLU_RAY 4.ARCHIVO");
			opcionFormato = sc.nextInt();

			switch (opcionFormato) {
				case 1 -> {return Formato.CD;}

				case 2 -> {return Formato.DVD;}

				case 3 -> {return Formato.BLU_RAY;}

				case 4 -> {return Formato.ARCHIVO;}
			}
		} while (true);
	}

	public static void altasPeliculas(Scanner sc, ArrayList<Multimedia> multimedias, ArrayList<Socio> socios) {
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

	public static void alquilarMultimedia(Scanner sc, Socio socio, ArrayList<Multimedia> multimedias) {
		System.out.println("Introduce que tipo de multimedia quieres alquilar? \n1 Película \n2 Videojuego \n3 Disco");
		int opcion = sc.nextInt();
		sc.nextLine();
		System.out.println("Introduce el titulo");
		String titulo = sc.nextLine();
		ArrayList<Multimedia> multimediaSocio = socio.getMultimediasAlquiladas();

		for (Multimedia multimedia : multimedias) {
			if (multimedia.getTitulo().equalsIgnoreCase(titulo.toLowerCase())) {
				multimediaSocio.add(multimedia);
			}
		}

		socio.setMultimediasAlquiladas(multimediaSocio);
		System.out.println(socio.getMultimediasAlquiladas().toString());
	}

	public static void devolverMultimedia(Scanner sc, Socio socio, ArrayList<Multimedia> multimedias) {
		System.out.println("Introduce el título del objeto que has alquilado: ");
		String titulo = sc.nextLine();
		System.out.println("Cuantos dias lo has alquilado? ");
		int diasAlquilado = sc.nextInt();
		sc.nextLine();
		int precio = 0;

		// Es 4 € por día o por los 3 días

		for (Multimedia multimedia : multimedias) {
			if (multimedia.getTitulo().equalsIgnoreCase(titulo.toLowerCase())) {
				precio = diasAlquilado * multimedia.getPrecio();
				if (diasAlquilado > 3) {
					diasAlquilado = diasAlquilado - 3;
					precio = precio + (diasAlquilado * 2);
				}
				socio.getMultimediasAlquiladas().remove(multimedia);
			}
		}

		System.out.println("Debes pagar " + precio + "$");
	}

	public static String mostrarMultimedia(ArrayList<Multimedia> multimedias) {
		StringBuilder stb = new StringBuilder();

		for (Multimedia multimedia : multimedias) {
			stb.append(multimedia.toString());
		}

		return stb.toString();
	}

	public static String mostrarPelicula(ArrayList<Pelicula> peliculas) {
		StringBuilder stb = new StringBuilder();

		for (Pelicula pelicula : peliculas) {
			stb.append(pelicula.toString());
		}

		return stb.toString();
	}

	public static String mostrarVideojuego(ArrayList<Videojuego> videojuegos) {
		StringBuilder stb = new StringBuilder();

		for (Videojuego videojuego : videojuegos) {
			stb.append(videojuego.toString());
		}

		return stb.toString();
	}

	public static ArrayList<Pelicula> sacarPeliculas(ArrayList<Multimedia> multimedias) {
		ArrayList<Pelicula> peliculas = new ArrayList<>();

		for (Multimedia multimedia : multimedias)
			if (multimedia instanceof Pelicula)
				peliculas.add((Pelicula) multimedia);

		return peliculas;
	}

	public static ArrayList<Videojuego> sacarVideojuegos(ArrayList<Multimedia> multimedias) {
		ArrayList<Videojuego> videojuegos = new ArrayList<>();

		for (Multimedia multimedia : multimedias)
			if (multimedia instanceof Videojuego)
				videojuegos.add((Videojuego) multimedia);

		return videojuegos;
	}
}
