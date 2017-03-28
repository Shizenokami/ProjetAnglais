package controlers;

import java.io.IOException;

import org.w3c.dom.Element;

import core.AuthentificationUser;
import core.QuestionsLoad;
import core.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class StudentUserControler {
	

	private Stat userstat;
	private AuthentificationUser auth;
	
	
	@FXML BorderPane Main_Pane;
	@FXML TextField TeacherCode;
	@FXML Button Button_Submit;
	@FXML Button Button_Stats;
	@FXML Button Button_Eval;
	@FXML Text ErrorText;
	
	public StudentUserControler(){
	}

	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}
	public void setStat(Element user){
		userstat=new Stat(user);
		
	}
	
	public void clicEval() {
		loadQCM();
	}
	
	public void clicSubmit() {
		
	}
	
	public void clicStats() {
		
	}
	
	public void loadStat(){
		
	}
	
	public void loadQCM() {
		try {
            QuestionsLoad db=new QuestionsLoad();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/QCMQuestion.fxml"));
            AnchorPane StudentWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentWindow);
            QCMControler v = loader.getController();
            v.setParam(db.getRandomNumberQuestions(20,1),userstat);
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
