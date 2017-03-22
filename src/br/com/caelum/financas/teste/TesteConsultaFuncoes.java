/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gustavo
 */
public class TesteConsultaFuncoes {

    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();

        Conta conta = new Conta();
        conta.setId(3);

//        String jpql = "select sum(m.valor) from Movimentacao m where m.conta=:pConta "
//                + "and m.tipoMovimentacao=:pTipo";
//        MovimentacaoDAO dao = new MovimentacaoDAO(manager);
//
//        System.out.println("Total movimentado ..: R$ " + dao.mediaDaContaPeloTipo(conta, TipoMovimentacao.SAIDA));
        TypedQuery<Double> query = manager.
                createNamedQuery("mediaDaContaPeloTipoMovimentacao", Double.class);

        query.setParameter("pConta", conta);
        query.setParameter("pTipo", TipoMovimentacao.ENTRADA);

        Double media = query.getSingleResult();

        System.out.println(media);
    }

}
