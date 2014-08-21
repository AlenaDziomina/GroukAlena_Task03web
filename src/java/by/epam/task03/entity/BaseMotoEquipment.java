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
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "BaseMotoEquipment")
@XmlSeeAlso({
    MainEquip.class,
    AdditionalEquip.class
})

public abstract class BaseMotoEquipment extends MotoEquipment{ //основной экип
    
    private enum GenderStyle {Y, M, W, CH}
    
    @XmlAttribute(name = "size", required = true)
    private String size; //размер
    @XmlAttribute(name = "gender-style")
    private GenderStyle genderStyle = GenderStyle.Y; //пол-возраст для определения размерной таблицы

    protected BaseMotoEquipment(){}
    
    protected BaseMotoEquipment(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    protected BaseMotoEquipment(int id, String name, int price, float weight)
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
        
        BaseMotoEquipment eq = (BaseMotoEquipment)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(size == null ? eq.size != null : !size.equals(eq.size)) {
            return false;
        }
        if(genderStyle != eq.genderStyle) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.size);
        hash = 29 * hash + Objects.hashCode(this.genderStyle);
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
        str.append(", size: ");
        str.append(size);
        str.append(", genderStyle: ");
        str.append(genderStyle);
       
        return str.toString(); 
    }
    
    public void setSize(String size) throws ProjectException{
        if (size == null || size.isEmpty()) {
            throw new ProjectException("BaseMotoEquipment.size == null or empty.");
        }
        this.size = size;
    }
    
    public String getSize(){
        return size;
    }
    
    public void setGenderStyle(String gender) throws ProjectException{
        if (gender == null || gender.isEmpty()) {
            throw new ProjectException("BaseMotoEquipment.gender == null or empty.");
        }
        
        try {
            this.genderStyle = GenderStyle.valueOf(gender);
        }
        catch(IllegalArgumentException e) {
            throw new ProjectException("BaseMotoEquipment: = " + gender
                    + " is unnoun.");
        }

    }
    
    public String getGenderStyle(){
        return genderStyle.toString();
    }
    
 
}
