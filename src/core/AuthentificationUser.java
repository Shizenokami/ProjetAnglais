package core;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class AuthentificationUser {
	
	private NodeList setUser;
	private Document doc;
	private String pathDoc;
	
	public static void main(String argv[]) {
		AuthentificationUser auth=new AuthentificationUser("asset/usrs.xml");
		auth.signUp("meuh","else","fin");
		System.out.println(auth.signIn("meuh", "fin"));
	}
	
	public AuthentificationUser(String path){
		pathDoc=path;
		loadUsers(pathDoc);
	}
	
	
	public void loadUsers(String pathUser){
		
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		
		try {
			DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
			
			doc=docBuilder.parse(pathUser);
			setUser = doc.getElementsByTagName("users");
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
	}
	
	public void saveinUsers(String pathUser){
		try {
			
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer;
			transformer = transformerFactory.newTransformer();
			DOMSource source = new DOMSource(doc);
			StreamResult streamResult =  new StreamResult(new File(pathUser));
			transformer.transform(source, streamResult);
			} 
		catch (Exception e) {
			e.printStackTrace();
		}
	}
	public void saveinUsers(){
		saveinUsers(pathDoc);
	}
	
	public boolean signUp(String userName,String mail,String password){
		boolean bool=false;
		NodeList usrs = doc.getElementsByTagName("user");
		for (int temp = 0; temp < usrs.getLength(); temp++) {
			Element usr=(Element) usrs.item(temp);
			if ( usr.getElementsByTagName("userName").item(0).getTextContent().equals(userName))
				bool=true;
				
		}
		if (!bool){
			Element newUser= doc.createElement("user");
			Element name=doc.createElement("userName");
			Element email=doc.createElement("mail");
			Element pass=doc.createElement("password");
			Element totalQuestion=doc.createElement("totalQuestion");
			Element correctAnswer=doc.createElement("correctAnswer");
			Element uElement = (Element) setUser.item(0);
			uElement.appendChild(newUser);
			newUser.appendChild(name);
			newUser.appendChild(email);
			newUser.appendChild(pass);
			newUser.appendChild(totalQuestion);
			newUser.appendChild(correctAnswer);
			name.appendChild(doc.createTextNode(userName));
			email.appendChild(doc.createTextNode(mail));
			pass.appendChild(doc.createTextNode(password));
			totalQuestion.appendChild(doc.createTextNode("0"));
			correctAnswer.appendChild(doc.createTextNode("0"));
			saveinUsers(pathDoc);}
		else 
			System.out.println("user already exist");
		return bool;
	}
	
	public Element signIn(String userName,String password){
		for (int temp = 0; temp < setUser.getLength(); temp++) {
			Element usr=(Element) setUser.item(temp);
			if ( usr.getElementsByTagName("userName").item(0).getTextContent().equals(userName) && usr.getElementsByTagName("password").item(0).getTextContent().equals(password))
				return usr;
		}
		return null;
	}
	
}
