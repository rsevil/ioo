package Modelo;

public abstract class Movimiento {
	protected int anchoPantalla;
	protected int altoPantalla;
	
	protected float vx;
	protected float vy;
	
	public Movimiento(int anchoPantalla, int altoPantalla){
		this.anchoPantalla = anchoPantalla;
		this.altoPantalla = altoPantalla;
	}
	
	public abstract Posicion calcularPosicion(float vx, float vy, float deltaTiempo, int diametro, Posicion posicion);
	
	protected float limites(float valor, float min, float max) {
		if (valor > max)
			return max;
		if (valor < min)
			return min;
		return valor;
	}
}