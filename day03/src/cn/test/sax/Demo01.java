package cn.test.sax;

import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.ContentHandler;
import org.xml.sax.Locator;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

public class Demo01 {

	/**
	 * sax ����html�ĵ�
	 * @throws SAXException 
	 * @throws ParserConfigurationException 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		//1.������������
		SAXParserFactory factory = SAXParserFactory.newInstance();
		
		//2.�õ�������
		SAXParser sp = factory.newSAXParser();
		
		//3.�õ���ȡ��
		XMLReader reader = sp.getXMLReader();
		
		//4.���ô�������
		reader.setContentHandler(new ListHandler());
		
		//5.��ȡxml�ĵ�����
		reader.parse("src/book.xml");

	}
}

//�õ�xml�ĵ���������
class ListHandler implements ContentHandler{

	public void startElement(String uri, String localName, String qName,
			Attributes atts) throws SAXException {
		System.out.println("<" + qName + ">");
		
		for(int i=0;atts!=null && i<atts.getLength();i++){
			String attName = atts.getQName(i);
			String attValue = atts.getValue(i);
			System.out.println(attName + "=" + attValue);
		}
	}
	
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		System.out.println(new String(ch,start,length));
		
	}

	public void endElement(String uri, String localName, String qName)
			throws SAXException {
		System.out.println("</" + qName + ">");
		
	}

	

	@Override
	public void ignorableWhitespace(char[] ch, int start, int length)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void processingInstruction(String target, String data)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void skippedEntity(String name) throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setDocumentLocator(Locator locator) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endDocument() throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void startPrefixMapping(String prefix, String uri)
			throws SAXException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void endPrefixMapping(String prefix) throws SAXException {
		// TODO Auto-generated method stub
		
	}
		
}
