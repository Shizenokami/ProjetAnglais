package controlers;

import core.Stat;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.layout.BorderPane;

public class StudentStatsControler {
	
	@FXML ProgressBar progressBar_1;
	@FXML ProgressBar progressBar_2;
	@FXML ProgressBar progressBar_3;
	@FXML ProgressBar progressBar_4;
	@FXML ProgressBar progressBar_5;
	@FXML ProgressBar progressBar_6;
	@FXML ProgressBar progressBar_7;
	@FXML ProgressBar progressBar_8;
	@FXML ProgressBar progressBar_9;
	@FXML ProgressBar progressBar_10;
	@FXML ProgressBar progressBar_11;
	@FXML ProgressBar progressBar_12;
	@FXML ProgressBar progressBar_13;
	@FXML ProgressBar progressBar_14;
	@FXML ProgressBar progressBar_15;
	@FXML ProgressBar progressBar_16;
	@FXML ProgressBar progressBar_17;
	@FXML ProgressBar progressBar_18;
	@FXML Button Button_Menu;
	private BorderPane Main_Pane;

	public void setmainpane(BorderPane b){
		this.Main_Pane=b;
	}

	public void setStatistics(Stat stats) {
		progressBar_1.setProgress(stats.getStat(2));
		progressBar_2.setProgress(stats.getStat(3));
		progressBar_3.setProgress(stats.getStat(4));
		progressBar_4.setProgress(stats.getStat(5));
		progressBar_5.setProgress(stats.getStat(6));
		progressBar_6.setProgress(stats.getStat(7));
		progressBar_7.setProgress(stats.getStat(8));
		progressBar_8.setProgress(stats.getStat(9));
		progressBar_9.setProgress(stats.getStat(10));
		progressBar_10.setProgress(stats.getStat(11));
		progressBar_11.setProgress(stats.getStat(12));
		progressBar_12.setProgress(stats.getStat(13));
		progressBar_13.setProgress(stats.getStat(14));
		progressBar_14.setProgress(stats.getStat(15));
		progressBar_15.setProgress(stats.getStat(16));
		progressBar_16.setProgress(stats.getStat(17));
		progressBar_17.setProgress(stats.getStat(18));
		progressBar_18.setProgress(stats.getTotalRatio());
		
	}
	
	
	
}
