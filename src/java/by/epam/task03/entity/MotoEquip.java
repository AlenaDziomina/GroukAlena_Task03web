/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.TreeSet;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "equip"
})
@XmlRootElement(name = "moto-equip")
public class MotoEquip {

    @XmlAnyElement
    private Set<MotoEquipment> equip;

    public MotoEquip() {
        this.equip = new TreeSet<>();
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
        
        MotoEquip eq = (MotoEquip)obj;
        if (!super.equals(eq)){
            return false;
        }
        return equip.equals(eq.equip);
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + Objects.hashCode(this.equip);
        return hash;
    }
    
    @Override 
    public String toString() {
        StringBuilder str = new StringBuilder(getClass().getName());
        str.append('@');
        str.append("equip: ");
        str.append(equip);
        return str.toString();
        
    }
    
    public List getEquip() {
        if (equip == null) {
            equip = new TreeSet<>();
        }
        return Collections.unmodifiableList(new ArrayList(equip));
    }
    
    public void setEquip(Set<MotoEquipment> equip) {
        this.equip = equip;
    }
    
    public void add(MotoEquipment eq) {
        this.equip.add(eq);
    }

}
