package controlers;

import java.io.IOException;

import core.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class StudentUserControler {
	
	private StudentStatsControler stats;
	private Stat stat;
	
	@FXML BorderPane Main_Pane;
	@FXML TextField TeacherCode;
	@FXML Button Button_Submit;
	@FXML Button Button_Stats;
	@FXML Button Button_Eval;
	@FXML Text ErrorText;
	
	public void clicEval() {
		
	}
	
	public void clicSubmit() {
		
	}
	
	public void clicStats() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/StudentStatWindow.fxml"));
            AnchorPane StudentStatsWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentStatsWindow);
            StudentUserControler v = loader.getController();
            v.setmainpane(Main_Pane);
            //stats.setStatistics(stat);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}

}
