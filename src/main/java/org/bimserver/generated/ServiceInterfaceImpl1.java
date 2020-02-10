//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import java.util.Set;
import javax.activation.DataHandler;
import org.bimserver.interfaces.objects.SCompareResult;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SIfcHeader;
import org.bimserver.interfaces.objects.SModelCheckerInstance;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SRevisionSummary;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserSettings;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class ServiceInterfaceImpl1 implements ServiceInterface {
    Reflector reflector;

    public ServiceInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public Long addExtendedDataSchema(SExtendedDataSchema var1) throws Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "addExtendedDataSchema", Long.class, new KeyValuePair[]{new KeyValuePair("extendedDataSchema", var1)});
    }

    public void addExtendedDataToProject(Long var1, SExtendedData var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "addExtendedDataToProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("extendedData", var2)});
    }

    public void addLocalServiceToProject(Long var1, SService var2, Long var3) throws Exception {
        this.reflector.callMethod("ServiceInterface", "addLocalServiceToProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("sService", var2), new KeyValuePair("internalServiceOid", var3)});
    }

    public Long addModelChecker(SModelCheckerInstance var1) throws Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "addModelChecker", Long.class, new KeyValuePair[]{new KeyValuePair("modelCheckerInstance", var1)});
    }

    public void addModelCheckerToProject(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "addModelCheckerToProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("modelCheckerOid", var2)});
    }

    public Long addServiceToProject(Long var1, SService var2) throws Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "addServiceToProject", Long.class, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("sService", var2)});
    }

    public SUser addUser(String var1, String var2, SUserType var3, Boolean var4, String var5) throws Exception {
        return (SUser)this.reflector.callMethod("ServiceInterface", "addUser", SUser.class, new KeyValuePair[]{new KeyValuePair("username", var1), new KeyValuePair("name", var2), new KeyValuePair("type", var3), new KeyValuePair("selfRegistration", var4), new KeyValuePair("resetUrl", var5)});
    }

    public void addUserToExtendedDataSchema(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "addUserToExtendedDataSchema", Void.TYPE, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("edsid", var2)});
    }

    public Boolean addUserToProject(Long var1, Long var2) throws Exception {
        return (Boolean)this.reflector.callMethod("ServiceInterface", "addUserToProject", Boolean.class, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("poid", var2)});
    }

    public SUser addUserWithPassword(String var1, String var2, String var3, SUserType var4, Boolean var5, String var6) throws
                                                                                                                       Exception {
        return (SUser)this.reflector.callMethod("ServiceInterface", "addUserWithPassword", SUser.class, new KeyValuePair[]{new KeyValuePair("username", var1), new KeyValuePair("password", var2), new KeyValuePair("name", var3), new KeyValuePair("type", var4), new KeyValuePair("selfRegistration", var5), new KeyValuePair("resetUrl", var6)});
    }

    public void changeUserType(Long var1, SUserType var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "changeUserType", Void.TYPE, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("userType", var2)});
    }

    public Long checkin(Long var1, String var2, Long var3, Long var4, String var5, DataHandler var6, Boolean var7, Boolean var8) throws
                                                                                                                                 Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "checkin", Long.class, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("comment", var2), new KeyValuePair("deserializerOid", var3), new KeyValuePair("fileSize", var4), new KeyValuePair("fileName", var5), new KeyValuePair("data", var6), new KeyValuePair("merge", var7), new KeyValuePair("sync", var8)});
    }

    public Long checkinFromUrl(Long var1, String var2, Long var3, String var4, String var5, Boolean var6, Boolean var7) throws
                                                                                                                        Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "checkinFromUrl", Long.class, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("comment", var2), new KeyValuePair("deserializerOid", var3), new KeyValuePair("fileName", var4), new KeyValuePair("url", var5), new KeyValuePair("merge", var6), new KeyValuePair("sync", var7)});
    }

    public void cleanupLongAction(Long var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "cleanupLongAction", Void.TYPE, new KeyValuePair[]{new KeyValuePair("actionId", var1)});
    }

    public SCompareResult compare(Long var1, Long var2, SCompareType var3, Long var4) throws Exception {
        return (SCompareResult)this.reflector.callMethod("ServiceInterface", "compare", SCompareResult.class, new KeyValuePair[]{new KeyValuePair("roid1", var1), new KeyValuePair("roid2", var2), new KeyValuePair("sCompareType", var3), new KeyValuePair("mcid", var4)});
    }

    public void deleteService(Long var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "deleteService", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }

    public Boolean deleteUser(Long var1) throws Exception {
        return (Boolean)this.reflector.callMethod("ServiceInterface", "deleteUser", Boolean.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public Long downloadCompareResults(Long var1, Long var2, Long var3, Long var4, SCompareType var5, Boolean var6) throws
                                                                                                                    Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "downloadCompareResults", Long.class, new KeyValuePair[]{new KeyValuePair("serializerOid", var1), new KeyValuePair("roid1", var2), new KeyValuePair("roid2", var3), new KeyValuePair("mcid", var4), new KeyValuePair("type", var5), new KeyValuePair("sync", var6)});
    }

    public List getAllAuthorizedUsersOfProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllAuthorizedUsersOfProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllCheckoutsByUser(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllCheckoutsByUser", List.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public List getAllCheckoutsOfProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllCheckoutsOfProjectAndSubProjects(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllCheckoutsOfProjectAndSubProjects", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllCheckoutsOfRevision(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllCheckoutsOfRevision", List.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public List getAllExtendedDataSchemas() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllExtendedDataSchemas", List.class, new KeyValuePair[0]);
    }

    public List getAllLocalProfiles(String var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllLocalProfiles", List.class, new KeyValuePair[]{new KeyValuePair("serviceIdentifier", var1)});
    }

    public List getAllLocalServiceDescriptors() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllLocalServiceDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllModelCheckers() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllModelCheckers", List.class, new KeyValuePair[0]);
    }

    public List getAllModelCheckersOfProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllModelCheckersOfProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllNonAuthorizedProjectsOfUser(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllNonAuthorizedProjectsOfUser", List.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public List getAllNonAuthorizedUsersOfProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllNonAuthorizedUsersOfProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllPrivateProfiles(String var1, String var2, String var3) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllPrivateProfiles", List.class, new KeyValuePair[]{new KeyValuePair("notificationsUrl", var1), new KeyValuePair("serviceIdentifier", var2), new KeyValuePair("token", var3)});
    }

    public List getAllPublicProfiles(String var1, String var2) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllPublicProfiles", List.class, new KeyValuePair[]{new KeyValuePair("notificationsUrl", var1), new KeyValuePair("serviceIdentifier", var2)});
    }

    public List getAllReadableProjects() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllReadableProjects", List.class, new KeyValuePair[0]);
    }

    public List getAllRelatedProjects(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllRelatedProjects", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllRepositoryExtendedDataSchemas() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllRepositoryExtendedDataSchemas", List.class, new KeyValuePair[0]);
    }

    public List getAllRepositoryModelCheckers() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllRepositoryModelCheckers", List.class, new KeyValuePair[0]);
    }

    public List getAllRevisionsByUser(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllRevisionsByUser", List.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public List getAllServiceDescriptors() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllServiceDescriptors", List.class, new KeyValuePair[0]);
    }

    public List getAllServicesOfProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllServicesOfProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getAllUsers() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllUsers", List.class, new KeyValuePair[0]);
    }

    public List getAllWritableProjects() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAllWritableProjects", List.class, new KeyValuePair[0]);
    }

    public Double getArea(Long var1, Long var2) throws Exception {
        return (Double)this.reflector.callMethod("ServiceInterface", "getArea", Double.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("oid", var2)});
    }

    public List getAvailableClasses() throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAvailableClasses", List.class, new KeyValuePair[0]);
    }

    public List getAvailableClassesInRevision(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getAvailableClassesInRevision", List.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public Set getCheckinWarnings(Long var1) throws Exception {
        return (Set)this.reflector.callMethod("ServiceInterface", "getCheckinWarnings", Set.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public Set getCheckoutWarnings(Long var1) throws Exception {
        return (Set)this.reflector.callMethod("ServiceInterface", "getCheckoutWarnings", Set.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public SExtendedDataSchema getExtendedDataSchemaFromRepository(String var1) throws Exception {
        return (SExtendedDataSchema)this.reflector.callMethod("ServiceInterface", "getExtendedDataSchemaFromRepository", SExtendedDataSchema.class, new KeyValuePair[]{new KeyValuePair("namespace", var1)});
    }

    public SFile getFile(Long var1) throws Exception {
        return (SFile)this.reflector.callMethod("ServiceInterface", "getFile", SFile.class, new KeyValuePair[]{new KeyValuePair("fileId", var1)});
    }

    public SGeoTag getGeoTag(Long var1) throws Exception {
        return (SGeoTag)this.reflector.callMethod("ServiceInterface", "getGeoTag", SGeoTag.class, new KeyValuePair[]{new KeyValuePair("goid", var1)});
    }

    public SIfcHeader getIfcHeader(Long var1) throws Exception {
        return (SIfcHeader)this.reflector.callMethod("ServiceInterface", "getIfcHeader", SIfcHeader.class, new KeyValuePair[]{new KeyValuePair("croid", var1)});
    }

    public SModelCheckerInstance getModelCheckerInstance(Long var1) throws Exception {
        return (SModelCheckerInstance)this.reflector.callMethod("ServiceInterface", "getModelCheckerInstance", SModelCheckerInstance.class, new KeyValuePair[]{new KeyValuePair("mcioid", var1)});
    }

    public Long getOidByGuid(Long var1, String var2) throws Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "getOidByGuid", Long.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("guid", var2)});
    }

    public String getQueryEngineExample(Long var1, String var2) throws Exception {
        return (String)this.reflector.callMethod("ServiceInterface", "getQueryEngineExample", String.class, new KeyValuePair[]{new KeyValuePair("qeid", var1), new KeyValuePair("key", var2)});
    }

    public List getQueryEngineExampleKeys(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getQueryEngineExampleKeys", List.class, new KeyValuePair[]{new KeyValuePair("qeid", var1)});
    }

    public SRevisionSummary getRevisionSummary(Long var1) throws Exception {
        return (SRevisionSummary)this.reflector.callMethod("ServiceInterface", "getRevisionSummary", SRevisionSummary.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public SService getService(Long var1) throws Exception {
        return (SService)this.reflector.callMethod("ServiceInterface", "getService", SService.class, new KeyValuePair[]{new KeyValuePair("soid", var1)});
    }

    public SServiceDescriptor getServiceDescriptor(String var1, String var2) throws Exception {
        return (SServiceDescriptor)this.reflector.callMethod("ServiceInterface", "getServiceDescriptor", SServiceDescriptor.class, new KeyValuePair[]{new KeyValuePair("baseUrl", var1), new KeyValuePair("serviceIdentifier", var2)});
    }

    public SUser getUserByUoid(Long var1) throws Exception {
        return (SUser)this.reflector.callMethod("ServiceInterface", "getUserByUoid", SUser.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public SUser getUserByUserName(String var1) throws Exception {
        return (SUser)this.reflector.callMethod("ServiceInterface", "getUserByUserName", SUser.class, new KeyValuePair[]{new KeyValuePair("username", var1)});
    }

    public List getUserRelatedLogs(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getUserRelatedLogs", List.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public SUserSettings getUserSettings() throws Exception {
        return (SUserSettings)this.reflector.callMethod("ServiceInterface", "getUserSettings", SUserSettings.class, new KeyValuePair[0]);
    }

    public List getUsersProjects(Long var1) throws Exception {
        return (List)this.reflector.callMethod("ServiceInterface", "getUsersProjects", List.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public Double getVolume(Long var1, Long var2) throws Exception {
        return (Double)this.reflector.callMethod("ServiceInterface", "getVolume", Double.class, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("oid", var2)});
    }

    public void importData(String var1, String var2, String var3, String var4) throws Exception {
        this.reflector.callMethod("ServiceInterface", "importData", Void.TYPE, new KeyValuePair[]{new KeyValuePair("address", var1), new KeyValuePair("username", var2), new KeyValuePair("password", var3), new KeyValuePair("path", var4)});
    }

    public void removeModelCheckerFromProject(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "removeModelCheckerFromProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("modelCheckerOid", var2)});
    }

    public void removeServiceFromProject(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "removeServiceFromProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("serviceOid", var2)});
    }

    public void removeUserFromExtendedDataSchema(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "removeUserFromExtendedDataSchema", Void.TYPE, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("edsid", var2)});
    }

    public Boolean removeUserFromProject(Long var1, Long var2) throws Exception {
        return (Boolean)this.reflector.callMethod("ServiceInterface", "removeUserFromProject", Boolean.class, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("poid", var2)});
    }

    public void sendCompareEmail(SCompareType var1, Long var2, Long var3, Long var4, Long var5, String var6) throws
                                                                                                             Exception {
        this.reflector.callMethod("ServiceInterface", "sendCompareEmail", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sCompareType", var1), new KeyValuePair("mcid", var2), new KeyValuePair("poid", var3), new KeyValuePair("roid1", var4), new KeyValuePair("roid2", var5), new KeyValuePair("address", var6)});
    }

    public void setRevisionTag(Long var1, String var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "setRevisionTag", Void.TYPE, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("tag", var2)});
    }

    public String shareRevision(Long var1) throws Exception {
        return (String)this.reflector.callMethod("ServiceInterface", "shareRevision", String.class, new KeyValuePair[]{new KeyValuePair("roid", var1)});
    }

    public void triggerNewExtendedData(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "triggerNewExtendedData", Void.TYPE, new KeyValuePair[]{new KeyValuePair("edid", var1), new KeyValuePair("soid", var2)});
    }

    public void triggerNewRevision(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("ServiceInterface", "triggerNewRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("soid", var2)});
    }

    public Boolean undeleteUser(Long var1) throws Exception {
        return (Boolean)this.reflector.callMethod("ServiceInterface", "undeleteUser", Boolean.class, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public void updateGeoTag(SGeoTag var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "updateGeoTag", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sGeoTag", var1)});
    }

    public void updateModelChecker(SModelCheckerInstance var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "updateModelChecker", Void.TYPE, new KeyValuePair[]{new KeyValuePair("modelCheckerInstance", var1)});
    }

    public void updateProject(SProject var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "updateProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sProject", var1)});
    }

    public void updateRevision(SRevision var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "updateRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sRevision", var1)});
    }

    public Long uploadFile(SFile var1) throws Exception {
        return (Long)this.reflector.callMethod("ServiceInterface", "uploadFile", Long.class, new KeyValuePair[]{new KeyValuePair("file", var1)});
    }

    public Boolean userHasCheckinRights(Long var1, Long var2) throws Exception {
        return (Boolean)this.reflector.callMethod("ServiceInterface", "userHasCheckinRights", Boolean.class, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("poid", var2)});
    }

    public Boolean userHasRights(Long var1) throws Exception {
        return (Boolean)this.reflector.callMethod("ServiceInterface", "userHasRights", Boolean.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public void validateModelChecker(Long var1) throws Exception {
        this.reflector.callMethod("ServiceInterface", "validateModelChecker", Void.TYPE, new KeyValuePair[]{new KeyValuePair("oid", var1)});
    }
}
