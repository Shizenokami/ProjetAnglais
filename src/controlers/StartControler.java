package controlers;

import java.io.IOException;

import org.w3c.dom.Element;
import core.AuthentificationUser;
import core.Stat;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class StartControler {
	
	
	private AuthentificationUser auth;
	private Element userelement;
	
	@FXML BorderPane Main_Pane;
	@FXML TextField UsernameSI;
	@FXML TextField UsernameSU;
	@FXML TextField PasswordSI;
	@FXML TextField PasswordSU;
	@FXML TextField EmailAddr;
	@FXML TextField ConfirmPassSU;
	@FXML Button Button_SignIn;
	@FXML Button Button_SignUp;
	@FXML Text ErrorText;
	
	public StartControler() {
		auth=new AuthentificationUser("asset/usrs.xml");
	}
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}
	
	public void clickSignIn() {
		if (UsernameSI.getText().equals(null) || PasswordSI.getText().equals(null)) {
			ErrorText.setText("Please enter your username and password to login.");
		} else {
			if ( (userelement = auth.signIn(UsernameSI.getText(), PasswordSI.getText())) == null) {
				ErrorText.setText("Your account or your identifiers do not exist.\nPlease Sign-up or check if your username and password are correct.");
			} else {
				loadStudent();
			}
			
		}
	}
	
	public void clickSignUp() {
		if (UsernameSU.getText().equals(null) || PasswordSU.getText().equals(null) || EmailAddr.getText().equals(null) || ConfirmPassSU.getText().equals(null)) {
			ErrorText.setText("Please fullfill the text areas to sign-up."); 
		} else if (!PasswordSU.getText().equals(ConfirmPassSU.getText())) {
			ErrorText.setText("Incorrect password repetition.");
		} else {
			if (auth.signUp(UsernameSU.getText(), EmailAddr.getText(), PasswordSU.getText())) {
				ErrorText.setText("You signed-up well, now please sign-in.");
			}
		}
	}
	
	
	public void loadStudent() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/StudentWindow.fxml"));
            AnchorPane StudentWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(StudentWindow);
            StudentUserControler v = loader.getController();
            v.setStat(userelement);
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}
	
	public void loadTeacher() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/TeacherWindow.fxml"));
            AnchorPane TeacherWindow = (AnchorPane) loader.load();
            Main_Pane.setCenter(TeacherWindow);
            StartControler v = loader.getController();
            v.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
	}

}
