/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lekce205;

import java.util.Objects;

/**
 *
 * @author vojtech.holcman.s
 */
public class Hash {
    private int a, b, c;
    private String str;
    private long l;
    
    public static void main(String[] args) {
        System.out.println("111\n".hashCode());
        System.out.println("11\n".hashCode());
    }

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Hash other = (Hash) obj;
        if (this.a != other.a) {
            return false;
        }
        if (this.b != other.b) {
            return false;
        }
        if (this.c != other.c) {
            return false;
        }
        if (this.l != other.l) {
            return false;
        }
        if (!Objects.equals(this.str, other.str)) {
            return false;
        }
        return true;
    }
    
}
