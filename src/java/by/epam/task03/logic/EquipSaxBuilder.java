/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ProjectException;
import by.epam.task03.entity.MotoEquip;
import by.epam.task03.entity.MotoEquipment;
import static by.epam.task03web.controller.ParsServlet.localLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.commons.lang3.EnumUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 *
 * @author Helena.Grouk
 */
public class EquipSaxBuilder extends AbstractEquipBuilder {
    
    private final EquipHandler eqh;
    private XMLReader reader;
    
    public EquipSaxBuilder() throws NullInitException{
        eqh = new EquipHandler();
        try {
            reader = XMLReaderFactory.createXMLReader();
            reader.setContentHandler(eqh);
        } catch (SAXException ex) {
            throw new NullInitException("Error of SAX parsing configuration: " + ex);
        }
    }
    
    @Override
    public void buildSetEquip(String fileName) throws NullInitException {
        try {
            // разбор XML-документа
            reader.parse(fileName);
            equip = eqh.getEquip();
        }
        catch (SAXException e) {
            throw new NullInitException("Parsing SAX failure: " + e);
        }
        catch (IOException e) {
            throw new NullInitException("File error or I/O error: " + e);
        }
    }
    
    private class EquipHandler extends DefaultHandler {
   
    private final MotoEquip equip;
    private MotoEquipment current;
    private String[] currentProp;
    private ArrayList<String[]> atrs;
    private final Pattern pat = Pattern.compile("-");
    
    public EquipHandler() {
        equip = new MotoEquip();
        atrs = new ArrayList<>();
    }
    
    public MotoEquip getEquip() {
        
        return equip;
    }
    
    @Override
    public void startElement(String uri, String localName, String qName, Attributes attrs) {
        Matcher mat = pat.matcher(localName);
        String str = mat.replaceAll("_").toUpperCase();
        currentProp = null;
        if (EnumUtils.isValidEnum(EquipEnum.class, str)) {
            
            String[] atr = {"class", EquipEnum.valueOf(str).getCl(), "String"};
            atrs.add(atr);
        }
        else {
            if (EnumUtils.isValidEnum(PropEnum.class, str)) {
                currentProp = PropEnum.valueOf(str).getProp();
            }
            
        }
        
        int N = attrs.getLength();
        for (int i = 0; i < N; i++) {
            Matcher mat1 = pat.matcher(attrs.getLocalName(i));
            String str1 = mat1.replaceAll("_").toUpperCase();
            if (EnumUtils.isValidEnum(PropEnum.class, str1)) {
                currentProp = PropEnum.valueOf(str1).getProp();
                currentProp[1] = attrs.getValue(i);
                atrs.add(currentProp);
                currentProp = null;
            }
        }
    }
    
    @Override
    public void endElement(String uri, String localName, String qName) {
        Matcher mat = pat.matcher(localName);
        String str = mat.replaceAll("_").toUpperCase();
        if (EnumUtils.isValidEnum(EquipEnum.class, str) && atrs.size() > 0) {
            try {
                current = EquipFactory.equipmentCreator(atrs.toArray(new String[atrs.size()][]));
                equip.add(current);
            } catch (ProjectException ex) {
                localLog.error("Creating equip failed.");
            }
            atrs = new ArrayList<>();
        } else if (EnumUtils.isValidEnum(PropEnum.class, str)) {
            atrs.add(currentProp);
            currentProp = null;
        }
    }
   
    @Override
    public void characters(char[] ch, int start, int length) {
        String s = new String(ch, start, length).trim();
        if (currentProp != null && !s.isEmpty()) {
            currentProp[1] = s;
        }
        
    }
}

}
