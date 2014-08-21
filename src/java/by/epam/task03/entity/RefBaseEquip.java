/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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
    "listForWhat"
})
@XmlRootElement(name = "for-what")
public class RefBaseEquip {
    @XmlAnyElement
    private Set<BaseMotoEquipment> listForWhat;

    public RefBaseEquip() {
        this.listForWhat = new TreeSet<>();
    }
    
    public void add(BaseMotoEquipment eq) {
        this.listForWhat.add(eq);
    }
    
    public List getListForWhat() {
        return Collections.unmodifiableList(new ArrayList(listForWhat));
    }
}
