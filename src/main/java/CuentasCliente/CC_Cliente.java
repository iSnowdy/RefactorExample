package CuentasCliente;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class CC_Cliente {
    private static final String ES_4750 = "ES-4750";
    //Clase que implementa la Cuenta Corriente de un Cliente del Banco
    //Código no ha sido refactorizado, por lo que es mejorable.

    //ATRIBUTOS
    private final String Nombre_Cliente;
    private final String Apellidos_Cliente;
    private String Numero_CC;
    private final LocalDate Fecha_Constitucion_CC;
    private float Saldo_Cliente;

    //METODOS

    //Constructor
    public CC_Cliente(String Nombre, String Apellidos, float Saldo, boolean credito) {

        //Definimos formato de fecha para confección del número de CC
        DateTimeFormatter Formato_Fecha = DateTimeFormatter.ofPattern("dd-MM-yyyy");

        //Datos Personales
        this.Nombre_Cliente = Nombre;
        this.Apellidos_Cliente = Apellidos;

        //Fecha Constitucion
        this.Fecha_Constitucion_CC =  LocalDate.now();

        //Número de CC
        extracted(Formato_Fecha);

        //Saldo inicial
        this.setSaldo_Cliente(Saldo);
    }

    public static String getEs4750() {
        return ES_4750;
    }

    private void extracted(DateTimeFormatter Formato_Fecha) {
        String Fecha_Formateada = Fecha_Constitucion_CC.format(Formato_Fecha);
        this.setNumero_CC(getEs4750() + "-" + Fecha_Formateada + "-" + this.getApellidos_Cliente());
    }

    public boolean ingresoCuentaCliente(int Cantidad) {
        //Realiza un ingreso si la Cantidad es correcta (positiva)

        boolean Ingreso_Correcto;
        if (Cantidad > 0) {

            this.setSaldo_Cliente(this.getSaldo_Cliente() + Cantidad);
            Ingreso_Correcto = true;

        } else {

            Ingreso_Correcto = false;
        }
        return Ingreso_Correcto;
    }

    public boolean retiradaCuentaCliente(int Cantidad) {
        //Retirada de fondos si saldo es suficiente.

        boolean Retirada_Correcta;
        if (Cantidad < this.getSaldo_Cliente()) {
            this.setSaldo_Cliente(this.getSaldo_Cliente() - Cantidad);
            Retirada_Correcta = true;
        } else {
            Retirada_Correcta = false;
        }
        return Retirada_Correcta;
    }

    public void Muestra_Datos_Cliente() {
        //Vuelca información de la CC en pantalla
        System.out.println(this.getNombre_Cliente());
        System.out.println(this.getApellidos_Cliente());
        System.out.println(this.getNumero_CC());
        System.out.println(this.Fecha_Constitucion_CC);
        System.out.println(this.getSaldo_Cliente());
    }

    public String getNombre_Cliente() {
        return Nombre_Cliente;
    }

    public String getApellidos_Cliente() {
        return Apellidos_Cliente;
    }

    public String getNumero_CC() {
        return Numero_CC;
    }

    public void setNumero_CC(String numero_CC) {
        Numero_CC = numero_CC;
    }

    public float getSaldo_Cliente() {
        return Saldo_Cliente;
    }

    public void setSaldo_Cliente(float saldo_Cliente) {
        Saldo_Cliente = saldo_Cliente;
    }
}