/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.Date;

/**
 *
 * @author vojtech.holcman.s
 */

public interface Creatable {
    Date getCreated();
}

public class Creature implements Creatable {
    private Date created;

    public Creature() {
        this.created = new Date();
    }

    @Override
    public Date getCreated() {
        return created;
    }
}


public class Human extends Creature {
    private String name;
   
    public Human(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

public class God {

    public static void main(String[] args) {
        long start = System.nanoTime();

        for (int i = 0; i < 100; i++) {
            new Creature() {
            };
        }
        Human adam = new Human("Adam");
        Human eva = new Human("Eva");

        long end = System.nanoTime();
        long time = end - start;

        System.out.println("Cas vytvoreni 102 stvoreni: " + time + " ns");
    }
}
