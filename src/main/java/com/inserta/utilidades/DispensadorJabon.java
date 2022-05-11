package com.inserta.utilidades;

public class DispensadorJabon {
	//Atributos
	private String marca;
	private float bateria;
	private int depositoMaximo;
	private int depositoActual;
	private boolean encendido;
	
	//region Constructores
	public DispensadorJabon() {
		this.marca = "Deliplus";
		this.bateria = 100;
		this.depositoMaximo = 500;
		this.depositoActual = 0;
		this.encendido = false;
	}
	
	public DispensadorJabon(String marca, float bateria, int depositoMaximo, int depositoActual, boolean estaEncendido) {
		this.marca = marca;
		this.bateria = bateria;
		this.depositoMaximo = depositoMaximo;
		this.depositoActual = depositoActual;
		this.encendido = estaEncendido;
	}
	//endregion

	//region Getters y setters
	public String getMarca() {
		return this.marca;
	}
	public float getBateria() {
		return this.bateria;
	}
	public int getDepositoMaximo() {
		return this.depositoMaximo;
	}
	public int getDepositoActual() {
		return this.depositoActual;
	}
	public boolean estaVacio(){
		return this.depositoActual <= 0;
	}
	public boolean isEncendido() {
		return this.encendido;
	}
	public boolean isApagado() {
		return !this.encendido;
	}
	public void setMarca(String marca) {
		//Si NO son "" o espacios en blanco....
		if (marca != null && !marca.isBlank()) {
			this.marca = marca;
		}
	}

	public void setBateria(float bateria) {
		if (bateria >=0 && bateria <= 100) {
			this.bateria = bateria;
		}
		if (this.bateria == 0) {
			this.apagar();
		}
	}
	
	public void setDepositoActual(int cantidad) {
		if (cantidad >= 0 && cantidad <= this.getDepositoMaximo()) {
			this.depositoActual = cantidad;
		}
	}
	
	public void setDepositoMaximo(int cantidad) {
		if(cantidad > 0 && cantidad < 2000000) {
			this.depositoMaximo = cantidad;
		}
	}
	
	public void setEncendido(boolean encendido) {
		this.encendido = encendido;
	}
	//endregion

	//region Métodos
	public void apagar() {
		this.encendido = true;
	}

	public void encender() {
		this.encendido = true;
		this.bateria -= 0.1;
		if (this.bateria <= 0) {
			this.bateria = 0;
			this.apagar();
		}
	}
	
	public void dispensar() {
		if (this.encendido) {
			this.depositoActual -= 15;
			this.bateria -= 0.7;
			//Si se quedaron en negativo, los ponemos a 0
			if (this.depositoActual < 0) {
				this.depositoActual = 0;
			}
			if (this.bateria < 0) {
				this.bateria = 0;
			}
		}
		
	}

	public void rellenar() {
		this.depositoActual = this.depositoMaximo;
	}
	
	public void recargar() {
		this.bateria = 100;
	}

	//endregion

	@Override
	public String toString() {
		String representacion = "";
		representacion += "Marca    : " + this.marca + "\n";
		representacion += "Batería  : " + this.bateria + "%\n";
		representacion += "Depósito : " + this.depositoActual + " ml / " + this.depositoMaximo + " ml\n";
		representacion += "Estado   : ";
		if (this.encendido) {
			representacion += "\033[032m"; //Verde
			representacion += "on\n";
		} else {
			representacion += "\033[031m"; //Rojo
			representacion += "off\n";
		}
		representacion += "\u001B[0m";
		representacion += "----------------------\n";

		return representacion;
	}

	
	
}	