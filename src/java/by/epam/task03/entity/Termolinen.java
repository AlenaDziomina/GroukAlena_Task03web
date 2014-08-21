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
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Termolinen", propOrder = {
    "elastic",
    "seamless"
})
@XmlRootElement
public class Termolinen extends AdditionalEquip {
    
    private enum ClothesType {socks, tshirt, jumper, shorts, pants }
    
    private boolean elastic;
    private boolean seamless; //бесшовный
    @XmlAttribute(name = "clothes-type", required = true)
    private ClothesType clothesType;
    
    public Termolinen(){}
    
    public Termolinen(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public Termolinen(int id, String name, int price, float weight)
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
        
        Termolinen eq = (Termolinen)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(clothesType != eq.clothesType) {
            return false;
        }
        if(elastic != eq.elastic) {
            return false;
        }
        if(seamless != eq.seamless) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.clothesType);
        hash = 97 * hash + (this.elastic ? 1 : 0);
        hash = 97 * hash + (this.seamless ? 1 : 0);
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
        str.append(", clothesType: ");
        str.append(clothesType);
        str.append(", elastic: ");
        str.append(elastic);
        str.append(", seamless: ");
        str.append(seamless);

        return str.toString();
    }
    
    public void setClothesType(String clothesType) throws ProjectException {
        if (clothesType == null || clothesType.isEmpty()){
            throw new ProjectException("Termolinen.clothesType == null or empty");
        }
        
        try {
            this.clothesType = ClothesType.valueOf(clothesType);
        }
        catch(IllegalArgumentException e) {
            throw new ProjectException("Termolinen.clothesType = " + clothesType
                    + " is unnoun.");
        }  
            
    }
    
    public String getClothesType() {
        return this.clothesType.toString();
    }
            
    public void setElastic(Boolean elastic) {
        this.elastic = elastic;
    }
    
    public boolean isElastic() {
        return this.elastic;
    }
    
    public void setSeamless(Boolean seamless) {
        this.seamless = seamless;
    }
    
    public boolean isSeamless() {
        return this.seamless;
    }
}
    

        