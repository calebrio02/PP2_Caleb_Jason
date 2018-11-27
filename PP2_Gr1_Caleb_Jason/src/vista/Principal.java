 package vista;

import java.beans.PropertyVetoException;
import java.io.IOException;

import javax.naming.CannotProceedException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import controlador.ArrayObjetos;
import controlador.ListaEnlazada;
import modelo.*;
public class Principal {

	public static void main(String[] args) throws IOException, ClassNotFoundException, CannotProceedException, PropertyVetoException {
		//JOptionPane.showMessageDialog(null, "Bienvenido al sistema bancario de PIAL.SA");
		//ArrayObjetos objeto = new ArrayObjetos();
		//ListaEnlazada l = new ListaEnlazada();
		GUI ventana = new GUI();
		//ventana.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//ventana.setVisible(true);
		//ventana.setSize(320, 240);
		ventana.inicio();
		//ventana.setVisible(true);
//

		/*
	public void crearVentana() {
		frame.setBounds(10, 10, 100, 30);
		frame.setSize(500, 500);
		escritorio.setBounds(10, 10, 100, 30);


		
			
	//Agregando los botones del menu
		
		escritorio.add(ingresar);
		escritorio.add(buscar);
		escritorio.add(mostrar);
		escritorio.add(eliminar);
		escritorio.add(guardar);
		escritorio.add(recuperar);
		escritorio.add(salir);
		escritorio.setBackground(Color.lightGray);
		ingresar.setBackground(Color.BLACK);
		ingresar.setBounds(50, 150, 100, 30);
		buscar.setBounds(200, 150, 100, 30);
		mostrar.setBounds(350, 150, 100, 30);
		eliminar.setBounds(50, 250, 100, 30);
		guardar.setBounds(200,250, 100, 30);
		recuperar.setBounds(350, 250, 100, 30);
		salir.setBounds(350, 350, 100, 30);
		
		
		ingresar.setVisible(true);
		buscar.setVisible(true);
		mostrar.setVisible(true);
		eliminar.setVisible(true);
		guardar.setVisible(true);
		recuperar.setVisible(true);
		
		
		escritorio.setVisible(true);
		
		frame.setLocationRelativeTo(null);
		frame.add(escritorio);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	//Metodo ateriormente pensado para establecer el internalFrame.



	/*public void ingresar() {
		JDesktopPane escritorioI = new JDesktopPane();
		JLabel nombre = new JLabel("Nombre");
		JLabel dni = new JLabel("Dni");
		JLabel salario = new JLabel("Salario");
		
		nombre.setHorizontalAlignment((int) LEFT_ALIGNMENT);
		
		escritorioI.add(nombre);
		
		//iFrame.setMaximizable(true);
		iFrame.setIconifiable(true);
		//iFrame.setResizable(true);
		iFrame.setClosable(true);
		iFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);
		iFrame.setSize(425,325);
//		iFrame.setsi
		iFrame.setBounds(10, 10, 425, 325);
		iFrame.setVisible(true);
		iFrame.setLocation(45, 50);
		escritorio.add(iFrame);
//		escritorioI.setSize(425,325);
		escritorioI.setBounds(10,  10, 425, 325);
		//setBound
		//escritorioI.setLocation(45, 50);
		escritorioI.setVisible(true);

		
		
		
		iFrame.add(escritorioI);
		iFrame.toFront();
		
	}/*
		//BOTONES
	/*
			JButton ingresar = new JButton("Ingresar");
			ingresar.setSize(10, 30);
			ingresar.setBounds(50, 150, 100, 30);
			ingresar.setVisible(true);
			ingresar.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){ingresar();
					}});
			
			
			
			
			
			
			
			JButton buscar = new JButton("Buscar");
			buscar.setSize(10, 30);
			buscar.setBounds(200, 150, 100, 30);
			buscar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			buscar.setVisible(true);
			JButton mostrar = new JButton("Mostrar");
			mostrar.setSize(10, 30);
			mostrar.setBounds(350, 150, 100, 30);
			mostrar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			mostrar.setVisible(true);
			JButton eliminar = new JButton("Eliminar");
			eliminar.setSize(10, 30);
			eliminar.setBounds(50, 250, 100, 30);
			eliminar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			eliminar.setVisible(true);
			JButton guardar = new JButton("Guardar");
			guardar.setSize(10, 30);
			guardar.setBounds(200,250, 100, 30);
			guardar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			guardar.setVisible(true);
			JButton recuperar = new JButton("Recuperar");
			recuperar.setSize(10, 30);
			recuperar.setBounds(350, 250, 100, 30);
			recuperar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			recuperar.setVisible(true);
			JButton salir = new JButton("Salir");
			salir.setSize(10, 30);
			salir.setBounds(350, 350, 100, 30);
			salir.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			salir.setVisible(true);
			
			
			
		mFrame.setSize(600,400);
		mFrame.setBounds(200, 200, 640, 640);
		mFrame.setLocationRelativeTo(null);
		mFrame.getContentPane().setLayout(null);
		mFrame.getContentPane().add(ingresar);
		mFrame.getContentPane().add(buscar);
		mFrame.getContentPane().add(mostrar);
		mFrame.getContentPane().add(eliminar);
		mFrame.getContentPane().add(guardar);
		mFrame.getContentPane().add(recuperar);
		mFrame.getContentPane().add(salir);
		mFrame.setVisible(true);
	}*/
		
		
		

	
	}
}
