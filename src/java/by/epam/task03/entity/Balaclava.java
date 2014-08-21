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
@XmlType(name = "Balaclava", propOrder = {
    "seamless"
})
@XmlRootElement
public class Balaclava extends AdditionalEquip {
    
    private boolean seamless; //бесшовный
    
    public Balaclava(){}
    
    public Balaclava(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public Balaclava(int id, String name, int price, float weight)
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
        
        Balaclava eq = (Balaclava)obj;
        if (!super.equals(eq)){
            return false;
        }
        
        if(seamless != eq.seamless) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 13 * hash + (this.seamless ? 1 : 0);
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
        
        str.append(", seamless: ");
        str.append(seamless);
       
        return str.toString();
    }
    
    public void setSeamless(Boolean seamless) {
        this.seamless = seamless;
    }
    
    public boolean isSeamless() {
        return this.seamless;
    }
}
