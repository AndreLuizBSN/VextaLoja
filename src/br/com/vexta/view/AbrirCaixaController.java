package br.com.vexta.view;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.vexta.MainApp;
import br.com.vexta.model.Caixa;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class AbrirCaixaController {

    @FXML
    private Label SaldoAnteriorLabel;
    @FXML
    private TextField SaldoHojeTextField;

    private BigDecimal ultimaValor;
    private int ultimoId;

    private boolean okClicked = false;
    private Stage dialogStage;
    private MainApp mainApp;

    /*
     * Contrutor*/
    public AbrirCaixaController(){

    }

    public void buscaDadosBanco(){
    	/*Busca os dados do banco de do ultimo lançamento fechado*/
    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplicationFirebirdPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT r FROM Caixa r WHERE r.fechado = 1", Caixa.class);

		BigDecimal valorFinal = null;
		List<Caixa> caixaList = query.getResultList();
		for (Caixa p : caixaList) {
			valorFinal = p.getValorFinal();
			ultimoId = p.getId();
		}

		this.ultimaValor = valorFinal;
	
		em.getTransaction().commit();

    }

	/**
     * Initializes the controller class. This method is automatically called
     * after the fxml file has been loaded.
     */
    @FXML
    private void initialize() {
    	this.buscaDadosBanco();
    	if(this.ultimaValor == null){
    		this.ultimaValor = BigDecimal.ZERO;
    		this.ultimoId = 1;
    	}else{
    		this.ultimoId = this.ultimoId + 1;
    	}

    	this.SaldoAnteriorLabel.setText(this.ultimaValor.toString());
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
    public boolean isOkClicked() {
        return okClicked;
    }

    private boolean AbrirCaixaBanco(String val){

    	try{
	    	EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplicationFirebirdPU");
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();

	    	Double d = Double.parseDouble(val);

	    	Caixa caixa = new Caixa();

	    	caixa.setId(this.ultimoId);
	    	caixa.setDataInicial(Calendar.getInstance().getTime());
	    	caixa.setDataFinal(null);
	    	caixa.setValorInicial(BigDecimal.valueOf(d));
	    	caixa.setValorFinal(null);
	    	caixa.setFechado(0);
	    	em.persist(caixa);

			em.getTransaction().commit();
			return true;
    	}catch(Exception e){
    		return false;
    	}


    }

    /**
     * Called when the user clicks ok.
     */
    @FXML
    private void handleAbrirCaixa() {
        if (isInputValid()) {

        	if(AbrirCaixaBanco(SaldoHojeTextField.getText())){
        		okClicked = true;
            	try {
                    // Carrega o layout de caixa pronto para ser aberto
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(MainApp.class.getResource("view/PrincipalCaixaFechado.fxml"));
                    AnchorPane personOverview = (AnchorPane) loader.load();

                    // Seta a tela como cenda no centro do rootlayout.
                    mainApp.setRootLayoutCenter(personOverview);


                    // Fornece o controller novo para o main app
                    //PrincipalCaixaAbertoController controller = loader.getController();
                    //controller.setMainApp(this.mainApp);

                } catch (IOException e) {
                    e.printStackTrace();
                }

        	}

        }

    }

    /**
     * Validates the user input in the text fields.
     *
     * @return true if the input is valid
     */
    private boolean isInputValid() {
        String errorMessage = "";

        if (SaldoHojeTextField.getText() == null || SaldoHojeTextField.getText().length() == 0) {
            errorMessage += "Saldo não é válido!\n";
        } else {
            // try to parse the postal code into an int.
            try {
                Double.parseDouble(SaldoHojeTextField.getText());
            } catch (NumberFormatException e) {
                errorMessage += "Saldo precisa ser um número(Separado por .)!\n";
            }
        }

        if (errorMessage.length() == 0) {
            return true;
        } else {
            // Show the error message.
            Alert alert = new Alert(AlertType.ERROR);
            alert.initOwner(dialogStage);
            alert.setTitle("Erro de validação");
            alert.setHeaderText("Por favor, verifique os campos");
            alert.setContentText(errorMessage);

            alert.showAndWait();

            return false;
        }
    }
}
