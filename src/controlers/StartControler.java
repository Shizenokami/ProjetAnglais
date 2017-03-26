package controlers;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class StartControler {
	
	@FXML BorderPane Main_Pane;
	@FXML TextField UsernameSI;
	@FXML TextField UsernameSU;
	@FXML TextField PassWordSI;
	@FXML TextField PassWordSU;
	@FXML TextField EmailAddr;
	@FXML TextField ConfirmPassSU;
	@FXML Button Button_SignIn;
	@FXML Button Button_SignUp;
	
	public StartControler() {
		
	}
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}

}
