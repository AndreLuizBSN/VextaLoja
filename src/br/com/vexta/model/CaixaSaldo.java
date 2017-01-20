package br.com.vexta.model;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
@Table(name = "CAIXA_SALDO")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CaixaSaldo.findAll", query = "SELECT c FROM CaixaSaldo c")
    , @NamedQuery(name = "CaixaSaldo.findById", query = "SELECT c FROM CaixaSaldo c WHERE c.id = :id")
    , @NamedQuery(name = "CaixaSaldo.findByDataInicial", query = "SELECT c FROM CaixaSaldo c WHERE c.dataInicial = :dataInicial")
    , @NamedQuery(name = "CaixaSaldo.findByDataFinal", query = "SELECT c FROM CaixaSaldo c WHERE c.dataFinal = :dataFinal")
    , @NamedQuery(name = "CaixaSaldo.findByValorInicial", query = "SELECT c FROM CaixaSaldo c WHERE c.valorInicial = :valorInicial")
    , @NamedQuery(name = "CaixaSaldo.findByValorFinal", query = "SELECT c FROM CaixaSaldo c WHERE c.valorFinal = :valorFinal")})
public class CaixaSaldo implements Serializable {

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

    public CaixaSaldo() {
    }

    public CaixaSaldo(Integer id) {
        this.id = id;
    }

    public CaixaSaldo(Integer id, Date dataInicial, BigDecimal valorInicial) {
        this.id = id;
        this.dataInicial = dataInicial;
        this.valorInicial = valorInicial;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CaixaSaldo)) {
            return false;
        }
        CaixaSaldo other = (CaixaSaldo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "demo.CaixaSaldo[ id=" + id + " ]";
    }

}
