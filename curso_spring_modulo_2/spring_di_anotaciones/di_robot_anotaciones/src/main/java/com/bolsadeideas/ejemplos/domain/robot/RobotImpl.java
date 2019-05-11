/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.domain.robot;

/**
*
* @author Andres Guzman F
*/
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component("robot")
public class RobotImpl implements Robot{

    @Autowired(required=true)
    @Qualifier("cabeza")
    private Cabeza cabeza;

    @Autowired(required=true)
    @Qualifier("brazo")
    private Brazo  brazoD;

    @Autowired(required=true)
    @Qualifier("brazo")
    private Brazo brazoI;

    @Autowired(required=true)
    @Qualifier("pierna")
    private Pierna piernaD;

    @Autowired(required=true)
    @Qualifier("pierna")
    private Pierna piernaI;

   @PostConstruct
    public void inicializarTipos(){
        brazoD.setTipo("derecho");
        brazoI.setTipo("izquierdo");
        piernaD.setTipo("derecha");
        piernaI.setTipo("izquierda");
    }


    public void moverRobot(){
        cabeza.mover();
        brazoD.mover();
        brazoI.mover();
        piernaD.correr();
        piernaI.correr();
    }


    public void setCabeza(Cabeza cabeza) {
        this.cabeza = cabeza;
    }

    public void setBrazoD(Brazo brazoD) {
        this.brazoD = brazoD;
    }

    public void setBrazoI(Brazo brazoI) {
        this.brazoI = brazoI;
    }

    public void setPiernaD(Pierna piernaD) {
        this.piernaD = piernaD;
    }

    public void setPiernaI(Pierna piernaI) {
        this.piernaI = piernaI;
    }

}