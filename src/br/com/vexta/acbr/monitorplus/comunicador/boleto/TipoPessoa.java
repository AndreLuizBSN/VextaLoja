/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vexta.acbr.monitorplus.comunicador.boleto;

/**
 *
 * @author Edson
 */
public enum TipoPessoa {

    PessoaFisica(0),
    PessoaJuridica(1),
    Outros(2);

    private final int codigo;

    TipoPessoa(int cod) {
        this.codigo = cod;
    }

    @Override
    public String toString() {
        return String.valueOf(codigo);
    }

}
