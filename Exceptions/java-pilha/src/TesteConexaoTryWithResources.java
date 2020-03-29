public class TesteConexaoTryWithResources {

    public static void main(String[] args) {
        try(Conexao c = new Conexao()){
            c.leDados();
        } catch (IllegalStateException ex){
            System.out.println("Ocorreu erro na conexao");
        }

    }

}
