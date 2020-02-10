//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import java.util.Set;
import javax.activation.DataHandler;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SDownloadResult;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SProjectSmall;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1ServiceInterfaceImpl1 implements Bimsie1ServiceInterface {
    Reflector reflector;

    public Bimsie1ServiceInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public void addExtendedDataToRevision(Long var1, SExtendedData var2) throws Exception {
        this.reflector.callMethod("Bimsie1ServiceInterface", "addExtendedDataToRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("extendedData", var2)});
    }

    public SProject addProject(String var1, String var2) throws Exception {
        return (SProject)this.reflector.callMethod("Bimsie1ServiceInterface", "addProject", SProject.class, new KeyValuePair[]{new KeyValuePair("projectName", var1), new KeyValuePair("schema", var2)});
    }

    public SProject addProjectAsSubProject(String var1, Long var2, String var3) throws Exception {
        return (SProject)this.reflector.callMethod("Bimsie1ServiceInterface", "addProjectAsSubProject", SProject.class, new KeyValuePair[]{new KeyValuePair("projectName", var1), new KeyValuePair("parentPoid", var2), new KeyValuePair("schema", var3)});
    }

    public Long branchToExistingProject(Long var1, Long var2, String var3, Boolean var4) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "branchToExistingProject", Long.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("destPoid", var2), new KeyValuePair("comment", var3), new KeyValuePair("sync", var4)});
    }

    public Long branchToNewProject(Long var1, String var2, String var3, Boolean var4) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "branchToNewProject", Long.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("projectName", var2), new KeyValuePair("comment", var3), new KeyValuePair("sync", var4)});
    }

    public Long checkin(Long var1, String var2, Long var3, Long var4, String var5, DataHandler var6, Boolean var7) throws
                                                                                                                   Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "checkin", Long.class, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("comment", var2), new KeyValuePair("deserializerOid", var3), new KeyValuePair("fileSize", var4), new KeyValuePair("fileName", var5), new KeyValuePair("data", var6), new KeyValuePair("sync", var7)});
    }

    public Long checkinFromUrl(Long var1, String var2, Long var3, String var4, String var5, Boolean var6) throws
                                                                                                          Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "checkinFromUrl", Long.class, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("comment", var2), new KeyValuePair("deserializerOid", var3), new KeyValuePair("fileName", var4), new KeyValuePair("url", var5), new KeyValuePair("sync", var6)});
    }

    public Long checkout(Long var1, Long var2, Boolean var3) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "checkout", Long.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("serializerOid", var2), new KeyValuePair("sync", var3)});
    }

    public Boolean deleteProject(Long var1) throws Exception {
        return (Boolean)this.reflector.callMethod("Bimsie1ServiceInterface", "deleteProject", Boolean.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public Long download(Long var1, Long var2, Boolean var3, Boolean var4) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "download", Long.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("serializerOid", var2), new KeyValuePair("showOwn", var3), new KeyValuePair("sync", var4)});
    }

    public Long downloadByGuids(Set var1, Set var2, Long var3, Boolean var4, Boolean var5) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadByGuids", Long.class, new KeyValuePair[]{new KeyValuePair("roids", var1), new KeyValuePair("guids", var2), new KeyValuePair("serializerOid", var3), new KeyValuePair("deep", var4), new KeyValuePair("sync", var5)});
    }

    public Long downloadByJsonQuery(Set var1, String var2, Long var3, Boolean var4) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadByJsonQuery", Long.class, new KeyValuePair[]{new KeyValuePair("roids", var1), new KeyValuePair("jsonQuery", var2), new KeyValuePair("serializerOid", var3), new KeyValuePair("sync", var4)});
    }

    public Long downloadByNames(Set var1, Set var2, Long var3, Boolean var4, Boolean var5) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadByNames", Long.class, new KeyValuePair[]{new KeyValuePair("roids", var1), new KeyValuePair("names", var2), new KeyValuePair("serializerOid", var3), new KeyValuePair("deep", var4), new KeyValuePair("sync", var5)});
    }

    public Long downloadByOids(Set var1, Set var2, Long var3, Boolean var4, Boolean var5) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadByOids", Long.class, new KeyValuePair[]{new KeyValuePair("roids", var1), new KeyValuePair("oids", var2), new KeyValuePair("serializerOid", var3), new KeyValuePair("sync", var4), new KeyValuePair("deep", var5)});
    }

    public Long downloadByTypes(Set var1, String var2, Set var3, Long var4, Boolean var5, Boolean var6, Boolean var7, Boolean var8) throws
                                                                                                                                    Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadByTypes", Long.class, new KeyValuePair[]{new KeyValuePair("roids", var1), new KeyValuePair("schema", var2), new KeyValuePair("classNames", var3), new KeyValuePair("serializerOid", var4), new KeyValuePair("includeAllSubtypes", var5), new KeyValuePair("useObjectIDM", var6), new KeyValuePair("deep", var7), new KeyValuePair("sync", var8)});
    }

    public Long downloadQuery(Long var1, Long var2, String var3, Boolean var4, Long var5) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadQuery", Long.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("qeid", var2), new KeyValuePair("code", var3), new KeyValuePair("sync", var4), new KeyValuePair("serializerOid", var5)});
    }

    public Long downloadRevisions(Set var1, Long var2, Boolean var3) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1ServiceInterface", "downloadRevisions", Long.class, new KeyValuePair[]{new KeyValuePair("roids", var1), new KeyValuePair("serializerOid", var2), new KeyValuePair("sync", var3)});
    }

    public List getAllExtendedDataOfRevision(Long var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1ServiceInterface", "getAllExtendedDataOfRevision", List.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public List getAllProjects(Boolean var1, Boolean var2) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1ServiceInterface", "getAllProjects", List.class, new KeyValuePair[]{new KeyValuePair("onlyTopLevel", var1), new KeyValuePair("onlyActive", var2)});
    }

    public List getAllProjectsSmall() throws Exception {
        return (List)this.reflector.callMethod("Bimsie1ServiceInterface", "getAllProjectsSmall", List.class, new KeyValuePair[0]);
    }

    public List getAllRevisionsOfProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1ServiceInterface", "getAllRevisionsOfProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public SDeserializerPluginConfiguration getDeserializerById(Long var1) throws Exception {
        return (SDeserializerPluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getDeserializerById", SDeserializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SDeserializerPluginConfiguration getDeserializerByName(String var1) throws Exception {
        return (SDeserializerPluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getDeserializerByName", SDeserializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("deserializerName", var1)});
    }

    public SDownloadResult getDownloadData(Long var1) throws Exception {
        return (SDownloadResult)this.reflector.callMethod("Bimsie1ServiceInterface", "getDownloadData", SDownloadResult.class, new KeyValuePair[]{new KeyValuePair("actionId", var1)});
    }

    public SExtendedData getExtendedData(Long var1) throws Exception {
        return (SExtendedData)this.reflector.callMethod("Bimsie1ServiceInterface", "getExtendedData", SExtendedData.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SExtendedDataSchema getExtendedDataSchemaById(Long var1) throws Exception {
        return (SExtendedDataSchema)this.reflector.callMethod("Bimsie1ServiceInterface", "getExtendedDataSchemaById", SExtendedDataSchema.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SExtendedDataSchema getExtendedDataSchemaByNamespace(String var1) throws Exception {
        return (SExtendedDataSchema)this.reflector.callMethod("Bimsie1ServiceInterface", "getExtendedDataSchemaByNamespace", SExtendedDataSchema.class, new KeyValuePair[]{new KeyValuePair("namespace", var1)});
    }

    public SProject getProjectByPoid(Long var1) throws Exception {
        return (SProject)this.reflector.callMethod("Bimsie1ServiceInterface", "getProjectByPoid", SProject.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public SProjectSmall getProjectSmallByPoid(Long var1) throws Exception {
        return (SProjectSmall)this.reflector.callMethod("Bimsie1ServiceInterface", "getProjectSmallByPoid", SProjectSmall.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getProjectsByName(String var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1ServiceInterface", "getProjectsByName", List.class, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public SQueryEnginePluginConfiguration getQueryEngineById(Long var1) throws Exception {
        return (SQueryEnginePluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getQueryEngineById", SQueryEnginePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SQueryEnginePluginConfiguration getQueryEngineByName(String var1) throws Exception {
        return (SQueryEnginePluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getQueryEngineByName", SQueryEnginePluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public SRevision getRevision(Long var1) throws Exception {
        return (SRevision)this.reflector.callMethod("Bimsie1ServiceInterface", "getRevision", SRevision.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public SSerializerPluginConfiguration getSerializerByContentType(String var1) throws Exception {
        return (SSerializerPluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getSerializerByContentType", SSerializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("contentType", var1)});
    }

    public SSerializerPluginConfiguration getSerializerById(Long var1) throws Exception {
        return (SSerializerPluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getSerializerById", SSerializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public SSerializerPluginConfiguration getSerializerByName(String var1) throws Exception {
        return (SSerializerPluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getSerializerByName", SSerializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("serializerName", var1)});
    }

    public List getSubProjects(Long var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1ServiceInterface", "getSubProjects", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public SDeserializerPluginConfiguration getSuggestedDeserializerForExtension(String var1, Long var2) throws
                                                                                                         Exception {
        return (SDeserializerPluginConfiguration)this.reflector.callMethod("Bimsie1ServiceInterface", "getSuggestedDeserializerForExtension", SDeserializerPluginConfiguration.class, new KeyValuePair[]{new KeyValuePair("extension", var1), new KeyValuePair("poid", var2)});
    }

    public void terminateLongRunningAction(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1ServiceInterface", "terminateLongRunningAction", Void.TYPE, new KeyValuePair[]{new KeyValuePair("actionId", var1)});
    }

    public Boolean undeleteProject(Long var1) throws Exception {
        return (Boolean)this.reflector.callMethod("Bimsie1ServiceInterface", "undeleteProject", Boolean.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }
}
