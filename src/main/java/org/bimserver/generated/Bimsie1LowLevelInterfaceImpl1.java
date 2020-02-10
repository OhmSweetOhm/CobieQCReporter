//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import org.bimserver.interfaces.objects.SDataObject;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1LowLevelInterfaceImpl1 implements Bimsie1LowLevelInterface {
    Reflector reflector;

    public Bimsie1LowLevelInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public void abortTransaction(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "abortTransaction", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1)});
    }

    public void addBooleanAttribute(Long var1, Long var2, String var3, Boolean var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "addBooleanAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void addDoubleAttribute(Long var1, Long var2, String var3, Double var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "addDoubleAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void addIntegerAttribute(Long var1, Long var2, String var3, Integer var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "addIntegerAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void addReference(Long var1, Long var2, String var3, Long var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "addReference", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3), new KeyValuePair("referenceOid", var4)});
    }

    public void addStringAttribute(Long var1, Long var2, String var3, String var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "addStringAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public Long commitTransaction(Long var1, String var2) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1LowLevelInterface", "commitTransaction", Long.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("comment", var2)});
    }

    public Integer count(Long var1, String var2) throws Exception {
        return (Integer)this.reflector.callMethod("Bimsie1LowLevelInterface", "count", Integer.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("className", var2)});
    }

    public Long createObject(Long var1, String var2, Boolean var3) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1LowLevelInterface", "createObject", Long.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("className", var2), new KeyValuePair("generateGuid", var3)});
    }

    public Boolean getBooleanAttribute(Long var1, Long var2, String var3) throws Exception {
        return (Boolean)this.reflector.callMethod("Bimsie1LowLevelInterface", "getBooleanAttribute", Boolean.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public Boolean getBooleanAttributeAtIndex(Long var1, Long var2, String var3, Integer var4) throws Exception {
        return (Boolean)this.reflector.callMethod("Bimsie1LowLevelInterface", "getBooleanAttributeAtIndex", Boolean.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4)});
    }

    public List getBooleanAttributes(Long var1, Long var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getBooleanAttributes", List.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public byte[] getByteArrayAttribute(Long var1, Long var2, String var3) throws Exception {
        return (byte[])this.reflector.callMethod("Bimsie1LowLevelInterface", "getByteArrayAttribute", byte[].class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public List getByteArrayAttributes(Long var1, Long var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getByteArrayAttributes", List.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public SDataObject getDataObjectByGuid(Long var1, String var2) throws Exception {
        return (SDataObject)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDataObjectByGuid", SDataObject.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("guid", var2)});
    }

    public SDataObject getDataObjectByOid(Long var1, Long var2) throws Exception {
        return (SDataObject)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDataObjectByOid", SDataObject.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("oid", var2)});
    }

    public List getDataObjects(Long var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDataObjects", List.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public List getDataObjectsByType(Long var1, String var2, String var3, Boolean var4) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDataObjectsByType", List.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("packageName", var2), new KeyValuePair("className", var3), new KeyValuePair("flat", var4)});
    }

    public Double getDoubleAttribute(Long var1, Long var2, String var3) throws Exception {
        return (Double)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDoubleAttribute", Double.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public Double getDoubleAttributeAtIndex(Long var1, Long var2, String var3, Integer var4) throws Exception {
        return (Double)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDoubleAttributeAtIndex", Double.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4)});
    }

    public List getDoubleAttributes(Long var1, Long var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getDoubleAttributes", List.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public String getEnumAttribute(Long var1, Long var2, String var3) throws Exception {
        return (String)this.reflector.callMethod("Bimsie1LowLevelInterface", "getEnumAttribute", String.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public Integer getIntegerAttribute(Long var1, Long var2, String var3) throws Exception {
        return (Integer)this.reflector.callMethod("Bimsie1LowLevelInterface", "getIntegerAttribute", Integer.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public Integer getIntegerAttributeAtIndex(Long var1, Long var2, String var3, Integer var4) throws Exception {
        return (Integer)this.reflector.callMethod("Bimsie1LowLevelInterface", "getIntegerAttributeAtIndex", Integer.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4)});
    }

    public List getIntegerAttributes(Long var1, Long var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getIntegerAttributes", List.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public Long getLongAttribute(Long var1, Long var2, String var3) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1LowLevelInterface", "getLongAttribute", Long.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public Long getLongAttributeAtIndex(Long var1, Long var2, String var3, Integer var4) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1LowLevelInterface", "getLongAttributeAtIndex", Long.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4)});
    }

    public Long getReference(Long var1, Long var2, String var3) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1LowLevelInterface", "getReference", Long.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3)});
    }

    public List getReferences(Long var1, Long var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getReferences", List.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3)});
    }

    public String getStringAttribute(Long var1, Long var2, String var3) throws Exception {
        return (String)this.reflector.callMethod("Bimsie1LowLevelInterface", "getStringAttribute", String.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public List getStringAttributes(Long var1, Long var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1LowLevelInterface", "getStringAttributes", List.class, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public void removeAllReferences(Long var1, Long var2, String var3) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "removeAllReferences", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3)});
    }

    public void removeAttribute(Long var1, Long var2, String var3, Integer var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "removeAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4)});
    }

    public void removeObject(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "removeObject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2)});
    }

    public void removeReference(Long var1, Long var2, String var3, Integer var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "removeReference", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3), new KeyValuePair("index", var4)});
    }

    public void removeReferenceByOid(Long var1, Long var2, String var3, Long var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "removeReferenceByOid", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3), new KeyValuePair("referencedOid", var4)});
    }

    public void setBooleanAttribute(Long var1, Long var2, String var3, Boolean var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setBooleanAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setBooleanAttributeAtIndex(Long var1, Long var2, String var3, Integer var4, Boolean var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setBooleanAttributeAtIndex", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4), new KeyValuePair("value", var5)});
    }

    public void setBooleanAttributes(Long var1, Long var2, String var3, List var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setBooleanAttributes", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("values", var4)});
    }

    public void setByteArrayAttribute(Long var1, Long var2, String var3, Byte[] var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setByteArrayAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setDoubleAttribute(Long var1, Long var2, String var3, Double var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setDoubleAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setDoubleAttributeAtIndex(Long var1, Long var2, String var3, Integer var4, Double var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setDoubleAttributeAtIndex", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4), new KeyValuePair("value", var5)});
    }

    public void setDoubleAttributes(Long var1, Long var2, String var3, List var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setDoubleAttributes", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("values", var4)});
    }

    public void setEnumAttribute(Long var1, Long var2, String var3, String var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setEnumAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setIntegerAttribute(Long var1, Long var2, String var3, Integer var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setIntegerAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setIntegerAttributeAtIndex(Long var1, Long var2, String var3, Integer var4, Integer var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setIntegerAttributeAtIndex", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4), new KeyValuePair("value", var5)});
    }

    public void setIntegerAttributes(Long var1, Long var2, String var3, List var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setIntegerAttributes", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("values", var4)});
    }

    public void setLongAttribute(Long var1, Long var2, String var3, Long var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setLongAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setLongAttributeAtIndex(Long var1, Long var2, String var3, Integer var4, Long var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setLongAttributeAtIndex", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4), new KeyValuePair("value", var5)});
    }

    public void setLongAttributes(Long var1, Long var2, String var3, List var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setLongAttributes", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("values", var4)});
    }

    public void setReference(Long var1, Long var2, String var3, Long var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setReference", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3), new KeyValuePair("referenceOid", var4)});
    }

    public void setStringAttribute(Long var1, Long var2, String var3, String var4) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setStringAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("value", var4)});
    }

    public void setStringAttributeAtIndex(Long var1, Long var2, String var3, Integer var4, String var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setStringAttributeAtIndex", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("index", var4), new KeyValuePair("value", var5)});
    }

    public void setWrappedBooleanAttribute(Long var1, Long var2, String var3, String var4, Boolean var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setWrappedBooleanAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("type", var4), new KeyValuePair("value", var5)});
    }

    public void setWrappedDoubleAttribute(Long var1, Long var2, String var3, String var4, Double var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setWrappedDoubleAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("type", var4), new KeyValuePair("value", var5)});
    }

    public void setWrappedIntegerAttribute(Long var1, Long var2, String var3, String var4, Integer var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setWrappedIntegerAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("type", var4), new KeyValuePair("value", var5)});
    }

    public void setWrappedLongAttribute(Long var1, Long var2, String var3, String var4, Long var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setWrappedLongAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("type", var4), new KeyValuePair("value", var5)});
    }

    public void setWrappedStringAttribute(Long var1, Long var2, String var3, String var4, String var5) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "setWrappedStringAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3), new KeyValuePair("type", var4), new KeyValuePair("value", var5)});
    }

    public Long startTransaction(Long var1) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1LowLevelInterface", "startTransaction", Long.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public void unsetAttribute(Long var1, Long var2, String var3) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "unsetAttribute", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("attributeName", var3)});
    }

    public void unsetReference(Long var1, Long var2, String var3) throws Exception {
        this.reflector.callMethod("Bimsie1LowLevelInterface", "unsetReference", Void.TYPE, new KeyValuePair[]{new KeyValuePair("tid", var1), new KeyValuePair("oid", var2), new KeyValuePair("referenceName", var3)});
    }
}
