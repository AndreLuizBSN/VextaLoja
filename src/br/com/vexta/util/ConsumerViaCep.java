package br.com.vexta.util;

import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;

public class ConsumerViaCep extends Consumer {
	public ConsumerViaCep(String urlStr) {
		super(String.format("http://viacep.com.br/ws/%s/json", urlStr));
	}
	
	public Map<String, String> getDatasCep(){
		
		Map<String, String> map = new HashMap<String, String>();
		JSONObject json = super.getDatas();
		
		


		map.put("cep", 			json.get("cep").toString());
		map.put("logradouro", 	json.get("logradouro").toString());
		map.put("complemento", 	json.get("complemento").toString());
		map.put("bairro", 		json.get("bairro").toString());
		map.put("localidade", 	json.get("localidade").toString());
		map.put("uf", 			json.get("uf").toString());
		map.put("unidade", 		json.get("unidade").toString());
		map.put("ibge", 		json.get("ibge").toString());
		map.put("gia", 			json.get("gia").toString());
		
		
		return map;
	}

}
