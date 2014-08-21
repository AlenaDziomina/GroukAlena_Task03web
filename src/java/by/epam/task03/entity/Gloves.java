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
@XmlType(name = "Gloves", propOrder = {
    "palmProtect",
    "fingersProtect",
    "knucklesProtect"
})
@XmlRootElement
public class Gloves extends BuiltInBodyProtection { //перчатки

    @XmlElement(name = "palm-protect")
    private boolean palmProtect; //защита ладони
    @XmlElement(name = "fingers-protect")
    private boolean fingersProtect; //защита пальцев
    @XmlElement(name = "knuckles-protect")
    private boolean knucklesProtect; //защита костяшек пальцев
    
    public Gloves(){}
    
    public Gloves(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public Gloves(int id, String name, int price, float weight) throws ProjectException {
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
        
        Gloves eq = (Gloves)obj;
        if (!super.equals(eq)){
            return false;
        }
        
        if(palmProtect != eq.palmProtect) {
            return false;
        }
        if(fingersProtect != eq.fingersProtect) {
            return false;
        }
        if(knucklesProtect != eq.knucklesProtect) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + (this.palmProtect ? 1 : 0);
        hash = 59 * hash + (this.fingersProtect ? 1 : 0);
        hash = 59 * hash + (this.knucklesProtect ? 1 : 0);
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
        str.append(", palmProtect: ");
        str.append(palmProtect);
        str.append(", fingersProtect: ");
        str.append(fingersProtect);
        str.append(", knucklesProtect: ");
        str.append(knucklesProtect);
        return str.toString();
    }
    
    public void setPalmProtect(Boolean palmProtect) {
        this.palmProtect = palmProtect;
    }
    
    public boolean isPalmProtect() {
        return this.palmProtect;
    }
    
    public void setFingersProtect(Boolean fingersProtect) {
        this.fingersProtect = fingersProtect;
    }
    
    public boolean isFingersProtect() {
        return this.fingersProtect;
    }
    
    public void setKnucklesProtect(Boolean knucklesProtect) {
        this.knucklesProtect = knucklesProtect;
    }
    
    public boolean isKnucklesProtect() {
        return this.knucklesProtect;
    }
    
}
