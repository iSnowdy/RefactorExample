package GestionCuentas;

import CuentasCliente.CC_Cliente;

public class Refactor {

    public static void main(String[] args) {
        //Creamos Cliente
        CC_Cliente cliente1 = new CC_Cliente("Pepito", "Perez", (float) 1000.10, false);
        cliente1.Muestra_Datos_Cliente();

        //Ingreso en la cuenta
        if (cliente1.ingresoCuentaCliente(100)) {
            System.out.println("Ingreso Correcto");
            cliente1.Muestra_Datos_Cliente();
        } else {
            System.out.println("Ingreso Incorrecto");
        }
        //Retirada de la cuenta 
        if (cliente1.retiradaCuentaCliente(50)) {
            System.out.println("Retirada Correcta");
            cliente1.Muestra_Datos_Cliente();
        } else {
            System.out.println("Error en Retirada");
        }
    }
}