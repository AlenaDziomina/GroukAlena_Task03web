/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package by.epam.task03.logic;

import by.epam.task03.exeption.NullInitException;
import by.epam.task03.entity.MotoEquip;

/**
 *
 * @author Helena.Grouk
 */
public abstract class AbstractEquipBuilder {

    protected MotoEquip equip;
    
    public AbstractEquipBuilder() {
        equip = new MotoEquip();
    }
    public AbstractEquipBuilder(MotoEquip equip) {
        this.equip = equip;
    }
    public MotoEquip getEquip() {
        return equip;
    }
    abstract public void buildSetEquip(String fileName) throws NullInitException;
    
    protected enum EquipEnum {
        ARMOR_JACKET("ArmorJacket"),
        BALACLAVA("Balaclava"), 
        ELBOW_PROTECTOR("ElbowProtector"), 
        GLOVES("Gloves"), 
        HELMET("Helmet"), 
        JACKET("Jacket"),
        KNEE_PROTECTOR("KneeProtector"),
        PANTS("Pants"), 
        PROTECTOR_INSERT("ProtectorInsert"), 
        SHOES("Shoes"),
        SLICKER("Slicker"),
        SLIDERS("Sliders"),
        TERMOLINEN("Termolinen"),
        VISOR("Visor");
        private final String cl;
        private EquipEnum(String cl) {
            this.cl = cl;
        }
        public String getCl() {
            return this.cl;
        }
    }
    
    protected enum PropEnum {
        ID("id", "", "int"),
        NAME("name", "", "String"),
        MANUFACTURER("manufacturer", "", "String"),
        PRICE("price", "", "int"),
        WEIGHT("weight", "", "float"),
        BASE_MATERIAL("baseMaterial", "", "String"),
        SIZE("size", "", "String"),
        GENDER_STYLE("genderStyle", "", "String"),
        MOTO_TYPE("motoType", "", "String"),
        SEASON("season", "", "String"),
        PROTECTION_MATERIAL("protectionMaterial", "", "String"),
        WATERPROOF("waterproof", "", "boolean"),
        PERFORATION("perforation", "", "boolean"),
        INSULATION("insulation", "", "boolean"),
        BACK_INSERT("backInsert", "", "boolean"),
        ELBOWS_INSERT("elbowsInsert", "", "boolean"),
        SHOWLDERS_INSERT("showldersInsert", "", "boolean"),
        HIP_INSERT("hipInsert", "", "boolean"),
        KNEE_INSERT("kneeInsert", "", "boolean"),
        SLIDER_MOUNT("sliderMount", "", "boolean"),
        PALM_PROTECT("palmProtect", "", "boolean"),
        FINGERS_PROTECT("fingersProtect", "", "boolean"),
        KNUCKLES_PROTECT("knucklesProtect", "", "boolean"),
        BACK_PROTECT("backProtect", "", "boolean"),
        CHEST_PROTECT("chestProtect", "", "boolean"),
        ELBOWS_PROTECT("elbowsProtect", "", "boolean"),
        SHOWLDERS_PROTECT("showldersProtect", "", "boolean"),
        ARTICULATED("articulated", "", "boolean"),
        MOUNT_TYPE("mountType", "", "String"),
        HELMET_TYPE("helmetType", "", "String"),
        SHELL_MATERIAL("shellMaterial", "", "String"),
        INSERT_MATERIAL("insertMaterial", "", "String"),
        VENTS("vents", "", "int"),
        SUN_VISOR("sunVisor", "", "boolean"),
        HEADSET_CONNECTOR("headsetConnector", "", "boolean"),
        ADMISSION_GP("admissionGp", "", "boolean"),
        SOLE_MATERIAL("soleMaterial", "", "String"),
        //FOR_WHAT("forWhat", "", "String"),
        BODY_PART("bodyPart", "", "String"),
        HAS_PICTURE("hasPicture", "", "boolean"),
        antifog("antifog", "", "boolean"),
        ANTIBLICK("antiblick", "", "boolean"),
        PINLOCK("pinlock", "", "boolean"),
        CLOTHES_TYPE("clothesType", "", "String"),
        ELASTIC("elastic", "", "boolean"),
        SEAMLESS("seamless", "", "boolean"),
        SEPARATE("separate", "", "boolean"),
        FLUORESCENT("fluorescent", "", "boolean"),
        HOOD("hood", "", "boolean")
        ;
        private final String[] nvt;
        private PropEnum(String n, String v, String t) {
            this.nvt = new String[] {n,v,t};
        }
        public String[] getProp() {
            return this.nvt;
        }
    }
}
