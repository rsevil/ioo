package Modelo;

public class Tierra extends Contexto {
	
	@Override
	float calcularVelocidad(Mamifero m) {
		return Constantes.MULTIPLICADOR_VELOCIDAD_ANIMAL_CONTEXTO_FAVORABLE;
	}

	@Override
	float calcularVelocidad(Ave a) {
		return Constantes.MULTIPLICADOR_VELOCIDAD_ANIMAL_CONTEXTO_NO_FAVORABLE;
	}
	
	@Override
	float calcularVelocidad(Reptil r) {
		return Constantes.MULTIPLICADOR_VELOCIDAD_ANIMAL_CONTEXTO_NORMAL;
	}
}
