package core;

import java.util.ArrayList;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import controlers.MainControler;




/* Use getRandomNumberQuestions(number of question needed , set number (1 or 2) will return an arraylist of element
 * to get the task you need to apply to the element getElementsByTagName("task").item(0).getTextContent()
 * to get the i answer you need to apply to the element getElementsByTagName("var").item(i).getTextContent()
 * to get the number of the correct answer you need to apply to the element getElementsByTagName("ans").item(0).getTextContent()
 * to get an explanation you need to apply getElementsByTagName("exp").item(0).getTextContent()
 */

public class QuestionsLoad {

	private NodeList set1;
	private NodeList set2;
	
	public static void main(String argv[]) {
		QuestionsLoad qu = new QuestionsLoad();
		QuestionSet El = qu.getOneCategoryQuestions(20,1);
		for (Element e:El.getElement()){
			System.out.println("question : "+e.getElementsByTagName("task").item(0).getTextContent());
			System.out.println("reponse : "+ e.getElementsByTagName("var").item(Integer.parseInt(e.getElementsByTagName("ans").item(0).getTextContent())-1).getTextContent());}
	}
	public QuestionsLoad() {
		loadQuestions("asset/File1.xml","asset/File2.xml");
	}
	
	
	//Path 1 "asset/File1.xml" Path 2 "asset/File2.xml"
	public void loadQuestions(String path1,String path2){
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			Document doc=docBuilder.parse(path1);
			set1 = doc.getElementsByTagName("question");
			
			doc=docBuilder.parse(path2);
			set2 = doc.getElementsByTagName("question");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public Element getQuestion(int i,int set){
		return (Element) getSet(set).item(i);
	}
	
	public NodeList getSet(int set){
		if (set==1)
			return set1;
		else
			return set2;
	}
	
	public QuestionSet getRandomNumberQuestions(int i,int set){
		QuestionSet myQuestions=new QuestionSet();
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		
		for (int l=0;l<i;l++){
			int c=0;
			int num=0;
			do {
				num =(int)(Math.random()*600);
				for (int k:numbers)
					if (num==k)
						c++;
			} while  (c!=0);
			myQuestions.addQuestion(getQuestion(num,set),num%20);
			numbers.add(num);
		}
		return myQuestions;
	}
	
	
	
	public QuestionSet getAllCategoryQuestions(int set){
		int num=(int)(Math.random()*30);
		int offset=(int)(Math.random()*20);
		QuestionSet myQuestions=new QuestionSet();
		
		for (int l=num*20;l<num*20+20;l++){
			myQuestions.addQuestion(getQuestion((l+offset)%20+num*20,set),(l+offset)%20);
		}
		return myQuestions;
	}
	
	public QuestionSet getOneCategoryQuestions(int i,int set){
		QuestionSet myQuestions=new QuestionSet();
		for (int l=i;l<600;l+=20){
			myQuestions.addQuestion(getQuestion(l,set),i);
		}
		return myQuestions;
		
	}
}
