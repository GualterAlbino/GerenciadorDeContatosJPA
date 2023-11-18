package Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class FabricaConexao {

    private static final String DATABASE = "UP1";

    public static EntityManager getConexao() {
        EntityManager objConexao = null;
        try {
            EntityManagerFactory fabrica = Persistence.createEntityManagerFactory(DATABASE);
            objConexao = fabrica.createEntityManager();
        } catch (Exception ex) {
            System.out.println("Ocorreu um erro ao tentar abrir conexão: " + ex.getMessage());
        }
        return objConexao;
    }
}
