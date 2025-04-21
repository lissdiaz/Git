package Hoja2_Ej1;

public class Cuenta {
	private String titular;
	private double cantidad;
	
	public Cuenta(String titular) {
		this.titular=titular;
	}
	
	public Cuenta(String titular, double cantidad) {
		this.titular=titular;
		this.cantidad=cantidad;;
	}
	
	public void setNombre(String titular) {
		this.titular=titular;
	}
	
	public void setCuenta(double cantidad) {
		this.cantidad=cantidad;
	}
	
	public String getNombreTitular() {
		return titular;
	}
	
	public double getCantidad() {
		return cantidad;
	}
	
	public String toString() {
		return "El titular es "+titular+" con una cantidad de "+cantidad+" en su  cuenta";
	}
	
	public void ingresar(double cantidad) {
		if (cantidad < 0) {
			this.cantidad=this.cantidad;
		}
		else {
			this.cantidad+=cantidad;
		}
	}
	
	public void retirar(double cantidad) {
		if (cantidad > this.cantidad) {
			this.cantidad=0;
		}
		else {
			this.cantidad=this.cantidad-cantidad;
		}
	}
}
