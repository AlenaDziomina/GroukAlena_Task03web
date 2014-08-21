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
@XmlType(name = "Visor", propOrder = {
    "antiblick",
    "antifog",
    "pinlock"
})
@XmlRootElement
public class Visor extends SpecialMotoEquipment { //визор
    
    private boolean antifog;
    private boolean antiblick;
    private boolean pinlock;
    
    public Visor(){}
    
    public Visor(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    public Visor(int id, String name, int price, float weight)
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
        
        Visor eq = (Visor)obj;
        if (!super.equals(eq)){
            return false;
        }
        
        if(antifog != eq.antifog) {
            return false;
        }
        
        if(antiblick != eq.antiblick) {
            return false;
        }
        if(pinlock != eq.pinlock) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + (this.antifog ? 1 : 0);
        hash = 79 * hash + (this.antiblick ? 1 : 0);
        hash = 79 * hash + (this.pinlock ? 1 : 0);
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
        str.append(", antifog: ");
        str.append(antifog);
        str.append(", antiblick: ");
        str.append(antiblick);
        str.append(", pinlock: ");
        str.append(pinlock);
        
        return str.toString();
    }
      
    public void setAntifog(Boolean antifog) {
        this.antifog = antifog;
    }
    
    public boolean isAntifog() {
        return this.antifog;
    }
    
    public void setAntiblick(Boolean antiblick) {
        this.antiblick = antiblick;
    }
    
    public boolean isAntiblick() {
        return this.antiblick;
    }
    
    public void setPinlock(Boolean pinlock) {
        this.pinlock = pinlock;
    }
    
    public boolean isPinlock() {
        return this.pinlock;
    }
}
