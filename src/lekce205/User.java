/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author vojtech.holcman.s
 */
public class User implements Comparable<User>{

    public static void main(String[] args) {
        List<User> list = new ArrayList<>();
        list.add(new User("Novotny", "Josef", "josef@novak.cz"));
        list.add(new User("Novak", "Alois", "alois@novak.cz"));
        list.add(new User("Novak", "Anna", "anna@novakova.cz"));

        System.out.println(list);

//        Collections.sort(list, (User o1, User o2) -> {
//            int c = o1.getLastName().compareTo(o2.getLastName());
//            if (c == 0) {
//                c = o1.getFirstName().compareTo(o2.getFirstName());
//                if (c == 0) {
//                    c = o1.email.compareTo(o2.email);
//                }
//            }
//            return c;
//        });

        System.out.println(list);
    }

    private final String lastName;
    private final String firstName;
    private final String email;

    public User(String lastName, String firstName, String email) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " (" + email + ")";
    }

    @Override
    public int compareTo(User o) {
       int c = this.getLastName().compareTo(o.getLastName());
            if (c == 0) {
                c = this.getFirstName().compareTo(o.getFirstName());
                if (c == 0) {
                    c = this.email.compareTo(o.email);
                }
            }
            return c;
    }
    
}
