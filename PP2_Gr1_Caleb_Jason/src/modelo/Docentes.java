package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Docentes extends Clientes implements Serializable  {
String categoria, estado, lugartrabajo; // Categoria --> prof. Adjunto, asociado, catedratico. estado--> interino, propiedad

public Docentes() {}

public String getCategoria() {
	return categoria;
}
public void setCategoria(String categoria) {
	this.categoria = categoria;
}
public String getEstado() {
	return estado;
}
public void setEstado(String estado) {
	this.estado = estado;
}
public String getLugartrabajo() {
	return lugartrabajo;
}
public void setLugartrabajo(String lugartrabajo) {
	this.lugartrabajo = lugartrabajo;
}
//INGRESA GENERICO DEL CLIENTE DE TIPO DOCENTE
public void IngresaDocente () {
	
	ingresarCliente();
	
	escogeCategoria();
	
	escogeEstado();
	
	setLugartrabajo(JOptionPane.showInputDialog("Ingresa el lugar de trabajo de " + getNombre()));
	
}

public void escogeCategoria() {   //Metodos para evitar que el usuario escriba,ya que se le es mas facil escoger por medio del numero, 
	//a nivel del programa es mas facil evitar que ocurran errores
	String tipoDocente="";
	int cambio=1;
	do {
		try {
			
			tipoDocente = (JOptionPane.showInputDialog(null, "Selecciona la categoria de docente", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
					{ "Selecciona","Adjunto", "Asociado", "Catedratico"}, "Selecciona")).toString() ;
			cambio=1;
			
			if(tipoDocente.equalsIgnoreCase("Adjunto")) {
				setCategoria("Adjunto");
				
			}else if(tipoDocente.equalsIgnoreCase("Asociado")) {
				setCategoria("Asociado");
				
			}else if(tipoDocente.equalsIgnoreCase("Catedratico")) {
				setCategoria("Catedratico");
				
			}else {
				JOptionPane.showMessageDialog(null,"Escoge una de las tres opciones");
			}
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Debes escoger una opcion");
			cambio=0;
		}
	} while (tipoDocente=="Selecciona"||cambio==0);
	

}

public void escogeEstado() {//Metodos para evitar que el usuario escriba,ya que se le es mas facil escoger por medio del numero, 
	//a nivel del programa es mas facil evitar que ocurran errores
	String estadoDocente="";
	int cambio=1;
	do {
		try {
			estadoDocente = (JOptionPane.showInputDialog(null, "Selecciona el estado del docente", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
					{ "Selecciona","Propiedad", "Interino"}, "Selecciona")).toString() ;
			cambio=1;
			
			if(estadoDocente.equalsIgnoreCase("Propiedad")) {
				setEstado("Propiedad");
				
			}else if(estadoDocente.equalsIgnoreCase("Interino")) {
				setEstado("Interino");
				
			}else {
				JOptionPane.showMessageDialog(null,"Escoge una de las tres opciones");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Debes escoger una opcion");
			cambio=0;
		}
	} while (estadoDocente=="Selecciona"||cambio==0);
		
}
//METODO DE MUESTRA ESPECIFICO DE ESTA CLASE
public String RespuestaDocente() {
	
	String Respuesta="";
	
	Respuesta+=RespuestaCliente()+"Tipo de cliente: Docente\n"
			+ "Categoria: "+getCategoria()+"\n"
					+ "Estado: "+getEstado()+"\n"
							+ "Lugar de Trabajo: "+getLugartrabajo()+"\n\n";
	
	return Respuesta;
}

}
