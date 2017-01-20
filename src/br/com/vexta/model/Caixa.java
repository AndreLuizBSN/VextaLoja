/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vexta.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author prince
 */
@Entity
@Table(name = "CAIXA")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Caixa.findAll", query = "SELECT c FROM Caixa c")
    , @NamedQuery(name = "Caixa.findById", query = "SELECT c FROM Caixa c WHERE c.id = :id")
    , @NamedQuery(name = "Caixa.findByDataInicial", query = "SELECT c FROM Caixa c WHERE c.dataInicial = :dataInicial")
    , @NamedQuery(name = "Caixa.findByDataFinal", query = "SELECT c FROM Caixa c WHERE c.dataFinal = :dataFinal")
    , @NamedQuery(name = "Caixa.findByValorInicial", query = "SELECT c FROM Caixa c WHERE c.valorInicial = :valorInicial")
    , @NamedQuery(name = "Caixa.findByValorFinal", query = "SELECT c FROM Caixa c WHERE c.valorFinal = :valorFinal")
    , @NamedQuery(name = "Caixa.findByFechado", query = "SELECT c FROM Caixa c WHERE c.fechado = :fechado")})
public class Caixa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "DATA_INICIAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataInicial;
    @Column(name = "DATA_FINAL")
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFinal;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @Column(name = "VALOR_INICIAL")
    private BigDecimal valorInicial;
    @Column(name = "VALOR_FINAL")
    private BigDecimal valorFinal;
    @Basic(optional = false)
    @Column(name = "FECHADO")
    private int fechado;

    public Caixa() {
    }

    public Caixa(Integer id) {
        this.id = id;
    }

    public Caixa(Integer id, Date dataInicial, BigDecimal valorInicial, int fechado) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.valorInicial = valorInicial;
        this.fechado = fechado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(Date dataInicial) {
        this.dataInicial = dataInicial;
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }

    public BigDecimal getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(BigDecimal valorInicial) {
        this.valorInicial = valorInicial;
    }

    public BigDecimal getValorFinal() {
        return valorFinal;
    }

    public void setValorFinal(BigDecimal valorFinal) {
        this.valorFinal = valorFinal;
    }

    public int getFechado() {
        return fechado;
    }

    public void setFechado(int fechado) {
        this.fechado = fechado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Caixa)) {
            return false;
        }
        Caixa other = (Caixa) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.vexta.model.Caixa[ id=" + id + " ]";
    }

}
