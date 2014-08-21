/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.exeption.NullInitException;
import by.epam.task03.exeption.ValidatingException;
import org.apache.commons.lang3.EnumUtils;

/**
 *
 * @author Helena.Grouk
 */
public abstract class EquipBuilderFactory {
    
    private enum TypeParser { SAX, STAX, DOM }
    public static AbstractEquipBuilder createStudentBuilder(String typeParser) throws NullInitException, ValidatingException {
        if (EnumUtils.isValidEnum(TypeParser.class, typeParser.toUpperCase())) {
            TypeParser type = TypeParser.valueOf(typeParser.toUpperCase());
            switch (type) {
                case DOM: return new EquipDomBuilder();
                case STAX: return new EquipStaxBuilder();
                case SAX: return new EquipSaxBuilder();
                default: throw new EnumConstantNotPresentException(type.getDeclaringClass(),type.name());
            }
        } else {
            throw new ValidatingException("Select SAX, StAX or DOM parser.");
        }
        
    }
}
