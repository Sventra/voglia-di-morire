package bancario;

import java.util.Arrays;

public class Banca {
    private ContoBancario[] conti;
    private int numeroDiContiAperti = 0;
    private static final double taeg = 4.6;
    private String nomeBanca;
    private String indirizzo;

    public Banca(String nomeBanca) {
        conti = new ContoBancario[1];
        setNomeBanca(nomeBanca);
    }

    public ContoBancario aperturaConto(String nome, String cognome, String cf, double saldo) {
        Persona persona = Utility.newPersona(nome, cognome, cf);
        ContoBancario conto = null;
        if (this.numeroDiContiAperti < conti.length) {
            if (this.numeroDiContiAperti > 0) {
                ContoBancario[] newConti = new ContoBancario[conti.length + 1];
                for (int j = 0; j < conti.length; j++) {
                    if (Utility.valoreStringa(cf) < Utility.valoreStringa(conti[j].cliente.getCodiceFiscale())) {
                        String iban = Utility.generateIban(this.conti);
                        conto = new ContoBancario(iban, saldo, persona);
                        conti[this.numeroDiContiAperti] = conto;
                        this.numeroDiContiAperti++;
                        newConti[j] = conto;
                        for (int k = j + 1; k < newConti.length; k++) {
                            newConti[k] = conti[j];
                            j++;
                        }
                        this.conti = newConti;
                    } else {
                        newConti[j] = conti[j];
                    }
                }

            } else {
                String iban = Utility.generateIban(this.conti);
                conto = new ContoBancario(iban, saldo, persona);
                conti[this.numeroDiContiAperti] = conto;
                this.numeroDiContiAperti++;
            }

        } else {
            // ContoBancario[] contiNew = new ContoBancario[conti.length * 2];
            // for (int i = 0; i < numeroDiContiAperti; i++) {
            // contiNew[i] = conti[i];
            // }
            ContoBancario[] newConti = new ContoBancario[conti.length + 1];
            for (int j = 0; j < conti.length; j++) {
                if (Utility.valoreStringa(cf) < Utility.valoreStringa(conti[j].cliente.getCodiceFiscale())) {
                    String iban = Utility.generateIban(this.conti);
                    conto = new ContoBancario(iban, saldo, persona);
                    conti[this.numeroDiContiAperti] = conto;
                    this.numeroDiContiAperti++;
                    newConti[j] = conto;
                    for (int k = j + 1; k < newConti.length; k++) {
                        newConti[k] = conti[j];
                        j++;
                    }
                    this.conti = newConti;
                } else {
                    newConti[j] = conti[j];
                }
            }
            this.conti = newConti;
        }
        return conto;
    }

    public double getDisponibilita(String cf) {
        for (int i = 0; i < conti.length; i++) {
            if (cf.equals(conti[i].cliente.codiceFiscale)) {
                return conti[i].getSaldo();
            }
        }
        return 0;
    }

    public void apriCartaDicredito(String iban, double saldo, Persona cliente, double fido) {

    }

    public boolean versa(String cf, double amount) {
        for (int i = 0; i < conti.length; i++) {
            if (conti[i].cliente.getCodiceFiscale().equals(cf + "")) {
                conti[i].versa(amount);
                return true;
            }

        }
        return false;
    }

    public boolean preleva(String cf, double amount) {
        for (int i = 0; i < conti.length; i++) {
            if (conti[i].cliente.getCodiceFiscale().equals(cf + "")) {
                if (conti[i].preleva(amount)) {
                    return true;
                } else {
                    return false;
                }
            }

        }
        return false;
    }

    public ContoBancario[] getConti() {
        return this.conti;
    }

    public void setConti(ContoBancario[] conti) {
        this.conti = conti;
    }

    public int getNumeroDiContiAperti() {
        return this.numeroDiContiAperti;
    }

    public void setNumeroDiContiAperti(int numeroDiContiAperti) {
        this.numeroDiContiAperti = numeroDiContiAperti;
    }

    public String getNomeBanca() {
        return this.nomeBanca;
    }

    public void setNomeBanca(String nomeBanca) {
        this.nomeBanca = nomeBanca;
    }

    public String getIndirizzo() {
        return this.indirizzo;
    }

    public void setIndirizzo(String indirizzo) {
        this.indirizzo = indirizzo;
    }

    // public void aperturaConto(ContoBancario conto){
    // if(this.numeroDiContiAperti<conti.length){
    // conti[this.numeroDiContiAperti]=conto;
    // this.numeroDiContiAperti++;
    // }else{
    // ContoBancario[] contiNew = new ContoBancario[conti.length *2];

    // for(int i = 0; i < numeroDiContiAperti; i++) {
    // contiNew[i] = conti[i];
    // }
    // contiNew[numeroDiContiAperti] = conto;
    // this.numeroDiContiAperti++;
    // this.conti=contiNew;
    // }

    @Override
    public String toString() {
        return "{" +
                " conti='" + Arrays.toString(conti) + "'" +
                ", numeroDiContiAperti='" + getNumeroDiContiAperti() + "'" +
                ", nomeBanca='" + getNomeBanca() + "'" +
                ", indirizzo='" + getIndirizzo() + "'" +
                "}";
    }

    // }

}
