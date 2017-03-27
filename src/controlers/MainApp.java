package controlers;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainApp extends Application {
	private Stage primaryStage;
	private BorderPane rootLayout;
	@Override
	public void start(Stage primaryStage) {
		this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Name of the Project");
        initialisation();
        showWindow();
    }
	
	public void initialisation() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/MainWindow.fxml"));
            rootLayout = (BorderPane) loader.load();
            Scene scene = new Scene(rootLayout);
            primaryStage.setScene(scene);
            primaryStage.show();
            primaryStage.setResizable(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	
	 public void showWindow() {
		 try {
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(MainApp.class.getResource("../views/StartWindow.fxml"));
		        AnchorPane StartWindow= (AnchorPane) loader.load();
		        rootLayout.setCenter(StartWindow);
		        StartControler st = loader.getController();
		        st.setmainpane(rootLayout);
		        
		    } catch (IOException e) {
		        e.printStackTrace();
		    }
	    }

	 public Stage getPrimaryStage(){
		 return primaryStage;
	 }
	 
	public static void main(String[] args) {
		launch(args);
	}
}
