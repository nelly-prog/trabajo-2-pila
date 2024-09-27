
package pilas;

import java.util.Stack;
import java.util.Scanner;


class Cuenta {
    private String nombre;
    private double monto;

    public Cuenta(String nombre, double monto) {
        this.nombre = nombre;
        this.monto = monto;
    }
    public void estadoDeCuenta() {
        System.out.println("Estado de Cuenta:");
        System.out.println("Nombre: " + nombre);
        System.out.println("Monto disponible: $" + monto);
    }

    public void depositar(double cantidad) {
        if (cantidad > 0) {
            monto += cantidad;
            System.out.println("Depósito de $" + cantidad + " realizado con éxito.");
        } else {
            System.out.println("La cantidad de depósito debe ser positiva.");
        }
    }
    public void retirar(double cantidad) {
        if (cantidad > 0 && cantidad <= monto) {
            monto -= cantidad;
            System.out.println("Retiro de $" + cantidad + " realizado con éxito.");
        } else if (cantidad > monto) {
            System.out.println("Fondos insuficientes.");
        } else {
            System.out.println("La cantidad de retiro debe ser positiva.");
        }
    }
}
public class Pilas {
    public static void main(String[] args) {
        Scanner D = new Scanner(System.in);
        Stack<Cuenta> pilaCuentas = new Stack<>();

      
        System.out.print("Ingrese su nombre: ");
        String nombre = D.nextLine();
        System.out.print("Ingrese el monto inicial: ");
        double montoInicial = D.nextDouble();
        Cuenta cuenta = new Cuenta(nombre, montoInicial);
        pilaCuentas.push(cuenta); 

        boolean continuar = true;

        while (continuar) {
            System.out.println("\nSeleccione una opción:");
            System.out.println("1. Depósito");
            System.out.println("2. Retiro");
            System.out.println("3. Ver estado de cuenta");
            System.out.println("4. Salir");
            int opcion = D.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad a depositar: ");
                    double cantidadDeposito = D.nextDouble();
                    pilaCuentas.peek().depositar(cantidadDeposito); 
                    pilaCuentas.peek().estadoDeCuenta(); 
                    break;

                case 2:
                    System.out.print("Ingrese la cantidad a retirar: ");
                    double cantidadRetiro = D.nextDouble();
                    pilaCuentas.peek().retirar(cantidadRetiro); 
                    pilaCuentas.peek().estadoDeCuenta(); 
                    break;

                case 3:
                    pilaCuentas.peek().estadoDeCuenta();
                    break;

                case 4:
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
        D.close();
    }
}
