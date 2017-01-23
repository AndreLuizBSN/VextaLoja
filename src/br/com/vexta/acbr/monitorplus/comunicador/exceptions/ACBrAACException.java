/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vexta.acbr.monitorplus.comunicador.exceptions;

/**
 *
 * @author Edson Moretti - www.vexta.com.br
 */
public class ACBrAACException extends Exception {
	private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of <code>BalancaInativaException</code> without
     * detail message.
     */
    public ACBrAACException() {
    }

    /**
     * Constructs an instance of <code>BalancaInativaException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ACBrAACException(String msg) {
        super(msg);
    }
}
