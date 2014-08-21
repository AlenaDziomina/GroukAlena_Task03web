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
@XmlType(name = "AdditionalEquip", propOrder = {
    "season"
})
@XmlSeeAlso({
    Slicker.class,
    Termolinen.class,
    Balaclava.class
})

public abstract class AdditionalEquip extends BaseMotoEquipment{ 
    //дополнительная экипировка
    
    private enum Season {SPRING, SUMMER, AUTUMN, WINTER}
    
    @XmlElement(required = true)
    private Season season; //сезон применения
    
    protected AdditionalEquip(){}
    
    protected AdditionalEquip(int id, String name) throws ProjectException {
        super(id, name);
    }
    
    protected AdditionalEquip(int id, String name, int price, float weight)
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
        
        AdditionalEquip eq = (AdditionalEquip)obj;
        if (!super.equals(eq)){
            return false;
        }
        
        return season == eq.season;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 71 * hash + Objects.hashCode(this.season);
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
        str.append(", season: ");
        str.append(season);
        return str.toString();
    }
    
    public void setSeason(String season) throws ProjectException {
        if (season == null || season.isEmpty()) {
            throw new ProjectException("AdditionalEquip.Season == null or empty.");
        }
        try {
            this.season = Season.valueOf(season);
        }
        catch(IllegalArgumentException e) {
            throw new ProjectException("AdditionalEquip.Season = " + season
                    + " is unnoun.");
        }  
    }
    
    public String getSeason() {
        return this.season.toString();
    }
}
