package day01.quiz.vendingmachine.model;

import day01.quiz.vendingmachine.Cola;
import day01.quiz.vendingmachine.Juice;

/**
 * Created by bollsal on 2016. 11. 11..
 */
public class Menu {

    Cola cola;
    Juice juice;

    public Menu(Cola cola, Juice juice) {
        this.cola = cola;
        this.juice = juice;
    }

    public Cola getCola() {
        return cola;
    }

    public void setCola(Cola cola) {
        this.cola = cola;
    }

    public Juice getJuice() {
        return juice;
    }

    public void setJuice(Juice juice) {
        this.juice = juice;
    }

    public boolean hasCola() {
        if (cola != null && cola.getCount() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasJuice() {
        if (juice != null && juice.getCount() != 0) {
            return true;
        } else {
            return false;
        }
    }

    public boolean hasItem() {
        if (hasCola() || hasJuice()) {
            return true;
        } else {
            return false;
        }
    }
}
