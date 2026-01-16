import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
public class KeyPresserSwing extends JFrame {
  public static void main(String[] args) {
    SwingUtilities.invokeLater(new Runnable() {
      @Override
      public void run() {
        KeyPresserSwing keyPresser = new KeyPresserSwing();
        keyPresser.start();
      }
    });
  }
  public void start() {
    JTextArea textArea = new JTextArea();
    // -------------- zde odstrihnout --------------------------------------
        textArea.addKeyListener(new KeyListener() {

      @Override
      public void keyPressed(KeyEvent e) {
        System.out.println("stisknuta klavesa id " + e.getKeyCode());
      }

      @Override
      public void keyReleased(KeyEvent e) {
        System.out.println("uvolnena klavesa id " + e.getKeyCode());
      }

      @Override
      public void keyTyped(KeyEvent e) {
        System.out.println("zapsan znak " + e.getKeyChar());
      }
    });
    // -------------- zde odstrihnout --------------------------------------
    getContentPane().add(textArea);
    setSize(500, 400);
    setTitle("KeyPressed Tester");
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
  }
}
