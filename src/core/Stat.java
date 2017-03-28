package core;

import org.w3c.dom.Element;

public class Stat {

	
	private int nbTotalquestion;
	private int nbCorrectAnswer;
	private int nbLocalAns;
	private int nbLocalQuest;
	
	private String themes[]= {"Word Order", "Articles", "Present Tenses", "Past Tenses", "Future Tense", "Passive Voice", "Confusing words", "Phrasal Verbs", "Irregular Verbs", "Linking words", "Adjectives", "Adverbs", "Gerunds and Infinitives", "Noun plus Preposition", "Prepositions", "Adjective plus Preposition", "Nouns", "Some, any, a lot of, many, much etc.", "Expressing hypothetical meaning", "Word Formation"};
	private int  nbThemeTotalquestion[];
	private int  nbThemeCorrectAnswer[];
	
	public Stat(Element usr){
		nbTotalquestion=Integer.parseInt(usr.getElementsByTagName("totalQuestion").item(0).getTextContent());
		nbCorrectAnswer=Integer.parseInt(usr.getElementsByTagName("totalQuestion").item(0).getTextContent());
		nbThemeTotalquestion=new int[20];
		nbThemeCorrectAnswer=new int[20];
		resetLocal();
	}
	
	public void resetLocal(){
		nbLocalAns=0;
		nbLocalQuest=0;
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
		usr.getElementsByTagName("nbCorrectAnswer").item(0).setTextContent(""+nbCorrectAnswer);
	}
	
}
