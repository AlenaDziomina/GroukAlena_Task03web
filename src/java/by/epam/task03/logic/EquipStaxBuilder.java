/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ProjectException;
import by.epam.task03.entity.MotoEquipment;
import static by.epam.task03web.controller.ParsServlet.localLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import org.apache.commons.lang3.EnumUtils;

/**
 *
 * @author Helena.Grouk
 */
public class EquipStaxBuilder extends AbstractEquipBuilder {
    private final static Pattern pat = Pattern.compile("-");
    private final XMLInputFactory inputFactory;
    private String[] currentProp;
    private ArrayList<String[]> atrs;
    
    public EquipStaxBuilder(){
        atrs = new ArrayList<>();
        inputFactory = XMLInputFactory.newInstance();
    }
    
    @Override
    public void buildSetEquip(String fileName) throws NullInitException {
        FileInputStream inputStream = null;
        XMLStreamReader reader;
        String name;
        try {
            inputStream = new FileInputStream(new File(fileName));
            reader = inputFactory.createXMLStreamReader(inputStream);
            // StAX parsing
            while (reader.hasNext()) {
                int type = reader.next();
                if (type == XMLStreamConstants.START_ELEMENT) {
                    name = reader.getLocalName();
                    Matcher mat = pat.matcher(name);
                    String str = mat.replaceAll("_").toUpperCase();
                    if (EnumUtils.isValidEnum(EquipEnum.class, str)) {
                        
                        String[] atr = {"class", EquipEnum.valueOf(str).getCl(), "String"};
                        atrs.add(atr);
                        
                        MotoEquipment st = buildEquip(reader);
                        equip.add(st);
                    }
                }
            }
        } catch (XMLStreamException ex) {
            throw new NullInitException("StAX parsing error! " + ex.getMessage());
        } catch (FileNotFoundException ex) {
            throw new NullInitException("File " + fileName + " not found! " + ex);
        } finally {
            try {
                if(inputStream != null ) {
                    inputStream.close();
                }
            }
            catch (IOException e) {
                throw new NullInitException("Impossible close file "+fileName+" : "+e);
            }
        }
    }

    private MotoEquipment buildEquip(XMLStreamReader reader) throws XMLStreamException {
        MotoEquipment eq = null;
        int N = reader.getAttributeCount();
        for (int i = 0; i < N; i++) {
            Matcher mat1 = pat.matcher(reader.getAttributeLocalName(i));
            String str1 = mat1.replaceAll("_").toUpperCase();
            if (EnumUtils.isValidEnum(PropEnum.class, str1)) {
                currentProp = PropEnum.valueOf(str1).getProp();
                currentProp[1] = reader.getAttributeValue(i);
                atrs.add(currentProp);
                currentProp = null;
            }
        }
        
        String name;
        while (reader.hasNext()) {
            int type = reader.next();
            
            switch (type) {
                case XMLStreamConstants.START_ELEMENT: {
                    name = reader.getLocalName();
                    Matcher mat = pat.matcher(name);
                    String str = mat.replaceAll("_").toUpperCase();
                    if (EnumUtils.isValidEnum(PropEnum.class, str)) {
                        currentProp = PropEnum.valueOf(str).getProp();
                        currentProp[1] = getXMLText(reader);
                        atrs.add(currentProp);
                        currentProp = null;
                    }
                } break;
                
                case XMLStreamConstants.END_ELEMENT: {
                    name = reader.getLocalName();
                    Matcher mat = pat.matcher(name);
                    String str = mat.replaceAll("_").toUpperCase();
                    if (EnumUtils.isValidEnum(EquipEnum.class, str) && atrs.size() > 0) {
                        try {
                            eq = EquipFactory.equipmentCreator(atrs.toArray(new String[atrs.size()][]));
                            atrs = new ArrayList<>();
                            return eq;
                        } catch (ProjectException ex) {
                            localLog.error("Creating equip failed.");
                        }
                        
                    }
                } break;
            }
        }
        
        return eq;
    }

    private String getXMLText(XMLStreamReader reader) throws XMLStreamException {
        String text = null;
        if (reader.hasNext()) {
            reader.next();
            text = reader.getText();
        }
        return text;
    }
}
