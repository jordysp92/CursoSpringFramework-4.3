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
@Component("brazo")
public class BrazoImpl implements Brazo {

    private String tipo;

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void mover() {
        System.out.println("Moviendo el brazo : " + tipo);
    }
}
