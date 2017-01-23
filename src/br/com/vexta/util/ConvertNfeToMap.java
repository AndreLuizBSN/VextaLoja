package br.com.vexta.util;

import java.util.HashMap;
import java.util.Map;

public class ConvertNfeToMap {
	
	private String dado;
	public ConvertNfeToMap(String dado) {
		this.dado = dado;
	}
	
	public Map<String, String> getDados(){
		
		Map<String, String> map = new HashMap<String, String>();
		
		this.dado = this.dado.replace(this.dado.substring(0, this.dado.indexOf("{")+1), "");
		String cab = this.dado.substring(0, this.dado.indexOf("= - XMotivo{"));
		this.dado = this.dado.replace(this.dado.substring(0, this.dado.indexOf("{")+1), "");
		this.dado = this.dado.replace("}", "");
		this.dado = cab+", "+this.dado;
		
		String[] dados = this.dado.split(", ");
		for (String string : dados) {
			System.out.println(string.substring(0, string.indexOf("=")));
			System.out.println(string.substring(string.indexOf("=")+1, string.length()));
			map.put(string.substring(0, string.indexOf("=")), string.substring(string.indexOf("=")+1, string.length()));
		}
		return map;
	}
	
}
