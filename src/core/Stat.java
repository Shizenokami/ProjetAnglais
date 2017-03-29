package core;


import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.w3c.dom.Element;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.SortedList;

public class Stat {

	
	private int nbTotalquestion;
	private int nbCorrectAnswer;
	private int nbLocalAns;
	private int nbLocalQuest;
	
	private List<String> QCMlist;
	ObservableList observableList = FXCollections.observableArrayList();

	private String themes[]= {"Word Order", "Articles", "Present Tenses", "Past Tenses", "Future Tense", "Passive Voice", "Confusing words", "Phrasal Verbs", "Irregular Verbs", "Linking words", "Adjectives", "Adverbs", "Gerunds and Infinitives", "Noun plus Preposition", "Prepositions", "Adjective plus Preposition", "Nouns", "Some, any, a lot of, many, much etc.", "Expressing hypothetical meaning", "Word Formation"};
	private int  nbThemeTotalquestion[];
	private int  nbThemeCorrectAnswer[];
	
	public Stat(Element usr){
		nbTotalquestion=Integer.parseInt(usr.getElementsByTagName("totalQuestion").item(0).getTextContent());
		nbCorrectAnswer=Integer.parseInt(usr.getElementsByTagName("totalQuestion").item(0).getTextContent());
		nbThemeTotalquestion=new int[20];
		nbThemeCorrectAnswer=new int[20];
		initialiseQCMList();
		resetLocal();
	}
	
	public void resetLocal(){
		nbLocalAns=0;
		nbLocalQuest=0;
	}
	public void initialiseQCMList(){
		QCMlist=new ArrayList<String>();
		QCMlist.add("BIG TEST");
		for (int temp=0;temp<18;temp++)
			QCMlist.add(themes[temp+2]);
		observableList.setAll(QCMlist);
	}
	
	public ObservableList<String> getQCMList(){
		return observableList;
	}
	
	public int getLocalQuest(){
		return nbLocalQuest;
	}
	public int getLocalAns(){
		return nbLocalAns;
	}
	public String getTheme(int theme){
		return themes[theme];
	}
	
	public void newQuestion(boolean correct){
		if (correct){
			nbLocalAns++;
			nbCorrectAnswer++;}
		nbLocalQuest++;
		nbTotalquestion++;
	}
	
	public void newQuestion(boolean correct,int theme){
		newQuestion(correct);
		if (correct)
			nbThemeCorrectAnswer[theme]++;
		nbThemeTotalquestion[theme]++;
	}
	
	
	
	public void Save(Element usr){
		usr.getElementsByTagName("totalQuestion").item(0).setTextContent(""+nbTotalquestion);
		usr.getElementsByTagName("correctAnswer").item(0).setTextContent(""+nbCorrectAnswer);
	}
	
	public double getStat(int category) {
		if (nbThemeTotalquestion[category]==0)
			return 0;
		double value = (double)nbThemeCorrectAnswer[category]/nbThemeTotalquestion[category];
		return value;
	}
	public double getTotalRatio() {
		double ca=0;
		for (int temp =2;temp<20;temp++){
			if (nbThemeTotalquestion[temp]!=0)
				ca+=(double)nbThemeCorrectAnswer[temp]/nbThemeTotalquestion[temp];
		}
		return ca/18;
	}
}
