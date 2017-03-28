package controlers;

import core.QuestionSet;
import core.Stat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
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
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
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
		position++;
		studentStat.newQuestion(0==Integer.parseInt(questionSet.getAnsElement(position-1)), questionSet.getTheme().get(position-1));
	}
	public void clickB(){
		position++;
		studentStat.newQuestion(1==Integer.parseInt(questionSet.getAnsElement(position-1)), questionSet.getTheme().get(position-1));
	}
	public void clickC(){
		position++;
		studentStat.newQuestion(2==(Integer.parseInt(questionSet.getAnsElement(position-1))-1), questionSet.getTheme().get(position-1));
	}
	public void clickD(){
		position++;
		studentStat.newQuestion(3==Integer.parseInt(questionSet.getAnsElement(position-1)), questionSet.getTheme().get(position-1));
	}
}
