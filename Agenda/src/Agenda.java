import java.util.Scanner;

public class Agenda {
	public static int menu() {
		Scanner leer;
		leer = new Scanner(System.in);
		int numero=0;
		
		do {
			System.out.println("1. Ver Contactos");
			System.out.println("2. Guardar Contactos");
			System.out.println("3. Borrar Contactos");
			System.out.println("4. Modificar Contactos");
			System.out.println("5. Buscar Contactos");
			System.out.println("6. Salir");
			numero = leer.nextInt();
		} while(numero!=6);
		return numero;
	}
	
	public static void espacioBlanco() {
		
	}

	public static void verContactos(int mAgenda[][]) {
		System.out.println("Tus contactos actuales son: ");
		for(int i=0;i<mAgenda.length;i++) {
			for(int j=0;j<mAgenda.length;j++) {
				System.out.println(mAgenda);
			}
		}
	}
	
	public static void guardarContactos(String mAgenda[][]) {
		
	}
	
	public static void borrarContactos() {
		
	}
	
	public static void modificarContactos() {
		
	}
	
	public static void buscarContactos() {
		
	}
	public static void main(String[] args) {
		Scanner leer;
		leer = new Scanner(System.in);
		int seleccion = 0;
		int mAgenda[][] = new int[5][2];
		
		do { 
			switch (menu()) {
			case 1: 
				verContactos(mAgenda);
				break;
			case 2: 
				break;
			case 3: 
				break;
			case 4: 
				break;
			case 5: 
				break;
			case 6: 
				break;
			}
		}while(seleccion!=6);

	}

}
