package Modelo;

public abstract class Elemento extends EntidadMovil {
	protected float puntaje;
	
	private float vx;
	private float vy;
	
	public Elemento(Movimiento movimiento, Posicion posicion, float vx, float vy, float puntaje) {
		super(movimiento, posicion, 4);
		this.puntaje = puntaje;
		this.vx = vx;
		this.vy = vy;
	}
	
	@Override
	protected float obtenerVX(){
		return this.vx;
	}
	
	@Override
	protected float obtenerVY(){
		return this.vy;
	}
	
	abstract float calcularPuntaje(Mamifero m);
	
	abstract float calcularPuntaje(Ave a);
	
	abstract float calcularPuntaje(Reptil r);
	
	void moverElemento(float deltaTiempo) {
		this.mover(deltaTiempo);
	}
	
	boolean ocupaCoordenadas(float xi, float xf, float yi, float yf) {
		float xib = this.posicion.obtenerX();
		float xfb = xib + this.ancho;
		float yib = this.posicion.obtenerY();
		float yfb = yib + this.alto;
		
		return !(yf <= yib || yi >= yfb || xf <= xib || xi >= xfb);
	}
}
