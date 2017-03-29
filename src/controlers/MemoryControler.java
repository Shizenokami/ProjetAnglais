package controlers;

import java.io.IOException;
import java.util.ArrayList;

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
	private boolean selected;
	private Button[] liste;
	private int[] selectedCards = { -1 , -1 };
	private int count;
	private ArrayList<Integer> found;
	
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
		selected = false;
		count=0;
		found = new ArrayList<Integer>();
	}
	
	public void clicButton_End() {
		try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(MainApp.class.getResource("../views/GamesWindow.fxml"));
            AnchorPane gamesWindow = (AnchorPane) loader.load();
            GamesControler games = loader.getController();
            Main_Pane.setCenter(gamesWindow);
            games.setmainpane(Main_Pane);
            
        } catch (IOException e) {
            e.printStackTrace();
        }
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
		bla(3);
	}
	
	public void clicButton_Card_5() {
		bla(4);
	}
	
	public void clicButton_Card_6() {
		bla(5);
	}
	
	public void clicButton_Card_7() {
		bla(6);
	}
	
	public void clicButton_Card_8() {
		bla(7);
	}
	
	public void clicButton_Card_9() {
		bla(8);
	}
	
	public void clicButton_Card_10() {
		bla(9);
	}
	
	public void clicButton_Card_11() {
		bla(10);
	}
	
	public void clicButton_Card_12() {
		bla(11);
	}
	
	public void clicButton_Card_13() {
		bla(12);
	}
	
	public void clicButton_Card_14() {
		bla(13);
	}
	
	public void clicButton_Card_15() {
		bla(14);
	}
	
	public void clicButton_Card_16() {
		bla(15);
	}
	
	public void select(int i) {
		if (selectedCards[0]==-1 && selectedCards[1]==-1) {
			selectedCards[1]=i; 
		} else if (selectedCards[0]==-1 && i<selectedCards[1]) {
			selectedCards[0]=i;
		} else {
			selectedCards[0] = selectedCards[1];
			selectedCards[1]=i;
		}
		System.out.println(selectedCards[0]+" "+selectedCards[1]);
	}
	
	public void bla(int i) {
		if ((selectedCards[0]!=i && selectedCards[1]!=i) && !(found.contains(i))) {
			liste[i].getStyleClass().add("rich-blue");
			liste[i].getStyleClass().remove("grey");
			liste[i].setText(game.text(i));
			if (selected) {
				if ( game.find(i,selectedCards[1]) ) {
					System.out.println("find!");
					liste[i].getStyleClass().add("answer");
					liste[i].getStyleClass().remove("rich-blue");
					liste[selectedCards[1]].getStyleClass().add("answer");
					liste[selectedCards[1]].getStyleClass().remove("rich-blue");
					selectedCards[0] = -1;
					selectedCards[1] = -1;
					found.add(i);
					found.add(selectedCards[1]);
					count++;
					if (count==8) { Button_End.setVisible(true); }
				} else {
					select(i);
				}
				System.out.println("selected = 2 or 0");
				System.out.println("i="+i);
				selected=false;
			} else if (!selected) {
				selected=true;
				if (selectedCards[0]!=-1) {
					System.out.println("remove");
					liste[selectedCards[0]].getStyleClass().add("grey");
					liste[selectedCards[0]].getStyleClass().remove("rich-blue");
					liste[selectedCards[1]].getStyleClass().add("grey");
					liste[selectedCards[1]].getStyleClass().remove("rich-blue");
					liste[selectedCards[0]].setText("");
					liste[selectedCards[1]].setText("");
					selectedCards[0] = -1;
					selectedCards[1] = -1;
				}
				System.out.println("selected = 1");
				System.out.println("i="+i);
				select(i);
			}
		}/* else if (selectedCards[1]==i && !(found.contains(i))) {
			liste[i].getStyleClass().remove("rich-blue");
			liste[i].getStyleClass().add("grey");
			liste[i].setText("");
			selected=!selected;
			select(-1);
		} else if (selectedCards[0]==i && !(found.contains(i))) {
			liste[i].getStyleClass().remove("rich-blue");
			liste[i].getStyleClass().add("grey");
			liste[i].setText("");
			selected=!selected;
			selectedCards[0]=-1;
		}*/
	}

}
