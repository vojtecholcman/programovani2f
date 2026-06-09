/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce206;

import java.util.*;

/**
 *
 * @author admin
 */
public class EmptyLines {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Deque<String> stack = new ArrayDeque<>();
        String line;
        while (!(line = sc.nextLine()).isEmpty()) {
            stack.push(line);
        }
        for (String s : stack) {
            System.out.println(s);
        }

    }

}
