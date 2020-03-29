public class ControleBonificacao {

    private double soma;

    public void registraBonificacao(Gerente g){
        double boni = g.getBonificacao();
        this.soma += boni;
    }

    public double getSoma() {
        return soma;
    }
}
