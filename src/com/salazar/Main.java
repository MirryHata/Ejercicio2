package com.salazar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class Main {
    public Main() {
    }
    public static void main(String[] args) {
        ArrayList<Visitantes> visitas = new ArrayList();
        Scanner lector = new Scanner(System.in);
        boolean z = true;
        while(true) {
            label81:
            while(z) {
                boolean x = true;
                boolean y = true;
                System.out.println("--------Bienvenidos--------");
                System.out.println("1. Hacer una reservacion");
                System.out.println("2. Ver lista de cliente");
                System.out.println("3. Salir");
                int opc = LectorDeDatos.solicitarEntero("Ingrese una opcion: ");
                System.out.println("\n");
                switch(opc) {
                    case 1:
                        Visitantes nuevaVisita = new Visitantes();
                        String telefono;
                        while(x) {
                            try {
                                System.out.println("Ingrese su nombre completo: ");
                                telefono = lector.nextLine();
                                if (!telefono.isBlank()) {
                                    nuevaVisita.setNombre(telefono);
                                }
                                x = false;
                                nuevaVisita.nombreCompleto = telefono;
                            } catch (ErrorValidacion var11) {
                                System.err.println(var11.getMessage());
                            }
                        }
                        x = true;
                        while(x) {
                            System.out.println("Ingrese el numero de telefono del cliente: ");
                            telefono = lector.nextLine();
                            System.out.println();
                            try {
                                if (!telefono.isBlank()) {
                                    nuevaVisita.setTelefono(telefono);
                                }
                                nuevaVisita.telefono = telefono;
                                Iterator var14 = visitas.iterator();
                                while(var14.hasNext()) {
                                    Visitantes c = (Visitantes)var14.next();
                                    if (telefono.equals(c.telefono)) {
                                        System.out.println("Bienvenido");
                                        ++c.contador;
                                        x = false;
                                        break;
                                    }
                                }
                                if (!x) {
                                    continue label81;
                                }

                                nuevaVisita.contador = 1;
                                visitas.add(nuevaVisita);
                                x = false;
                                System.out.println("Hola");
                            } catch (ErrorValidacion var12) {
                                System.err.println(var12.getMessage());
                            }
                        }
                        break;
                    case 2:
                        System.out.println("--------Esta es la lista de clientes--------");
                        Iterator var8 = visitas.iterator();
                        while(true) {
                            if (!var8.hasNext()) {
                                continue label81;
                            }
                            Visitantes c = (Visitantes)var8.next();
                            System.out.println("Nombre: " + c.nombreCompleto);
                            System.out.println("Telefono: " + c.telefono);
                            System.out.println("Visitas: " + c.contador);
                            System.out.println();
                        }
                    case 3:
                        System.out.println("Adios");
                        z = false;
                }
            }

            return;
        }
    }
}
