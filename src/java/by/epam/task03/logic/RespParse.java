/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.logic.factory.AbstractEquipBuilder;
import by.epam.task03.entity.MotoEquipment;
import by.epam.task03.exeption.EntityInitException;
import by.epam.task03.exeption.ProjectException;
import by.epam.task03.exeption.ValidatingException;
import static by.epam.task03.logic.factory.EquipBuilderFactory.createStudentBuilder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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

    public void processRequest(String file_path) throws ProjectException  {
        
        Map<String, String> errors = new HashMap<>();
        request.removeAttribute("errors");
       
        String strParser = request.getParameter("parser");
        request.setAttribute("parsername", strParser);
        
        AbstractEquipBuilder builder;
        try {
            builder = createStudentBuilder(strParser);
            builder.buildSetEquip(file_path);
            List<MotoEquipment> equip  = builder.getEquip().getEquip();
            request.setAttribute("equip", equip);
        } catch (EntityInitException ex) {
            String msg = ex.getMessage();
            errors.put("parser", ex.getMessage());
            request.setAttribute("errors", errors);
            throw new ProjectException(msg);
        } catch (ValidatingException ex) {
            String msg = ex.getMessage();
            errors.put("parsername", ex.getMessage());
            request.setAttribute("errors", errors);
            throw new ProjectException(msg);
        }
        
        
    }

}
