package xs;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.junit.Test;



public class test{
	@Test
	//獲取一個節點的數據
	public void test() throws DocumentException{
		//創建一個xml解析對象
		SAXReader reader=new SAXReader();
		//將xml文檔加載到document上
		Document doc=reader.read("src/NewFile.xml");
		//獲取根節點
		Element root=doc.getRootElement();
		//獲取當前節點的所有子節點
		List list=root.elements();
		//獲取第三個子節點
		Element thirdbook=(Element)list.get(2);
		String name=thirdbook.element("name").getText();
		System.out.println(name); //spring教程
	}
	
	//遍歷節點
	@Test
	public void test2() throws DocumentException {
		//創建一個xml解析對象
		SAXReader reader=new SAXReader();
		//將xml文檔加載到document上
		Document doc=reader.read("src/NewFile.xml");
		//獲取根節點
		Element root=doc.getRootElement();
		
		travel(root);
		/*
		spring教程
		books

			
			
			

		book

				
				
			
		name
		java教程

				
				
			
		price
		100

				
				
			

			
			
			

		book

				
				
			
		name
		c++教程

				
				
			
		price
		20

				
				
			

			
			
			

		book

				
				
			
		name
		spring教程

				
				
			
		price
		30

				
				
			

			
			
			
*/

	}
	
	
	public void travel(Element e) {
		System.out.println(e.getName());
		for(int i=0;i<e.nodeCount();i++) {
			//獲取一個幾點，但這個節點不一定是標簽
			Node node=e.node(i);
			//若是標簽
			if(node instanceof Element) {
				travel((Element)node);
			}
			//若不是標簽，比如像"java教程"這種文本，也算是他的子節點，就直接打印名字
			else {
				System.out.println(e.getText());
			}
		}
	}
}
