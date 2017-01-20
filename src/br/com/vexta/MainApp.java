package br.com.vexta;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import br.com.vexta.model.Caixa;
import br.com.vexta.view.PrincipalCaixaAbertoController;
import br.com.vexta.view.PrincipalCaixaFechadoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/*
 * Classe principal da aplicação
 */
public class MainApp extends Application {

	//Declaração variaveis globais
	private Stage primaryStage;
    private BorderPane rootLayout;

    /**
     * Metodo para aplicar ao centro do rootLayout a cena desejada
     */
    public void setRootLayoutCenter(AnchorPane pane) {
    	this.rootLayout.setCenter(pane);
    }

    /**
     * Metodo obrigatório
     * Seta alguns dados como titulação e icone para a aplicação principal
     * e carrega as primeiras telas
     */
    @Override
    public void start(Stage primaryStage) {
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Vexta Store");
        //this.primaryStage.setFullScreen(true);

        // Set the application icon.
        this.primaryStage.getIcons().add(new Image("file:resources/images/icon.png"));

        //Inicializa a tela principal(palco)
        initRootLayout();

        //Aqui pode ser feito as validações de sessão para ver qual tela chamar
        //Por padão chamarei a tela de caixa fechado, aguardando abertura
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("JavaApplicationFirebirdPU");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();

		Query query = em.createQuery("SELECT r FROM Caixa r WHERE r.fechado = 0", Caixa.class);

		Date ultimaData = null;
		List<Caixa> caixaList = query.getResultList();
		for (Caixa p : caixaList) {
			ultimaData = p.getDataInicial();
		}
		em.getTransaction().commit();
		
		if(ultimaData != null) {
			showCaixa();
		}else {
			showAbrirCaixa();
		}
    }

    /**
     * Inicializa o root layout
     */
    public void initRootLayout() {
        try {
            // Carrega o root layout do arquivo fxml.
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class
                    .getResource("view/RootLayout.fxml"));
            rootLayout = (BorderPane) loader.load();

            // Mostra a scene (cena) contendo o root layout.
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);


            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo de abertura de caixa
     */
    public void showAbrirCaixa() {
        try {
            // Carrega o layout de caixa pronto para ser aberto
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PrincipalCaixaAberto.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Seta a tela como cenda no centro do rootlayout.
            rootLayout.setCenter(personOverview);


            // Fornece o controller novo para o main app
            PrincipalCaixaAbertoController controller = loader.getController();
            controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Metodo de abertura de caixa
     */
    public void showCaixa() {
        try {
            // Carrega o layout de caixa pronto para ser aberto
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("view/PrincipalCaixaFechado.fxml"));
            AnchorPane personOverview = (AnchorPane) loader.load();

            // Seta a tela como cenda no centro do rootlayout.
            rootLayout.setCenter(personOverview);


            // Fornece o controller novo para o main app
            PrincipalCaixaFechadoController controller = loader.getController();
            //controller.setMainApp(this);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    /**
     * Retorna o estagio principal
     * @return
     */
    public Stage getPrimaryStage() {
        return primaryStage;
    }

    /**
     * Metodo principal para execução do projeto
     */
    public static void main(String[] args) {
		launch(args);
	}
}
