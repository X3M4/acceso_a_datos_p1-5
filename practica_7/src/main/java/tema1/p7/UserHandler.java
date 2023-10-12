package tema1.p7;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class UserHandler extends DefaultHandler{

    boolean got = false;
    boolean characters = false;
    boolean id = false;
    boolean name = false;
    boolean culture = false;
    boolean born = false;
    boolean died = false;
    boolean alive = false;
    boolean tittle = false;
    boolean alias = false;
    boolean father = false;
    boolean mother = false;
    boolean spouse = false;
    boolean allegiances = false;
    boolean books = false;
    boolean book = false;
    boolean tvSeries = false;
    boolean season = false;
    boolean aliases = false;

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        // TODO Auto-generated method stub
        String sep = " ";
        switch (qName) {
            case "GOT":
                this.got = true;
                break;
            case "character":
                this.characters = true;
                break;
            case "id":
                this.id = true;
                break;
            case "name":
                this.name = true;
                break;
            case "culture":
                this.culture = true;
                break;
            case "born":
                this.born = true;
                break;
            case "died":
                this.died = true;
                break;
            case "alive":
                this.alive = true;
                break;
            case "tittle":
                this.tittle = true;
                break;
            case "aliases":
                this.aliases = true;
                break;
            case "alias":
                this.alias = true;
                break;
            case "father":
                this.father = true;
                break;
            case "mother":
                this.mother = true;
                break;
            case "spouse":
                this.spouse = true;
                break;
            case "allegiances":
                this.allegiances = true;
                break;
            case "books":
                this.books = true;
                break;
            case "book":
                this.book = true;
                break;
            case "tvSeries":
                this.tvSeries = true;
                break;
            case "season":
                this.season = true;
                break;
            default: break;
        }
        
    }

        @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        // TODO Auto-generated method stub
        if(this.got){
            System.out.println(levels("GOT") + new String(ch, start, length));
            this.got = false;
        }else if(this.characters){
            System.out.println(levels("character") + new String(ch, start, length));
            this.characters = false;
        }else if(this.id){
            System.out.println(levels("id") + new String(ch, start, length));
            this.id = false;
        }else if(this.name) {
            System.out.println(levels("name") + new String(ch, start, length));
            this.name = false;
        }else if(this.culture) {
            System.out.println(levels("culture") + new String(ch, start, length));
            this.culture = false;
        }else if(this.born) {
            System.out.println(levels("born") + new String(ch, start, length));
            this.born = false;
        }else if(this.died) {
            System.out.println(levels("died") + new String(ch, start, length));
            this.died = false;
        }else if(this.alive) {
            System.out.println(levels("alive") + new String(ch, start, length));
            this.alive = false;
        }else if(this.tittle) {
            System.out.println(levels("tittle") + new String(ch, start, length));
            this.tittle = false;
        }else if(this.alias) {
            System.out.println("\t" + levels("alias") + new String(ch, start, length));
            this.alias = false;
        }else if(this.father) {
            System.out.println(levels("father") + new String(ch, start, length));
            this.father = false;
        }else if(this.mother){
            System.out.println(levels("mother") + new String(ch, start, length));
            this.mother = false;
        }else if(this.spouse) {
            System.out.println(levels("spouse") + new String(ch, start, length));
            this.spouse = false;
        }else if(this.allegiances) {
            System.out.println(levels("allegiances") + new String(ch, start, length));
            this.allegiances = false;
        }else if(this.book) {
            System.out.println("\t" +levels("book") + new String(ch, start, length));
            this.book = false;
        }else if(this.season) {
            System.out.println("\t" +levels("season") + new String(ch, start, length));
            this.season = false;
        }else if(this.tvSeries) {
            System.out.println(levels("tvSeries") + new String(ch, start, length));
            this.tvSeries = false;
        }else if(this.aliases) {
            System.out.println(levels("aliases") + new String(ch, start, length));
            this.aliases = false;
        }else if(this.books)  {
            System.out.println(levels("books") + new String(ch, start, length));
            this.books = false;
        }
    }

    public static String levels(String name){
        String sep = " ";
        switch (name) {
            case "GOT":
                return sep.repeat(0) + name +": ";
            case "character":
                return sep.repeat(1) + name +": ";
                
            case "id":
                return sep.repeat(2) + name +": ";
                
            case "name":
                return sep.repeat(3) + name +": ";

            case "culture":
            case "born":
            case "died":
            case "alive":
            case "tittle":
            case "aliases":
            case "father": 
            case "mother":  
            case "spouse":
            case "allegiances":
            case "books":
            case "tvSeries":
                return sep.repeat(4) + name + ": ";
            case "alias":
                return sep.repeat(4) + "- ";
            case "book":
            case "season":
                return sep.repeat(5) + "- ";
            default:
                return "";
        }
    }
}
