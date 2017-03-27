package core;

import java.util.ArrayList;

import org.w3c.dom.Element;

public class QuestionSet {

	
	private ArrayList<Element> questions;
	private ArrayList<Integer> theme;
	
	public QuestionSet(){
		questions=new ArrayList<Element>();
		theme=new ArrayList<Integer>();
	}
	
	public void  addQuestion(Element e,int theme){
		questions.add(e);
		this.theme.add(theme);
	}
	
	public ArrayList<Integer> getTheme(){
		return theme;
	}
	
}
