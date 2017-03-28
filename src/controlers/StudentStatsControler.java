package controlers;

import core.Stat;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;

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
	
	public void setStatistics(Stat stats) {
		progressBar_1.setProgress(stats.getStat(1));
		progressBar_2.setProgress(stats.getStat(2));
		progressBar_3.setProgress(stats.getStat(3));
		progressBar_4.setProgress(stats.getStat(4));
		progressBar_5.setProgress(stats.getStat(5));
		progressBar_6.setProgress(stats.getStat(6));
		progressBar_7.setProgress(stats.getStat(7));
		progressBar_8.setProgress(stats.getStat(8));
		progressBar_9.setProgress(stats.getStat(9));
		progressBar_10.setProgress(stats.getStat(10));
		
	}
	
}
