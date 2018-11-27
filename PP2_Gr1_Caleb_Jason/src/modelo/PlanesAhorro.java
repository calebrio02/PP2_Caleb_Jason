package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class PlanesAhorro extends Servicios implements Serializable {
	
	double saldo;
	int mesesCancelados;
	
public PlanesAhorro() {	
}


//////////SETS Y GETS DE ESTA CLASE
public double getSaldo() {
	return saldo;
}
public void setSaldo(double saldo) {
	this.saldo = saldo;
}
public int getMesesCancelados() {
	return mesesCancelados;
}
public void setMesesCancelados(int mesesCancelados) {
	this.mesesCancelados = mesesCancelados;
}//FIN DE SETS Y GETS////////////////////


public void ingresarMesesCancelados() {//INGRESA DE ESTA CLASE
	setMesesCancelados(Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de meses cancelados")));
}
public String SoloDNI() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public void Ingresar() {
	// TODO Auto-generated method stub	
}
@Override
public String Muestra() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return null;
}
}//FIN DE ESTA CLASE
