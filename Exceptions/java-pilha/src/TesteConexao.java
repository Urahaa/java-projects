import java.sql.SQLOutput;

public class TesteConexao {

    public static void main(String[] args) {
        Conexao c = null;
        try{
            c = new Conexao();
            c.leDados();
        }catch (IllegalStateException ise){
            System.out.println("Ocorreu erro na conexão");
        } finally {
            c.close();
        }

    }

}
