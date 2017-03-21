package br.com.caelum.financas.teste;

import br.com.caelum.financas.modelo.Conta;
import javax.persistence.EntityManager;

import br.com.caelum.financas.util.JPAUtil;

public class TesteEstadosJPA {

    public static void main(String[] args) {

        EntityManager manager = new JPAUtil().getEntityManager();

        manager.getTransaction().begin();

        Conta conta = manager.find(Conta.class, 7);
        conta.setTitular("Gustavo Bezerra");
        // Testes do capitulo
        manager.getTransaction().commit();

        manager.close();

    }
}
