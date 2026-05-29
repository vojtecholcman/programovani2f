/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 *
 * @author vojtech.holcman.s
 */
public class Tree<E> {

    public static void main(String[] args) {
        Tree<String> koren = new Tree<>("Koren");
        Tree<String> daniel = koren.add("Daniel");
        koren.add("Vasek");
        koren.add("Vilda");

        daniel.add("adoptovanej1");
        daniel.add("adoptovanej2");
        System.out.println(koren.toString());
        System.out.println(koren.contains("Vilda"));
        System.out.println(koren.contains("Krystof"));
    }
    private final E value;
    private final Tree<E> parent;
    private final Set<Tree<E>> children = new LinkedHashSet<>();

    public Tree(E value) {
        this(value, null);
    }

    public Tree(E value, Tree<E> parent) {
        this.value = value;
        this.parent = parent;
    }

    public Tree<E> add(E value) {
        Tree tree = new Tree<>(value, this);
        this.children.add(tree);
        return tree;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(String.valueOf(value));
        if (!children.isEmpty()) {
            sb.append(": {");
            for (Tree<E> c : children) {
                sb.append(c);
                sb.append(", ");
            }
            sb.delete(sb.length() - 2, sb.length());
            sb.append("}");
        }
        return sb.toString();
    }

    public boolean contains(E value) {
        if (this.value == value) {
            return true;
        }
        for (Tree<E> c : children) {
            if (c.contains(value)) {
                return true;
            }
        }
        return false;
    }
}
