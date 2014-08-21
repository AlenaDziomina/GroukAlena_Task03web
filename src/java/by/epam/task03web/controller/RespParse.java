/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03web.controller;

import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ValidatingException;
import by.epam.task03.entity.MotoEquipment;
import by.epam.task03.logic.AbstractEquipBuilder;
import static by.epam.task03.logic.EquipBuilderFactory.createStudentBuilder;
import java.util.List;
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
        
        AbstractEquipBuilder builder;
        builder = createStudentBuilder(strParser);
        builder.buildSetEquip("C:\\Users\\User\\Documents\\NetBeansProjects\\Task03web\\equip_test.xml");
        List<MotoEquipment> equip  = builder.getEquip().getEquip();
        request.setAttribute("equip", equip);
    }

    
    
    
    
}
