/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bolsadeideas.ejemplos.domain.robot;

/**
 *
 * @author Andres Guzman F
 */
public class RobotImpl implements Robot {

    private Cabeza cabeza;
    private Brazo brazoD;
    private Brazo brazoI;
    private Pierna piernaD;
    private Pierna piernaI;

    public void moverRobot() {
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
