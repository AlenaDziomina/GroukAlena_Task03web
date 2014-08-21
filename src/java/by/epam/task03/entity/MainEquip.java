/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MainEquip", propOrder = {
    "motoType"
})
@XmlSeeAlso({
    Shoes.class,
    Helmet.class,
    BodyProtection.class
})

public abstract class MainEquip extends BaseMotoEquipment{ //основная экипировка
    
    private enum MotoType {TURIST, SPORT, ENDURO, CROSS, STUNT, COMMON}
    
    @XmlElement(name = "moto-type", required = true, defaultValue = "COMMON")
    private MotoType motoType = MotoType.COMMON; //тип применения экипировки
    
    protected MainEquip(){}
    
    protected MainEquip(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    protected MainEquip(int id, String name, int price, float weight)
            throws ProjectException {
        super(id, name, price, weight);
    }
    
     @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (null == obj) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        
        MainEquip eq = (MainEquip)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(motoType != eq.motoType) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.motoType);
        return hash;
    }

    @Override
    public String toString() {
        String str1 = super.toString();
        int i = str1.indexOf("@");
        if (i > 0) {
            str1 = str1.substring(i+1);
        }
        
        StringBuilder str = new StringBuilder(getClass().getName());
        str.append('@');
        str.append(str1);
        str.append(", motoType: ");
        str.append(motoType);

        return str.toString();
    }
    
    public void setMotoType(String motoType) throws ProjectException{
        if (motoType == null || motoType.isEmpty()) {
            throw new ProjectException("MainEquip.motoType == null or empty.");
        }
        
        try {
            this.motoType = MotoType.valueOf(motoType);
        }
        catch(IllegalArgumentException e) {
            throw new ProjectException("MainEquip.motoType=" + motoType 
                    + " is unnoun.");
        }
        
    }
    
    public String getMotoType(){
        return motoType.toString();
    }

}
