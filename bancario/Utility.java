package bancario;

import java.util.Random;
import java.util.Scanner;

public class Utility {
    public static String generateIban(ContoBancario[] conti) {
        Random randomnum = new Random();
        String iban = null;
        int randomico = randomnum.nextInt(999999);
        for (int i = 0; i < conti.length; i++) {
            if (conti[i] != null &&
                    conti[i].getIban().equals(randomico + "")) {
                randomico = randomnum.nextInt(999999);
                i = 0;
            }
        }
        iban = randomico + "";
        return "IT00" + iban;
    }

    public static long valoreStringa(String stringa) {
        long risultato = 0;

        for (int i = 0; i < stringa.length(); i++) {
            final char ch = stringa.charAt(i);
            risultato += (int) ch;
        }

        return risultato;
    }

    public static Persona newPersona(String nome, String cognome, String cf) {
        return new Persona(nome, cognome, cf);
    }

    public static Scanner createScanner() {
        return new Scanner(System.in);
    }
}
