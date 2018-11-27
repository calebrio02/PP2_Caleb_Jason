package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Pensionados extends Clientes implements Serializable {
	int anosjubilado;
	String tipoPensionado;
	
public Pensionados() {}
//INGRESA ESPECIFICO DE LA CLASE DE ESTE TIPO DE CLIENTE	
public void IngresaPensionado() {
// SE IMPLEMENTAN CONDICIONES Y ESTRUCUTURAS DE CONTROL PARA EVITAR DATOS ERRONEOS
	int cambio=1;
	String anterior="";
	ingresarCliente();
	
	do {
		try {
		anterior = (JOptionPane.showInputDialog(null, "Selecciona el area en la que se desempe�aba", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
				{ "Selecciona","Docente", "Administrativo"}, "Selecciona")).toString() ;
		
		if(anterior.equalsIgnoreCase("Docente")) {
			setTipoEmpleado("Docente");
			
		}else if(anterior.equalsIgnoreCase("Administrativo")) {
			setTipoEmpleado("Administrativo");
		}
		
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Debes escoger una opcion");
		cambio=0;
	}
	} while (anterior.equals("Seleccionar")||cambio==0);
	do {
		try {
			setAnosjubilado(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de a�os jubilado (a) de " + getNombre())));
			cambio=1;
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingresa solo numeros");
			cambio=0;
		}
	} while (cambio==0);

}

public int getAnosjubilado() {
		return anosjubilado;
	}

public void setAnosjubilado(int anosjubilado) {
		this.anosjubilado = anosjubilado;
	}
public String getTipoEmpleado() {
		return tipoPensionado;
	}
public void setTipoEmpleado(String tipoEmpleado) {
		this.tipoPensionado = tipoEmpleado;
	}
	
//METODO DE MUESTRA ESPECIFICO DE ESTA CLASE	
public String RespuestaPensionado() {
	String Respuesta="";
	
	Respuesta+=RespuestaCliente()+"Tipo de Cliente: Pensionado\n"
	+"A�os jubilado: "+getAnosjubilado()+"\n"
			+ "Area en la que se desempe�aba: "+getTipoEmpleado()+"\n\n";
	
	return Respuesta;
}
}
