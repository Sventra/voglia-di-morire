package bancario;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int risp = 0;
        // Banca[] banche = new Banca[10];
        // banche[0] = new Banca("Unicredit");
        Scanner scanner = Utility.createScanner();
        Banca banca = new Banca("Unicredit");

        ContoBancario conto1 = banca.aperturaConto("Andrea", "De Michele", "abc", 0);
        ContoBancario conto2 = banca.aperturaConto("Gianni", "Morandi", "gma", 0);

        System.out.println("\n--Bevenuto in " + banca + "--");
        System.out.println("-Seleziona il tipo di operazione-");
        System.out.println("1: Disponibilità");
        System.out.println("2: Preleva");
        System.out.println("3: Versa");
        System.out.println("4: Cancella il tuo conto");
        System.out.println("0: Esci\n");
        try {
            risp = scanner.nextInt();
        } catch (Exception e) {
            System.out.println("Errore: " + e.getMessage());
        }
        double amount;
        boolean exit = false;
        while (exit == false) {
            switch (risp) {
                case 1:
                    System.out.println("Il saldo del conto " + conto1.getIban() + " è: "
                            + banca.getDisponibilita(conto1.cliente.getCodiceFiscale()) + " euro\n");
                    break;
                case 2:
                    System.out.println("Quanto vuoi prelevare?");
                    amount = scanner.nextDouble();
                    if (banca.preleva(conto1.cliente.getCodiceFiscale(), amount)) {
                        System.out.println("Hai correttamente prelevato " + amount + "euro");
                        System.out.println(
                                "Nuovo saldo: " + banca.getDisponibilita(conto1.cliente.getCodiceFiscale()) + "euro\n");
                    } else {
                        if (banca.getDisponibilita(conto1.cliente.getCodiceFiscale()) == 0) {
                            System.out.println("Il tuo conto è vuoto, deposita prima di prelevare");
                        } else {
                            System.out.println(
                                    "Non hai abbastanza soldi sul conto per prelevare " + amount
                                            + "euro, possibile prelievo: "
                                            + banca.getDisponibilita(conto1.cliente.getCodiceFiscale()) + "euro\n");
                        }
                    }
                    break;
                case 3:
                    System.out.println("Quanto vuoi depositare?");
                    amount = scanner.nextDouble();
                    banca.versa(conto1.cliente.getCodiceFiscale(), amount);
                    System.out.println("Hai correttamente versato " + amount + "euro\n");
                    break;
                case 4:
                    break;
                case 0:
                    exit = true;
            }
            System.out.println("Seleziona il tipo di operazione:");
            System.out.println("1: Disponibilità");
            System.out.println("2: Preleva");
            System.out.println("3: Versa");
            System.out.println("4: Cancella il tuo conto");
            System.out.println("0: Esci\n");
            try {
                risp = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Errore: " + e.getMessage());
            }
            if (risp == 0) {
                exit = true;
            }

        }

    }

}
