import java.util.Scanner;
/*
*@version 1.0
*@author Alex Noe
*/
public class Agenda {
	/*
	*Lo primero que creamos para el proyecto es crear un menu en el cual elegiremos las acciones que llevaremos a cabo
	en el programa principal.
	*/
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
	/*
	*Aqui mostramos por pantalla los contactos que tenemos almacenados en memoria 
	*/
	public static void verContactos(String mAgenda[][]) {
		System.out.println("Tus contactos actuales son: ");
		for(int i=0;i<mAgenda.length;i++) {
			if (mAgenda[i][0]!=null) {
				
				System.out.println(mAgenda[i][0]+ mAgenda[i][1]);
		}
		}
		
	}
	/*
	*Este metodo sirve para buscar un espacio en el vector donde almacenamos los contactos.
	*/
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
	/*
	*En este metodo guardaremos los contactos introduciendo un nombre y un numero de telefono
	*/
	public static void guardarContactos(String mAgenda[][]) {
		int posicion=espacio(mAgenda);
		Scanner leer;
		leer = new Scanner(System.in);
		System.out.println("Dime un nombre y un numero para guardar en tu agenda: ");
		
		mAgenda [posicion][0]=leer.nextLine();
		mAgenda [posicion][1]=leer.nextLine();
		
	}
	/*
	*Aqui daremos la opcion de borrar un contacto guardado pasando su posicion a null
	*/
	public static void borrarContactos(String mAgenda[][]) {
		int borrrar=buscarContactos(mAgenda);
		
		mAgenda[borrrar][0]=null;
		mAgenda[borrrar][1]=null;
	}
	/*
	*Aqui modificamos el contacto que tengamos guardado utilizando los metodos de borrar y guardar a la vez
	*/
	public static void modificarContactos(String mAgenda[][]) {
		borrarContactos(mAgenda);
		guardarContactos(mAgenda);
	}
	/*
	*Este metodo sirve para mostrarnos el contacto que queramos buscandolo en el vector
	*/
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
	/*
	*Aqui se llevara a cabo el switch en el que llamamos a nuestro menu y a todos los metodos anteriormente creados
	para que nuestro programa se vea bien y funcione correctamente
	*/
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
