package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteGerenciamentoJPA {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        manager.getTransaction().begin();

        // ID de uma conta que exista no banco de dados, no caso ID: 1
        Conta conta = manager.find(Conta.class, 7);
        
        // commit antes da alteração
        manager.getTransaction().commit();
        System.out.println(conta.getTitular());
        // Alteração do titular da conta
        conta.setTitular("Leticia Ribeiro");

        manager.getTransaction().begin();
        manager.merge(conta);
        manager.getTransaction().commit();
        System.out.println(conta.getTitular());
        manager.close();
    }
    
}
