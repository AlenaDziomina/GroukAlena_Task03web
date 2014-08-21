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
@XmlType(name = "Jacket", propOrder = {
    "backInsert",
    "elbowsInsert",
    "shouldersInsert"
})
@XmlRootElement
public class Jacket extends BuiltInBodyProtection{ //мотокуртка
    
    @XmlElement(name = "back-insert")
    private boolean backInsert; //наличие вставки защиты спины
    @XmlElement(name = "elbows-insert")
    private boolean elbowsInsert; //наличие вставки защиты локтей
    @XmlElement(name = "shoulders-insert")
    private boolean shouldersInsert; //наличие вставки защиты плечей
    
    public Jacket(){}
    
    public Jacket(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public Jacket(int id, String name, int price, float weight) 
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
        
        Jacket eq = (Jacket)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(backInsert != eq.backInsert) {
            return false;
        }
        if(elbowsInsert != eq.elbowsInsert) {
            return false;
        }
        if(shouldersInsert != eq.shouldersInsert) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.backInsert ? 1 : 0);
        hash = 79 * hash + (this.elbowsInsert ? 1 : 0);
        hash = 79 * hash + (this.shouldersInsert ? 1 : 0);
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
        str.append(", backInsert: ");
        str.append(backInsert);
        str.append(", elbowsInsert: ");
        str.append(elbowsInsert);
        str.append(", shouldersInsert: ");
        str.append(shouldersInsert);

        return str.toString();
    }
    
    public void setBackInsert(Boolean backInsert) {
        this.backInsert = backInsert;
    }
    
    public boolean isBackInsert() {
        return backInsert;
    }
    
    public void setElbowsInsert(Boolean elbowsInsert) {
        this.elbowsInsert = elbowsInsert;
    }
    
    public boolean isElbowsInsert() {
        return elbowsInsert;
    }
    
    public void setShouldersInsert(Boolean shouldersInsert) {
        this.shouldersInsert = shouldersInsert;
    }
    
    public boolean isShouldersInsert() {
        return shouldersInsert;
    }
    
   
}
