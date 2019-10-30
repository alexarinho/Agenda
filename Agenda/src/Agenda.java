import java.util.Scanner;

public class Agenda {
	public static int menu() {
		Scanner leer;
		leer = new Scanner(System.in);
		int numero=0;
		boolean boleano=false;
		do {
			System.out.println("1. Ver Contactos");
			System.out.println("2. Guardar Contactos");
			System.out.println("3. Borrar Contactos");
			System.out.println("4. Modificar Contactos");
			System.out.println("5. Buscar Contactos");
			System.out.println("6. Salir");
			numero = leer.nextInt();
			if(numero>0 && numero<7) {
				boleano = true;
			}
		} while(boleano == false);
		return numero;
	}
	
	public static void verContactos(String mAgenda[][]) {
		System.out.println("Tus contactos actuales son: ");
		for(int i=0;i<mAgenda.length;i++) {
			if (mAgenda[i][0]!=null) {
				
				System.out.println(mAgenda[i][0]+ mAgenda[i][1]);
		}
		}
		
	}
	
	public static int espacio(String mAgenda[][]) {
		int espacio=0;
		for(int i=0;i<mAgenda.length;i++) {
			if(mAgenda[i] == null) {
				espacio = i;
				break;
			}
		}
		return espacio;
	}
	
	public static void guardarContactos(String mAgenda[][]) {
		int posicion=espacio(mAgenda);
		Scanner leer;
		leer = new Scanner(System.in);
		System.out.println("Dime un nombre y un numero para guardar en tu agenda: ");
		
		mAgenda [posicion][0]=leer.nextLine();
		mAgenda [posicion][1]=leer.nextLine();
		
	}
	
	public static void borrarContactos(String mAgenda[][]) {
		int borrrar=buscarContactos(mAgenda);
		
		mAgenda[borrrar][0]=null;
		mAgenda[borrrar][1]=null;
	}
	
	public static void modificarContactos(String mAgenda[][]) {
		borrarContactos(mAgenda);
		guardarContactos(mAgenda);
	}
	
	public static int buscarContactos(String mAgenda[][]) {
		Scanner leer;
		leer = new Scanner(System.in);
		int posi=0;
		String palabra="";
		palabra = leer.nextLine();
		
		for(int i=0;i<mAgenda.length;i++) {
			if ((mAgenda[i][0]!=null) && (mAgenda[i][0].equalsIgnoreCase(palabra))){
				posi=i;
			}
		}
		return posi;
	}
	public static void main(String[] args) {
		Scanner leer;
		leer = new Scanner(System.in);
		int seleccion = 0;
		int posicion=0;
		String mAgenda[][] = new String[5][2];
		
		do { 
			switch (menu()) {
			case 1: 
				verContactos(mAgenda);
				break;
			case 2: 
				guardarContactos(mAgenda);
				break;
			case 3:
				borrarContactos(mAgenda);
				break;
			case 4: 
				modificarContactos(mAgenda);
				break;
			case 5: 
				System.out.println("A quien quieres buscar");
				posicion=buscarContactos(mAgenda);
				System.out.println("La persona que buscas esta en la posicion: "+posicion);
				break;
			case 6: 
				System.out.println("Hasta luego bro");
				break;
			}
		}while(seleccion!=6);

	}

}
