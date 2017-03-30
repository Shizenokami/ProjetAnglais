package controlers;

import java.io.IOException;

import core.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class ScoreControler {

	@FXML BorderPane Main_Pane;
	@FXML Text score;
	
	public ScoreControler(){
	}
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}

	public void setStat(int correctAnswer,int totalquestion){
		score.setText("Score :"+correctAnswer+"/"+totalquestion);
	}
	public void clickValidate(){
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/StudentWindow.fxml"));
            AnchorPane StudentWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentWindow);
            StudentUserControler v = loader.getController();
            v.setStat(StartControler.userstat);
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
