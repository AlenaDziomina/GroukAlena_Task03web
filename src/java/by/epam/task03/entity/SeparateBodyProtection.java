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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SeparateBodyProtection", propOrder = {
    "mountType"
})
@XmlSeeAlso({
    ArmorJacket.class,
    ElbowProtector.class,
    KneeProtector.class
})

public abstract class SeparateBodyProtection extends BodyProtection { 
    //отдельная защита тела (в виде щитков)
    
    @XmlElement(name = "mount-type", required = true)
    private String mountType; //тип крепления к телу
    
    protected SeparateBodyProtection(){}
    
    protected SeparateBodyProtection(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    protected SeparateBodyProtection(int id, String name, int price, float weight) throws ProjectException {
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
        
        SeparateBodyProtection eq = (SeparateBodyProtection)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(mountType == null ? eq.mountType != null : 
                !mountType.equals(eq.mountType)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 47 * hash + Objects.hashCode(this.mountType);
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
        str.append(", mountType: ");
        str.append(mountType);
        return str.toString();
    }
    
    public void setMountType(String mountType) 
            throws ProjectException {
        if (mountType == null || mountType.isEmpty()) {
            throw new ProjectException("SeparateBodyProtection.mountType == null or empty.");
        }
        this.mountType = mountType;
    }
    
    public String getMountType() {
        return mountType;
    }
    
}
