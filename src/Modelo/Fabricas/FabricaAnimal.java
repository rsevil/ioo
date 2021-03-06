package Modelo.Fabricas;

import Modelo.Animal;
import Modelo.Contexto;
import Modelo.Movimiento;
import Modelo.Posicion;

public abstract class FabricaAnimal {
	
	public abstract Animal crear(Movimiento movimiento, Posicion posicion, Contexto contexto, float vidaInicial);
	
}
