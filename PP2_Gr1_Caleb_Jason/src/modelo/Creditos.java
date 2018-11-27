package modelo;

import java.io.Serializable;

public class Creditos extends Servicios implements Serializable {
	
double montoCredito, cuotaPagar, interes;
int plazo;

public Creditos() {
}
public double getMontoCredito() {
	return montoCredito;
}

public void setMontoCredito(double montoCredito) {
	this.montoCredito = montoCredito;
}

public double getCuotaPagar() {
	return cuotaPagar;
}

public void setCuotaPagar(double cuotaPagar) {
	this.cuotaPagar = cuotaPagar;
}

public double getInteres() {
	return interes;
}

public void setInteres(double interes) {
	this.interes = interes;
}

public int getPlazo() {
	return plazo;
}

public void setPlazo(int plazo) {
	this.plazo = plazo;
}

// IMPLEMENTACION DE LOS DIFERENTES METODOS ABSTRACTOS
@Override
public String toString() {
	// TODO Auto-generated method stub
	return null;
}


@Override
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
}
