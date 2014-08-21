/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03web.controller;

import by.epam.task03.entity.MotoEquipment;
import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ValidatingException;
import by.epam.task03.logic.AbstractEquipBuilder;
import static by.epam.task03.logic.EquipBuilderFactory.createStudentBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Enumeration;
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
    
     
    RespParse(HttpServletRequest request, HttpServletResponse response) {
        this.request = request;
        this.response = response;
    }

    void getResponse() throws NullInitException, ValidatingException {
        
        request.removeAttribute("errors");
       
        String strParser = request.getParameter("parser");
        request.setAttribute("parsername", strParser);
        
        String str = System.getProperty("user.home");
        String path = str+"/NetBeansProjects/Task03web/";
        
        AbstractEquipBuilder builder;
        builder = createStudentBuilder(strParser);
        builder.buildSetEquip(path + "equip_test.xml");
        List<MotoEquipment> equip  = builder.getEquip().getEquip();
        request.setAttribute("equip", equip);
    }

}
