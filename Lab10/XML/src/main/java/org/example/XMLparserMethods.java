package org.example;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

public class XMLparserMethods {

    public void read(){

        try {

            File inputFile = new File("D:/Files/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Корневой элемент: " + doc.getDocumentElement().getNodeName());
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++){

                Node node = nodeList.item(i);
                System.out.println("\nТекущий элемент: " + node.getNodeName());
                if (node.getNodeType() == Node.ELEMENT_NODE){

                    Element element = (Element) node;
                    System.out.println("Название книги: "
                            + element.getElementsByTagName("title").item(0)
                            .getTextContent());
                    System.out.println("Автор: "
                            + element.getElementsByTagName("author").item(0)
                            .getTextContent());
                    System.out.println("Год издания: "
                            + element.getElementsByTagName("year").item(0)
                            .getTextContent());
                }
            }
        } catch (Exception e){

            e.printStackTrace();
        }
    }

    public void write(Document doc){

        try {

            doc.setXmlStandalone(true);
            doc.normalizeDocument();
            javax.xml.transform.TransformerFactory tf = javax.xml.transform.TransformerFactory.newInstance();
            javax.xml.transform.Transformer transformer = tf.newTransformer();
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.ENCODING,  "UTF-8");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.STANDALONE,  "yes");
            transformer.setOutputProperty(javax.xml.transform.OutputKeys.INDENT,  "yes");
            javax.xml.transform.dom.DOMSource source = new javax.xml.transform.dom.DOMSource(doc);
            javax.xml.transform.stream.StreamResult result =
                    new javax.xml.transform.stream.StreamResult(new File(  "D:/Files/example.xml"));
            transformer.transform(source, result);
        } catch (Exception e){

            e.printStackTrace();
        }
    }

    public void findAuthor (String str){

        try {

            File inputFile = new File("D:/Files/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++){

                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){

                    Element element = (Element) node;
                    if (element.getElementsByTagName("author").item(0).getTextContent().equals(str)){

                        System.out.println("Название книги: "
                                + element.getElementsByTagName("title").item(0)
                                .getTextContent());
                        System.out.println("Автор: "
                                + element.getElementsByTagName("author").item(0)
                                .getTextContent());
                        System.out.println("Год издания: "
                                + element.getElementsByTagName("year").item(0)
                                .getTextContent());
                    }
                }
            }
            System.out.println();
        } catch (Exception e){

            e.printStackTrace();
        }
    }

    public void findYear (String str){

        try {

            File inputFile = new File("D:/Files/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++){

                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){

                    Element element = (Element) node;
                    if (element.getElementsByTagName("year").item(0).getTextContent().equals(str)){

                        System.out.println("Название книги: "
                                + element.getElementsByTagName("title").item(0)
                                .getTextContent());
                        System.out.println("Автор: "
                                + element.getElementsByTagName("author").item(0)
                                .getTextContent());
                        System.out.println("Год издания: "
                                + element.getElementsByTagName("year").item(0)
                                .getTextContent());
                    }
                }
            }
            System.out.println();
        } catch (Exception e){

            e.printStackTrace();
        }
    }

    public void remove (String str){

        try {

            File inputFile = new File("D:/Files/example.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();
            Document doc = dbBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            NodeList nodeList = doc.getElementsByTagName("book");
            for (int i = 0; i < nodeList.getLength(); i++){

                Node node = nodeList.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE){

                    Element element = (Element) node;
                    if (element.getElementsByTagName("title").item(0).getTextContent().equals(str)){

                        Node parentNode = element.getParentNode();
                        parentNode.removeChild(element);
                        write(doc);

                    }
                }
            }
            System.out.println();
        } catch (Exception e){

            e.printStackTrace();
        }
    }
}
