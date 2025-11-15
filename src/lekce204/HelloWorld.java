/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce204;

import java.awt.event.MouseAdapter;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author vojtech.holcman.s
 */
public class HelloWorld {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Hello Wolrd");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
                JButton button = new JButton("c");
                button.addMouseListener(new MouseAdapter() {
});
        frame.setVisible(true);
    }
}
