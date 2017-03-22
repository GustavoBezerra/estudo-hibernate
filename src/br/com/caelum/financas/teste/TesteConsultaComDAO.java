package br.com.caelum.financas.teste;

import br.com.caelum.financas.dao.MovimentacaoDAO;
import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteConsultaComDAO {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = manager.find(Conta.class, 2);

        MovimentacaoDAO dao = new MovimentacaoDAO(manager);
        Double media = dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.ENTRADA);
        System.out.println("Media: "+media);
    }

}
