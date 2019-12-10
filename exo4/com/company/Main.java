package com.company;

import java.util.Arrays;

public class Main {
    public static Boolean verif(String alphabet, String chain) {
        alphabet = alphabet.toLowerCase();
        chain = chain.toLowerCase();
        if (alphabet == null || chain == null) return false;
        for (int i = 0; i < chain.length(); i++) {
            if (!alphabet.contains(String.valueOf(chain.charAt(i)))) {
                System.out.println("ERROR BAD SYNTAXE");
                return false;
            }
        }
        return true;
    }

    public static void permuteLeft(String chain, int position) {
        System.out.println("--PERMUTE LEFT--");
        String[] newValue = new String[chain.length()];
        int j = 0;
        System.out.println("CHAINE :" + chain);
        for (int i = position; i < chain.length(); i++) {
            newValue[j] = String.valueOf(chain.charAt(i));
            j++;
        }
        int t = 0;
        for (int k = j; k < newValue.length; k++) {
            if (t < position) {
                newValue[k] = String.valueOf(chain.charAt(t));
                t++;
            }
        }

        System.out.println(Arrays.toString(newValue));
    }

    public static void permutRight(String chain, int position) {
        System.out.println("--PERMUTE RIGHT--");
        String[] newValue = new String[chain.length()];
        int j = 0;
        System.out.println("CHAINE : " + chain);
        for (int i = position; i != -1; i--) {
            newValue[j] = String.valueOf(chain.charAt(i));
            j++;
        }
        int t = position;
        for (int k = j; k < newValue.length; k++) {
            newValue[k] = String.valueOf(chain.charAt(t));
            t++;
        }

        System.out.println(Arrays.toString(newValue));
    }

    public static void VerifAnag(String chain, String value) {
        System.out.println("--ANAGRAMME--");
        char[] arrayC = chain.toCharArray();
        char[] arrayV = value.toCharArray();
        boolean cond = true;
        boolean goodLen = true;

        if (chain.length() != value.length()) {
            System.out.println( value + " is not a anagramme of " + chain);
            goodLen =false;
        }
        if(goodLen==true) {
            Arrays.sort(arrayC);
            Arrays.sort(arrayV);
            for (int i = 0; i < chain.length(); i++) {
                if (arrayC[i] != arrayV[i]) {
                    cond = false;
                }
            }

            if (cond) System.out.println(value + " is a anagramme of " + chain);
            else System.out.println(value + " is not a anagramme of " + chain);
        }

    }
    public static void SuppValue(String chain, String value) {
        System.out.println("--DELETE--");
        System.out.println(" Delete : " + value  + " in  " + chain);
        String newString = chain.replaceAll(value, "");
        System.out.println("New String : " + newString);
    }


    public static void main(String[] args) {
        // write your code here
        if (args.length == 0) {
            System.out.println("No alphabet or word entered ");
        }

        verif(args[0], args[1]);
        permuteLeft(args[1], 1);
        permutRight(args[1], 1);

        if (args[2] != null && args[3] != null) {
            switch (args[2]) {
                case "/a":
                    VerifAnag(args[1], args[3]);
                    break;
                case "/o":
                    SuppValue(args[1], args[3]);
                    break;
                default:
                    throw new IllegalStateException("Bad option");
            }


        }
    }
}