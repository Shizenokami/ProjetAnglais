package controlers;

import java.io.IOException;


import controlers.StartControler;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class MainControler  {

		private @FXML BorderPane Main_Pane;
		private StudentUserControler v=null;
		public void goHome(){
			//System.out.println("test");
			 try {
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(StudentUserControler.class.getResource("../views/StudentWindow.fxml"));
		            AnchorPane StudentUserWindow = (AnchorPane) loader.load();
		            Main_Pane.setCenter(StudentUserWindow);
		            v = loader.getController();
		            v.setmainpane(Main_Pane);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		
		public void exit(){
			if (!StartControler.userstat.equals(null)){
				StartControler.userstat.Save(StartControler.userelement);
				StartControler.auth.saveinUsers();
			}
			Platform.exit();
		}
		
		public void disconnect() {
			//System.out.println("test");
			 try {
				 if (!StartControler.userstat.equals(null))
					 StartControler.userstat.Save(StartControler.userelement);
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(MainApp.class.getResource("../views/StartWindow.fxml"));
		            AnchorPane StartWindow = (AnchorPane) loader.load();
		            Main_Pane.setCenter(StartWindow);
		            StartControler v = loader.getController();
		            v.setmainpane(Main_Pane);
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		
		public void goAbout(){
			//System.out.println("test");
			 try {
		            FXMLLoader loader = new FXMLLoader();
		            loader.setLocation(MainApp.class.getResource("../views/AboutWindow.fxml"));
		            AnchorPane AboutWindow = (AnchorPane) loader.load();
		            Main_Pane.setCenter(AboutWindow);
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
		}
		
		public void sampleAction() {
			
		}

}
