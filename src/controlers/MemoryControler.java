package controlers;

import core.Memory;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class MemoryControler {
	
	private Memory game;
	private boolean ended=false;
	private int selected;
	private Button[] liste;
	private int[] selectedCards = { -1 , -1 };
	private int count;
	
	@FXML BorderPane Main_Pane;
	@FXML Button Button_Card_1;
	@FXML Button Button_Card_2;
	@FXML Button Button_Card_3;
	@FXML Button Button_Card_4;
	@FXML Button Button_Card_5;
	@FXML Button Button_Card_6;
	@FXML Button Button_Card_7;
	@FXML Button Button_Card_8;
	@FXML Button Button_Card_9;
	@FXML Button Button_Card_10;
	@FXML Button Button_Card_11;
	@FXML Button Button_Card_12;
	@FXML Button Button_Card_13;
	@FXML Button Button_Card_14;
	@FXML Button Button_Card_15;
	@FXML Button Button_Card_16;
	@FXML Button Button_End;
	
	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}
	
	public void initialise() {
		liste = new Button[16];
		liste[0] = Button_Card_1;
		liste[1] = Button_Card_2;
		liste[2] = Button_Card_3;
		liste[3] = Button_Card_4;
		liste[4] = Button_Card_5;
		liste[5] = Button_Card_6;
		liste[6] = Button_Card_7;
		liste[7] = Button_Card_8;
		liste[8] = Button_Card_9;
		liste[9] = Button_Card_10;
		liste[10] = Button_Card_11;
		liste[11] = Button_Card_12;
		liste[12] = Button_Card_13;
		liste[13] = Button_Card_14;
		liste[14] = Button_Card_15;
		liste[15] = Button_Card_16;
		
		game = new Memory();
		selected = 0;
		count=0;
	}
	
	public void clicButton_Card_1() {
		bla(0);
	}
	
	public void clicButton_Card_2() {
		bla(1);		
	}
	
	public void clicButton_Card_3() {
		bla(2);	
	}
	
	public void clicButton_Card_4() {
		
	}
	
	public void clicButton_Card_5() {
		
	}
	
	public void clicButton_Card_6() {
		
	}
	
	public void clicButton_Card_7() {
		
	}
	
	public void clicButton_Card_8() {
		
	}
	
	public void clicButton_Card_9() {
		
	}
	
	public void clicButton_Card_10() {
		
	}
	
	public void clicButton_Card_11() {
		
	}
	
	public void clicButton_Card_12() {
		
	}
	
	public void clicButton_Card_13() {
		
	}
	
	public void clicButton_Card_14() {
		
	}
	
	public void clicButton_Card_15() {
		
	}
	
	public void clicButton_Card_16() {
		
	}
	
	public void select(int i) {
		if (i<selectedCards[0]) {
			selectedCards[1]= selectedCards[0];
			selectedCards[0]=i;
		} else {
			selectedCards[1] = i;
		}
	}
	
	public void bla(int i) {
		if (selectedCards[0]!=i && selectedCards[1]!=i) {
			liste[i].getStyleClass().add("rich-blue");
			liste[i].getStyleClass().remove("grey");
			//liste[0].setText(game.text(getCard(0)));
			liste[i].setText("bla");
			select(i);
			if (selected==1) {
				System.out.println("?");
				if (game.find()) {
					liste[selectedCards[0]].getStyleClass().add("answer");
					liste[selectedCards[0]].getStyleClass().remove("rich-blue");
					liste[selectedCards[1]].getStyleClass().add("answer");
					liste[selectedCards[1]].getStyleClass().remove("rich-blue");
					selectedCards[0] = -1;
					selectedCards[1] = -1;
					count++;
				}
				selected = 0;
				
			} 
			if (selected == 0) {
				selected+=1;
				System.out.println("1");
				if (selectedCards[0]!=-1) {
					System.out.println("2");
					liste[selectedCards[0]].getStyleClass().add("grey");
					liste[selectedCards[0]].getStyleClass().remove("rich-blue");
					liste[selectedCards[1]].getStyleClass().add("grey");
					liste[selectedCards[1]].getStyleClass().remove("rich-blue");
				}
			}
		} else {
			liste[i].getStyleClass().remove("rich-blue");
			liste[i].getStyleClass().add("grey");
			
		}
	}

}
