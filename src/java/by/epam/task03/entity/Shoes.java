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
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Shoes", propOrder = {
    "soleMaterial",
    "protectionMaterial",
    "mountType"
})
@XmlRootElement
public class Shoes extends MainEquip { //мотообувь
    
    @XmlElement(name = "sole-material", required = true)
    private String soleMaterial; //материал основания
    @XmlElement(name = "protection-material", required = true)
    private String protectionMaterial; //материал защиты
    @XmlElement(name = "mount-type", required = true)
    private String mountType; //тип крепления (застежки)
    
    public Shoes(){}
    
    public Shoes(int id, String name) throws ProjectException {
        super(id, name);
    }
  
    public Shoes(int id, String name, int price, float weight)
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
        
        Shoes eq = (Shoes)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(soleMaterial == null ? eq.soleMaterial != null : 
                !soleMaterial.equals(eq.soleMaterial)) {
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
        hash = 59 * hash + Objects.hashCode(this.soleMaterial);
        hash = 59 * hash + Objects.hashCode(this.mountType);
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
        str.append(", soleMaterial: ");
        str.append(soleMaterial);
        str.append(", mountType: ");
        str.append(mountType);
       
        return str.toString();
    }
    
    public void setSoleMaterial(String baseMaterial) throws ProjectException {
        if (baseMaterial == null ) {
            throw new ProjectException("Shoes.soleMaterial == null");
        }
        if (baseMaterial.isEmpty()) {
            throw new ProjectException("Shoes.soleMaterial is empty");
        }
        this.soleMaterial = baseMaterial;
    }
    
    public String getSoleMaterial() {
        return soleMaterial;
    }
    
    public void setProtectionMaterial(String protectionMaterial) 
            throws ProjectException {
        if (protectionMaterial == null) {
            throw new ProjectException("Shoes.protectionMaterial == null");
        }
        if (protectionMaterial.isEmpty()) {
            throw new ProjectException("Shoes.protectionMaterial is empty");
        }
        this.protectionMaterial = protectionMaterial;
    } 
    
    public String getProtectionMaterial() {
        return protectionMaterial;
    }
    
    public void setMountType(String mountType) throws ProjectException {
        if (mountType == null) {
            throw new ProjectException("Shoes.mountType == null");
        }
        if (mountType.isEmpty()) {
            throw new ProjectException("Shoes.mountType is empty");
        }
        this.mountType = mountType;
    }
    
    public String getMountType() {
        return mountType;
    }

    
}
