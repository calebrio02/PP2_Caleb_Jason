package controlador;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.*;
public class Lista implements Serializable {
	
		JTextArea jtxt_area;
		FileNameExtensionFilter filtro;
		String ruta = "";
		JScrollPane scroll;
	
	
	

		Nodo cabeza=null;
		int tamano=0;
	
	
	
	
	
	private class Nodo implements Serializable {
	public Servicios s;
	Nodo siguiente=null;
	
	public Nodo (Servicios s) {
		this.s=s;
	}
	}
	
	
	
	
	
public void insertarPrincipio(Servicios s) {
	Nodo nodo = new Nodo(s);
	 nodo.siguiente=cabeza;
	 cabeza=nodo;
	 tamano++;
}

public void insertarFinal(Servicios s) {
	Nodo nodo = new Nodo(s);
	if (cabeza==null) {
		cabeza=nodo;
	}else {
		Nodo puntero = cabeza;
		 while (puntero.siguiente!=null) {
			puntero = puntero.siguiente;
		}
		puntero.siguiente= nodo;
	}
	tamano++;
}

public boolean estaVacio() {
	
	return cabeza==null;
}


public void mostrar() {
	Nodo puntero = cabeza;
	String mensaje="";
	if(estaVacio()) {
		JOptionPane.showMessageDialog(null, "Lista esta vacia");
	}else {
		//Datos para ver los datos de forma dinamica
		
		String texto="";
		for (int i = 0; i < tamano; i++) {
			mensaje+=puntero.s.toString() + "\n\n";
			puntero = puntero.siguiente;
			
		}
		texto+= mensaje;
		JTextArea jtxt_area = new JTextArea();
		JScrollPane scroll;
		jtxt_area.setText(texto);
		jtxt_area.setEditable(false);
		jtxt_area.setForeground(Color.GREEN);
		jtxt_area.setBackground(Color.BLACK);
		scroll = new JScrollPane(jtxt_area);
		scroll.setPreferredSize( new Dimension( 500, 500 ) );
		
		JOptionPane.showMessageDialog(null, scroll,"Cantidad de Datos " + "("+tamano+")", JOptionPane.YES_NO_OPTION);
		
	}

}


public Nodo buscar() {
	boolean encontrado= false;
		Nodo nodo = cabeza;
		
		try {
			if(estaVacio()) {
				JOptionPane.showMessageDialog(null, "Lista Vacia", "AVISO", JOptionPane.WARNING_MESSAGE);
			}else {
			

			String datoBuscar= JOptionPane.showInputDialog("Ingresa el DNI del  Cliente a buscar:");
			if(nodo.s.SoloDNI().equalsIgnoreCase(datoBuscar)) {
				JOptionPane.showMessageDialog(null, "Cliente encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				JOptionPane.showMessageDialog(null, nodo.s.toString()); 
				encontrado = true;

			}else {
				for (int i = 0; i < tamano; i++) {
					nodo = nodo.siguiente;
					if(nodo.s.SoloDNI().equalsIgnoreCase(datoBuscar)) {
						JOptionPane.showMessageDialog(null, "Cliente encontrado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
						JOptionPane.showMessageDialog(null, nodo.s.toString()); 
						encontrado = true;
						break;
						}
					
					
						encontrado = false;
						
						

			}
			}
			if(encontrado==true){
			}	else if(encontrado==false) {
				JOptionPane.showMessageDialog(null, "Cliente no existe", "Aviso", JOptionPane.WARNING_MESSAGE);
			}
			}
			}catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Cliente  no existe");
			}
		
	return nodo;
}
public Nodo eliminaEspecifico() {
	boolean encontrado= false;
	Nodo anterior = cabeza;
	Nodo nodo= cabeza;
	try {
	if(estaVacio()) {
		JOptionPane.showMessageDialog(null, "Lista Vacia", "AVISO", JOptionPane.WARNING_MESSAGE);
	}else {
	

	String datoEliminar= JOptionPane.showInputDialog("Ingresa el DNI del  Cliente a eliminar es:");
	if(nodo.s.SoloDNI().equalsIgnoreCase(datoEliminar)) {
		JOptionPane.showMessageDialog(null, "El numero del  Cliente a eliminar es: "  + nodo.s.SoloDNI()); 
		cabeza = nodo.siguiente;
		encontrado = true;
		tamano --;
	}else {
		for (int i = 0; i < tamano; i++) {
			nodo = nodo.siguiente;
			if(nodo.s.SoloDNI().equalsIgnoreCase(datoEliminar)) {
				JOptionPane.showMessageDialog(null, "El numero del  Cliente a eliminar es: "  + nodo.s.SoloDNI());
				anterior.siguiente = nodo.siguiente;
				tamano--;
				encontrado = true;
				break;
				}
				anterior= anterior.siguiente;
			
			
				encontrado = false;
				
				

	}
	}
	if(encontrado==true){
		JOptionPane.showMessageDialog(null, "Cliente eliminado", "Aviso", JOptionPane.INFORMATION_MESSAGE);
	}	else if(encontrado==false) {
		JOptionPane.showMessageDialog(null, "Cliente no existe", "Aviso", JOptionPane.WARNING_MESSAGE);
	}
	}
	}catch (Exception e) {
		JOptionPane.showMessageDialog(null, "Cliente  no existe");
	}
	return anterior;
}

public void guardarInfo() throws IOException {
	
	if(estaVacio()) {
		JOptionPane.showMessageDialog(null, "Lista Vacia");
	}else {
	Nodo escrituraNodo;
	escrituraNodo = cabeza;
	FileOutputStream out = new FileOutputStream("Clientes.dat");
	ObjectOutputStream a = new ObjectOutputStream(out);

	while(escrituraNodo != null) {
		a.writeObject(escrituraNodo.s);
		escrituraNodo = escrituraNodo.siguiente;
	}
	
	JOptionPane opt = new JOptionPane("Guardado", JOptionPane.INFORMATION_MESSAGE, JOptionPane.DEFAULT_OPTION, null, new Object[]{});
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


	
	
	a.close();
	}
}

public void recuperarInfo() throws ClassNotFoundException, IOException {
	int cuentaObjetos =0;
	FileInputStream in = new FileInputStream("Clientes.dat");
	ObjectInputStream a = new ObjectInputStream(in);
	

	try{
		while(true){
			insertarFinal((Servicios) a.readObject());
			cuentaObjetos++;
		}
}catch(EOFException e) {
	//e.printStackTrace();
}
catch (IOException e){
	//e.printStackTrace();
}
finally{
	try{
		if (a!= null){
			a.close();
		}
	}catch (IOException e){
		//e.printStackTrace();
	}
}
	JOptionPane.showMessageDialog(null,"--> " + cuentaObjetos + " Objeto(s) Recuperado(s)");
}
}





