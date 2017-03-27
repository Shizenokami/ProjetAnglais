package controlers;

import java.io.IOException;

import core.AuthentificationUser;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class StartControler {
	
	private AuthentificationUser userlist;
	
	@FXML BorderPane Main_Pane;
	@FXML TextField UsernameSI;
	@FXML TextField UsernameSU;
	@FXML TextField PassWordSI;
	@FXML TextField PassWordSU;
	@FXML TextField EmailAddr;
	@FXML TextField ConfirmPassSU;
	@FXML Button Button_SignIn;
	@FXML Button Button_SignUp;
	@FXML Text ErrorText;
	
	public StartControler() {
		
	}
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}
	
	public void signInClic() {
		if (UsernameSI.getText().equals(null) || PassWordSI.getText().equals(null)) {
			ErrorText.setText("Please enter your username and password to login.");
		} else {
			if ( userlist.signIn(UsernameSI.getText(), PassWordSI.getText()) == null) {
				ErrorText.setText("Your account or your identifiers do not exist.\nPlease Sign-up or check if your username and password are correct.");
			}
		}
	}
	
	public void SignUpClic() {
		if (UsernameSU.getText().equals(null) || PassWordSU.getText().equals(null) || EmailAddr.getText().equals(null) || ConfirmPassSU.getText().equals(null)) {
			ErrorText.setText("Please fullfill the text areas to sign-up.");
		} else if (!PassWordSU.getText().equals(ConfirmPassSU.getText())) {
			ErrorText.setText("Incorrect password repetition.");
		} else {
			userlist.signUp(UsernameSU.getText(), EmailAddr.getText(), PassWordSU.getText());
		}
	}

}
