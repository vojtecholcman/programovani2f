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
public class UncheckedException extends Exception {

    /**
     * Creates a new instance of <code>UncheckedEception</code> without detail
     * message.
     */
    public UncheckedException() {
    }

    /**
     * Constructs an instance of <code>UncheckedEception</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public UncheckedException(String msg) {
        super(msg);
    }
}
