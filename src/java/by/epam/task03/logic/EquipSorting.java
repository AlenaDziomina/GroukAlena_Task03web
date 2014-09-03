/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.exeption.ProjectException;
import by.epam.task03.entity.MotoEquipment;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author Helena.Grouk
 */
public class EquipSorting {
    public static List<?> sortEquip(List<?> list, String param) 
            throws ProjectException {
        
        if (list == null || list.isEmpty()) {
            throw new ProjectException("EquipSorting: list == null or empty.");
        }
        if (param == null) {
            throw new ProjectException("EquipSorting: param == null.");
        }
        
        if (list.get(0) instanceof MotoEquipment) {
            
            switch (param) {
                case "name": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipNameComparator);
                } break;
                case "type": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipTypeComparator);
                } break;
                case "weight": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipWeigthComparator);
                } break;
                case "price": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipPriceComparator);
                } break;
                case "size": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipSizeComparator);
                } break;
                case "gender": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipGenderComparator);
                } break;
                case "motoType": {
                    Collections.sort((List<MotoEquipment>)list, 
                            EquipComparator.equipMotoTypeComparator);
                } break;
                default: {
                    throw new ProjectException("EquipSorting: no such type of comparator.");
                }
            }
        }
       
        return null;
    }
    
    public static List<MotoEquipment> selectByPrice(List<MotoEquipment> magaz, 
            int min, int max) throws ProjectException {
        if (min > max) {
            throw new ProjectException("SelectByPrice: min > max.");
        }
        
        Collections.sort(magaz, EquipComparator.equipPriceComparator);
        
        List<MotoEquipment> sortList = new ArrayList();
        
        for (MotoEquipment eq : magaz) {
            if (eq.getPrice() >= min & eq.getPrice() <= max) {
                sortList.add(eq);
            }
        }
        
        List<MotoEquipment> immutList = Collections.unmodifiableList(sortList);

        return immutList;
        
        
    }
}
