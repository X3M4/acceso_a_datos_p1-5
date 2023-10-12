package tema1.p7;

import java.io.File;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class ParserXML {
    public static void main(String[] args) {
        try {
         File inputFile = new File("DAM_AD_UD01_P6_GOT_Ini.xml");
         SAXParserFactory factory = SAXParserFactory.newInstance();
         SAXParser saxParser = factory.newSAXParser();
         UserHandler userhandler = new UserHandler();
         saxParser.parse(inputFile, userhandler);     
      } catch (Exception e) {
         e.printStackTrace();
      }
    }
}