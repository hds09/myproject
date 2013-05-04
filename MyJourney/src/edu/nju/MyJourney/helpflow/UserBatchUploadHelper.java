package edu.nju.MyJourney.helpflow;

import java.io.StringReader;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;



import edu.nju.MyJourney.model.User;

public class UserBatchUploadHelper {
	/*
	 * parse xmlStr to User array
	 */
	public static ArrayList<User> Convert2List(String xmlStr) throws Exception{
		ArrayList<User> list=new ArrayList<User>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        InputSource is = new InputSource(new StringReader(xmlStr));
        Document doc=builder.parse(is);
        NodeList nlist=doc.getElementsByTagName("User");
        System.out.println("number of users to be inserted: "+nlist.getLength()+" ...");
        for(int i=0;i<nlist.getLength();i++){
        	User tmpUser=new User();
        	Node tmp=nlist.item(i);
        	System.out.println("processing node "+i+" ...");
        	Node first=tmp.getFirstChild();
        	Node tmpNode=first.getNextSibling();
        	while(tmpNode!=null){
        		if(tmpNode.getNodeType()==Node.ELEMENT_NODE){
        			String nodeName=tmpNode.getNodeName();
        			if(nodeName.equals("account")){
        				tmpUser.setAccount(tmpNode.getTextContent());
        			}else if(nodeName.equals("name")){
        				tmpUser.setName(tmpNode.getTextContent());
        			}else if(nodeName.equals("age")){
        				tmpUser.setAge(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("city")){
        				tmpUser.setCity(tmpNode.getTextContent());
        			}else if(nodeName.equals("email")){
        				tmpUser.setEmail(tmpNode.getTextContent());
        			}else if(nodeName.equals("phone")){
        				tmpUser.setPhone(tmpNode.getTextContent());
        			}else if(nodeName.equals("password")){
        				tmpUser.setPwd(tmpNode.getTextContent());
        			}else if(nodeName.equals("sex")){
        				tmpUser.setSex(Integer.parseInt(tmpNode.getTextContent()));
        			}else if(nodeName.equals("image")){
        				tmpUser.setImage(tmpNode.getTextContent());
        			}else{
        				System.out.println("uncaught attr: "+nodeName);
        			}
        		}
        		tmpNode=tmpNode.getNextSibling();
        	}
        	list.add(tmpUser);
        }
		return list;
	}
}
