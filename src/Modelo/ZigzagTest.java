package Modelo;

import static org.junit.Assert.*;

import org.junit.Test;

public class ZigzagTest {

	private int anchoPantalla = 75;
	private int altoPantalla = 75;
	
	private Zigzag crear(){
		return new Zigzag(anchoPantalla,altoPantalla);
	}
	
	@Test
	public void testZigzag() {
		Zigzag sut = crear();
		
		assertEquals(anchoPantalla, sut.anchoPantalla);
		assertEquals(altoPantalla, sut.altoPantalla);
	}
	
	@Test
	public void testCalcularPosicion_VxPositiva_MoverALaDerecha() {
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VxPositiva_MoverAIzquierda() {
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyPositiva_MoverParaAbajo() {
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = 1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(2,p.obtenerY(),2);
	}
	
	@Test
	public void testCalcularPosicion_VyPositiva_MoverParaArriba() {
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = 0;
		float vy = -1;
		float xi = 1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(0,p.obtenerY(),2);
	}
	
	@Test
	public void testCalcularPosicion_RebotaHaciaIzquierda(){
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = anchoPantalla-1;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi+1, yi, yi+1);
		
		assertEquals(anchoPantalla-1,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_RebotaHaciaDerecha(){
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = -1;
		float vy = 0;
		float xi = 0;
		float yi = 1;
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi + 1);
		
		assertEquals(1,p.obtenerX(),2);
	}
	
	@Test
	public void testCalcularPosicion_VaHaciaDerechaLlegaMaximaCantidadDeFramesRebotaIzquierda(){
		Zigzag sut = crear();
		
		float dt = 1;
		float vx = 1;
		float vy = 0;
		float xi = 0;
		float yi = 1;
		
		int i;
		for(i = 0; i < 60; i++){
			Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi+1);
			xi = p.obtenerX();
		}
		
		Posicion p = sut.calcularPosicion(vx, vy, dt, xi, xi + 1, yi, yi+1);
		
		assertEquals(58, p.obtenerX(),2);
	}
	
	@Test
	public void testLimites_EntreLimites(){
		Zigzag sut = crear();
		
		float n = sut.limites(5, 0, 10);
		
		assertEquals(5, n, 2);
	}
	
	@Test
	public void testLimites_LimiteSuperior(){
		Zigzag sut = crear();
		
		float n = sut.limites(15, 0, 10);
		
		assertEquals(10, n, 2);
	}

	@Test
	public void testLimites_LimiteInferior(){
		Zigzag sut = crear();
		
		float n = sut.limites(2, 5, 10);
		
		assertEquals(5, n, 2);
	}
	
}
