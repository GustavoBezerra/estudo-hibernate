/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;
import br.com.caelum.financas.util.JPAUtil;
import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.EntityManager;

/**
 *
 * @author Gustavo
 */
public class TesteJPARelacionamento {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Conta conta = new Conta();
        conta.setTitular("Ana Maria");
        conta.setBanco("Itau");
        conta.setNumero("54321");
        conta.setAgencia("111");
        
        Movimentacao movimentacao = new Movimentacao();
        movimentacao.setData(Calendar.getInstance());
        movimentacao.setDescricao("Conta de Luz");
        movimentacao.setTipoMovimentacao(TipoMovimentacao.SAIDA);
        movimentacao.setValor(new BigDecimal("123.9"));
        movimentacao.setConta(conta);

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        manager.persist(conta);
        manager.persist(movimentacao);

        manager.getTransaction().commit();

        manager.close();
    }
    
}
