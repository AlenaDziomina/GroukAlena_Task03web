/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import by.epam.task03.exeption.ProjectException;
import static by.epam.task03web.controller.ParsServlet.localLog;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author Helena.Grouk
 */
public class EquippedMotorcyclist {
    
    private Helmet helmet;
    private Shoes shoes;
    private Jacket jacket;
    private Pants pants;
    private List<AdditionalEquip> addEquip;
    private List<SpecialMotoEquipment> specEquip;
    
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
        
        EquippedMotorcyclist eq = (EquippedMotorcyclist)obj;
        if (!super.equals(eq)){
            return false;
        }
        if(! helmet.equals(eq.helmet)) {
            return false;
        }
        if(! jacket.equals(eq.jacket)) {
            return false;
        }
        if(! pants.equals(eq.pants)) {
            return false;
        }
        if(! shoes.equals(eq.shoes)) {
            return false;
        }
        if(! addEquip.equals(eq.addEquip)) {
            return false;
        }
        if(! specEquip.equals(eq.specEquip)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 97 * hash + Objects.hashCode(this.helmet);
        hash = 97 * hash + Objects.hashCode(this.shoes);
        hash = 97 * hash + Objects.hashCode(this.jacket);
        hash = 97 * hash + Objects.hashCode(this.pants);
        hash = 97 * hash + Objects.hashCode(this.addEquip);
        hash = 97 * hash + Objects.hashCode(this.specEquip);
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
        str.append(", helmet: ");
        str.append(helmet.toString());
        str.append(", shoes: ");
        str.append(shoes.toString());
        str.append(", jacket: ");
        str.append(jacket.toString());
        str.append(", pants: ");
        str.append(pants.toString());
        str.append(", addEquip: ");
        if (addEquip != null){
            str.append(addEquip.toString());
        } else {
            str.append("null");
        }
        str.append(", specEquip: ");
        if (specEquip != null) {
            str.append(specEquip.toString());
        } else {
            str.append("null");
        }
        
        return str.toString();
    }
    
    public EquippedMotorcyclist() { }
    
    public EquippedMotorcyclist(MotoEquipment... equip) {
        
        for (MotoEquipment eq : equip) {
            try {
                setEquip(eq);
            } catch (IllegalArgumentException ex) {
                localLog.error("EquippedMotorcyclist: can't setEquip.");
            }
        }
    }

    public void setHelmet(Helmet helmet) throws ProjectException {
        if (helmet == null) {
            throw new ProjectException("EquippedMotorcyclist.setHelmet: helmet == null");
        }
        this.helmet = helmet;
    }
    
    public Helmet getHelmet() {
        return this.helmet;
    }

    public void setShoes(Shoes shoes) {
        this.shoes = shoes;
    }
    
    public Shoes getShoes(){
        return this.shoes;
    }
    
    public void setJacket(Jacket jacket) {
        this.jacket = jacket;  
    }

    public Jacket getJacket() {
        return this.jacket;
    }
    
    public void setPants(Pants pants) {
        this.pants = pants;
    }

    public Pants getPants() {
        return this.pants;
    }
     
    public void setEquip(MotoEquipment eq) {
        
        String clName = eq.getClass().getSimpleName();
        StringBuilder metName = new StringBuilder("set");
        metName.append(clName.substring(0, 1).toUpperCase());
        metName.append(clName.substring(1));
        
        try {   
            Method met = this.getClass().getMethod(metName.toString(),
                    eq.getClass());
            met.invoke(this, eq);
        } catch (NoSuchMethodException | SecurityException
                    | IllegalAccessException | IllegalArgumentException
                    | InvocationTargetException ex) {
            localLog.error("EquippedMotorcyclist: can't setEquip.");
        }
        
    }

    public int getPrice() {
        int price = helmet.getPrice() + shoes.getPrice()+ jacket.getPrice()
                + pants.getPrice();
        if (specEquip != null) {
            price = specEquip.stream().map((eq) -> eq.getPrice())
                    .reduce(price, Integer::sum);
        }
        if (addEquip != null) {
            price = addEquip.stream().map((eq) -> eq.getPrice())
                    .reduce(price, Integer::sum);
        }
        return price;
    }
   
}
