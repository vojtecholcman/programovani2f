/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce204;

import cz.gyarab.util.paint.*;
import java.awt.Color;
import java.awt.Graphics2D;

import java.awt.Graphics;
import java.awt.BasicStroke;
import java.awt.Stroke;


/**
 *\
 * @author vojta
 */

public class Shapes{
    public static void main(String[] args) {
        Canvas canvas = new ThickCanvas();
        Painter painter = new Painter(canvas);
        
        painter.add(new Triangle(100, 120, 50, Color.YELLOW));
        painter.add(new Diamond(250, 150, 80, Color.RED));
        painter.add(new Cross(400, 200, 120, Color.GREEN));
        painter.add(new Pentagon(150, 300, 60, Color.ORANGE));
        painter.add(new Star(350, 320, 20, 45, Color.MAGENTA));
        
        painter.paint();
    }
}

class ThickCanvas extends SwingCanvas {
    public ThickCanvas() {
        super();//zdedeni SwingCanvasu
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        Stroke oldStroke = g2.getStroke();

        g2.setStroke(new BasicStroke(10));
        super.paintComponent(g2);

        g2.setStroke(oldStroke);
    }
}

class Triangle extends Shape{
    private int size; //velikost trojuhelniku
    
    //konstruktor
    public Triangle(int x, int y, int size, Color color) {
        super(color, x, y);//zdedeni x,y z predka
        this.size = size;//nastaveni velikosti
    }

    //vykresleni
    @Override
    protected void paintShape(Graphics2D g) {
        int xCenter = getX();//zjisteni x z predka
        int yCenter = getY();//zjisteni y z predka
        
        int[] xCanvas = {xCenter, xCenter - size/2, xCenter + size/2};
        int[] yCanvas = {yCenter - size, yCenter + size/2, yCenter + size/2};
        
        g.fillPolygon(xCanvas, yCanvas, 3);
    }
}

class Diamond extends Shape{
    private int size; //velikost trojuhelniku
    
    //konstruktor
    public Diamond(int x, int y, int size, Color color) {
        super(color, x, y);//zdedeni x,y z predka
        this.size = size;//nastaveni velikosti
    }

    //vykresleni
    @Override
    protected void paintShape(Graphics2D g) {
        int xCenter = getX();//zjisteni x z predka
        int yCenter = getY();//zjisteni y z predka
        
        int[] xCanvas = {xCenter, xCenter - size, xCenter, xCenter + size};
        int[] yCanvas = {yCenter - size,yCenter, yCenter + size, yCenter};
        
        g.fillPolygon(xCanvas, yCanvas, 4);
    }
}

class Cross extends Shape{
    private int size; //velikost trojuhelniku
    
    //konstruktor
    public Cross(int x, int y, int size, Color color) {
        super(color, x, y);//zdedeni x,y z predka
        this.size = size;//nastaveni velikosti
    }

    //vykresleni
    @Override
    protected void paintShape(Graphics2D g) {
        int xCenter = getX();//zjisteni x z predka
        int yCenter = getY();//zjisteni y z predka
        int arm = size/2;
        int thick = size/4;
        
        g.fillRect(xCenter - thick/2, yCenter - arm, thick, 2*arm);//svisly
        g.fillRect(xCenter - arm, yCenter - thick/2, 2*arm, thick);//vodorovny
    }
}

class Pentagon extends Shape {
    private int radius; //polomer

    public Pentagon(int x, int y, int radius, Color color) {
        super(color, x, y);//zdedeni x,y z predka
        this.radius = radius;//nastaveni velikosti
     }

    @Override
    protected void paintShape(Graphics2D g) {
        int xCenter = getX();//stred x
        int yCenter = getY();//stred y

        int n = 5;//pocet vrcholu
        int[] xCanvas = new int[n];
        int[] yCanvas = new int[n];

        for (int i = 0; i < n; i++) {
            double angle = ((-Math.PI) / 2 + 2 * Math.PI * i / n);
            xCanvas[i] = xCenter + (int)(radius * Math.cos(angle));
            yCanvas[i] = yCenter + (int)(radius * Math.sin(angle));
        }

        g.fillPolygon(xCanvas, yCanvas, n);
    }
}

class Star extends Shape {
    private int innerRadius;//vnitrni polomer
    private int outerRadius;//vnejsi polomer

    public Star(int x, int y, int innerRadius, int outerRadius, Color color) {
        super(color, x, y);
        this.innerRadius = innerRadius;
        this.outerRadius = outerRadius;
    }

    @Override
    protected void paintShape(Graphics2D g) {
        int xCenter = getX();//stred x
        int yCenter = getY();//stred y

        int points = 5;//pocet cipu hvezdy
        int n = points * 2;//pocet vnejsich+vnitrnich vrcholu
        int[] xCanvas = new int[n];
        int[] yCanvas = new int[n];

        for (int i = 0; i < n; i++) {
            int r; //polomer pro aktualni vrchol

            if (i % 2 == 0) {
                r = outerRadius;
            } else {
                r = innerRadius;
            }
            double angle = -Math.PI / 2 + i * Math.PI / points;

            xCanvas[i] = xCenter + (int) (r * Math.cos(angle));
            yCanvas[i] = yCenter + (int) (r * Math.sin(angle));
        }
        g.fillPolygon(xCanvas, yCanvas, n); //vyplnena hvezda
    }
}