package core;

import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;



/* Use getRandomNumberQuestions(number of question needed , set number (1 or 2) will return an arraylist of element
 * to get the task you need to apply to the element getElementsByTagName("task").item(0).getTextContent()
 * to get the i answer you need to apply to the element getElementsByTagName("var").item(i).getTextContent()
 * to get the number of the correct answer you need to apply to the element getElementsByTagName("ans").item(0).getTextContent()
 * to get an explanation you need to apply getElementsByTagName("exp").item(0).getTextContent()
 */

public class QuestionsSet {

	private NodeList set1;
	private NodeList set2;
	
	public QuestionsSet() {
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
	
	public ArrayList<Element> getRandomNumberQuestions(int i,int set){
		ArrayList<Element> myQuestion=new ArrayList<Element>();
		ArrayList<Integer> numbers=new ArrayList<Integer>();
		
		for (int l=0;l<i;l++){
			int c=0;
			int num=0;
			do {
				num =(int)(Math.random()*600-0.0001);
				for (int k:numbers)
					if (num==k)
						c++;
			} while  (c!=0);
			myQuestion.add(getQuestion(num,set));
			numbers.add(num);
		}
		return myQuestion;
	}
}
