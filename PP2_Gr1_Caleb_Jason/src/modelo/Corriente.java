package modelo;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.io.Serializable;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Corriente extends Creditos implements Serializable {
		
double hipoteca;
double montoHipoteca;
String tipoCliente;
JInternalFrame iFrame = new JInternalFrame("Hola");

public double getMontoHipoteca() {
	return montoHipoteca;
}
public void setMontoHipoteca(double montoHipoteca) {
	this.montoHipoteca = montoHipoteca;
}
public Corriente() {
}
public double getHipoteca() {
	return hipoteca;
}
public void setHipoteca(double hipoteca) {
	this.hipoteca = hipoteca;
}
public void setTipoCliente(String tipoCliente) {
	this.tipoCliente = tipoCliente;
}
public String getTipoCliente() {
	return tipoCliente;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void EscogeIngresaCliente() {
	//METODO PARA ESOCGER E INGRESAR LOS DATOS ESPECIFICOS DEL TIPO DE CLIENTE QUE SE ESCOJA
	String elCliente="";
	int cambio=1;
	
	do {
		try {
			
			elCliente = (JOptionPane.showInputDialog(null, "Selecciona el tipo de cliente", null, JOptionPane.PLAIN_MESSAGE,null, new Object[]
					{ "Selecciona","Docente", "Pensionado", "Administrativo"}, "Selecciona")).toString() ;
			
			if(elCliente.equalsIgnoreCase("Docente")) {
				setTipoCliente("Docente");
				ingresaDocenteCreditoCorriente();
			}else if(elCliente.equalsIgnoreCase("Pensionado")) {
				setTipoCliente("Pensionado"); 
				ingresaPensionadoCreditoCorriente();
			}else if(elCliente.equalsIgnoreCase("Administrativo")) {
				setTipoCliente("Administrativo");
				ingresaAdministrativoCreditoCorriente();
			}else {
				JOptionPane.showMessageDialog(null, "Debes escoger una opcion");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Escoge una opcion");
			cambio=0;
		}
	} while (cambio==0||elCliente.equals("Selecciona"));
	

}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

//INGRESA Y MUESTRA DE LOS TRES TIPOS DE CLIENTES PARA CREDITO CORRIENTE//
public void ingresaAdministrativoCreditoCorriente() {

	
	
	//EstableceDatosAdministrativos();
	setMontoCredito(calculoMontoCreditoAdministrativoCorriente());
	setInteres(22);

	setCuotaPagar(calculoCoutaCorriente());
	setHipoteca(calculoHipotecaCorriente());
	
	
}
public String muestraDatosAdministrativosCorriente() {
	String mensaje = "";
	mensaje += MuestraDatosAdministrativos() + "Monto del Credito: ¢" +String.format("%.0f", getMontoCredito())+ "\n"
	+ "Interes: " +String.format("%.0f",getInteres()) + "%\n"
	+ "Plazo: " + getPlazo() + " meses.\n"
	+ "Cuota a pagar: ¢" + String.format("%.0f",getCuotaPagar())
	+ "\n///////////////////////////////////";
			
	return mensaje;
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//PLANTILLA GRAFICA DEL CLIENTE ADMINISTRATICO *CORRIENTE*


public void ingresaDocenteCreditoCorriente() {
	
	
	setMontoCredito(calculoMontoCreditoDocenteCorriente());
	setInteres(22);
	
	setCuotaPagar(calculoCoutaCorriente());
	setHipoteca(calculoHipotecaCorriente());
	
}

public String muestraDatosDocentesCorriente() {
	String mensaje = "";
	mensaje += MuestraDatosDocentes()+ "Monto del Credito: ï¿½" +String.format("%.0f", getMontoCredito())+ "\n"
			+ "Interes: " +String.format("%.0f",getInteres()) + "%\n"
			+ "Plazo: " + getPlazo() + " meses.\n"
			+ "Cuota a pagar: ï¿½" + String.format("%.0f",getCuotaPagar()) 
			+ "\n///////////////////////////////////";
	
	return mensaje;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public JDesktopPane dskCorrienteDocente() {
	
	//Escritorio
	JDesktopPane desktopI = new JDesktopPane();
	
	//JCombobox's
	
	JComboBox boxC;
	JComboBox boxE;
	
	String[] categoriaDocente = {"Selecciona","Adjunto","Asociado","Catedratico"};//categoria del docente
	String[] estadoDocente = {"selecciona","Propiedad", "Interino"};//estado del docente
	
	boxC = new JComboBox(categoriaDocente);
	boxC.setBounds(200, 200, 200, 20);
	desktopI.add(boxC);
	
	boxE = new JComboBox(estadoDocente);
	boxE.setBounds(200, 150, 200, 20);
	desktopI.add(boxE);
	
	
	
	//textfields
	
	JTextField lugarTrabajo = new JTextField();
	lugarTrabajo.setColumns(10);
	lugarTrabajo.setBounds(150, 42, 130, 26);
	desktopI.add(lugarTrabajo);
	
	JTextField plazo = new JTextField();
	plazo.setColumns(10);
	plazo.setBounds(150, 70, 130, 26);
	desktopI.add(plazo);

	
	//labels
	
	JLabel labelLugarTrabajo = new JLabel("Lugar de trabajo");
	labelLugarTrabajo.setBounds(26, 42, 200, 16);
	desktopI.add(labelLugarTrabajo);

	JLabel lPlazo = new JLabel("Plazo");
	lPlazo.setBounds(26, 70, 200, 16);
	desktopI.add(lPlazo);
	
	JLabel lCategoriaDocente = new JLabel("Categoria del Docente");
	lCategoriaDocente.setBounds(26, 200, 200, 20);
	desktopI.add(lCategoriaDocente);

	JLabel lEstadoDocente = new JLabel("Estado del Docente");
	lEstadoDocente.setBounds(26, 150, 200, 20);
	desktopI.add(lEstadoDocente);

	
	//Buttons
		JButton ingresar = new JButton("ingresar");
		
		ingresar.setBounds(227, 277, 90, 23);
		ingresar.setVisible(true);
		ingresar.addActionListener(new ActionListener() {
		
			public void actionPerformed(ActionEvent arg0) {
				ingresaDocenteCreditoCorriente();
				setTipoCliente("Docente");
				setPlazo(Integer.parseInt(plazo.getText()));
				clienteDo.setLugartrabajo(lugarTrabajo.getText());
				clienteDo.setCategoria(boxC.getSelectedItem().toString());
				clienteDo.setEstado(boxE.getSelectedItem().toString());
				
				//MENSAJE INFORMATIVO TEMPORIZADO
				  JOptionPane opt = new JOptionPane("Datos Agregados", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
				  final JDialog dlg = opt.createDialog("Aviso");
				  new Thread(new Runnable()
				        {
				          public void run()
				          {
				            try
				            {
				              Thread.sleep(1000);//Duracion de un segundo para que el mensaje desaparezca
				              dlg.dispose();

				            }
				            catch ( Throwable th )
				            {
				          
				            }
				          }
				        }).start();
				  dlg.setVisible(true);
				
				 
			}
		});
		JButton volver = new JButton("Volver");
		volver.setBounds(333, 277, 80, 23);
		volver.setVisible(true);
		volver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				iFrame.dispose();
			}
		});
		desktopI.add(ingresar);
		desktopI.add(volver);
	 	desktopI.setSize(600,400);
		desktopI.setBounds(0, 0, 640, 640);
		desktopI.setVisible(true);
		

	
	return desktopI;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

public void ingresaPensionadoCreditoCorriente() {
	
	
	setMontoCredito(calculoMontoCreditoPensionadoCorriente());
	setInteres(22);
	
	setCuotaPagar(calculoCoutaCorriente());
	setHipoteca(calculoHipotecaCorriente());

}



///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
public String muestraDatosPensionadosCorriente() {
	String mensaje = "";
	mensaje += MuestraDatosPensionados() + "Monto del Credito: ï¿½" +String.format("%.0f", getMontoCredito())+ "\n"
			+ "Interes: " +String.format("%.0f",getInteres()) + "%\n"
			+ "Plazo: " + getPlazo() + " meses.\n"
			+ "Cuota a pagar: ï¿½" + String.format("%.0f",getCuotaPagar());
			
	return mensaje;
}


public JDesktopPane dskCorrientePensionado() {
	//escritorio
		JDesktopPane desktopI = new JDesktopPane();
		
		//Combo box
		JComboBox boxT;
		JComboBox boxE;
		
		String[] tipoPensionado = {"Selecciona","Docente","Administrativo"};//Area  en la que se desempeniaba
		
		
		boxT= new JComboBox(tipoPensionado);
		boxT.setBounds(200, 200, 200, 20);
		desktopI.add(boxT);
		
		
		
		
		
			//textfields
		JTextField aniosPensionado = new JTextField();
		aniosPensionado.setColumns(10);
		aniosPensionado.setBounds(150, 42, 130, 26);
		desktopI.add(aniosPensionado);
		
		JTextField plazo = new JTextField();
		plazo.setColumns(10);
		plazo.setBounds(150, 70, 130, 26);
		desktopI.add(plazo);
		
		JTextField montoHipoteca = new JTextField();
		montoHipoteca.setColumns(10);
		montoHipoteca.setBounds(150, 98, 130, 26);
		desktopI.add(montoHipoteca);
		
		
		
		//Labels
		
		JLabel lAniosPensionado = new JLabel("Anos pensionado");
		lAniosPensionado.setBounds(26, 42, 200, 16);
		desktopI.add(lAniosPensionado);
		
		JLabel lPlazo = new JLabel("plazo");
		lPlazo.setBounds(26, 70, 200, 16);
		desktopI.add(lPlazo);
		
		JLabel lHipoteca = new JLabel("Monto de Hipoteca");
		lHipoteca.setBounds(26, 98, 200, 16);
		desktopI.add(lHipoteca);
		
		JLabel areaDesempeniada = new JLabel("Area en que desempeno");
		areaDesempeniada.setBounds(26, 200, 200, 20);
		desktopI.add(areaDesempeniada);
		
	
		
		//Buttons
		JButton ingresar = new JButton("ingresar");

		ingresar.setBounds(227, 277, 90, 23);
		ingresar.setVisible(true);
		ingresar.addActionListener(new ActionListener() {
			
			

			public void actionPerformed(ActionEvent arg0) {
				setTipoCliente("Pensionado");
				setPlazo(Integer.parseInt(plazo.getText()));		
				setMontoHipoteca((Double.parseDouble(montoHipoteca.getText())));
				ingresaPensionadoCreditoCorriente();
				clientePe.setTipoEmpleado(boxT.getSelectedItem().toString());
				clientePe.setAnosjubilado(Integer.parseInt(aniosPensionado.getText()));
				
				  JOptionPane opt = new JOptionPane("Datos Agregados", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
				  final JDialog dlg = opt.createDialog("Aviso");
				  new Thread(new Runnable()
				        {
				          public void run()
				          {
				            try
				            {
				              Thread.sleep(1000);//Duracion de un segundo para que el mensaje desaparezca
				              dlg.dispose();

				            }
				            catch ( Throwable th )
				            {
				            
				            }
				          }
				        }).start();
				  dlg.setVisible(true);
				
				
		
				
				 
			}
		});
		desktopI.add(ingresar);
		
		
			
		
		
		 	desktopI.setSize(600,400);
			desktopI.setBounds(0, 0, 640, 640);
			desktopI.setVisible(true);
			

		
		return desktopI;
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//Calculo del monto total  del credito CORRIENTE-- ADMINISTRATIVOS 
public double calculoMontoCreditoAdministrativoCorriente() {
	double resultado =0;
	
resultado = clienteAd.getSalario()+(clienteAd.getSalario()*0.90);
return resultado;
	
}

///////////////////////////////////////////////////////////////////////



//Calculo del monto total CORRIENTE-- DOCENTES
public double calculoMontoCreditoDocenteCorriente() {
	double resultado =0;
	
resultado = clienteDo.getSalario()+(clienteDo.getSalario()*0.90);
return resultado;
	
}

///////////////////////////////////////////////////////////////////////


//Calculo del monto total del credito CORRIENTE-- PENSIONADOS 
public double calculoMontoCreditoPensionadoCorriente() {
	double resultado =0;
	
resultado = clientePe.getSalario()+(clientePe.getSalario()*0.90);
return resultado;
	
}
///////////////////////////////////////////////////////////////////////

//CALCULO DE LA CUOTA DEL CREDITO CORRIENTE-FUNCIONA PARA TODOS LOS TIPOS DE CLIENTES EN CREDITO CORRIENTE

public double calculoCoutaCorriente() {
	double resultado =0;
	resultado = (getMontoCredito()+(getMontoCredito()*getInteres()/100))/getPlazo();
	return resultado;
}

//CALCULO DE LA HIPOTECA DE CREDITO CORRIENTE-FUNCIONA PARA TODOS LOS TIPOS DE CLIENTES EN CREDITO CORRIENTE

public double calculoHipotecaCorriente() {
	double resultado=0;
	double calculo = 0;
	calculo = getMontoCredito()*0.20;
	
	resultado = getMontoCredito() - calculo;
	
	return resultado;
}



//MUESTRAS GENERICOS
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
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

public String muestraCualquiera() {
	
	String mensaje = "";
	if(getTipoCliente().equalsIgnoreCase("Administrativo")) {
		mensaje = muestraDatosAdministrativosCorriente();
	}else if(getTipoCliente().equalsIgnoreCase("Docente")) {
		mensaje = muestraDatosDocentesCorriente();
	}else if(getTipoCliente().equalsIgnoreCase("Pensionado")) {
		mensaje = muestraDatosPensionadosCorriente();
	}
	
	return mensaje;
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
	return "Tipo de credito: Corriente\n\n"+muestraCualquiera();
}
}