/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.entity.MotoEquipment;
import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ProjectException;
import static by.epam.task03web.controller.ParsServlet.localLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.commons.lang3.EnumUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

/**
 *
 * @author Helena.Grouk
 */

public final class EquipDomBuilder extends AbstractEquipBuilder {
    
    private DocumentBuilder docBuilder;
    private final static Pattern pat = Pattern.compile("-");
    private String[] currentProp;
    private ArrayList<String[]> atrs;
    
    public EquipDomBuilder() throws NullInitException {
        atrs = new ArrayList<>();
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        try {
            docBuilder = factory.newDocumentBuilder();
        }
        catch (ParserConfigurationException e) {
            throw new NullInitException("Error of parsing configuration: " + e);
        }
    }

    @Override
    public void buildSetEquip(String fileName) throws NullInitException {
        Document doc;
        String name;
        try {
            doc = docBuilder.parse(fileName);
            Element root = doc.getDocumentElement();
            NodeList eqList = root.getChildNodes();
            int N = eqList.getLength();
            for (int i = 0; i < eqList.getLength(); i++) {
                int type = eqList.item(i).getNodeType();
                if (type == 1) {
                    name = eqList.item(i).getNodeName();
                    Matcher mat = pat.matcher(name);
                    String str = mat.replaceAll("_").toUpperCase();
                    if (EnumUtils.isValidEnum(EquipEnum.class, str)) {                      
                        String[] atr = {"class", EquipEnum.valueOf(str).getCl(), "String"};
                        atrs.add(atr);
                        Element el = (Element) eqList.item(i);
                        MotoEquipment eq = buildEquip(el);
                        equip.add(eq);
                    }
                }
            }
        }
        catch (IOException e) {
            throw new NullInitException("File error or I/O error: " + e);
        }
        catch (SAXException e) {
            throw new NullInitException("Parsing failure: " + e);
        }
    }

    private MotoEquipment buildEquip(Element el) {
        MotoEquipment eq = null;
        String name;
        NamedNodeMap attrs = el.getAttributes();
        
        int N = el.getAttributes().getLength();
        for (int i = 0; i < N; i++) {
            name = attrs.item(i).getNodeName();
            Matcher mat = pat.matcher(name);
            String str = mat.replaceAll("_").toUpperCase();
            if (EnumUtils.isValidEnum(PropEnum.class, str)) {
                currentProp = PropEnum.valueOf(str).getProp();
                currentProp[1] = attrs.item(i).getNodeValue();
                atrs.add(currentProp);
                currentProp = null;
            }
        }
        
        NodeList propList = el.getChildNodes();
        N = propList.getLength();
        for (int i = 0; i < N; i++) {
            int type = propList.item(i).getNodeType();
            if (type == 1) {
                name = propList.item(i).getNodeName();
                Matcher mat = pat.matcher(name);
                String str = mat.replaceAll("_").toUpperCase();
                {
                    if (EnumUtils.isValidEnum(PropEnum.class, str)) {
                        currentProp = PropEnum.valueOf(str).getProp();
                        currentProp[1] = propList.item(i).getTextContent();
                        atrs.add(currentProp);
                        currentProp = null;
                    }
                }
            }
        }
        
        try {
            eq = EquipFactory.equipmentCreator(atrs.toArray(new String[atrs.size()][]));
            atrs = new ArrayList<>();
            return eq;
        } catch (ProjectException ex) {
            localLog.error("Parsing equip failed.");
        }
        
        return eq;
    }
    
}
