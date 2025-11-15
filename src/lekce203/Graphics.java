/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce203;

import cz.gyarab.util.paint.Canvas;
import cz.gyarab.util.paint.Painter;
import cz.gyarab.util.paint.SwingCanvas;

import java.awt.Color;

/**
 *
 * @author vojtech.holcman.s
 */
public class Graphics {
    public static void main(String[] args) {
        Canvas canvas = new SwingCanvas();
        Painter painter = new Painter();
        Rectangle r = new Rectangle(100, 100, 200, 50);
        painter.add(r);
        painter.add(new Rectangle(50, 10, 100, 100, Color.red));
    }
}
