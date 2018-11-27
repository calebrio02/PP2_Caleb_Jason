package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class EquipoComputo extends Especial implements Serializable {
String dispositivo, comercio, TipoCliente;


public EquipoComputo() {	
}

public String getTipoCliente() {
	return TipoCliente;
}
public void setTipoCliente(String tipoCliente) {
	TipoCliente = tipoCliente;
}
public String getDispositivo() {
	return dispositivo;
}

public void setDispositivo(String dispositivo) {
	this.dispositivo = dispositivo;
}

public String getComercio() {
	return comercio;
}

public void setComercio(String comercio) {
	this.comercio = comercio;
}
//INGRESA ESPECIFICO DE LA CLASE DE TIPO EQUPO COMPUTO
public void estableceEquipoComputo() {
	setDispositivo(JOptionPane.showInputDialog("Ingrese el nombre del dispositivo a adquirir"));
	setComercio(JOptionPane.showInputDialog("Ingrese el nombre del comercio donde lo comprara"));
}
public void TipoCliente() {//METOD PARA SELECCIONAR EL TIPO DE CLIENTE ESPECIFICO
	int cambio=1;
	String tipoCliente="";
	do {
		try {
			tipoCliente = (JOptionPane.showInputDialog(null, "Selecciona el tipo de cliente", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
					{ "Selecciona","Docente", "Administrativo"}, "Selecciona")).toString() ;
			
			if(tipoCliente.equalsIgnoreCase("Docente")) {
				ingresaDocente();
				setTipoCliente("Docente");
				
			}else if(tipoCliente.equalsIgnoreCase("Administrativo")) {
				ingresaAdministrativo();
				setTipoCliente("Administrativo");
			}else{
				
				JOptionPane.showMessageDialog(null,"Escoge una de las dos opciones");
			}
	} catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Debes escoger una opcion");
		cambio=0;
	}
	} while (tipoCliente=="Selecciona"||tipoCliente==null||cambio==0);	
}


//INGRESA DE LOS DOS TIPOS DE CLIENTES PARA CREDITO ESPECIAL EQUIPOCOMPUTO//
public void ingresaAdministrativo() {
	EstableceDatosAdministrativos();
	int cambio=0;
	do {
		
		try {
			setMontoCredito(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del credito (�3 600 000 maximo)")));
			cambio=1;
			if(getMontoCredito()<0||getMontoCredito()>3600000) {
				JOptionPane.showMessageDialog(null, "El monto debe ir de �0 a �3600000");
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
		}
	}while(getMontoCredito()<0||getMontoCredito()>3600000||cambio==0);
	setInteres(12);
	setPlazo(60);
	setCuotaPagar(calculoCuotaEspecialOrdinario());
	estableceEquipoComputo();
}

public void ingresaDocente() {
	EstableceDatosDocente();
	int cambio=0;
	
	do {
		
		try {
			setMontoCredito(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el monto del credito (�3 600 000 maximo)")));
			cambio=1;
			if(getMontoCredito()<0||getMontoCredito()>3600000) {
				JOptionPane.showMessageDialog(null, "El monto debe ir de �0 a �3600000");
			}			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Ingrese solo numeros");
		}
	}while(getMontoCredito()<0||getMontoCredito()>3600000||cambio==0);
	setInteres(12);
	setPlazo(60);
	setCuotaPagar(calculoCuotaEspecialOrdinario());
	estableceEquipoComputo();
}


//CALCULO DE LA CUOTA DEL CREDITO ESPECIAL--ORNDINARIO Y ECOMPUNTO -- FUNCIONA PARA TODOS LOS TIPOS DE CLIENTES EN CREDITO ESPECIAL
public double calculoCuotaEspecialOrdinario() {
	double resultado =0;
	resultado = (getMontoCredito()+(getMontoCredito()*getInteres()/100))/getPlazo(); 
	return resultado;
}
///////////////////////////////////////////////////////////////////////


public String MuestraDocente() {//MUESTRA ESPECIFICO DE CLIENTE DOCENTE
	String Muestra="";
	Muestra+=MuestraDatosDocentes() +"Tipo de credito especial: Computo\n"
			+ "Monto solicitado: �"+String.format("%.0f",getMontoCredito())+"\n"
					+ "Equipo a Adquirir: "+getDispositivo()+"\n"
						+ "Comercio de compra: "+getComercio()+"\n"
							+ "Plazo fijo: "+getPlazo()+" meses." +"\n" 
								+ "Interes fijo: "+String.format("%.0f",getInteres())+"%\n"
								+ "Cuota a pagar: �"+String.format("%.0f",getCuotaPagar())+"\n\n";
	
	return Muestra;
}

public String MuestraAdministrativo() {// MUESTRA ESPECIFICO DE CLIENTE  ADMINISTRATIVO
	
	String Muestra="";
	Muestra+=MuestraDatosAdministrativos() +"Tipo de credito especial: Computo\n"
			+ "Monto solicitado: �"+String.format("%.0f",getMontoCredito())+"\n"
			+ "Equipo a Adquirir: "+getDispositivo()+"\n"
				+ "Comercio de compra: "+getComercio()+"\n"
					+ "Plazo fijo: "+getPlazo()+" meses." +"\n" 
						+ "Interes fijo: "+String.format("%.0f",getInteres())+"%\n"
						+ "Cuota a pagar: �"+String.format("%.0f",getCuotaPagar())+"\n\n";
	
	return Muestra;
	
}//FIN DE MUESTRAS ESPECIFICOS


////////////MUESTRAS GENERICOS/////////////////////////////////
public String MuestraCualquiera() {//PARA MOSTRAR CUALQUIER TIPO DE CLIENTE
String Muestra="";

if(getTipoCliente().equals("Docente")) {//SI ES DOCENTE
Muestra=MuestraDocente();//SE MUESTRAN SOLO LOS DATOS DE DOCENTE
}else if(getTipoCliente().equalsIgnoreCase("Administrativo")) {//SI ES ADMINISTRATIVO
Muestra=MuestraAdministrativo();//SE MUESTRAN SOLO LOS DATOS DE ADMINISTRATIVO
}

return Muestra;
}

public String MuestraSoloDNI() {//PARA MOSTRAR CUALQUIER DNI
String Muestra="";

if(getTipoCliente().equals("Docente")) {
Muestra=clienteDo.getDni();
}else if(getTipoCliente().equalsIgnoreCase("Administrativo")) {
Muestra=clienteAd.getDni();
}
return Muestra;
}//FIN DE MUESTRAS GENERICOS


//////////////METODOS ABSTRACTOS//////////////////
@Override
public String toString() {// PARA MOSTRAR LOS DATOS DE ESTA CLASE
// TODO Auto-generated method stub
return MuestraCualquiera();
}
public void Ingresar() {// PARA INGRESAR LOS DATOS DE ESTA CLASE
// TODO Auto-generated method stub
TipoCliente();
									
}												
public String SoloDNI() {//PARA TRAER SOLO EL DNI
// TODO Auto-generated method stub			
return MuestraSoloDNI();					
}												
////////////////////////////////////////////////////
}