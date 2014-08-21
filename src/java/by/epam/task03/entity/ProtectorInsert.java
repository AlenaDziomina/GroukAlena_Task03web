/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
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
@XmlType(name = "ProtectionInsert")
@XmlRootElement(name = "protector-insert")
public class ProtectorInsert extends SpecialMotoEquipment { //защитные вставки в мотокуртку и мотоштаны
    
    private enum BodyPart {back, elbows, shoulders, chest, hip, knee}
    
    @XmlAttribute(name = "body-part", required = true)
    private BodyPart bodyPart;
    
    public ProtectorInsert(){}
    
    public ProtectorInsert(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public ProtectorInsert(int id, String name, int price, float weight)
            throws ProjectException {
        super(id, name, price, weight);
    }
    
    public void setBodyPart(String bodyPart) throws ProjectException {
        if (bodyPart == null || bodyPart.isEmpty()) {
            throw new ProjectException("Protector.bodyPart == null or empty");
        }
        
        try {
            this.bodyPart = BodyPart.valueOf(bodyPart);
        }
        catch(IllegalArgumentException e) {
            throw new ProjectException("Protector.bodyPart = " + bodyPart
                    + " is unnoun.");
        }  
    }
    
    public String getBodyPart() {
        return bodyPart.toString();
    }
    
    
}
