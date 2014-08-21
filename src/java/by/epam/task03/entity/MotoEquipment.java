/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import java.math.BigInteger;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlID;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
/**
 *
 * @author Helena.Grouk
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "MotoEquipment", propOrder = {
    "id",
    "manufacturer",
    "price",
    "weight",
    "baseMaterial"
})
@XmlSeeAlso({
    SpecialMotoEquipment.class,
    BaseMotoEquipment.class
})

public abstract class MotoEquipment implements Comparable<MotoEquipment> {
    //мотоэкипировка
    @XmlElement(required = true)
    private int id; //идентификатор объекта
    @XmlElement(required = true)
    private String manufacturer; //производитель
    @XmlElement(required = true)
    @XmlSchemaType(name = "positiveInteger")
    private int price; //цена
    @XmlElement(required = true)
    private float weight; //вес
    @XmlElement(name = "base-material", required = true)
    private String baseMaterial; //основной материал
    @XmlAttribute(name = "id_s", required = true)
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    @XmlID
    @XmlSchemaType(name = "ID")
    private String id_s; //идентификатор объекта
    @XmlAttribute(name = "name", required = true)
    private String name; //торговое наименование
    
    
    protected MotoEquipment(){}
    
    protected MotoEquipment(int id, String name) throws ProjectException {  
        setId(id);
        setName(name); 
    }
    
    protected MotoEquipment(int id, String name, int price, float weight)
            throws ProjectException {
        
        this(id, name);
        setPrice(price);
        setWeight(weight);
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
        
        MotoEquipment eq = (MotoEquipment)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(id != eq.id) {
            return false;
        }
        if(name == null ? eq.name != null : !name.equals(eq.name)){
            return false;
        }
        if(price != eq.price) {
            return false;
        }
        if(manufacturer == null ? eq.manufacturer != null : 
                !manufacturer.equals(eq.manufacturer)) {
            return false;
        }
        if(weight != eq.weight) {
            return false;
        }
        if(baseMaterial == null ? eq.baseMaterial != null : 
                !baseMaterial.equals(eq.baseMaterial)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 67 * hash + this.id;
        hash = 67 * hash + Objects.hashCode(this.name);
        hash = 67 * hash + Objects.hashCode(this.manufacturer);
        hash = 67 * hash + this.price;
        hash = 67 * hash + Float.floatToIntBits(this.weight);
        hash = 67 * hash + Objects.hashCode(this.baseMaterial);
        return hash;
    }

    @Override
    public String toString() {
        
        StringBuilder str = new StringBuilder(getClass().getName());
        str.append('@');
        str.append("id: ");
        str.append(id);
        str.append(", name: ");
        str.append(name);
        str.append(", manufacturer: ");
        str.append(manufacturer);
        str.append(", price: ");
        str.append(price);
        str.append(", weight: ");
        str.append(weight);
        str.append(", baseMaterial: ");
        str.append(baseMaterial);
       
        return str.toString();
    }
    
    @Override
    public int compareTo(MotoEquipment eq) { //сравнение по id
        if (eq == null ) {
            throw new NullPointerException();
        }
        int compareId = eq.getId();
        return this.id - compareId;      
    }
    
    protected final void setId(int id) throws ProjectException {
        if (id <= 0) {
            throw new ProjectException("MotoEquipment.id <= 0");
        }
        this.id_s = "id" + id;
        this.id = id;
    }
    
    public int getId() {
        return id;
    }
    
    protected final void setName(String name) throws ProjectException {
        if (name == null || name.isEmpty()){
            throw new ProjectException("MotoEquipment.name == null or empty");
        }
        
        this.name = name;
    }
    
    public String getName() {
        return name;
    }
    
    public void setManufacturer(String manufacturer) throws ProjectException {
        if (manufacturer == null || manufacturer.isEmpty()){
            throw new ProjectException("MotoEquipment.manufacturer == null or empty");
        }
        this.manufacturer = manufacturer;
    }
    
    public String getManufacturer() {
        return manufacturer;
    }
    
    public void setPrice(Integer price) throws ProjectException {
        if (price < 0) {
            throw new ProjectException("MotoEquipment.price < 0");
        }
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setWeight(Float weight) throws ProjectException {
        if (weight < 0) {
            throw new ProjectException("MotoEquipment.price < 0");
        }
        this.weight = weight;
    }
    
    public float getWeight() {  
        return weight;
    }
    
    public void setBaseMaterial(String baseMaterial) throws ProjectException {
         if (baseMaterial == null || baseMaterial.isEmpty()){
            throw new ProjectException("MotoEquipment.baseMaterial == null or empty");
        }
        this.baseMaterial = baseMaterial;
    }
    
    public String getBaseMaterial() {  
        return baseMaterial;
    }

}


    
    
