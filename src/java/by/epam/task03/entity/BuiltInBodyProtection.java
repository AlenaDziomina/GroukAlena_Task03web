/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BuiltInBodyProtection", propOrder = {
    "waterproof",
    "perforation",
    "insulation"
})
@XmlSeeAlso({
    Pants.class,
    Jacket.class,
    Gloves.class
})

public abstract class BuiltInBodyProtection extends BodyProtection{
    //встроенная защита тела
   
    private boolean waterproof; //влагостойкость (покрытия, пропитки и др)
    private boolean perforation; //наличие перворации
    private boolean insulation; //наличие утеплителя

    protected BuiltInBodyProtection(){}
    
    protected BuiltInBodyProtection(int id, String name)
            throws ProjectException {
        super(id, name);
    }
    
    protected BuiltInBodyProtection(int id, String name, int price,
            float weight) throws ProjectException {
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
        
        BuiltInBodyProtection eq = (BuiltInBodyProtection)obj;
        if (!super.equals(eq)){
            return false;
        }
        
        if(waterproof != eq.waterproof) {
            return false;
        }
        if(perforation != eq.perforation) {
            return false;
        }
        if(insulation != eq.insulation) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + (this.waterproof ? 1 : 0);
        hash = 53 * hash + (this.perforation ? 1 : 0);
        hash = 53 * hash + (this.insulation ? 1 : 0);
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
        str.append(", waterproof: ");
        str.append(waterproof);
        str.append(", perforation: ");
        str.append(perforation);
        str.append(", insulation: ");
        str.append(insulation);
        
        return str.toString();
    }
    
    public void setWaterproof(Boolean waterproof) {
        this.waterproof = waterproof;
    }
    
    public boolean isWaterproof() {
        return waterproof;
    }
    
    public void setPerforation(Boolean perforation) {
        this.perforation = perforation;
    }
    
    public boolean isPerforation() {
        return perforation;
    }
    
    public void setInsulation(Boolean insulation) {
        this.insulation = insulation;
    }
    
    public boolean isInsulation() {
        return insulation;
    }
    
    
}
