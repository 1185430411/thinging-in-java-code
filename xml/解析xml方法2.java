package xs;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;

public class test{
	@Test
	public void test() throws DocumentException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("src/NewFile.xml");
		Node node1=doc.selectSingleNode("/books/book/name");
		System.out.println(node1.getText());  //java教程
		
		Node node2=doc.selectSingleNode("/books/book[2]/name");
		System.out.println(node2.getText());  //c++教程
		
		Node node3=doc.selectSingleNode("/books/book[3]/name");
		System.out.println(node3.getText());  //spring教程
		
		Node node4=doc.selectSingleNode("/books/book/attribute::id");
		System.out.println(node4.getText());  //1001
	}
	@Test
	public void test2() throws DocumentException {
		SAXReader reader=new SAXReader();
		Document doc=reader.read("src/NewFile.xml");
		List list=doc.selectNodes("//*");
		for(int i=0;i<list.size();i++) {
			Node node=(Node)list.get(i);
			System.out.println(node.getName()+"\t"+node.getText());
		}
		/*
		java教程
		c++教程
		spring教程
		1001
		books	
			
			
			

		book	
				
				
			
		name	java教程
		price	100
		book	
				
				
			
		name	c++教程
		price	20
		book	
				
				
			
		name	spring教程
		price	30
		*/
	}
}
