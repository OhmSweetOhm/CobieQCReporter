//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1NotificationRegistryInterfaceImpl1 implements Bimsie1NotificationRegistryInterface {
    Reflector reflector;

    public Bimsie1NotificationRegistryInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public SLongActionState getProgress(Long var1) throws Exception {
        return (SLongActionState)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "getProgress", SLongActionState.class, new KeyValuePair[]{new KeyValuePair("topicId", var1)});
    }

    public List getProgressTopicsOnProject(Long var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "getProgressTopicsOnProject", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public List getProgressTopicsOnRevision(Long var1, Long var2) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "getProgressTopicsOnRevision", List.class, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("roid", var2)});
    }

    public List getProgressTopicsOnServer() throws Exception {
        return (List)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "getProgressTopicsOnServer", List.class, new KeyValuePair[0]);
    }

    public void registerChangeProgressOnProject(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("poid", var2)});
    }

    public void registerChangeProgressOnRevision(Long var1, Long var2, Long var3) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("roid", var2), new KeyValuePair("poid", var3)});
    }

    public void registerChangeProgressOnServer(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerChangeProgressOnServer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void registerNewExtendedDataOnRevisionHandler(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerNewExtendedDataOnRevisionHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("roid", var2)});
    }

    public void registerNewProjectHandler(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerNewProjectHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void registerNewRevisionHandler(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerNewRevisionHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void registerNewRevisionOnSpecificProjectHandler(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerNewRevisionOnSpecificProjectHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("poid", var2)});
    }

    public void registerNewUserHandler(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerNewUserHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void registerProgressHandler(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerProgressHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1), new KeyValuePair("endPointId", var2)});
    }

    public Long registerProgressOnProjectTopic(SProgressTopicType var1, Long var2, String var3) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerProgressOnProjectTopic", Long.class, new KeyValuePair[]{new KeyValuePair("type", var1), new KeyValuePair("poid", var2), new KeyValuePair("description", var3)});
    }

    public Long registerProgressOnRevisionTopic(SProgressTopicType var1, Long var2, Long var3, String var4) throws
                                                                                                            Exception {
        return (Long)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerProgressOnRevisionTopic", Long.class, new KeyValuePair[]{new KeyValuePair("type", var1), new KeyValuePair("poid", var2), new KeyValuePair("roid", var3), new KeyValuePair("description", var4)});
    }

    public Long registerProgressTopic(SProgressTopicType var1, String var2) throws Exception {
        return (Long)this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "registerProgressTopic", Long.class, new KeyValuePair[]{new KeyValuePair("type", var1), new KeyValuePair("description", var2)});
    }

    public void unregisterChangeProgressOnProject(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("poid", var2)});
    }

    public void unregisterChangeProgressOnRevision(Long var1, Long var2, Long var3) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("roid", var2), new KeyValuePair("poid", var3)});
    }

    public void unregisterChangeProgressOnServer(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterChangeProgressOnServer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void unregisterNewExtendedDataOnRevisionHandler(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterNewExtendedDataOnRevisionHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("roid", var2)});
    }

    public void unregisterNewProjectHandler(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterNewProjectHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void unregisterNewRevisionHandler(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterNewRevisionHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void unregisterNewRevisionOnSpecificProjectHandler(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterNewRevisionOnSpecificProjectHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1), new KeyValuePair("poid", var2)});
    }

    public void unregisterNewUserHandler(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterNewUserHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("endPointId", var1)});
    }

    public void unregisterProgressHandler(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterProgressHandler", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1), new KeyValuePair("endPointId", var2)});
    }

    public void unregisterProgressTopic(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "unregisterProgressTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1)});
    }

    public void updateProgressTopic(Long var1, SLongActionState var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationRegistryInterface", "updateProgressTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1), new KeyValuePair("state", var2)});
    }
}
