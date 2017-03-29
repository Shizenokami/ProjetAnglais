package controlers;

import java.io.IOException;
import javafx.scene.control.Button;
import core.QuestionSet;
import core.QuestionsLoad;
import core.Stat;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class QCMChoiceControler {
	
	private boolean start=false;
	private String choice;
	private Stat userstat=StartControler.userstat;
    private QuestionsLoad db=new QuestionsLoad();
	@FXML BorderPane Main_Pane;
	@FXML ListView<String> choiceList;
	@FXML Button Button_Start;
	
	public void clicStart() {
		if (start) {
			loadQCM();
		}
	}
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
		choiceList.setItems((ObservableList<String>) userstat.getQCMList());
	}
	
	
	public void clicList() {
		choice = choiceList.getSelectionModel().getSelectedItem();
		start = true;
		Button_Start.getStyleClass().add("rich-blue");
	}
	public QuestionSet getQuestion(){
		if (choice.equals("BIG TEST"))
			return db.getRandomNumberQuestions(50,1);
		for (int temp=2;temp<userstat.getQCMList().size()+1;temp++)
			if (choice.equals(userstat.getTheme(temp)))
				return db.getOneCategoryQuestions(temp,1);
		return null;
			
	}
	public void loadQCM() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/QCMQuestion.fxml"));
            AnchorPane StudentWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentWindow);
            QCMControler v = loader.getController();
            userstat.resetLocal();
            v.setParam(getQuestion(),userstat);
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
