package controlers;

import java.io.IOException;

import core.QuestionsLoad;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class GamesControler {
	
	
	@FXML BorderPane Main_Pane;
	@FXML Button Button_Memory;
	@FXML Button Button_Game1;
	@FXML Button Button_Game2;
	@FXML Button Button_Game3;
	@FXML Button Button_Game4;
	@FXML Button Button_Game5;
	@FXML Button Button_Game6;

	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}
	
	public void clicMemory() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(StudentUserControler.class.getResource("../views/MemoryWindow.fxml"));
            AnchorPane memoryGameWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(memoryGameWindow);
            MemoryControler v = loader.getController();
            v.initialise();
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
		
	}
	
	public void clicGame1() {
		
	}
	
	public void clicGame2() {
		
	}
	
	public void clicGame3() {
		
	}
	
	public void clicGame4() {
		
	}
	
	public void clicGame5() {
		
	}
	
	public void clicGame6() {
		
	}


	

}
