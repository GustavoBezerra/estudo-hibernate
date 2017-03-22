/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteMovimentacaoConta {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

//        Movimentacao movimentacao = manager.find(Movimentacao.class, 2);
        Conta conta = manager.find(Conta.class, 2);
//
//        System.out.println("Titular da conta: " + movimentacao.getConta().getTitular());
        System.out.println(conta.getMovimentacoes().size());
//        Query query = manager.createQuery("select c from Conta c");
//        Query query = manager.createQuery("select c from Conta c join fetch c.movimentacoes");
//        List<Conta> contas = query.getResultList();
//
//        for (Conta conta : contas) {
//            System.out.println("Número de movimentações ...: " + conta.getMovimentacoes().size());
//        }

    }

}
