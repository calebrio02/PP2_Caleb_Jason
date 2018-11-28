package modelo;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.beans.PropertyVetoException;
import java.io.IOException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDesktopPane;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.CaretEvent;
import javax.swing.plaf.basic.BasicInternalFrameUI;

import controlador.Lista;

public class GUI<E> {
	String nombre, dni, salario;
	
	public JInternalFrame getiFrame() {
		return iFrame;
	}

	public void setiFrame(JInternalFrame iFrame) {
		this.iFrame = iFrame;
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

	public String getSalario() {
		return salario;
	}

	public void setSalario(String salario) {
		this.salario = salario;
	}
	Lista lista = new Lista();
	Corriente c = new Corriente();
	Vivienda v = new Vivienda();
	EspecialOrdinario eo = new EspecialOrdinario();
	EquipoComputo ec = new EquipoComputo();
	Anual a = new Anual();
	ALaVista av = new ALaVista();
	JFrame frame = new JFrame("Menu principal Sistema PIAL");	
	JDesktopPane escritorioP = new JDesktopPane();
	JInternalFrame iFrame = new JInternalFrame("Ingresar");
	JDesktopPane desktopI = new JDesktopPane();
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////	
	
public void inicio() {
	
escritorioP = new JDesktopPane() {
		
		ImageIcon img = new ImageIcon("/Users/jasonlara/git/PP2_Caleb_Jason/PP2_Gr1_Caleb_Jason/src/modelo/pial.png");
		Image image = img.getImage();
		Image img1 = image.getScaledInstance(630, 600, Image.SCALE_SMOOTH);
		 
		
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(img1, 0, 0, this);
			
		}
	};
	
	//BOTONES
	JButton ingresar = new JButton("Ingresar");
	//PanelCont.setLayout(cl);
	ingresar.setSize(10, 30);
	ingresar.setBounds(100, 150, 100, 30);
	ingresar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	ingresar.setVisible(true);
	ingresar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){try {
			ingresar();
		} catch (PropertyVetoException e1) {
			// TODO Auto-generated catch block
		}
			}});
	
	
	JButton buscar = new JButton("Buscar");
	buscar.setSize(10, 30);
	buscar.setBounds(275, 150, 100, 30);
	buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	buscar.setVisible(true);
	buscar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			lista.buscar();
			}});
	
	
	JButton mostrar = new JButton("Mostrar");
	mostrar.setSize(10, 30);
	mostrar.setBounds(450, 150, 100, 30);
	mostrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	mostrar.setVisible(true);
	mostrar.addActionListener(new ActionListener(){
		public void actionPerformed(ActionEvent e){
			lista.mostrar();
			}});
	
	
	JButton eliminar = new JButton("Eliminar");
	eliminar.setSize(10, 30);
	eliminar.setBounds(100, 250, 100, 30);
	eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	eliminar.setVisible(true);
	eliminar.addActionListener(e->lista.eliminaEspecifico());
	
	
	JButton guardar = new JButton("Guardar");
	guardar.setSize(10, 30);
	guardar.setBounds(275,250, 100, 30);
	guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	guardar.setVisible(true);
	guardar.addActionListener(e-> {
		try {
			lista.guardarInfo();
		} catch (IOException e1) {
			
		}
	});
	
	
	JButton recuperar = new JButton("Recuperar");
	recuperar.setSize(10, 30);
	recuperar.setBounds(450, 250, 100, 30);
	recuperar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	recuperar.setVisible(true);
	recuperar.addActionListener(e -> {
		try {
			lista.recuperarInfo();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	});
	
	JButton salir = new JButton("Salir");
	salir.setSize(10, 30);
	salir.setBounds(450, 350, 100, 30);
	salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	salir.setVisible(true);
	salir.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			JOptionPane opt = new JOptionPane("Ten buen dia!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
			  final JDialog dlg = opt.createDialog("Aviso");
			  new Thread(new Runnable()
			        {
			          public void run()
			          {
			            try
			            {
			              Thread.sleep(800);//Duracion de un segundo para que el mensaje desaparezca
			              dlg.dispose();

			            }
			            catch ( Throwable th )
			            {
			            
			            }
			          }
			        }).start();
			  dlg.setVisible(true);
			 System.exit(0);
			
		}
	});;
	escritorioP.setBounds(0, 0, 630, 600);
	escritorioP.setBackground(Color.orange);
	escritorioP.add(ingresar);
	escritorioP.add(buscar);
	escritorioP.add(mostrar);
	escritorioP.add(eliminar);
	escritorioP.add(guardar);
	escritorioP.add(recuperar);
	escritorioP.add(salir);
	escritorioP.setVisible(true);
		/*public void paint(Graphics g) {
			g.drawImage(image, 0, 0, getWidth(),getHeight(),this);
		}
	};*/
frame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
frame.setSize(600,400);
frame.setBounds(200, 200, 640, 640);
frame.setLocationRelativeTo(null);
frame.getContentPane().setLayout(null);
frame.add(escritorioP);
frame.setVisible(true);

}
//////////////////////////////////////////////////////////////////////////////////////////////////////
public void ingresarDatosGenerales(){
		JInternalFrame iFrame = new JInternalFrame("Ingresa datos del paquete");
		JDesktopPane desktopI = new JDesktopPane();

		iFrame.setMaximizable(false);
		iFrame.setIconifiable(true);
		iFrame.setResizable(false);
		iFrame.setClosable(true);
		iFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		iFrame.setSize(500,300);
		iFrame.setVisible(true);
		iFrame.setLocation(60, 150);
		desktopI.setSize(600,400);
		desktopI.setBounds(0, 0, 640, 640);
		desktopI.setVisible(true);
		escritorioP.add(iFrame);
		escritorioP.setVisible(true);
		
	
		iFrame.add(desktopI);
		try {
			iFrame.setMaximum(true);
		} catch (PropertyVetoException e) {
			
		}
		iFrame.toFront();
		
		
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////
public void ingresar() throws PropertyVetoException {
	

	//ESPACIOS DE TEXTO Y TITULOS DE ESOS ESPACIOS
	
	JInternalFrame iFrame = new JInternalFrame("Ingresar");
	JDesktopPane desktopI = new JDesktopPane();
	JLabel nombre = new JLabel("Nombre");
	JLabel dni = new JLabel("DNI");
	JLabel salario = new JLabel("Salario");
	JLabel tipoCliente = new JLabel("Tipo de Cliente");
	JLabel productoFinanciero = new JLabel("Producto Financiero");
	JTextField aNombre = new JTextField();
	JTextField aDni = new JTextField();
	JTextField aSalario = new JTextField();
	JButton continuar = new JButton("Continuar");
	JButton volver = new JButton("Volver");
	
	//CREANDO LOS COMBO-BOX
	JComboBox boxS;
	JComboBox boxC;
	
	String[] clientes = {"Selecciona","Administrativo", "Docente","Pensionado"};
	String[] servicioA = {"Selecciona tipo de cliente primero"};
	
	nombre.setBounds(47, 44,60, 16);
    nombre.setVisible(true);
    nombre.setFont(new Font("Courier", Font.BOLD, 16)); 
    aNombre.setBounds(120, 41, 86, 20);
    aNombre.setVisible(true);
    
    
    desktopI.add(nombre);
    desktopI.add(aNombre);
    
    
    dni.setBounds(47, 74,60, 16);
    dni.setVisible(true);
    dni.setFont(new Font("Courier", Font.BOLD, 16));
    aDni.setBounds(120, 71, 86, 20);
    aDni.setVisible(true);
    desktopI.add(dni);
    desktopI.add(aDni);
    aDni.addKeyListener(new KeyListener(){
    	 
    	public void keyTyped(KeyEvent e)
    	 
    	{if (aDni.getText().length()== 7)
    	 
    	     e.consume();
    	}
    	 
    	public void keyPressed(KeyEvent arg0) {
    	}
    	 
    	public void keyReleased(KeyEvent arg0) {
    	}
    	});
    
    salario.setBounds(47, 104,70, 16);
    salario.setVisible(true);
    salario.setFont(new Font("Courier", Font.BOLD, 16));
    aSalario.setBounds(120, 101, 86, 20);
    aSalario.setVisible(true);
    desktopI.add(salario);
    desktopI.add(aSalario);
    aSalario.addKeyListener(new KeyAdapter()
    {
       public void keyTyped(KeyEvent e)
       {
          char caracter = e.getKeyChar();

          // Verificar si la tecla pulsada no es un digito
          if(((caracter < '0') ||
             (caracter > '9')) &&
             (caracter != '\b' /*corresponde a BACK_SPACE*/))
          {
             e.consume();  // ignorar el evento de teclado
             JOptionPane opt = new JOptionPane("Ingrese solo numeros", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
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
       }
    });
	
	iFrame.setMaximizable(false);
	iFrame.setIconifiable(true);
	iFrame.setResizable(false);
	iFrame.setClosable(true);
	iFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	iFrame.setSize(500,400);
	iFrame.setVisible(true);
	iFrame.setLocation(60, 100);
	desktopI.setSize(600,400);
	desktopI.setBounds(0, 0, 640, 640);
	desktopI.setVisible(true);
	escritorioP.add(iFrame);
	escritorioP.setVisible(true);
	iFrame.add(nombre);
	iFrame.add(desktopI);
	iFrame.setMaximum(true);
	iFrame.toFront();

	
	tipoCliente.setBounds(26, 150, 200, 20);
	tipoCliente.setFont(new Font("Courier", Font.BOLD, 12));
	desktopI.add(tipoCliente);
	
	productoFinanciero.setBounds(26, 200, 200, 20);
	productoFinanciero.setFont(new Font("Courier", Font.BOLD, 12));
	desktopI.add(productoFinanciero);
	
	boxC = new JComboBox(clientes);
	boxC.setBounds(200, 150, 200, 20);
	desktopI.add(boxC);
	
	
	boxS = new JComboBox();
	boxS.setBounds(200, 200, 200, 20);
	boxS.setModel(new DefaultComboBoxModel(servicioA));
	desktopI.add(boxS);

	continuar.setBounds(200, 277, 100, 23);
	continuar.setVisible(true);
	continuar.setFont(new Font("Courier", Font.BOLD, 11));
	continuar.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			if(aNombre.getText().isEmpty()) {
				  JOptionPane opt = new JOptionPane("Ingresa un nombre", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
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
				
				
			}else if(aDni.getText().isEmpty()||aDni.getText().length()<7){
				if(aDni.getText().isEmpty()){
					JOptionPane opt = new JOptionPane("Ingresa una Identificacion", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
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
				}else if(aDni.getText().length()<7) {
					JOptionPane.showMessageDialog(null,"El DNI debe contener 7 digitos");
					aDni.setText("");
				
				}
			
			}else if(aSalario.getText().isEmpty()) {
				  JOptionPane opt = new JOptionPane("Debes ingresar un salario", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
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
				
			
			
			}else {
				
				
				if(boxS.getSelectedItem().toString().equalsIgnoreCase("Selecciona tipo de cliente primero")) {
					JOptionPane opt = new JOptionPane("Debes escoger un cliente y un producto financiero!", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
					  final JDialog dlg = opt.createDialog("Aviso");
					  new Thread(new Runnable()
					        {
					          public void run()
					          {
					            try
					            {
					              Thread.sleep(1500);//Duracion de un segundo para que el mensaje desaparezca
					              dlg.dispose();

					            }
					            catch ( Throwable th )
					            {
					            }
					          }
					        }).start();
					  dlg.setVisible(true);
				}else {
				dinamicDesk(boxC.getSelectedItem().toString(), boxS.getSelectedItem().toString(),
						aNombre.getText(),aDni.getText(),aSalario.getText());
						aNombre.setText("");
						aDni.setText("");
						aSalario.setText("");
				}
			}	   	 
			}	
	});
	desktopI.add(continuar);
	volver.setBounds(333, 277, 80, 23);
	volver.setVisible(true);
	volver.setFont(new Font("Courier", Font.BOLD, 11));
	volver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			iFrame.dispose();
		}
	});
	desktopI.add(volver);
boxC.addItemListener(new ItemListener() {
	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		if(e.getStateChange() == ItemEvent.SELECTED);
			boxS.setModel(new DefaultComboBoxModel(accionComboBoxClientes(boxC.getSelectedItem().toString())));	
		}
}
);	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
public void dinamicDesk (String boxC, String boxS, String n, String d, String s) {
	  if (boxC.equalsIgnoreCase("Administrativo")&&boxS.equalsIgnoreCase("Credito Corriente")) {		 //ADMINISTRATIVO- CORRIENTE
		c = new Corriente();
			// TODO Auto-generated catch bloc
		c.clienteAd.setNombre(n);
		c.clienteAd.setDni(d);
		c.clienteAd.setSalario(Double.parseDouble(s));
		c.ingresaAdministrativoCreditoCorriente();
			escritorioP.add(c.dskCorrienteAdministrativo());
			escritorioP.setVisible(true);		
			try {
				c.getiFrame().setMaximum(true);
			} catch (PropertyVetoException e) {
			}
			c.getiFrame().toFront();
			lista.insertarFinal(c);
			getiFrame().dispose();
	}else if (boxC.equalsIgnoreCase("Docente")&&boxS.equalsIgnoreCase("Credito Corriente")) {		//DOCENTE-CORRIENTE
		c = new Corriente();
		frameBase(c.dskCorrienteDocente(),"Ingresa datos Docente en credito corriente");
		c.clienteDo.setNombre(n);
		c.clienteDo.setDni(d);
		c.clienteDo.setSalario(Double.parseDouble(s));
		lista.insertarFinal(c);
		iFrame.dispose();
	}else if(boxC.equalsIgnoreCase("Pensionado")&&boxS.equalsIgnoreCase("Credito Corriente")) {		//PENSIONADO-CORRIENTE
		
		
		c = new Corriente();
		frameBase(c.dskCorrientePensionado(), "Ingresa datos Pesionado en credito corriente");
		c.clientePe.setNombre(n);
		c.clientePe.setDni(d);
		c.clientePe.setSalario(Double.parseDouble(s));
		lista.insertarFinal(c);
		
		
	}else if(boxC.equalsIgnoreCase("Administrativo")&&boxS.equalsIgnoreCase("Credito Vivienda")) {	//ADMINISTRATIVO-VIVIENDA
		
	}else if(boxC.equalsIgnoreCase("Docente")&&boxS.equalsIgnoreCase("Credito Vivienda")) {			//DOCENTE-VIVIENDA
		
	}else if(boxC.equalsIgnoreCase("Pensionado")&&boxS.equalsIgnoreCase("Credito Vivienda")) {		//PENSIONADO-VIVIENDA
		System.exit(0);// PARA PRUEBA DE CONDICIONES
		
		
		
	}else if(boxC.equalsIgnoreCase("Administrativo")&&boxS.equalsIgnoreCase("Especial Ordinario")) {//ADMINISTRATIVO-ORDINARIO
		
		
		
		
	}else if(boxC.equalsIgnoreCase("Docente")&&boxS.equalsIgnoreCase("Especial Ordinario")) {		//DOCENTE-ORDINARIO
		
		
		
	}else if(boxC.equalsIgnoreCase("Administrativo")&&boxS.equalsIgnoreCase("Equipo Computo")) {	//ADMINISTRATIVO-EQUIPOCOMPUTO
		
		
		
	}else if(boxC.equalsIgnoreCase("Docente")&&boxS.equalsIgnoreCase("Equipo Computo")) {			//DOCENTE-EQUIPOCOMPUTO
		
		
		
	}else if(boxC.equalsIgnoreCase("Administrativo")&&boxS.equalsIgnoreCase("Plan ahorro a la vista")) {//ADMINISTRATIVO-ALAVISTA
		
		
		
	}else if(boxC.equalsIgnoreCase("Docente")&&boxS.equalsIgnoreCase("Plan ahorro a la vista")) {	//DOCENTE-ALAVISTA
		
		
		
	}else if(boxC.equalsIgnoreCase("Pensionado")&&boxS.equalsIgnoreCase("Plan ahorro a la vista")) {//PENSIONADO-ALAVISTA
		
		
		
	}else if(boxC.equalsIgnoreCase("Administrativo")&&boxS.equalsIgnoreCase("Plan ahorro anual")) {	//ADMINISTRATIVO-ANUAL
		
		
		
	}else if(boxC.equalsIgnoreCase("Docente")&&boxS.equalsIgnoreCase("Plan ahorro anual")) {		//DOCENTE-ANUAL
		
		
		
		
	}else if(boxC.equalsIgnoreCase("Pensionado")&&boxS.equalsIgnoreCase("Plan ahorro anual")) {		//PENSIONADO-ANUAL
		
	}
	
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
public void frameBase(JDesktopPane d, String t) {
	
	JInternalFrame iFrame = new JInternalFrame("Ingresar");
	iFrame.setTitle(t);
	iFrame.setMaximizable(false);
	iFrame.setIconifiable(true);
	iFrame.setResizable(false);
	iFrame.setClosable(true);
	iFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
	iFrame.setSize(500,400);
	iFrame.setVisible(true);
	iFrame.setLocation(60, 100);
	escritorioP.add(iFrame);
	escritorioP.setVisible(true);
	JButton volver = new JButton("Volver");
	volver.setBounds(333, 277, 80, 23);
	volver.setVisible(true);
	d.add(volver);
	volver.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent arg0) {
			iFrame.dispose();
		}
	});
	iFrame.add(d);
	try {
		iFrame.setMaximum(true);
	} catch (PropertyVetoException e) {
	}
	iFrame.toFront();
}
//////////////////////////////////////////////////////////////////////////////////////////////////////
public String[] accionComboBoxClientes(String cliente) { 
	
	//COMBO BOX DEPENDIENTES ;)
	
	String [] servicios= new String[1];
	servicios[0]= "Selecciona tipo de cliente primero";
	if(cliente.equalsIgnoreCase("Selecciona")) {
		servicios = new String[1];
		servicios[0]= "Selecciona tipo de cliente primero";
	}else if(!cliente.equalsIgnoreCase("Selecciona")) {	
	if(cliente.equalsIgnoreCase("Administrativo")) {
		servicios = new String[7];
		servicios[0]= "Selecciona producto financiero";
		servicios[1]= "Credito Corriente";
		servicios[2]= "Credito Vivienda";
		servicios[3]= "Especial Ordinario";
		servicios[4]= "Equipo computo";
		servicios[5] = "Plan ahorro a la vista";
		servicios[6] = "Plan ahorro anual";
	}else if(cliente.equalsIgnoreCase("Docente")) {
		servicios= new String[7];
		servicios[0]= "Selecciona producto financiero";
		servicios[1]= "Credito Corriente";
		servicios[2]= "Credito Vivienda";
		servicios[3]= "Especial Ordinario";
		servicios[4]= "Equipo computo";
		servicios[5] = "Plan ahorro a la vista";
		servicios[6] = "Plan ahorro anual";
	}else if(cliente.equalsIgnoreCase("Pensionado")) {
		servicios= new String[5];
		servicios[0]= "Selecciona producto financiero";
		servicios[1]= "Credito Corriente";
		servicios[2]= "Credito Vivienda";
		servicios[3] = "Plan ahorro a la vista";
		servicios[4] = "Plan ahorro anual";
	}
	}
	return servicios;
}	
}