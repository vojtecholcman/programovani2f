/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

/**
 *
 * @author vojtech.holcman.s
 */
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
