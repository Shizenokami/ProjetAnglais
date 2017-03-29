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
		if (theme==0 || theme==1)
			return;
		questions.add(e);
		this.theme.add(theme);
	}
	
	public ArrayList<Integer> getTheme(){
		return theme;
	}
	public ArrayList<Element> getElement(){
		return questions;
	}
	
	public String getTaskElement(int position){
		return questions.get(position).getElementsByTagName("task").item(0).getTextContent();
	}
	public String getVarElement(int num,int position){
		return questions.get(position).getElementsByTagName("var").item(num).getTextContent();
	}
	public String getAnsElement(int position){
		return questions.get(position).getElementsByTagName("ans").item(0).getTextContent();
	}
	public String getExpElement(int position){
		return questions.get(position).getElementsByTagName("exp").item(0).getTextContent();
	}
	
	
}
