package modelo;
import java.io.Serializable;

import javax.swing.*;
public  class  Clientes implements Serializable {
	
String nombre, dni;
double salario;

public Clientes () {
}

public String getNombre() {
	return nombre;
}
public void setNombre(String nombre) {
	this.nombre = nombre;
}
public String getDni() {
	return dni;
}
public void setDni(String dni) {
	this.dni = dni;
}
public double getSalario() {
	return salario;
}
public void setSalario(double salario) {
	this.salario = salario;
}


public void ingresarCliente() {//INGRESA GENERICO PARA CUALQUIER CLIENTE
	//SE ESTABLECEN CONDICIONES Y ESTRUCUTURAS DE CONTROL PARA INGRESAR DATOS SIN ERRORES
	int cambio=0;
			
	setNombre(JOptionPane.showInputDialog("Introduce el nombre"));
	do {
		
		setDni(JOptionPane.showInputDialog("Introduce el DNI de " + getNombre()+"."));
		if(getDni().length()<7||getDni().length()>7) {
			JOptionPane.showMessageDialog(null, "El DNI debe contener 7 numeros!");
		}else {
			
		}
		
		
	}while(getDni().length()<7||getDni().length()>7);
	
	
	do {
		try {
			setSalario(Double.parseDouble(JOptionPane.showInputDialog("Introduce el salario en � correspondiente a " + getNombre()+".")));
			cambio=1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese unicamente numeros");
			cambio=0;
		}
	} while (cambio==0);
	
}
//MUESTRA GENERICO PARA LOS CLIENTES
public String RespuestaCliente()
{	String Muestra="";
	
	Muestra+="DATOS DEL CLIENTE\n"
			+ "Nombre: "+getNombre()+"\n"
			+ "DNI: "+getDni()+"\n"
			+ "Salario: �"+String.format("%.1f",getSalario())+"\n\n";
	
	return Muestra;
	
	}
}
