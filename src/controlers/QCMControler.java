package controlers;

import java.io.IOException;

import core.QuestionSet;
import core.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class QCMControler {

	
	private QuestionSet questionSet;
	private Stat studentStat;
	private int position=0;
	@FXML BorderPane Main_Pane;
	@FXML Text question;
	@FXML Text answerA;
	@FXML Text answerB;
	@FXML Text answerC;
	@FXML Text answerD;
	@FXML Text correctAnswer;
	@FXML Button Button_A;
	@FXML Button Button_B;
	@FXML Button Button_C;
	@FXML Button Button_D;
	
	
	
	public QCMControler(){
	}
	public void update(){
		if ((position)>=questionSet.getElement().size()){
			loadScore();
			return;
		}
		question.setText(questionSet.getTaskElement(position));
		answerA.setText(questionSet.getVarElement(0,position));
		answerB.setText(questionSet.getVarElement(1,position));
		answerC.setText(questionSet.getVarElement(2,position));
		answerD.setText(questionSet.getVarElement(3,position));
	}
	
	
	
	public void setmainpane(BorderPane b){
		
		this.Main_Pane=b;
		update();
	}
	
	public void setParam(QuestionSet questionSet,Stat studentStat){
		this.questionSet=questionSet;
		this.studentStat=studentStat;
	}
	
	public String getQuestion(){
		return questionSet.getTaskElement(position);
	}
	public String getVarA(){
		return questionSet.getVarElement(0,position);
	}
	public String getVarB(){
		return questionSet.getVarElement(1,position);
	}
	public String getVarC(){
		return questionSet.getVarElement(2,position);
	}
	public String getVarD(){
		return questionSet.getVarElement(3,position);
	}
	public String getAns(){
		return questionSet.getVarElement(Integer.parseInt((questionSet.getAnsElement(position)))-1,position);
	}
	public String getExplanation(){
		return questionSet.getExpElement(position);
	}
	
	public void clickA(){
		studentStat.newQuestion(0==(Integer.parseInt(questionSet.getAnsElement(position))-1), questionSet.getTheme().get(position));
		position++;
		update();
	}
	public void clickB(){
		studentStat.newQuestion(1==(Integer.parseInt(questionSet.getAnsElement(position))-1), questionSet.getTheme().get(position));
		position++;
		update();
	}
	public void clickC(){
		studentStat.newQuestion(2==(Integer.parseInt(questionSet.getAnsElement(position))-1), questionSet.getTheme().get(position));
		position++;
		update();
	}
	public void clickD(){
		studentStat.newQuestion((3==Integer.parseInt(questionSet.getAnsElement(position))-1), questionSet.getTheme().get(position));
		position++;
		update();
	}
	public void loadScore() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/ScoreWindow.fxml"));
            AnchorPane StudentWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentWindow);
            ScoreControler v = loader.getController();
            v.setStat(studentStat.getLocalAns(),studentStat.getLocalQuest());
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
}
