package novaAbordagem;

public class Caixa {

    private static Double saldo;

    public Caixa(Double saldo){
        Caixa.saldo = saldo;
    }

    public static Double getSaldo() {
        return saldo;
    }

    public static void setSaldo(Double saldo) {
        Caixa.saldo = saldo;
    }
}
