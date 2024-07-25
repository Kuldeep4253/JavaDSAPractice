package Array;

import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class XmlDataReader {
    public static void main(String argv[]) {
        try {
//creating a constructor of file class and parsing an XML file  
            File file = new File("/Users/kuldeepshukla/Downloads/output.xml");
//an instance of factory that gives a document builder  
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//an instance of builder to parse the specified xml file  
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(file);
            doc.getDocumentElement().normalize();
            System.out.println("Root element: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("status");
// nodeList is not iterable, so we are using for loop
                for (int count = 0; count < nodeList.getLength(); count++) {
                    Node elemNode = nodeList.item(count);
                    if (elemNode.getNodeType() == Node.ELEMENT_NODE) {
// get node name and value
                        System.out.println("\nNode Name =" + elemNode.getNodeName() + " [OPEN]");
                        System.out.println("Node Content =" + elemNode.getTextContent());
                        if (elemNode.hasAttributes()) {
                            NamedNodeMap nodeMap = elemNode.getAttributes();
                            for (int i = 0; i < nodeMap.getLength(); i++) {
                                Node node = nodeMap.item(i);
                                System.out.println("attr name : " + node.getNodeName());
                                System.out.println("attr value : " + node.getNodeValue());
                            }
                        }

                        System.out.println("Node Name =" + elemNode.getNodeName() + " [CLOSE]");
                }
            }
        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }

    }

}
