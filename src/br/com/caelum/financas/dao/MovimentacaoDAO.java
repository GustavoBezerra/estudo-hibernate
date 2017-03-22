package br.com.caelum.financas.dao;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gustavo
 */
public class MovimentacaoDAO {

    private EntityManager manager;

    public MovimentacaoDAO(EntityManager manager) {
        this.manager = manager;
    }

    public Double mediaDaContaPeloTipo(Conta conta, TipoMovimentacao tipo) {
        String jpql = "select avg(m.valor) from Movimentacao m where m.conta=:pConta "
                + "and m.tipoMovimentacao=:pTipo";
        TypedQuery<Double> query = manager.createQuery(jpql, Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", tipo);

        return query.getSingleResult();
    }

    public Long totalDeMovimentacoes(Conta conta) {
        TypedQuery<Long> query = manager.createNamedQuery("totalDeMovimentacoes", Long.class);
        query.setParameter("pConta", conta);

        return query.getSingleResult();
    }

}
