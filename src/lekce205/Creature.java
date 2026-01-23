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
