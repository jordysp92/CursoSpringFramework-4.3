/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.domain.robot;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
*
* @author Andres Guzman F
*/
@Scope("prototype")
@Component("pierna")
public class PiernaImpl implements Pierna {

    private String tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void arrodillarse() {
        System.out.println("Arrodillando la pierna : " + tipo);
    }

    public void saltar() {
        System.out.println("Saltando con la pierna : " + tipo);
    }

    public void correr() {
        System.out.println("Corriendo con la pierna : " + tipo);
    }
}
