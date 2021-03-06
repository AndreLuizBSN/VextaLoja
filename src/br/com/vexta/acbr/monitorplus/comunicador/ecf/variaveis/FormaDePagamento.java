/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vexta.acbr.monitorplus.comunicador.ecf.variaveis;

import java.math.BigDecimal;

/**
 *
 * @author Edson
 */
public class FormaDePagamento {

    private String codigo;
    private String descricao;
    boolean imprimeVinculado;
    private BigDecimal total;

    public String getCodigo() {
        return codigo;
    }

    protected void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    protected void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isImprimeVinculado() {
        return imprimeVinculado;
    }

    protected void setImprimeVinculado(boolean imprimeVinculado) {
        this.imprimeVinculado = imprimeVinculado;
    }

    public BigDecimal getTotal() {
        if (total == null) {
            throw new NullPointerException("Total NULL verifique se já foi rodado o comando: ecf..getVariaveis().getFormasDePagamento().lerTotaisFormaPagamento()");
        }
        return total;
    }

    protected void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return String.format("%02d", codigo) + (imprimeVinculado ? "V" : "") + " " + descricao + (total == null ? "" : " T" + total);
    }

}
