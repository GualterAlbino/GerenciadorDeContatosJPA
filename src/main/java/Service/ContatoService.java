package Service;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Query;
import java.awt.List;
import java.util.ArrayList;
import model.ContatoClass;

public class ContatoService {

    private EntityManager em;

    public ContatoService(EntityManager em) {
        this.em = em;
    }

    public void inserir(ContatoClass contato) {
        EntityTransaction transaction = null;
        try {
            transaction = em.getTransaction();
            transaction.begin();

            em.persist(contato);

            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro na camada SERVICE: " + e);
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public void editar(ContatoClass contato) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Verifica se o objeto está gerenciado
            if (!em.contains(contato)) {
                // Se não estiver, utiliza o merge para torná-lo gerenciado
                contato = em.merge(contato);
            }

            // Confirma as alterações ao finalizar a transação
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro na camada SERVICE ao editar contato: " + e);

            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public ArrayList<ContatoClass> listar() {
        var contatosList = em.createQuery("SELECT c FROM ContatoClass c", ContatoClass.class)
                .getResultList();
        return new ArrayList<>(contatosList);
    }

    public void deletar(ContatoClass contato) {
        EntityTransaction transaction = em.getTransaction();

        try {
            transaction.begin();

            // Certifique-se de que o contato está gerenciado (attached) antes de removê-lo
            if (!em.contains(contato)) {
                contato = em.merge(contato);
            }

            em.remove(contato);

            // Confirma as alterações ao finalizar a transação
            transaction.commit();
        } catch (Exception e) {
            System.out.println("Erro na camada SERVICE ao deletar contato: " + e);

            if (transaction.isActive()) {
                transaction.rollback();
            }
        }
    }

    public ContatoClass buscaPorCodigo(int codigo) {
        return em.find(ContatoClass.class, codigo);
    }

}
