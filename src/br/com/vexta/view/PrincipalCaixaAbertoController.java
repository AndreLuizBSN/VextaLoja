package br.com.vexta.view;


import br.com.vexta.MainApp;
import br.com.vexta.util.HorasExec;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

public class PrincipalCaixaAbertoController {

	private boolean okClicked = false;
	private MainApp mainApp;

	@FXML
	public Label horas;


	/**
	 * Initializes the controller class. This method is automatically called
	 * after the fxml file has been loaded.
	 */
	@FXML
	private void initialize() {
		new HorasExec(this.horas);
	}

	/**
	 * Is called by the main application to give a reference back to itself.
	 *
	 * @param main
	 */
	public void setMainApp(MainApp mainApp) {
	    this.mainApp = mainApp;
	}
	/**
	 * Returns true if the user clicked OK, false otherwise.
	 *
	 * @return
	 */
	public boolean isOkClicked() {
	    return okClicked;
	}

	/**
	 * Called when the user clicks ok.
	 */
	@FXML
	private void handleAbrirCaixa() {

	    okClicked = true;
	    try {
	    	FXMLLoader loader = new FXMLLoader();
	        loader.setLocation(MainApp.class.getResource("view/AbriOCaixa.fxml"));
	        AnchorPane personOverview = (AnchorPane) loader.load();
	        mainApp.setRootLayoutCenter(personOverview);

            // Fornece o controller novo para o main app
	        AbrirCaixaController controller = loader.getController();
            controller.setMainApp(this.mainApp);

    	}catch(Exception e) {
    		e.printStackTrace();
    	}
	}
	
	@FXML
	private void keyPressedF2AbrirCaixa() {
		
		if(KeyCode.F2.isDigitKey()) {
			System.out.println("Clicked");
		}
	}
}
