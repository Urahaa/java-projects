package br.com.bytebank.banco.model;


import java.io.Serializable;

/**
 * @author Matheus
 * @version 0.1
 * Utilizando comentário para documentação
 */

public abstract class Conta implements Comparable<Conta>, Serializable {

    protected double saldo;
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

    public abstract void deposita(double valor);

    public void saca(double valor) throws SaldoInsuficienteException {
        if(this.saldo < valor){
            throw new SaldoInsuficienteException("Saldo: "+ this.getSaldo()
                    + ", Valor: " + valor
                    +" não é suficiente para a operação");
        }
        this.saldo-=valor;
    }

    public void transfere(double valor, Conta destino) throws SaldoInsuficienteException {
            this.saca(valor);
            destino.deposita(valor);
    }

    public static int getTotalDeContas(){
        return Conta.totalDeContas;
    }

    @Override
    public String toString() {
        return "Conta - " +
                "saldo:" + saldo +
                ", agencia:" + agencia +
                ", numero:" + numero +
                ", titular:" + titular.getNome() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Conta conta = (Conta) o;
        return agencia == conta.agencia && numero == conta.numero;
    }

    @Override
    public int compareTo(Conta c) {
        return Double.compare(this.getSaldo(), c.getSaldo());
    }
}
