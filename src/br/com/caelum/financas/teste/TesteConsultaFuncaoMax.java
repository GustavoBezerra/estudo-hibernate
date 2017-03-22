/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.util.JPAUtil;
import java.math.BigDecimal;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

/**
 *
 * @author Gustavo
 */
public class TesteConsultaFuncaoMax {
    
    public static void main(String[] args) {
        EntityManager manager = new JPAUtil().getEntityManager();
        
        Conta conta = manager.find(Conta.class, 2);
        
        TypedQuery<BigDecimal> query = manager.createQuery("select max(m.valor) from Movimentacao m where m.conta = :pConta", BigDecimal.class);
        query.setParameter("pConta", conta);
        
        BigDecimal resultado = query.getSingleResult();
        System.out.println("Maior valor: "+resultado);
    }
    
}
