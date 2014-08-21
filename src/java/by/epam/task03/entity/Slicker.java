/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Slicker", propOrder = {
    "separate",
    "fluorescent",
    "hood"
})
@XmlRootElement
public class Slicker extends AdditionalEquip { //дождевик
    
    private boolean separate;
    private boolean fluorescent;
    private boolean hood;
    
    public Slicker(){}
    
    public Slicker(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public Slicker(int id, String name, int price, float weight)
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
        
        Slicker eq = (Slicker)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(separate != eq.separate) {
            return false;
        }
        if(fluorescent != eq.fluorescent) {
            return false;
        }
        if(hood != eq.hood) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 59 * hash + (this.separate ? 1 : 0);
        hash = 59 * hash + (this.fluorescent ? 1 : 0);
        hash = 59 * hash + (this.hood ? 1 : 0);
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
        str.append(", separate: ");
        str.append(separate);
        str.append(", fluorescent: ");
        str.append(fluorescent);
        str.append(", hood: ");
        str.append(hood);

        return str.toString();
    }
    
    public void setSeparate(Boolean separate) {
        this.separate = separate;
    }
    
    public boolean isSeparate() {
        return this.separate;
    }
    
    public void setFluorescent(Boolean fluorescent) {
        this.fluorescent = fluorescent;
    }
    
    public boolean ifFluorescent() {
        return this.fluorescent;
    }
    
    public void setHood(Boolean hood) {
        this.hood = hood;
    }
    
    public boolean isHood() {
        return this.hood;
    }
}
