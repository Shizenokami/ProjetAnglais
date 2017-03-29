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

	private int choice=-1;
	private boolean validate=false;
	private QuestionSet questionSet;
	private Stat studentStat;
	private int position=0;
	@FXML BorderPane Main_Pane;
	@FXML Text question;
	@FXML Text answerA;
	@FXML Text answerB;
	@FXML Text answerC;
	@FXML Text answerD;
	@FXML Text explanation;
	@FXML Text answers;
	@FXML Text positionqcm;
	@FXML Button Button_A;
	@FXML Button Button_B;
	@FXML Button Button_C;
	@FXML Button Button_D;
	@FXML Button Button_Next;
	@FXML Button Button_Validate;
	
	
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
		answers.setText("");
		explanation.setText("");
		positionqcm.setText("Question : "+(position+1)+"/"+questionSet.getElement().size());
		choice=-1;
		validate=false;
		Button_Next.getStyleClass().remove("rich-blue");
	}
	
	
	
	public void setmainpane(BorderPane b){
		
		this.Main_Pane=b;
		update();
	}
	
	public void setParam(QuestionSet questionSet,Stat studentStat){
		this.questionSet=questionSet;
		this.studentStat=studentStat;
	}
	
	public String getAns(){
		return questionSet.getVarElement(Integer.parseInt((questionSet.getAnsElement(position)))-1,position);
	}
	public String getExplanation(){
		return questionSet.getExpElement(position);
	}
	public void printSolution(){//si reel exam pas de pint de solution
		String s="";
		if (choice==(Integer.parseInt(questionSet.getAnsElement(position))-1))
			s+="Correct, ";
		answers.setText(s+"answer : "+getAns());
		explanation.setText(getExplanation());
	}
	
	
	public void clickValidate(){
		if (choice==-1 || validate)
			return;
		Button_Next.getStyleClass().add("rich-blue");
		studentStat.newQuestion(choice==(Integer.parseInt(questionSet.getAnsElement(position))-1), questionSet.getTheme().get(position));
		printSolution();
		position++;
		validate=true;
		
	}
	
	public void clickNext(){
		if (validate)
			update();
	}
	
	public void clickA(){
		if (!validate) {
			choice =0;
			Button_A.getStyleClass().add("answer");
			Button_B.getStyleClass().remove("answer");
			Button_C.getStyleClass().remove("answer");
			Button_D.getStyleClass().remove("answer");
		}
	}
	public void clickB(){
		if (!validate) {
			choice =1;
			Button_A.getStyleClass().remove("answer");
			Button_B.getStyleClass().add("answer");
			Button_C.getStyleClass().remove("answer");
			Button_D.getStyleClass().remove("answer");
		}
	}
	public void clickC(){
		if (!validate) {
			choice =2;
			Button_A.getStyleClass().remove("answer");
			Button_B.getStyleClass().remove("answer");
			Button_C.getStyleClass().add("answer");
			Button_D.getStyleClass().remove("answer");
		}
	}
	public void clickD(){
		if (!validate) {
			choice =3;
			Button_A.getStyleClass().remove("answer");
			Button_B.getStyleClass().remove("answer");
			Button_C.getStyleClass().remove("answer");
			Button_D.getStyleClass().add("answer");
		}
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
