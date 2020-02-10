//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1NotificationInterfaceImpl1 implements Bimsie1NotificationInterface {
    Reflector reflector;

    public Bimsie1NotificationInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public void closedProgressOnProjectTopic(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "closedProgressOnProjectTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("topicId", var2)});
    }

    public void closedProgressOnRevisionTopic(Long var1, Long var2, Long var3) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "closedProgressOnRevisionTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("roid", var2), new KeyValuePair("topicId", var3)});
    }

    public void closedProgressOnServerTopic(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "closedProgressOnServerTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1)});
    }

    public void newExtendedData(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newExtendedData", Void.TYPE, new KeyValuePair[]{new KeyValuePair("roid", var1), new KeyValuePair("edid", var2)});
    }

    public void newProgressOnProjectTopic(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newProgressOnProjectTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("topicId", var2)});
    }

    public void newProgressOnRevisionTopic(Long var1, Long var2, Long var3) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newProgressOnRevisionTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("roid", var2), new KeyValuePair("topicId", var3)});
    }

    public void newProgressOnServerTopic(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newProgressOnServerTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1)});
    }

    public void newProgressTopic(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newProgressTopic", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1)});
    }

    public void newProject(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1)});
    }

    public void newRevision(Long var1, Long var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("roid", var2)});
    }

    public void newUser(Long var1) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "newUser", Void.TYPE, new KeyValuePair[]{new KeyValuePair("uoid", var1)});
    }

    public void progress(Long var1, SLongActionState var2) throws Exception {
        this.reflector.callMethod("Bimsie1NotificationInterface", "progress", Void.TYPE, new KeyValuePair[]{new KeyValuePair("topicId", var1), new KeyValuePair("state", var2)});
    }
}
