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
@XmlType(name = "BodyProtection", propOrder = {
    "protectionMaterial"
})
@XmlSeeAlso({
    BuiltInBodyProtection.class,
    SeparateBodyProtection.class
})

public abstract class BodyProtection extends MainEquip{ //защита тела
    
    @XmlElement(name = "protection-material", required = true)
    private String protectionMaterial;
    
    protected BodyProtection(){}
    
    protected BodyProtection(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    protected BodyProtection(int id, String name, int price, float weight)
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
        
        BodyProtection eq = (BodyProtection)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(protectionMaterial == null ? eq.protectionMaterial != null : 
                !protectionMaterial.equals(eq.protectionMaterial)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.protectionMaterial);
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
        str.append(", protectionMaterial: ");
        str.append(protectionMaterial);
        
        return str.toString();
    }
    
    public void setProtectionMaterial(String protectionMaterial)
            throws ProjectException {
        if (protectionMaterial == null || protectionMaterial.isEmpty()) {
            throw new ProjectException("BodyProtection.protectionMaterial == null or empty.");
        }
        this.protectionMaterial = protectionMaterial;
    } 
    
    public String getProtectionMaterial() {
        return protectionMaterial;
    }
    
    
}
