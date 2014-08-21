/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SpecialMotoEquipment", propOrder = {
    "forWhat"
})
@XmlSeeAlso({
    ProtectorInsert.class,
    Visor.class,
    Sliders.class
})

public abstract class SpecialMotoEquipment extends MotoEquipment{
    //специализированный экип
    
    //для какой основной экипировки предназначено
    @XmlAnyElement
    private RefBaseEquip forWhat = new RefBaseEquip();
    
    protected SpecialMotoEquipment(){}
    
    protected SpecialMotoEquipment(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    protected SpecialMotoEquipment(int id, String name, int price, float weight)
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
        
        SpecialMotoEquipment eq = (SpecialMotoEquipment)obj;
        if (!super.equals(eq)){
            return false;
        }
        return forWhat == eq.forWhat;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.forWhat);
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
        str.append(", forWhat: ");
        str.append(forWhat.toString());
        
        return str.toString();
       
    }
    
    public List getForWhat() {
        return this.forWhat.getListForWhat();
    }
    
    public void setForWhat(BaseMotoEquipment eq) throws ProjectException{
        if (null == eq) {
            throw new ProjectException("BaseMotoEquipment forWhat == null.");
        }
        forWhat.add(eq);
    }
    
}
