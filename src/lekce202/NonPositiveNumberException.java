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
public class NonPositiveNumberException extends IllegalArgumentException {

    /**
     * Creates a new instance of <code>NonPositiveNumberException</code> without
     * detail message.
     */
    public NonPositiveNumberException(double x, String name) {
        super(String.format(
                    "'%s' = %.1f; should be a positive number", name, x));
    }

    /**
     * Constructs an instance of <code>NonPositiveNumberException</code> with
     * the specified detail message.
     *
     * @param msg the detail message.
     */
    public NonPositiveNumberException(String msg) {
        super(msg);
    }
}
