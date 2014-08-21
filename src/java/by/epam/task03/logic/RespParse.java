/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.entity.MotoEquipment;
import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ValidatingException;
import static by.epam.task03.logic.EquipBuilderFactory.createStudentBuilder;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.net.URLDecoder;
import java.nio.charset.Charset;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Helena.Grouk
 */
public class RespParse {
    
    HttpServletRequest request;
    HttpServletResponse response;
    
     
    public RespParse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    public void getResponse() throws NullInitException, ValidatingException {
        
        request.removeAttribute("errors");
       
        String strParser = request.getParameter("parser");
        request.setAttribute("parsername", strParser);
        
        
        
        
        String str = System.getProperty("user.home");
        String path = str+"/NetBeansProjects/Task03web/";
        
        URL pathURL = AbstractEquipBuilder.class.getProtectionDomain().getCodeSource().getLocation();
        try {
            String classFile = URLDecoder.decode(pathURL.getFile().substring(1).replace('/', File.separatorChar),
                    Charset.defaultCharset().name());
            String propertiesFile = classFile.replace(".jar", ".properties");
        } catch (UnsupportedEncodingException ex) {
            Logger.getLogger(RespParse.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        AbstractEquipBuilder builder;
        builder = createStudentBuilder(strParser);
        builder.buildSetEquip(path + "equip_test.xml");
        List<MotoEquipment> equip  = builder.getEquip().getEquip();
        request.setAttribute("equip", equip);
    }

}
