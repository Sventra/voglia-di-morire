package bancario;

public class CartaDiCredito extends ContoBancario {
    double fido;

    public double getFido() {
        return this.fido;
    }

    public void setFido(double fido) {
        this.fido = fido;
    }

    public CartaDiCredito(String iban, double saldo, Persona cliente, double fido) {
        super(iban, saldo, cliente);
        this.fido = fido;
    }

}
