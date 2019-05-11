/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.domain.robot;

/**
*
* @author Andres Guzman F
*/
public class BrazoImpl implements Brazo {

    private String tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void mover() {
        System.out.println("Moviendo el brazo : " + tipo);
    }
}
