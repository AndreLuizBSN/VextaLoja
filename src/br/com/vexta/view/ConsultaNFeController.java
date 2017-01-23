package br.com.vexta.view;

import java.util.Map;

import br.com.vexta.acbr.monitorplus.comunicador.ACBrNFe;
import br.com.vexta.acbr.monitorplus.comunicador.exceptions.ACBrNFeException;
import br.com.vexta.MainApp;
import br.com.vexta.util.ConvertNfeToMap;
import br.com.vexta.util.ConvertStatusNfeToMap;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class ConsultaNFeController {

	//Variaveis para certificado e status
    @FXML
    private Label certificado;
    @FXML
    private Label versao;
    @FXML
    private Label ambiente;
    @FXML
    private Label versaoAplicacao;
    @FXML
    private Label codigoStatus;
    @FXML
    private Label motivo;
    @FXML
    private Label codigoUf;
    @FXML
    private Label dtHrRecibo;
    
    //Variaveis para a nfe
    @FXML
    private Label chaveNfe;
    @FXML
    private Label protocoloNfe;
    @FXML
    private Label digValNfe;
    @FXML
    private Label versaoNfe;
    @FXML
    private Label ambNfe;
    @FXML
    private Label verAppNfe;
    @FXML
    private Label codStatusNfe;
    @FXML
    private Label motivoNfe;
    @FXML
    private Label codUfNfe;
    @FXML
    private Label dtHrReciboNfe;
    
    @FXML
    private TextField tfXmlUrl;

    private ACBrNFe n;

    /*
     * Contrutor*/
    public ConsultaNFeController(){

    }
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	this.n = new ACBrNFe();
    	//----------CONSULTANDO CERTIFICADO----------
        try {
        	this.certificado.setText(n.getCNPJDoCertificado());
        } catch (ACBrNFeException ex) {
        	this.certificado.setText("Erro ao carregar os dados de certificado!");
        }
        //----------CONSULTANDO STATUS----------
        try {
        	ConvertStatusNfeToMap m = new ConvertStatusNfeToMap(n.getStatusServico().toString());
        	Map<String, String> map = m.getDados();
        	this.versao.setText(map.get("Versao"));
        	this.ambiente.setText(map.get("TpAmb").equals("1") ? "1 - Produção" : "2 - Homologação");
        	this.versaoAplicacao.setText(map.get("VerAplic"));
        	this.codigoStatus.setText(map.get("CStat"));
        	this.motivo.setText(map.get("XMotivo"));
        	this.codigoUf.setText(map.get("CUF"));
        	this.dtHrRecibo.setText(map.get("DhRecbto"));
        } catch (ACBrNFeException ex) {
        	this.versao.setText("Erro ao carregar o status do serviço da NF-e");
        }
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
    }

    /**
     * Returns true if the user clicked OK, false otherwise.
     *
     * @return
     */

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleConsultarNfe() {
    	
        //----------CONSULTANDO NFE VIA CAMINHO STRING----------
        try {
        	System.out.println(this.tfXmlUrl.getText());
        	ConvertNfeToMap m = new ConvertNfeToMap(n.consultarNFe(this.tfXmlUrl.getText()).toString());
        	Map<String, String> map = m.getDados();
        	this.chaveNfe.setText(map.get("ChNFe"));
        	this.protocoloNfe.setText(map.get("NProt"));
        	this.digValNfe.setText(map.get("DigVal"));
        	this.versaoNfe.setText(map.get("Versao"));
        	this.ambNfe.setText(map.get("TpAmb").equals("1") ? "1 - Produção" : "2 - Homologação");
        	this.verAppNfe.setText(map.get("VerAplic"));
        	this.codStatusNfe.setText(map.get("CStat"));
        	this.motivoNfe.setText(map.get("XMotivo"));
        	this.codUfNfe.setText(map.get("CUF"));
        	this.dtHrReciboNfe.setText(map.get("DhRecbto"));
        	System.out.println(n.consultarNFe(this.tfXmlUrl.getText()).toString());
        } catch (ACBrNFeException ex) {
        	this.chaveNfe.setText("Erro ao consultar XML!");
        }
		
    }

    
}
