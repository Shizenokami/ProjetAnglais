package controlers;

import org.w3c.dom.Element;
import core.AuthentificationUser;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class StartControler {
	
	private AuthentificationUser userlist;
	private AbstractUserControler user;
	
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
	
	public void clickSignIn() {
		//if (UsernameSI.getText()==null || PassWordSI.getText()==null) {
			ErrorText.setText("Please enter your username and password to login.");
		/*} else {
			Element userelement;
			if ( (userelement = userlist.signIn(UsernameSI.getText(), PassWordSI.getText())) == null) {
				ErrorText.setText("Your account or your identifiers do not exist.\nPlease Sign-up or check if your username and password are correct.");
			} else {
				userelement = userlist.signIn(UsernameSI.getText(), PassWordSI.getText());
			}
			
		}*/
	}
	
	public void clickSignUp() {
		/*if (UsernameSU.getText().equals(null) || PassWordSU.getText().equals(null) || EmailAddr.getText().equals(null) || ConfirmPassSU.getText().equals(null)) {
			ErrorText.setText("Please fullfill the text areas to sign-up."); */
		//} else if (!PassWordSU.getText().equals(ConfirmPassSU.getText())) {
			ErrorText.setText("Incorrect password repetition.");
		/*} else {
			if (userlist.signUp(UsernameSU.getText(), EmailAddr.getText(), PassWordSU.getText())) {
				ErrorText.setText("You signed-up well, now please sign-in.");
			}
		}*/
	}

}
