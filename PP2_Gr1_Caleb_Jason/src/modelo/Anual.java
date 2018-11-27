package modelo;

import java.io.Serializable;

import javax.swing.JOptionPane;

public class Anual extends PlanesAhorro implements Serializable {

	double porcentajeCliente;
	String TipoCliente;
	int cod;
	
public Anual() {
}	

///////////SETS Y GETS DE ESTA CLASE///////////////////////////

public String getTipoCliente() {
		return TipoCliente;
}


	public void setTipoCliente(String tipoCliente) {
		TipoCliente = tipoCliente;
}
public double getPorcentajeCliente() {
		return porcentajeCliente;
}
public void setPorcentajeCliente(double porcentajeCliente) {
		this.porcentajeCliente = porcentajeCliente;
}// FIN DE SETS Y GETS////////////////


public void IngresarAnual() {//METODO DE INGRESAR DE ESTA CLASE
	
	TipoClienteAnual();
	setPorcentajeCliente(Double.parseDouble(JOptionPane.showInputDialog("Ingrese el porcentaje que desea rebajar de su salario")));
	ingresarMesesCancelados();
}
public void TipoClienteAnual() {//METOD PARA SELECCIONAR EL TIPO DE CLIENTE ESPECIFICO

	String tipoCliente="";
	int cambio=1;
	do {
		try {
			tipoCliente = (JOptionPane.showInputDialog(null, "Selecciona el tipo de cliente", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
					{ "Selecciona","Docente", "Pensionado", "Administrativo"}, "Selecciona")).toString() ;
			
			
			if(tipoCliente.equalsIgnoreCase("Docente")) {
				EstableceDatosDocente();
				setTipoCliente("Docente");
				
			}else if(tipoCliente.equalsIgnoreCase("Pensionado")) {
				EstableceDatosPensionado();
				setTipoCliente("Pensionado");
				
			}else if(tipoCliente.equalsIgnoreCase("Administrativo")) {
				EstableceDatosAdministrativos();
				setTipoCliente("Administrativo");
				
			}else {
				JOptionPane.showMessageDialog(null,"Escoge una de las tres opciones");
				
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			JOptionPane.showMessageDialog(null, "Escoge una opcion");
			cambio=0;
		}

	} while (tipoCliente=="Selecciona"||cambio==0);
}


///////////////////// CALCULOS DE CADA TIPO DE CLIENTE//////////////////////
public double CalculoDocente() {//CALCULO ESPECIFICO DE DOCENTE
	double cuota=0;
	cuota=(clienteDo.getSalario()*getPorcentajeCliente());
	cuota=cuota*getMesesCancelados();
	setSaldo(cuota);
	return getSaldo()/100;
}

public double CalculoPensionado() {//CALCULO ESPECIFICO DE PENSIONADO
	double cuota=0;
	cuota=(clientePe.getSalario()*getPorcentajeCliente());
	cuota=cuota*getMesesCancelados();
	setSaldo(cuota);
	return getSaldo()/100;
}

public double CalculoAdministrativo() {//CALCULO ESPECIFICO DE ADMINISTRATIVO
	double cuota=0;
	cuota=(clienteAd.getSalario()*getPorcentajeCliente());
	cuota=cuota*getMesesCancelados();
	setSaldo(cuota);
	return getSaldo()/100;														//
}//FIN DE LOS CALCULOS


/////////////// MOSTRAR DATOS DE CADA TIPO DE CLIENTE DE ESTA CLASE///////////
public String MuestraDocente() {//MUESTRA ESPECIFICO DE CLIENTE DOCENTE
	String Muestra="";
	Muestra+=MuestraDatosDocentes() +"Tipo de plan de ahorro: Anual\n"
			+ "Porcentaje sobre salario: "+String.format("%.0f",getPorcentajeCliente())+"%\n"
					+ "Meses de ahorro: "+getMesesCancelados()+"\n"
							+ "Total de ahorro: �"+String.format("%.1f", CalculoDocente())+"\n\n";
	
	return Muestra;
}

public String MuestraPensionado() {// MUESTRA ESPECIFICO DE CLIENTE PENSIONADO
	String Muestra="";
	Muestra+=MuestraDatosPensionados()+"Tipo de plan de ahorro: Anual\n"
			+ "Porcentaje sobre salario: "+String.format("%.0f",getPorcentajeCliente())+"%\n"
				+ "Meses de ahorro: "+getMesesCancelados()+"\n"
					+ "Total de ahorro: �"+String.format("%.1f", CalculoPensionado())+"\n\n";
	
	return Muestra;
}

public String MuestraAdministrativo() {// MUESTRA ESPECIFICO DE CLIENTE  ADMINISTRATIVO
	String Muestra="";
	Muestra+=MuestraDatosAdministrativos()+"Tipo de plan de ahorro: Anual\n"
			+ "Porcentaje sobre salario: "+String.format("%.0f",getPorcentajeCliente())+"%\n"
				+ "Meses de ahorro: "+getMesesCancelados()+"\n"
					+ "Total de ahorro: �"+String.format("%.1f", CalculoAdministrativo())+"\n\n";
	
	return Muestra;
}//FIN DE MUESTRAS ESPECIFICOS


////////////MUESTRAS GENERICOS/////////////////////////////////
public String MuestraCualquiera() {//PARA MOSTRAR CUALQUIER TIPO DE CLIENTE
	String Muestra="";
	
		if(getTipoCliente().equalsIgnoreCase("Docente")) {//SI ES DOCENTE
			Muestra=MuestraDocente();//SE MUESTRAN SOLO LOS DATOS DE DOCENTE
		}else if(getTipoCliente().equalsIgnoreCase("Pensionado")) {//SI ES PENSIONADO
			Muestra=MuestraPensionado();//SE MUESTRAN SOLO LOS DATOS DE PENSIONADO
		}else if(getTipoCliente().equalsIgnoreCase("Administrativo")) {//SI ES ADMINISTRATIVO
			Muestra=MuestraAdministrativo();//SE MUESTRAN SOLO LOS DATOS DE ADMINISTRATIVO
		}
	
	return Muestra;
}

public String MuestraSoloDNI() {//PARA MOSTRAR CUALQUIER DNI
	String Muestra="";
	
	if(getTipoCliente().equalsIgnoreCase("Docente")) {
		Muestra=clienteDo.getDni();
	}else if(getTipoCliente().equalsIgnoreCase("Pensionado")) {
		Muestra=clientePe.getDni();
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
	setTipoCliente("");
	IngresarAnual();
 
}
public String SoloDNI() {//PARA TRAER SOLO EL DNI
	// TODO Auto-generated method stub
	return MuestraSoloDNI();
}
////////////////////////////////////////////////////
}//FIN DE CLASE