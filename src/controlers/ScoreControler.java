package controlers;

import core.Stat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	public void clickValidate(){}

}
