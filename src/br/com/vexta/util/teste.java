package br.com.vexta.util;

import java.util.Map;

public class teste {

	public static void main(String[] args) {
		

    	String xmlNfe = "XMotivoConsulta{ChNFe=42170100748697000264550010000098531000173843, NProt=342170004026984, DigVal=MUa5ZZKMkoxUNOeoqX87F07eYv0= - XMotivo{Versao=SVRS201601160949, TpAmb=1, VerAplic=SVRS201601160949, CStat=100, XMotivo=Autorizado o uso da NF-e, CUF=42, DhRecbto=12/01/2017 08:52:54}";
		ConvertNfeToMap m = new ConvertNfeToMap(xmlNfe);
		Map<String, String> map = m.getDados();

	}

}
