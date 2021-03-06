package Modelo;

public class Zigzag extends Movimiento {
	
	private int frames;
	private boolean derecha;
	private boolean izquierda;
	
	public Zigzag(int anchoPantalla, int altoPantalla){
		super(anchoPantalla, altoPantalla);
		this.frames = 0;
		this.derecha = true;
		this.izquierda = false;
	}

	@Override
	Posicion calcularPosicion(float vx, float vy, float deltaTiempo, float xi, float xf, float yi, float yf) {
		this.frames++;
		if (this.frames == 60 && (xf < this.anchoPantalla || xi <= 0)){
			if(this.derecha){
				this.derecha = false;
				this.izquierda = true;
			}else if (this.izquierda){
				this.izquierda = false;
				this.derecha = true;
			}
			this.frames = 0;
		}else{
			if (this.derecha && xf >= anchoPantalla){
				this.derecha = false;
				this.izquierda = true;
				this.frames = 0;
			}else if (this.izquierda && xi <= 0){
				this.derecha = false;
				this.izquierda = true;
				this.frames = 0;
			}
		}
		
		if (izquierda)
			vx = -vx;
		
		return new Posicion(
				limites(xi + vx * deltaTiempo, 0, this.anchoPantalla - (xf - xi)),
				yi + vy * deltaTiempo);
	}
}
