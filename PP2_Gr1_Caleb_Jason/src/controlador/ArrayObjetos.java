package controlador;

import javax.swing.JOptionPane;

import modelo.ALaVista;
import modelo.Anual;
import modelo.Corriente;
import modelo.EquipoComputo;
import modelo.EspecialOrdinario;
import modelo.Servicios;
import modelo.Vivienda;

public class ArrayObjetos {
	Servicios s [] = new Servicios [100];//creacion del array de objetos
	Corriente c = new Corriente();
	Vivienda v = new Vivienda();
	EspecialOrdinario eo = new EspecialOrdinario();
	EquipoComputo ec = new EquipoComputo();
	Anual a = new Anual();
	ALaVista av = new ALaVista();	
	private int ContUser=0, Cod=1;

public ArrayObjetos() {
//Constructor de la clase que contiene el menu de interaccion que a su vez llama a los diferentes metodos para manipular el arreglo
	
	
	int e2 =0;
		for(;;) {
			try {
			
			e2= Integer.parseInt(JOptionPane.showInputDialog("Ingrese una opcion\n"
														  + "1-Ingresar\n"
														  + "2-Mostrar todos los usuarios\n"
														  + "3-Buscar\n"
														  + "4-Eliminar\n"
														  + "5-Salir"));
		switch (e2) {
		case 1:Ingresar();// si la opcion es 1 se llama al metodo ingresar
			break;
		case 2:Mostrar();  // si la opcion es 2 se llama al metodo mostrar todos
			break;
		case 3:Buscar();// si la opcion es 3 se llama al metodo buscar con la clave especifica de dni
			break;
		case 4:Eliminar();//si opcion es 4 se llama al metodo eliminar un usario con la lcave especifica de dni
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Has decidido finalizar. Hasta Pronto! :)");
			System.exit(0);//opcion para terminar el programa
			break;
		default:
		JOptionPane.showMessageDialog(null, "Opcion invalida");
		}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros.");
				
			}
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
					c = new Corriente();
					String tipoCredito="";
					
					do {

					
						tipoCredito = (JOptionPane.showInputDialog(null, "Selecciona el tipo de credito", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
								{ "Selecciona","Corriente", "Vivienda","Especiales"}, "Selecciona")).toString() ;
						cambio=1;
						//si el usuario selecciono anteriormente "creditos" se le pregunta cual de los tipos de creditos desea
						
						if(tipoCredito.equalsIgnoreCase("Corriente")) {// si escogio "corriente se entra en esta condicion"
							c.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unico
							c.Ingresar();// se llama al metodo ingresar abstracto
							s[ContUser]=c;// se guarda el objeto en la posicion que tenga ContUser al momento
							
						}else 
							if(tipoCredito.equalsIgnoreCase("Vivienda")) {// si escogio "vivienda" se entra en esta condicion"
								v.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
								v.Ingresar();// se llama al metodo ingresar abstracto
								s[ContUser]=v;// se guarda el objeto en la posicion que tenga ContUser al momento
								
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
												s[ContUser]=eo;// se guarda el objeto en la posicion que tenga ContUser al momento
												
											}else 
												if(tipoEspecial.equalsIgnoreCase("Equipo Computo")) {
													//si el usuario selecciona especial ordinario se entra en esta condicion
													
													ec.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
													ec.Ingresar();// se llama al metodo ingresar abstracto
													s[ContUser]=ec;// se guarda el objeto en la posicion que tenga ContUser al momento
													
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
									s[ContUser]=a;// se guarda el objeto en la posicion que tenga ContUser al momento
									cambio=1;
									
								}else 
									if(tipoAhorro.equalsIgnoreCase("A la Vista")) {
										av.setCod(Cod);//se le da el valor de la variable cod para darle un codigo unic
										av.Ingresar();// se llama al metodo ingresar abstracto
										s[ContUser]=av;// se guarda el objeto en la posicion que tenga ContUser al momento
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
	
	
	for (int i = 0; i < ContUser; i++) {
		
		
		JOptionPane.showMessageDialog(null, s[i].toString());

	}
	
}

public void Buscar(){//metodo para buscar y mostrar a un solo cliente
	
	String t,m="";
	int b;
	
	for(int i=0;i<ContUser;i++) {
		
		m+="\n"+s[i].getCod()+"- "+s[i].SoloDNI();//se hace uso del metodo para llamar solo el nombre del cliente y asi saber a quien se mostrara
		
		}
	try {
		
	
	t = JOptionPane.showInputDialog(null, "Digite el codigo del cliente a buscar. "+m);
	
	if(t!=null&&!t.equals("")) {
		
		b = Integer.parseInt(t); t = "";
	
	if(ContUser!=0) {
		
		for(int i=0;i<ContUser;i++) {
			
			if (s[i].getCod()==b) {
				
				t = "";
				t +=s[i].toString();//uso del metodo toString para mostrar todos los datos del cliente a buscar
			break;
			}
			
			else {
				
				t = "No se ha encontrado al cliente";
			}
		}
		JOptionPane.showMessageDialog(null, t);
	}
	}
	} catch (Exception e) {
	JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros");
	}
}
	
public void Eliminar() {//metodo para eliminar a un cliente que se encuentre dentro del arreglo en ese momento
	int e;
	String m="";
	
	Servicios Borra [] = new Servicios[ContUser-1]; 
	
	for(int i=0;i<ContUser;i++) {
		
	m+="\n"+s[i].getCod()+"- "+s[i].SoloDNI();//uso del metodo para mostrar solo el nombre y asi saber a quien se eliminara

	}
	try {
		
	
	e = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite el codigo del cliente a eliminar. "+m));
	
	if (e<=ContUser) {
		
		for(int i=0;i<ContUser;i++) {
			
			if (e==s[i].getCod()) {
				
				continue;}
			
			else {
				
				if(s[i].getCod()<e) {
				
					Borra[i]=s[i];
				}
				
			if (s[i].getCod()>e) {
				
				s[i].setCod(i);
				
				Borra[i-1]=s[i];
			}
			}
		}
	s = null; Cod--; ContUser--;
	
	s = new Servicios [100];
	
	for (int i=0; i<Borra.length;i++) {
		
		s[i]=Borra[i];
	}
	}
	else {
		
		JOptionPane.showMessageDialog(null, "El cliente a eliminar no existe.");
	}
	} catch (Exception e2) {
		JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros");
	}
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