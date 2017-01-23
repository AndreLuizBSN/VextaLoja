package br.com.vexta.util;

import java.util.HashMap;
import java.util.Map;

public class ConvertStatusNfeToMap {
	
	private String dado;
	public ConvertStatusNfeToMap(String dado) {
		this.dado = dado;
	}
	
	public Map<String, String> getDados(){
		
		Map<String, String> map = new HashMap<String, String>();
		
		this.dado = this.dado.replace(this.dado.substring(0, this.dado.indexOf("{")+1), "");
		this.dado = this.dado.replace(this.dado.substring(0, this.dado.indexOf("{")+1), "");
		this.dado = this.dado.replace("}", "");
		String[] dados = this.dado.split(", ");
		for (String string : dados) {
			map.put(string.substring(0, string.indexOf("=")), string.substring(string.indexOf("=")+1, string.length()));
		}
		
		return map;
	}
	
}
