/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.entity.BaseMotoEquipment;
import by.epam.task03.entity.MainEquip;
import by.epam.task03.entity.MotoEquipment;
import java.util.Comparator;

/**
 *
 * @author Helena.Grouk
 */
public abstract class EquipComparator implements Comparator<MotoEquipment> {
    
    public static Comparator<MotoEquipment> equipNameComparator 
        = (MotoEquipment eq1, MotoEquipment eq2) -> {
            String eqName1 = eq1.getName().toUpperCase();
            String eqName2 = eq2.getName().toUpperCase();

            return eqName1.compareTo(eqName2);
    };
    
     public static Comparator<MotoEquipment> equipTypeComparator
            = (MotoEquipment eq1, MotoEquipment eq2) -> {
                String eqType1 = eq1.getClass().getTypeName();
                String eqType2 = eq2.getClass().getTypeName();
                
                return eqType1.compareTo(eqType2);
    };
    
    public static Comparator<MotoEquipment> equipWeigthComparator
            = (MotoEquipment eq1, MotoEquipment eq2) -> {
                Float eqWeight1 = eq1.getWeight();
                Float eqWeight2 = eq2.getWeight();
                
                return eqWeight1.compareTo(eqWeight2);
    };
    
    public static Comparator<MotoEquipment> equipPriceComparator
            = (MotoEquipment eq1, MotoEquipment eq2) -> {
                Integer eqPrice1 = eq1.getPrice();
                Integer eqPrice2 = eq2.getPrice();
                
                return eqPrice1.compareTo(eqPrice2);
    };
    
    public static Comparator<MotoEquipment> equipSizeComparator
            = (MotoEquipment eq1, MotoEquipment eq2) -> {
                String size1;
                String size2;
                
                try {
                    size1 = ((BaseMotoEquipment)eq1).getSize();
                } catch (Exception ex) {
                    size1 = "";
                }
                
                try {
                    size2 = ((BaseMotoEquipment)eq2).getSize();
                } catch (Exception ex) {
                    size2 = "";
                }
                
                return size1.compareTo(size2);
    };
    
    public static Comparator<MotoEquipment> equipGenderComparator
            = (MotoEquipment eq1, MotoEquipment eq2) -> {
                String gender1;
                String gender2;
                
                try {
                    gender1 = ((BaseMotoEquipment)eq1).getGenderStyle();
                } catch (Exception ex) {
                    gender1 = "";
                }
                
                try {
                    gender2 = ((BaseMotoEquipment)eq2).getGenderStyle();
                } catch (Exception ex) {
                    gender2 = "";
                }
                
                return gender1.compareTo(gender2);
    };
    
    public static Comparator<MotoEquipment> equipMotoTypeComparator
            = (MotoEquipment eq1, MotoEquipment eq2) -> {
                String moto1;
                String moto2;
                
                try {
                    moto1 = ((MainEquip)eq1).getMotoType();
                } catch (Exception ex) {
                    moto1 = "";
                }
                
                try {
                    moto2 = ((MainEquip)eq2).getMotoType();
                } catch (Exception ex) {
                    moto2 = "";
                }
                
                return moto1.compareTo(moto2);
    };
                          
}
