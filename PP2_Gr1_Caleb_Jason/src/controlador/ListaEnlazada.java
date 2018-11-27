package controlador;



import java.io.IOException;
import java.io.Serializable;

import javax.naming.CannotProceedException;
import javax.swing.JOptionPane;

import modelo.ALaVista;
import modelo.Anual;
import modelo.Corriente;
import modelo.EquipoComputo;
import modelo.EspecialOrdinario;
import modelo.Servicios;
import modelo.Vivienda;

public class ListaEnlazada {
	Servicios s [] = new Servicios [100];//creacion del array de objetos
	Lista lista = new Lista();
	Corriente c = new Corriente();
	Vivienda v = new Vivienda();
	EspecialOrdinario eo = new EspecialOrdinario();
	EquipoComputo ec = new EquipoComputo();
	Anual a = new Anual();
	ALaVista av = new ALaVista();	
	private int ContUser=0, Cod=1;

public ListaEnlazada() throws IOException, ClassNotFoundException, CannotProceedException {}
//Constructor de la clase que contiene el menu de interaccion que a su vez llama a los diferentes metodos para manipular el arreglo
	
public void menu() throws IOException, ClassNotFoundException, CannotProceedException {
	
	int e2 =0;
		for(;;) {
			//try {
			
			e2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion\n"
														  + "1-Ingresar\n"
														  + "2-Mostrar todos los usuarios\n"
														  + "3-Buscar\n"
														  + "4-Guardar Informacion\n"
														  + "5-Recuperar Informacion\n"
														  + "6-Eliminar\n"
														  + "7-Salir"));
		switch (e2) {
		case 1:Ingresar();// si la opcion es 1 se llama al metodo ingresar
			break;
		case 2:Mostrar();  // si la opcion es 2 se llama al metodo mostrar todos
			break;
		case 3:Buscar();// si la opcion es 3 se llama al metodo buscar con la clave especifica de dni
			break;
		case 4:
			guardarInfo();
			break;
		case 5:
			recuperarInfo();
			break;
		case 6:Eliminar();//si opcion es 4 se llama al metodo eliminar un usario con la lcave especifica de dni
			
			break;
		case 7:
			JOptionPane.showMessageDialog(null, "Has decidido finalizar. Hasta Pronto! :)");
			System.exit(0);//opcion para terminar el programa
			break;
		default:
		JOptionPane.showMessageDialog(null, "Opcion invalida");
		}
			//} catch (Exception e) {
				//JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros.");
				
			//}
		}
}
		

public void Ingresar() {//metodo para escoger las distintas opciones
	String tipoServicio = "";
	// creacion de nuevos opbjetos para no sobreescribir los que ya existen SUPER IMPORTANTE!!!!!!
	
	 c = new Corriente(); 
	 v = new Vivienda();
	 eo = new EspecialOrdinario();
	 ec = new EquipoComputo();
	 a = new Anual();
	 av = new ALaVista();
	 int cambio=1;
		do{

				
				tipoServicio = (JOptionPane.showInputDialog(null, "Selecciona el tipo de servicio", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
						{ "Selecciona","Creditos", "Planes Ahorro"}, "Selecciona")).toString() ;
				cambio=1;
				//menu de seleccion multiple para escoger los dos tipo de paquetes financieros
				
				if(tipoServicio.equalsIgnoreCase("Creditos")) {//si el usuario seleecciona "creditos en el menu se entra a esta condicion"
					String tipoCredito="";
					
					do {

					
						tipoCredito = (JOptionPane.showInputDialog(null, "Selecciona el tipo de credito", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
								{ "Selecciona","Corriente", "Vivienda","Especiales"}, "Selecciona")).toString() ;
						cambio=1;
						//si el usuario selecciono anteriormente "creditos" se le pregunta cual de los tipos de creditos desea
						
						if(tipoCredito.equalsIgnoreCase("Corriente")) {// si escogio "corriente se entra en esta condicion"
							c.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unico
						;// se llama al metodo ingresar abstracto
							c.Ingresar();
							lista.insertarFinal(c);
							
							
						}else 
							if(tipoCredito.equalsIgnoreCase("Vivienda")) {// si escogio "vivienda" se entra en esta condicion"
								v.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
								v.Ingresar();// se llama al metodo ingresar abstracto
								//s[ContUser]=v;// se guarda el objeto en la posicion que tenga ContUser al momento
								lista.insertarFinal(v);
								
							}else
								
								
								
								
								if(tipoCredito.equalsIgnoreCase("Especiales")) {// si escogio "Especiales se entra en esta condicion"
									String tipoEspecial="";
									
									do{

											
											tipoEspecial = (JOptionPane.showInputDialog(null, "Selecciona el tipo credito Especial", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
													{ "Selecciona","Especial Ordinario", "Equipo Computo"}, "Selecciona")).toString() ;
											cambio=1;
											//se le pegunta al cliente cual tipo de credito especial desea
											
											if(tipoEspecial.equalsIgnoreCase("Especial Ordinario")) {
												//si el usuario selecciona especial ordinario se entra en esta condicion
												eo.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
												eo.Ingresar();// se llama al metodo ingresar abstracto
												//s[ContUser]=eo;// se guarda el objeto en la posicion que tenga ContUser al momento
												lista.insertarFinal(eo);
												
											}else 
												if(tipoEspecial.equalsIgnoreCase("Equipo Computo")) {
													//si el usuario selecciona especial ordinario se entra en esta condicion
													
													ec.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
													ec.Ingresar();// se llama al metodo ingresar abstracto
													//s[ContUser]=ec;// se guarda el objeto en la posicion que tenga ContUser al momento
													lista.insertarFinal(ec);
													
												}else {
													
													JOptionPane.showMessageDialog(null,"Escoge una de las dos opciones");
												}

									} while (tipoEspecial=="Selecciona"||cambio==0);
									// con esta condicion se controla que el usuario escoja alguna de las opciones disponibles
								}else{
									
									JOptionPane.showMessageDialog(null,"Escoge una de las tres opciones");
								}

					} while (tipoCredito=="Selecciona"||tipoCredito==null||cambio==0);
				}else 
					
					
					
					
					if(tipoServicio.equalsIgnoreCase("Planes Ahorro")) {//si el usuario seleecciona planes de ahorro en el menu se entra a esta condicion"
						String tipoAhorro="";
						
						do{
							try {
								
								tipoAhorro = (JOptionPane.showInputDialog(null, "Selecciona el tipo de Plan de Ahorro", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
										{ "Selecciona","Anual", "A la Vista"}, "Selecciona")).toString();
								cambio=1;
								// se le pregunta al usuario que tipo de plan de ahorro desea
								
								if(tipoAhorro.equalsIgnoreCase("Anual")) {//si escoge anual se entra en esta condicion	
									a.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
									a.Ingresar();// se llama al metodo ingresar abstracto
									//s[ContUser]=a;// se guarda el objeto en la posicion que tenga ContUser al momento
									lista.insertarFinal(a);
									cambio=1;
									
								}else 
									if(tipoAhorro.equalsIgnoreCase("A la Vista")) {
										av.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
										av.Ingresar();// se llama al metodo ingresar abstracto
										//s[ContUser]=av;// se guarda el objeto en la posicion que tenga ContUser al momento
										lista.insertarFinal(av);
										cambio=1;
										
									}else {
										
										JOptionPane.showMessageDialog(null,"Escoge una de las dos opciones");
									}
							} catch (Exception e) {
								JOptionPane.showMessageDialog(null, "Debes escoger una opcion");
								cambio=0;
							}
						} while (tipoAhorro=="Selecciona"||cambio==0);
					}else  {
						JOptionPane.showMessageDialog(null,"Escoge una de las dos opciones");
					}
		
		}while (tipoServicio=="Selecciona"||cambio==0);
		
Cod++;//cod aumenta de valor
ContUser ++;//cont user aumenta de valor

}

public void Mostrar() {//metodo para recorrer el arreglo de objetos y mostrar todos los clientes que se encuentren ingresados hasta el momento
	
	
	/*for (int i = 0; i < ContUser; i++) {
		
		
		JOptionPane.showMessageDialog(null, s[i].toString());

	}*/
	lista.mostrar();
	
}

public void Buscar(){//metodo para buscar y mostrar a un solo cliente
	lista.buscar();
}


public void Eliminar() {//metodo para eliminar a un cliente que se encuentre dentro del arreglo en ese momento
	lista.eliminaEspecifico();
}
public void guardarInfo() throws IOException {
	lista.guardarInfo();
}

public void recuperarInfo() throws ClassNotFoundException, IOException, CannotProceedException {
	lista.recuperarInfo();
}

public Servicios[] getS() {
	return s;
}

public void setS(Servicios[] s) {
	this.s = s;
}

public Corriente getC() {
	return c;
}

public void setC(Corriente c) {
	this.c = c;
}

public Vivienda getV() {
	return v;
}

public void setV(Vivienda v) {
	this.v = v;
}

public EspecialOrdinario getEo() {
	return eo;
}

public void setEo(EspecialOrdinario eo) {
	this.eo = eo;
}

public EquipoComputo getEc() {
	return ec;
}

public void setEc(EquipoComputo ec) {
	this.ec = ec;
}

public Anual getA() {
	return a;
}

public void setA(Anual a) {
	this.a = a;
}

public ALaVista getAv() {
	return av;
}

public void setAv(ALaVista av) {
	this.av = av;
}
}