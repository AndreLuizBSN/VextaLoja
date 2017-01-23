package br.com.vexta.view;

import java.util.Map;

import br.com.vexta.MainApp;
import br.com.vexta.util.ConsumerViaCep;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class ConsultaCepController {

    @FXML
    private Label cep;
    @FXML
    private Label logradouro;
    @FXML
    private Label complemento;
    @FXML
    private Label bairro;
    @FXML
    private Label localidade;
    @FXML
    private Label uf;
    @FXML
    private Label unidade;
    @FXML
    private Label ibge;
    @FXML
    private Label gia;
    
    @FXML
    private TextField tfCep;

    private Stage dialogStage;
    private MainApp mainApp;

    /*
     * Contrutor*/
    public ConsultaCepController(){

    }
	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    }

    /**
     * Is called by the main application to give a reference back to itself.
     *
     * @param mainApp
     */
    public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
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
    private void handleConsultarCep() {
    	if(isInputValid()) {
    		String UrlStr = "89160027";
    		Map<String, String> map = new ConsumerViaCep(UrlStr).getDatasCep();
    		this.logradouro.setText(map.get("logradouro"));
    		this.cep.setText(map.get("cep"));
    		this.complemento.setText(map.get("complemento"));
    		this.bairro.setText(map.get("bairro"));
    		this.localidade.setText(map.get("localidade"));
    		this.uf.setText(map.get("uf"));
    		this.unidade.setText(map.get("unidade"));
    		this.ibge.setText(map.get("ibge"));
    		this.gia.setText(map.get("gia"));
    	}
    	
    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (tfCep.getText() == null || tfCep.getText().length() != 8) {
            errorMessage += "Informe um CEP válido!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Integer.parseInt(tfCep.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Informe apenas números para o CEP!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Erro de validação");
            alert.setHeaderText("Por favor, verifique o campo");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
