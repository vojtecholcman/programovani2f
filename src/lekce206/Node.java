/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

/**
 *
 * @author admin
 */
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class Node {

    public static void main(String[] args) {
        Node red1 = new Node();
        Node red2 = new Node();
        Node red3 = new Node();
        Node red4 = new Node();
        red1.connect(red2);
        red1.connect(red3);
        red2.connect(red4);
        Node blue1 = new Node();
        Node blue2 = new Node();
        Node blue3 = new Node();
        blue1.connect(blue2);
        blue2.connect(blue3);
        blue3.connect(blue1);
        System.out.println(red1.getComponentSize());
        System.out.println(red2.getComponentSize());
        System.out.println(red3.getComponentSize());
        System.out.println(blue1.getComponentSize());
    }
    private final Set<Node> neighborhood = new HashSet<>();

    public void connect(Node node) {
        node.neighborhood.add(this);
        this.neighborhood.add(node);
    }

    public int getComponentSize() {
        // -------------- zde odstrihnout --------------------------------------
        Set<Node> visited = new HashSet<>();
        Set<Node> toProcess = new HashSet<>();

        toProcess.add(this);

        while (!toProcess.isEmpty()) {
            Node current = toProcess.iterator().next();
            toProcess.remove(current);

            if (!visited.contains(current)) {
                visited.add(current);

                for (Node neighbor : current.neighborhood) {
                    if (!visited.contains(neighbor)) {
                        toProcess.add(neighbor);
                    }
                }
            }
        }

        return visited.size();
        // -------------- zde odstrihnout --------------------------------------
    }
}
