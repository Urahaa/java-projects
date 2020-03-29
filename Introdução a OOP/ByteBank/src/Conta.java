public class Conta {
    private double saldo;
    private int agencia;
    private int numero;
    private Cliente titular;
    private static int totalDeContas;

    public Conta(int agencia, int numero) {
        totalDeContas++;
        this.setAgencia(agencia);
        this.setNumero(numero);
    }

    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public void setAgencia(int agencia) {
        if(agencia<=0){
            System.out.println("Valor da agência igual ou menor que zero");
            return;
        }
        this.agencia = agencia;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if(numero<=0){
            System.out.println("Valor do número igual ou menor que zero");
            return;
        }
            this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setTitular(Cliente titular) {
        this.titular = titular;
    }

    public void deposita(double valor){
        if(valor > 0)
            this.saldo += valor;
    }

    public boolean saca(double valor){
        if(this.saldo >= valor){
            this.saldo-=valor;
            return true;
        }
        return false;
    }

    public boolean transfere(double valor, Conta destino){
        if(this.saldo>=valor){
            this.saca(valor);
            destino.deposita(valor);
            return true;
        }
        return false;
    }

    public static int getTotalDeContas(){
        return Conta.totalDeContas;
    }

}
