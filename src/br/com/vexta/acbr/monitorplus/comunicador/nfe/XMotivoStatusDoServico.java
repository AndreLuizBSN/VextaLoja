/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vexta.acbr.monitorplus.comunicador.nfe;

/**
 *
 * @author Edson Moretti - www.vexta.com.br
 */
public class XMotivoStatusDoServico extends XMotivo {

    private String TMed;

    public XMotivoStatusDoServico(String re) {
        super(re);
    }

    public XMotivoStatusDoServico(XMotivo re) {
        super(re);
    }

    public String getTMed() {
        return TMed;
    }

    public void setTMed(String TMed) {
        this.TMed = TMed;
    }

    @Override
    public String toString() {
        return "XMotivoStatusDoServico{" + "TMed=" + TMed + " - " + super.toString();
    }

}
