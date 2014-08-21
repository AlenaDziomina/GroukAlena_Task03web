/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.exeption.ProjectException;
import by.epam.task03.entity.EquippedMotorcyclist;
import by.epam.task03.entity.MainEquip;
import by.epam.task03.entity.MotoEquipment;
import static by.epam.task03.logic.EquipSorting.sortEquip;
import static by.epam.task03web.controller.ParsServlet.localLog;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Helena.Grouk
 */
public class EquippedMotorcyclistFactory {
    
    public static EquippedMotorcyclist MotoObjectCreator(
            List<MotoEquipment> magaz, String[]... objArgs) 
            throws ProjectException {

        if (magaz == null) {
            throw new ProjectException("EquippedMotorcyclistFactory: magaz or objArgs == null");
        }
        if (objArgs == null) {
            throw new ProjectException("EquippedMotorcyclistFactory: magaz or objArgs == null");
        }
        
        sortMotoObj(magaz, objArgs[0]);
        
        EquippedMotorcyclist eqMoto = new EquippedMotorcyclist();

        for (int i = 1; i < objArgs.length; i++) {
            
            MotoEquipment obj = findMotoObj(magaz, objArgs[i]);
            if (obj == null) {
                localLog.info("EquippedMotorcyclistFactory: Can't find equip on parameters: " 
                        + Arrays.toString(objArgs));
            } else {
                eqMoto.setEquip(obj);
            }
        } 
        return eqMoto;
    }
    
    private static void sortMotoObj(List<MotoEquipment> magaz, String... sortArgs) {
        
        for (int i = sortArgs.length; i > 0; i--) {
            try {
                sortEquip(magaz, sortArgs[i-1]);
            } catch (ProjectException ex) {
                localLog.info("EquippedMotorcyclistFactory: cant sort equip on " 
                        + Arrays.toString(sortArgs));
            }
        }    
    }

    private static MotoEquipment findMotoObj(List<MotoEquipment> magaz, 
            String...args) {
     
        if (args == null || args.length < 4 ) {
            localLog.info("FindMotoObj: args of search is null or too short.");
        }

        for (MotoEquipment obj : magaz) { 
            
            if (args[0].equals(obj.getClass().getSimpleName())
                    && args[1].equals(((MainEquip)obj).getSize())
                    && args[2].equals(((MainEquip)obj).getGenderStyle())
                    && args[3].equals(((MainEquip)obj).getMotoType())) {
                return obj;
            }                 
        }
        return null;
    }
}
