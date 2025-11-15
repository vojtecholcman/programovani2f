/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce203;

import cz.gyarab.util.paint.Shape;
import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author vojtech.holcman.s
 */
public class Rectangle extends Shape{
    
    private int width, height;

    public Rectangle(int x, int y, int width, int height) {
        super(x, y);
        this.width = width;
        this.height = height;
    }

    public Rectangle(int x, int y, int width, int height, Color color) {
        super(color, x, y);
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }


    @Override
    protected void paintShape(Graphics2D g) {
        g.drawRect(getX(), getY(), width, height);
    }
    
}
