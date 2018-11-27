package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Administrativos extends Clientes implements Serializable {

	String puesto, lugarTrabajo;
	
	 public Administrativos() {
	 }
	 
	public String getPuesto() {
		return puesto;
	}
	public void setPuesto(String puesto) {
		this.puesto = puesto;
	}
	public String getLugarTrabajo() {
		return lugarTrabajo;
	}
	public void setLugarTrabajo(String lugarTrabajo) {
		this.lugarTrabajo = lugarTrabajo;
	}
	
public void ingresarAdministrativos() {
		
		ingresarCliente();
		setPuesto(JOptionPane.showInputDialog("Ingresa el puesto de " + getNombre()));
		setLugarTrabajo(JOptionPane.showInputDialog("Ingresa el lugar de trabajo de " + getNombre()));
	}

public String RespuestaAdministrativos() {
	String Respuesta="";
	
	Respuesta+=RespuestaCliente()+"Tipo de cliente: Administrativo\n"
			+ "Puesto: "+getPuesto()+"\n"
			+ "Lugar de trabajo: "+getLugarTrabajo()+"\n\n";
	
	return Respuesta;
}
public void MuestraAdministrativo() {
	
	JOptionPane.showMessageDialog(null, RespuestaAdministrativos());
	
		
	}
}
