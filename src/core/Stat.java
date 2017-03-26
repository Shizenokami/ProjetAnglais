package core;

import org.w3c.dom.Element;

public class Stat {

	
	private int nbTotalquestion;
	private int nbCorrectAnswer;
	
	public Stat(Element usr){
		nbTotalquestion=Integer.parseInt(usr.getElementsByTagName("totalQuestion").item(0).getTextContent());
		nbCorrectAnswer=Integer.parseInt(usr.getElementsByTagName("totalQuestion").item(0).getTextContent());
	}
	
	public void newQuestion(boolean correct){
		if (correct)
			nbCorrectAnswer++;
		nbTotalquestion++;
	}
	
	public void Save(Element usr){
		usr.getElementsByTagName("totalQuestion").item(0).setTextContent(""+nbTotalquestion);
		usr.getElementsByTagName("nbCorrectAnswer").item(0).setTextContent(""+nbCorrectAnswer);
	}
	
}
