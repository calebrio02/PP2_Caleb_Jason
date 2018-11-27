package modelo;

import java.io.Serializable;

public class Especial extends Creditos implements Serializable {
	
	
	//CLASE DE TIPO VISTA, NECESARIA PARA QUE LAS CLASE: EQUIPO COMPUTO Y ESPECIAL ORDINARIO PUEDAN ACCEDER A LA JERARQUIA MAS ALTA DEL PROBLEMA
	//PD: NO TIENE ATRIBUTOS Y NO IMPLEMENTA METODOS PROPIOS SOLO LOS ABSTRACTOS
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
