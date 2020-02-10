//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import java.util.Set;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SMessagingSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectDefinition;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SPluginDescriptor;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginDescriptor;
import org.bimserver.interfaces.objects.SWebModulePluginConfiguration;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class PluginInterfaceImpl1 implements PluginInterface {
    Reflector reflector;

    public PluginInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public void addDeserializer(SDeserializerPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addDeserializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("deserializer", var1)});
    }

    public void addInternalService(SInternalServicePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addInternalService", Void.TYPE, new KeyValuePair[]{new KeyValuePair("internalService", var1)});
    }

    public void addModelCompare(SModelComparePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addModelCompare", Void.TYPE, new KeyValuePair[]{new KeyValuePair("modelCompare", var1)});
    }

    public void addModelMerger(SModelMergerPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addModelMerger", Void.TYPE, new KeyValuePair[]{new KeyValuePair("modelMerger", var1)});
    }

    public void addObjectIDM(SObjectIDMPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addObjectIDM", Void.TYPE, new KeyValuePair[]{new KeyValuePair("objectIDM", var1)});
    }

    public void addQueryEngine(SQueryEnginePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addQueryEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("queryEngine", var1)});
    }

    public void addRenderEngine(SRenderEnginePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addRenderEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("renderEngine", var1)});
    }

    public void addSerializer(SSerializerPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "addSerializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("serializer", var1)});
    }

    public void deleteDeserializer(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteDeserializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sid", var1)});
    }

    public void deleteInternalService(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteInternalService", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void deleteModelChecker(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteModelChecker", Void.TYPE, new KeyValuePair[]{new KeyValuePair("iid", var1)});
    }

    public void deleteModelCompare(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteModelCompare", Void.TYPE, new KeyValuePair[]{new KeyValuePair("iid", var1)});
    }

    public void deleteModelMerger(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteModelMerger", Void.TYPE, new KeyValuePair[]{new KeyValuePair("iid", var1)});
    }

    public void deleteObjectIDM(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteObjectIDM", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void deleteQueryEngine(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteQueryEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("iid", var1)});
    }

    public void deleteRenderEngine(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteRenderEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("iid", var1)});
    }

    public void deleteSerializer(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "deleteSerializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sid", var1)});
    }

    public List getAllDeserializerPluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllDeserializerPluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllDeserializers(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllDeserializers", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllDeserializersForProject(Boolean var1, Long var2) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllDeserializersForProject", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1), new KeyValuePair("poid", var2)});
    }

    public List getAllInternalServices(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllInternalServices", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllModelCheckerPluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllModelCheckerPluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllModelComparePluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllModelComparePluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllModelCompares(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllModelCompares", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllModelMergerPluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllModelMergerPluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllModelMergers(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllModelMergers", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllObjectIDMPluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllObjectIDMPluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllObjectIDMs(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllObjectIDMs", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllQueryEnginePluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllQueryEnginePluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllQueryEngines(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllQueryEngines", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllRenderEnginePluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllRenderEnginePluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllRenderEngines(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllRenderEngines", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllSerializerPluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllSerializerPluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllSerializers(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllSerializers", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public List getAllSerializersForRoids(Boolean var1, Set var2) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllSerializersForRoids", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1), new KeyValuePair("roids", var2)});
    }

    public List getAllServicePluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllServicePluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllWebModulePluginDescriptors() throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllWebModulePluginDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllWebModules(Boolean var1) throws Exception {
        return (List)this.reflector.callMethod("PluginInterface", "getAllWebModules", List.class, new KeyValuePair[]{new KeyValuePair("onlyEnabled", var1)});
    }

    public SModelComparePluginConfiguration getDefaultModelCompare() throws Exception {
        return (SModelComparePluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultModelCompare", SModelComparePluginConfiguration.class, new KeyValuePair[0]);
    }

    public SModelMergerPluginConfiguration getDefaultModelMerger() throws Exception {
        return (SModelMergerPluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultModelMerger", SModelMergerPluginConfiguration.class, new KeyValuePair[0]);
    }

    public SObjectIDMPluginConfiguration getDefaultObjectIDM() throws Exception {
        return (SObjectIDMPluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultObjectIDM", SObjectIDMPluginConfiguration.class, new KeyValuePair[0]);
    }

    public SQueryEnginePluginConfiguration getDefaultQueryEngine() throws Exception {
        return (SQueryEnginePluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultQueryEngine", SQueryEnginePluginConfiguration.class, new KeyValuePair[0]);
    }

    public SRenderEnginePluginConfiguration getDefaultRenderEngine() throws Exception {
        return (SRenderEnginePluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultRenderEngine", SRenderEnginePluginConfiguration.class, new KeyValuePair[0]);
    }

    public SSerializerPluginConfiguration getDefaultSerializer() throws Exception {
        return (SSerializerPluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultSerializer", SSerializerPluginConfiguration.class, new KeyValuePair[0]);
    }

    public SWebModulePluginConfiguration getDefaultWebModule() throws Exception {
        return (SWebModulePluginConfiguration)this.reflector.callMethod("PluginInterface", "getDefaultWebModule", SWebModulePluginConfiguration.class, new KeyValuePair[0]);
    }

    public SInternalServicePluginConfiguration getInternalServiceById(Long var1) throws Exception {
        return (SInternalServicePluginConfiguration)this.reflector.callMethod("PluginInterface", "getInternalServiceById", SInternalServicePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SMessagingSerializerPluginConfiguration getMessagingSerializerByPluginClassName(String var1) throws
                                                                                                        Exception {
        return (SMessagingSerializerPluginConfiguration)this.reflector.callMethod("PluginInterface", "getMessagingSerializerByPluginClassName", SMessagingSerializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("pluginClassName", var1)});
    }

    public SModelComparePluginConfiguration getModelCompareById(Long var1) throws Exception {
        return (SModelComparePluginConfiguration)this.reflector.callMethod("PluginInterface", "getModelCompareById", SModelComparePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SModelComparePluginConfiguration getModelCompareByName(String var1) throws Exception {
        return (SModelComparePluginConfiguration)this.reflector.callMethod("PluginInterface", "getModelCompareByName", SModelComparePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public SModelMergerPluginConfiguration getModelMergerById(Long var1) throws Exception {
        return (SModelMergerPluginConfiguration)this.reflector.callMethod("PluginInterface", "getModelMergerById", SModelMergerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SModelMergerPluginConfiguration getModelMergerByName(String var1) throws Exception {
        return (SModelMergerPluginConfiguration)this.reflector.callMethod("PluginInterface", "getModelMergerByName", SModelMergerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public SObjectIDMPluginConfiguration getObjectIDMById(Long var1) throws Exception {
        return (SObjectIDMPluginConfiguration)this.reflector.callMethod("PluginInterface", "getObjectIDMById", SObjectIDMPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SObjectIDMPluginConfiguration getObjectIDMByName(String var1) throws Exception {
        return (SObjectIDMPluginConfiguration)this.reflector.callMethod("PluginInterface", "getObjectIDMByName", SObjectIDMPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("objectIDMName", var1)});
    }

    public SPluginDescriptor getPluginDescriptor(Long var1) throws Exception {
        return (SPluginDescriptor)this.reflector.callMethod("PluginInterface", "getPluginDescriptor", SPluginDescriptor.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SObjectDefinition getPluginObjectDefinition(Long var1) throws Exception {
        return (SObjectDefinition)this.reflector.callMethod("PluginInterface", "getPluginObjectDefinition", SObjectDefinition.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SObjectType getPluginSettings(Long var1) throws Exception {
        return (SObjectType)this.reflector.callMethod("PluginInterface", "getPluginSettings", SObjectType.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public SRenderEnginePluginConfiguration getRenderEngineById(Long var1) throws Exception {
        return (SRenderEnginePluginConfiguration)this.reflector.callMethod("PluginInterface", "getRenderEngineById", SRenderEnginePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SRenderEnginePluginConfiguration getRenderEngineByName(String var1) throws Exception {
        return (SRenderEnginePluginConfiguration)this.reflector.callMethod("PluginInterface", "getRenderEngineByName", SRenderEnginePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public SSerializerPluginConfiguration getSerializerByPluginClassName(String var1) throws Exception {
        return (SSerializerPluginConfiguration)this.reflector.callMethod("PluginInterface", "getSerializerByPluginClassName", SSerializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("pluginClassName", var1)});
    }

    public SSerializerPluginDescriptor getSerializerPluginDescriptor(String var1) throws Exception {
        return (SSerializerPluginDescriptor)this.reflector.callMethod("PluginInterface", "getSerializerPluginDescriptor", SSerializerPluginDescriptor.class, new KeyValuePair[]{new KeyValuePair("type", var1)});
    }

    public SWebModulePluginConfiguration getWebModuleById(Long var1) throws Exception {
        return (SWebModulePluginConfiguration)this.reflector.callMethod("PluginInterface", "getWebModuleById", SWebModulePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SWebModulePluginConfiguration getWebModuleByName(String var1) throws Exception {
        return (SWebModulePluginConfiguration)this.reflector.callMethod("PluginInterface", "getWebModuleByName", SWebModulePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public Boolean hasActiveSerializer(String var1) throws Exception {
        return (Boolean)this.reflector.callMethod("PluginInterface", "hasActiveSerializer", Boolean.class, new KeyValuePair[]{new KeyValuePair("contentType", var1)});
    }

    public void setDefaultModelCompare(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultModelCompare", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setDefaultModelMerger(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultModelMerger", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setDefaultObjectIDM(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultObjectIDM", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setDefaultQueryEngine(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultQueryEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setDefaultRenderEngine(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultRenderEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setDefaultSerializer(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultSerializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setDefaultWebModule(Long var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "setDefaultWebModule", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public void setPluginSettings(Long var1, SObjectType var2) throws Exception {
        this.reflector.callMethod("PluginInterface", "setPluginSettings", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("settings", var2)});
    }

    public void updateDeserializer(SDeserializerPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateDeserializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("deserializer", var1)});
    }

    public void updateInternalService(SInternalServicePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateInternalService", Void.TYPE, new KeyValuePair[]{new KeyValuePair("internalService", var1)});
    }

    public void updateModelCompare(SModelComparePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateModelCompare", Void.TYPE, new KeyValuePair[]{new KeyValuePair("modelCompare", var1)});
    }

    public void updateModelMerger(SModelMergerPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateModelMerger", Void.TYPE, new KeyValuePair[]{new KeyValuePair("modelMerger", var1)});
    }

    public void updateObjectIDM(SObjectIDMPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateObjectIDM", Void.TYPE, new KeyValuePair[]{new KeyValuePair("objectIDM", var1)});
    }

    public void updateQueryEngine(SQueryEnginePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateQueryEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("queryEngine", var1)});
    }

    public void updateRenderEngine(SRenderEnginePluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateRenderEngine", Void.TYPE, new KeyValuePair[]{new KeyValuePair("renderEngine", var1)});
    }

    public void updateSerializer(SSerializerPluginConfiguration var1) throws Exception {
        this.reflector.callMethod("PluginInterface", "updateSerializer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("serializer", var1)});
    }
}
