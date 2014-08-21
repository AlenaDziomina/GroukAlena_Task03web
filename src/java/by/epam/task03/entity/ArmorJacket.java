/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "ArmorJacket", propOrder = {
    "backProtect",
    "chestProtect",
    "elbowsProtect",
    "shouldersProtect"
})
@XmlRootElement(name = "armor-jacket")
public class ArmorJacket extends SeparateBodyProtection {
    
    @XmlElement(name = "back-protect")
    private boolean backProtect; //наличие вставки защиты спины
    @XmlElement(name = "chest-protect")
    private boolean chestProtect;
    @XmlElement(name = "elbows-protect")
    private boolean elbowsProtect; //наличие вставки защиты локтей
    @XmlElement(name = "shoulders-protect")
    private boolean shouldersProtect; //наличие вставки защиты плечей
    
    public ArmorJacket(){}
    
    public ArmorJacket(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public ArmorJacket(int id, String name, int price, float weight)
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
        
        ArmorJacket eq = (ArmorJacket)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(backProtect != eq.backProtect) {
            return false;
        }
        if(chestProtect != eq.chestProtect) {
            return false;
        }
        if(elbowsProtect != eq.elbowsProtect) {
            return false;
        }
        if(shouldersProtect != eq.shouldersProtect) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + (this.backProtect ? 1 : 0);
        hash = 67 * hash + (this.chestProtect ? 1 : 0);
        hash = 67 * hash + (this.elbowsProtect ? 1 : 0);
        hash = 67 * hash + (this.shouldersProtect ? 1 : 0);
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
        str.append(", back: ");
        str.append(backProtect);
        str.append(", elbows: ");
        str.append(elbowsProtect);
        str.append(", shoulders: ");
        str.append(shouldersProtect);
        str.append(", chest: ");
        str.append(chestProtect);

        return str.toString();
    }
    
    public void setBackProtect(Boolean backProtect) {
        this.backProtect = backProtect;
    }
    
    public boolean isBackProtect() {
        return backProtect;
    }
    
    public void setElbowsProtect(Boolean elbowsProtect) {
        this.elbowsProtect = elbowsProtect;
    }
    
    public boolean isElbowsProtect() {
        return elbowsProtect;
    }
    
    public void setShouldersProtect(Boolean shouldersProtect) {
        this.shouldersProtect = shouldersProtect;
    }
    
    public boolean isShouldersProtect() {
        return shouldersProtect;
    }
    
    public void setChestProtect(Boolean chestProtect) {
        this.chestProtect = chestProtect;
    }
    
    public boolean isChestProtect() {
        return chestProtect;
    }
}
