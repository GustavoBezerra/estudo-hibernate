package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TestaConsultaComNamedQuery {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

        MovimentacaoDAO dao = new MovimentacaoDAO(manager);
        Long total = dao.totalDeMovimentacoes(conta);

        System.out.println(total);
    }

}
