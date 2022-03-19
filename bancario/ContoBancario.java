package bancario;

public class ContoBancario {
    private String iban;
    private double saldo;
    Persona cliente;

    public ContoBancario(String iban, double saldo, Persona cliente) {
        this.iban = iban;
        this.saldo = saldo;
        this.cliente = cliente;
    }

    public void versa(double amount) {
        this.saldo = this.saldo + amount;
    }

    public boolean preleva(double amount) {
        if (this.saldo >= amount) {
            this.saldo = this.saldo - amount;
            return true;
        } else {
            return false;
        }
    }

    public String getIban() {
        return this.iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    // public boolean preleva(double amount) {
    // for (int i = 0; i < conto.length; i++) {
    // if (conto[i].cliente.getCodiceFiscale().equals(cf + "") &&
    // conto[i].getSaldo() > amount) {
    // this.saldo = this.saldo - amount;
    // return true;
    // }

    // }
    // return false;

    // }

    @Override
    public String toString() {
        return "{" +
                " iban='" + getIban() + "'" +
                ", saldo='" + getSaldo() + "'" +
                ", cliente='" + cliente + "'" +
                "}";
    }
}
