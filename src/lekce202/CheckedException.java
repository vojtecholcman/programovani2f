/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce202;

/**
 *
 * @author vojtech.holcman.s
 */
public class CheckedException extends Exception {

    /**
     * Creates a new instance of <code>CheckedException</code> without detail
     * message.
     */
    public CheckedException() {
    }

    /**
     * Constructs an instance of <code>CheckedException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public CheckedException(String msg) {
        super(msg);
    }
}
