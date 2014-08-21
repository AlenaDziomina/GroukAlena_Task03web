/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;


import by.epam.task03.exeption.LogicException;
import by.epam.task03.exeption.NullInitException;
import by.epam.task03.entity.MotoEquipment;
import static by.epam.task03web.controller.ParsServlet.localLog;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;



/**
 *
 * @author Helena.Grouk
 */
public class EquipFactory {
    
    private static final String PATH = MotoEquipment.class.getPackage().getName();
    
    public static MotoEquipment equipmentCreator(String[]... args) throws NullInitException, LogicException {
        
        String className = findClassName(args);
        int id = findId(args);
        String name = findName(args);
        
        MotoEquipment newEq = buildEquip(className, id, name);      
            
        for (String[] arg : args){    
            if (!"class".equals(arg[0]) && !"name".equals(arg[0])  && !"id".equals(arg[0])) {
                try {
                    setProperties(newEq, arg);
                } catch (NullInitException | LogicException ex) {
                    localLog.error("Set equip property fail.");
                }
            }
        }
            
        return newEq;
    }
    
    private static String findClassName(String[]... args) throws NullInitException {
        
        for (String[] arg : args) {
            if ("class".equals(arg[0]) && arg.length >= 2) {
                return arg[1];
            }
        }
        throw new NullInitException("EquipFactory: can't find class "+args[0][0] +"."); 
    }
    
    private static int findId(String[]... args) throws NullInitException {
        for (String[] arg : args) {
            if ("id".equals(arg[0]) && arg.length >= 2) {
                return Integer.parseInt(arg[1]);
            }
        }
        throw new NullInitException("EquipFactory: can't find id.");
    }

    private static String findName(String[][] args) throws NullInitException {
        for (String[] arg : args) {
            if ("name".equals(arg[0]) && arg.length >= 2) {
                return arg[1];
            }
        }
        throw new NullInitException("EquipFactory: can't find name.");
    }

        
    private static MotoEquipment buildEquip(String className, int objId, String objName) throws NullInitException, LogicException {

        if (className == null || className.isEmpty()) {
                throw new NullInitException("BuildObj: className == null or emoty.");
        }
        
        try {    
            Class < ? extends MotoEquipment> cl = (Class < ? extends MotoEquipment>) Class.forName(PATH + "." + className);
            Constructor<?> constr = cl.getConstructor(int.class, String.class);
            MotoEquipment newEq = (MotoEquipment) constr.newInstance(objId, objName);
            return newEq;
        } catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new LogicException("Built equip object fail.", ex);
        }
    }
    
    private static void setProperties(MotoEquipment obj, String[] arg) throws NullInitException, LogicException {
        
        
        if(arg == null || arg.length < 3) {
            throw new NullInitException("SetProperties: arg == null.");
        }
        
        Object val = factoryConvertor(arg[1], arg[2]);
        Class<? extends MotoEquipment> cl = obj.getClass();
        Class<?> type = val.getClass();
        StringBuilder metName = new StringBuilder("set");
        metName.append(arg[0].substring(0, 1).toUpperCase());
        metName.append(arg[0].substring(1));
        
        try {
            Method met = cl.getMethod(metName.toString(), type);
            met.invoke(obj, val);
        } catch (NoSuchMethodException | SecurityException | IllegalAccessException | IllegalArgumentException | InvocationTargetException ex) {
            throw new LogicException("SetProperties: can't set property " + Arrays.toString(arg), ex);
        }
        
        

    }

    private static Object factoryConvertor(String var, String valType) throws NullInitException {
        
        if (valType == null || valType.isEmpty() || var == null || var.isEmpty()) {
            throw new NullInitException("FactoryConvertor: property += null or empty.");
        }
        
        valType = valType.toLowerCase();
        switch (valType) {
            case "string": {
                return var;
            }
            case "int": {
                return Integer.parseInt(var);
            }
            case "float": {
                return Float.parseFloat(var);
            }
            case "boolean": {
                return Boolean.parseBoolean(var);
            }
            default: {
                return null;
            }
        }
    }
    
}
