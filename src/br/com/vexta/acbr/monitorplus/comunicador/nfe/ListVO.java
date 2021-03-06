/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.vexta.acbr.monitorplus.comunicador.nfe;

import br.com.vexta.acbr.monitorplus.comunicador.utils.TextUtils;
import java.util.ArrayList;

/**
 *
 * @author DANIEL
 * @param <T>
 */
public class ListVO<T> extends ArrayList<T> {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
    public boolean add(T e) {
        ((MembroList) e).setInd(TextUtils.lpadZero(3, this.size() + 1));
        return super.add(e);
    }

    @Deprecated
    @Override
    public void add(int index, T element) {
        super.add(index, element); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (T item : this) {
            sb.append("\n").append(item.toString());
        }
        String retorno = sb.toString();
        return retorno;
    }

}
