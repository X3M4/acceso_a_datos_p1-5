package tema1.p7_2;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import java.util.*;
import java.io.*;

public class ParserXML extends DefaultHandler {
    
    private boolean etiqueta = false;
    private StringBuilder lineaTexto;
    private int nivel = 0;
    private final String ESPACIADO = "\t";

    @Override
    public void startDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("\n\tCOMIENZA LA IMPRESIÓN DEL DOCUMENTO XML\t");
    }

    //Cada vez que se inicie la lectura de un elemento el programa hará lo que se indica en la función startElement
    //Se pone la variable etiqueta a true y se inicia un nuevo StringBuilder
    @Override
    public void startElement(String uri, String localName, String qName, Attributes atts) throws SAXException {
        
        this.etiqueta = true;

        this.lineaTexto = new StringBuilder();
    }
    //Se añade al StringBuilder la cadena que se indica en la función characters
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if(etiqueta) {
            this.lineaTexto.append(ch, start, length);
        }
    }
    //En caso de que la variable lineaTexto no esté vacía se imprime el elemento y el texto que contiene cada elemento
    @Override
    public void endElement(String uri, String localName, String qName) throws SAXException {
        if (etiqueta) {
            if(!lineaTexto.isEmpty()){
                System.out.println(localName + ": " + lineaTexto.toString());
            }
        }
        etiqueta = false;
    }
    //En esta parte del código se indica lo que realizará el programa al iniciar la lectura del documento XML
    @Override
    public void endDocument() throws SAXException {
        // TODO Auto-generated method stub
        System.out.println("\n\tTERMINA LA IMPRESIÓN DEL DOCUMENTO XML\n");
    }

    //Con esta función se convierte la ruta dada en la lectura del Scanner en formato URL
    private static String convierteEnURL(String archivo){
        String path = new File(archivo).getAbsolutePath();
        if(File.separatorChar != '/') {
            path = path.replace(File.separatorChar, '/');
        }

        if (!path.startsWith("/")){
            path = "/" + path;
        }
        System.out.println(path);
        return "file:" + path;
    }

    public static void usage() {
        System.out.println("Error leyendo el archivo XML");
        
        System.exit(1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Escriba la ruta al archivo XML que se quiere imprimir por pantalla");
        String archivo = sc.nextLine();
        sc.close();
        /*
        NO SOY CAPAZ DE LEER EL ARCHIVO PASANDO EL PATH DEL XML COMO PARÁMETROS POR TERMINAL 
        POR LO QUE LO PASO ESCRIBIENDO EL PATH MEDIANTE SCANNER

        String archivo = null;

        for(int i = 0; i < args.length; i++) {
            archivo = args[i];

            if(i != args.length - 1) {
                usage();
            }
        }

        if(archivo == null) {
            usage();
        }*/
              
        try{
            SAXParserFactory spf = SAXParserFactory.newInstance();
            spf.setNamespaceAware(true);
            SAXParser saxParser = spf.newSAXParser();
            XMLReader xmlReader = saxParser.getXMLReader();
            xmlReader.setContentHandler(new ParserXML());
            xmlReader.parse(convierteEnURL(archivo));
        }catch(Exception e) {
            e.printStackTrace();
        }
    }
}