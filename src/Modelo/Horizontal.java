package Modelo;

public class Horizontal extends Movimiento {
	
	public Horizontal(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);	
	}
	
	public Posicion calcularPosicion(float vx, float vy, float deltaTiempo, int diametro, Posicion posicion) {
		//TODO:Calcular posicion nueva
		return posicion;
	}
}