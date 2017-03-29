package controlers;

import java.io.IOException;
import javafx.scene.control.Button;
import core.QuestionsLoad;
import core.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class QCMChoiceControler {
	
	private boolean start=false;
	private String choice;
	private Stat userstat;
	
	@FXML BorderPane Main_Pane;
	@FXML ListView<String> choiceList;
	@FXML Button Button_Start;
	
	
	
	public void clicStart() {
		if (start) {
			loadQCM();
		}
	}
	
	public void clicList() {
		String choice = choiceList.getSelectionModel().getSelectedItem();
		start = true;
		Button_Start.getStyleClass().add("rich-blue");
	}
	
	public void loadQCM() {
		try {
            QuestionsLoad db=new QuestionsLoad();
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/QCMQuestion.fxml"));
            AnchorPane StudentWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentWindow);
            QCMControler v = loader.getController();
            userstat.resetLocal();
            v.setParam(db.getRandomNumberQuestions(20,1),userstat);
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
