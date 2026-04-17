package lekce205;


import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Sorter {

    public static void sortStringsIgnoreCase(List<String> strings) {
        // -------------- zde odstrihnout --------------------------------------
        for(int i = 0; i < strings.size(); i++){
            String prvni = strings.get(i);
            String nasledujici = strings.get(i+1);
//            Collections.sort(strings, Comparator<String> c);
        }
        // -------------- zde odstrihnout --------------------------------------
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList(new String[]{"ahoj", "Alois", "Adam", "Abrahám", "Asterix"});
        sortStringsIgnoreCase(strings);
        System.out.println(strings);
    }
}
