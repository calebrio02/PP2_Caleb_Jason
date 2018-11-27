
package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Vivienda extends Creditos implements Serializable  {//clase vivienda que hereda de creditos
	
String direccionPropiedad;
double tamano, peritaje;
String tipoCliente;
double totalCredito;
double totalPeritaje;
int cod;


public double getPeritaje() {
	return peritaje;
}

public void setPeritaje(double peritaje) {
	this.peritaje = peritaje;
}


public double getTotalPeritaje() {
	return totalPeritaje;
}

public void setTotalPeritaje(double totalPeritaje) {
	this.totalPeritaje = totalPeritaje;
}

public double getTotalCredito() {
	return totalCredito;
}

public void setTotalCredito(double totalCredito) {
	this.totalCredito = totalCredito;
}

public String getTipoCliente() {
	return tipoCliente;
}

public void setTipoCliente(String tipoCliente) {
	this.tipoCliente = tipoCliente;
}

public String getDireccionPropiedad() {
	return direccionPropiedad;
}

public void setDireccionPropiedad(String direccionPropiedad) {
	this.direccionPropiedad = direccionPropiedad;
}

public double getTamano() {
	return tamano;
}

public void setTamano(double tamano) {
	this.tamano = tamano;
}


public void estableceVivienda() {// ingresa especifico de esta clase 
	int cambio=0;
  setDireccionPropiedad(JOptionPane.showInputDialog("Ingrese la direccion de la "
  		+ "propiedad"));
//se preguntan especificamente los datos que se necesitan. 
//Asimismo se dan diferentes estrucuturas de control para que el usuario no ingrese un dato indebido y se caiga el prgrama
  	do {
		try {
			setTamano(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el tamano de la propiedad en m�")));
			cambio=1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
  	
	do {
		try {
			setTotalPeritaje(Long.parseLong(JOptionPane.showInputDialog("Ingrese el peritaje de la propiedad (valor de propiedad)")));
			cambio=1;
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
}



public void EscogeIngresaCliente() {
	
//estrucutura de control para luego solo mostrar los datos del cliente especifico y no confundirlos con otros
	
	String elCliente="";
	int cambio=1;
	do {
		try {
			
			elCliente= (JOptionPane.showInputDialog(null, "Selecciona el tipo de cliente", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
					{ "Selecciona","Docente", "Pensionado", "Administrativo"}, "Selecciona")).toString() ;
			
			if(elCliente.equalsIgnoreCase("Docente")) {
				setTipoCliente("Docente");
				ingresaDocenteCreditoVivienda();;
			}else if(elCliente.equalsIgnoreCase("Pensionado")) {
				setTipoCliente("Pensionado"); 
				ingresaPensionadoCreditoVivienda();;
			}else if(elCliente.equalsIgnoreCase("Administrativo")) {
				setTipoCliente("Administrativo");
				ingresaAdministrativoCreditoVivienda();
			}
		} catch (Exception e) {

			JOptionPane.showMessageDialog(null, "Escoge una opcion");
			cambio=0;
		}
	} while (cambio==0||elCliente.equals("Selecciona"));
	

}

//INGRESA DE LOS TIPOS DE CLIENTES PARA CREDITO VIVIENDA//
public void ingresaAdministrativoCreditoVivienda() {
	EstableceDatosAdministrativos();
	int cambio=0;
	do {
		do {
			try {
				setTotalCredito(Long.parseLong(JOptionPane.showInputDialog("Ingrese el monto del credito (de �20 000 000 a �81 000 000 )")));
				cambio=1;
				if(getTotalCredito()<20000000||getTotalCredito()>81000000) {
					JOptionPane.showMessageDialog(null, "El monto debe ir de �20 000 000 a �81 000 000");
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
	}while(getTotalCredito()<20000000||getTotalCredito()>81000000);
	
	setInteres(16);
	do {
		do {
			try {
				setPlazo(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el plazo (Debe estar entre 144 y 360 meses)")));
				cambio=1;
				if(getPlazo()<144||getPlazo()>360) {
					JOptionPane.showMessageDialog(null, "El plazo debe estar entre 144 y 360 meses");
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
	}while(getPlazo()<144||getPlazo()>360);
	setCuotaPagar(calculoCuotaVivienda());
	estableceVivienda();
}
//MUESTRA DE LOS CLIENTES DE CREDITO VIVIENDA
public String muestraDatosAdministrativoVivienda() {
	String mensaje = "";
	//SE LES DA UN FORMATO ESPECIAL A ALGUNOS DE LOS VALORES CON NUMEROS GRANDES
	mensaje += MuestraDatosAdministrativos() + "Monto del Credito: �" + String.format("%.0f", getTotalCredito()) + "\n"
	+ "Interes: " +String.format("%.0f",getInteres()) +"%\n"
	+ "Plazo: " + getPlazo() + " meses.\n"
	+ "Cuota a pagar: �" + String.format("%.0f",getCuotaPagar()) + "\n"
	+ "Direccion de la propiedad: " + getDireccionPropiedad()+ "\n"
	+ "Tamano de la propiedad: " +String.format("%.0f", getTamano() )+ "m�\n" 
	+ "Peritaje: �" + String.format("%.0f",getTotalPeritaje());
			
	return mensaje;
}


public void ingresaDocenteCreditoVivienda() {
	EstableceDatosDocente();
	int cambio=0;
	do {
		do {
			try {
				setTotalCredito(Long.parseLong(JOptionPane.showInputDialog("Ingrese el monto del credito (de �20 000 000 a �81 000 000 )")));
				cambio=1;
				if(getTotalCredito()<20000000||getTotalCredito()>81000000) {
					JOptionPane.showMessageDialog(null, "El monto debe ir de �20 000 000 a �81 000 000");
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
	}while(getTotalCredito()<20000000||getTotalCredito()>81000000);
	
	setInteres(16);
	do {
		do {
			try {
				setPlazo(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el plazo (Debe estar entre 144 y 360 meses)")));
				cambio=1;
				if(getPlazo()<144||getPlazo()>360) {
					JOptionPane.showMessageDialog(null, "El plazo debe estar entre 144 y 360 meses");
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
	}while(getPlazo()<144||getPlazo()>360);
	setCuotaPagar(calculoCuotaVivienda());
	estableceVivienda();
}
public String muestraDatosDocenteVivienda() {
	String mensaje = "";
	mensaje += MuestraDatosDocentes() + "Monto del Credito: �" + String.format("%.0f", getTotalCredito()) + "\n"
			+ "Interes: " +String.format("%.0f",getInteres()) +"%\n"
			+ "Plazo: " + getPlazo() + " meses.\n"
			+ "Cuota a pagar: �" + String.format("%.0f",getCuotaPagar()) + "\n"
			+ "Direccion de la propiedad: " + getDireccionPropiedad()+ "\n"
			+ "Tamano de la propiedad: " +String.format("%.0f", getTamano() )+ "m�\n" 
			+ "Peritaje: �" + String.format("%.0f",getTotalPeritaje());
			
	return mensaje;
}
public void ingresaPensionadoCreditoVivienda() {
	EstableceDatosPensionado();
	int cambio=0;
	do {
		do {
			try {
				setTotalCredito(Long.parseLong(JOptionPane.showInputDialog("Ingrese el monto del credito (de �20 000 000 a �81 000 000 )")));
				cambio=1;
				if(getTotalCredito()<20000000||getTotalCredito()>81000000) {
					JOptionPane.showMessageDialog(null, "El monto debe ir de �20 000 000 a �81 000 000");
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
	}while(getTotalCredito()<20000000||getTotalCredito()>81000000);
	
	setInteres(16);
	do {
		do {
			try {
				setPlazo(Integer.parseInt(JOptionPane.showInputDialog("Ingresa el plazo (Debe estar entre 144 y 360 meses)")));
				cambio=1;
				if(getPlazo()<144||getPlazo()>360) {
					JOptionPane.showMessageDialog(null, "El plazo debe estar entre 144 y 360 meses");
				}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
			cambio=0;
		}
	} while (cambio==0);
	}while(getPlazo()<144||getPlazo()>360);
	setCuotaPagar(calculoCuotaVivienda());
	estableceVivienda();
}

public String muestraDatosPensionadovivienda() {
	String mensaje = "";
	mensaje += MuestraDatosPensionados()+ "Monto del Credito: �" + String.format("%.0f", getTotalCredito()) + "\n"
			+ "Interes: " +String.format("%.0f",getInteres()) +"%\n"
			+ "Plazo: " + getPlazo() + " meses.\n"
			+ "Cuota a pagar: �" + String.format("%.0f",getCuotaPagar()) + "\n"
			+ "Direccion de la propiedad: " + getDireccionPropiedad()+ "\n"
			+ "Tamano de la propiedad: " +String.format("%.0f", getTamano() )+ "m�\n" 
			+ "Peritaje: �" + String.format("%.0f",getTotalPeritaje());
			
	return mensaje;
}

//CALCULO GENERICO PARA TODOS LOS CLIENTES DE VIVIENDA
public double calculoCuotaVivienda() {
	double resultado=0;
	double elDiez= 0;
	resultado = (getTotalCredito()+(getTotalCredito()*getInteres()/100));
	elDiez = resultado + (resultado*0.10);
	
	return elDiez/getPlazo();
}
//METODO PARA SOLO LLAMAR AL DNI
public String muestraDni() {
	String mensaje = "";
	
	if(getTipoCliente().equalsIgnoreCase("Administrativo")) {
		mensaje = clienteAd.getDni();
	}else if(getTipoCliente().equalsIgnoreCase("Docente")) {
		mensaje = clienteDo.getDni();
	}else if(getTipoCliente().equalsIgnoreCase("Pensionado")) {
		mensaje = clientePe.getDni();
	}
	return mensaje;
}


//METODO ESPECIAL PAAR SOLO IMPRIMIR LOS DATOS DE UN TIPO DE CLIENTE
public String muestraCualquiera() {
	
	String mensaje = "";
	if(getTipoCliente().equalsIgnoreCase("Administrativo")) {
		mensaje = muestraDatosAdministrativoVivienda();
	}else if(getTipoCliente().equalsIgnoreCase("Docente")) {
		mensaje = muestraDatosDocenteVivienda();
	}else if(getTipoCliente().equalsIgnoreCase("Pensionado")) {
		mensaje = muestraDatosPensionadovivienda();
	}
	
	return "Tipo de credito: Vivienda \n\n"+mensaje;
}

@Override
public String SoloDNI() {
	// TODO Auto-generated method stub
	return muestraDni();
}

@Override
public void Ingresar() {
	EscogeIngresaCliente();
	// TODO Auto-generated method stub
	
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return muestraCualquiera();
}
}