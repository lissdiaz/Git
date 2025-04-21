package Hoja2_Ej1;

public class UsoCuenta {

	public static void main(String[] args) {
		Cuenta persona1=new Cuenta("Ángel Gandú");
		Cuenta persona2=new Cuenta("Mariana Diaz",200.0);
		System.out.println(persona1.toString());
		persona2.retirar(300);
		System.out.println(persona2.toString());
		
	}

}
