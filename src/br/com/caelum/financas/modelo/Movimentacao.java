package br.com.caelum.financas.modelo;

import java.math.BigDecimal;
import java.util.Calendar;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Gustavo
 */
@NamedQueries({
    @NamedQuery(name = "mediaDaContaPeloTipoMovimentacao",
            query = "select avg(m.valor) from Movimentacao m where m.conta=:pConta  and m.tipoMovimentacao = :pTipo"),
    @NamedQuery(name = "totalDeMovimentacoes",
            query = "select count(m) from Movimentacao m where m.conta = :pConta")
})

@Entity
public class Movimentacao {

    @Id
    @GeneratedValue
    private int id;

    private BigDecimal valor;

    @Enumerated(EnumType.STRING)
    private TipoMovimentacao tipoMovimentacao;

    @Temporal(TemporalType.DATE)
    private Calendar data;

    private String descricao;

    @ManyToOne
    private Conta conta;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the valor
     */
    public BigDecimal getValor() {
        return valor;
    }

    /**
     * @param valor the valor to set
     */
    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    /**
     * @return the tipoMovimentacao
     */
    public TipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    /**
     * @param tipoMovimentacao the tipoMovimentacao to set
     */
    public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    /**
     * @return the data
     */
    public Calendar getData() {
        return data;
    }

    /**
     * @param data the data to set
     */
    public void setData(Calendar data) {
        this.data = data;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @return the conta
     */
    public Conta getConta() {
        return conta;
    }

    /**
     * @param conta the conta to set
     */
    public void setConta(Conta conta) {
        this.conta = conta;
    }
}
