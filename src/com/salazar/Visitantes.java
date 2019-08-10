package com.salazar;
import com.salazar.ErrorValidacion;

public class Visitantes {
    public String nombreCompleto;
    public String telefono;
    public int contador;

    public Visitantes() {
        this.nombreCompleto = this.nombreCompleto;
    }
    public String setNombre(String nombre) throws ErrorValidacion {
        if (nombre.length() > 50) {
            throw new ErrorValidacion("Ese nombre es muy largo.");
        } else {
            return nombre;
        }
    }
    public void setTelefono(String telefono) throws ErrorValidacion {
        if (!telefono.matches("[0-9]{4}\\-[0-9]{4}")) {
            throw new ErrorValidacion("El numero de telefono es invalido.");
        } else {
            this.telefono = telefono;
        }
    }
}

