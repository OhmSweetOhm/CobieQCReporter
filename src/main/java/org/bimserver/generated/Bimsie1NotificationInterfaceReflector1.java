//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1NotificationInterfaceReflector1 implements Reflector {
    Bimsie1NotificationInterface publicInterface;

    public Bimsie1NotificationInterfaceReflector1(Bimsie1NotificationInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("closedProgressOnProjectTopic")) {
                this.publicInterface.closedProgressOnProjectTopic((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("closedProgressOnRevisionTopic")) {
                this.publicInterface.closedProgressOnRevisionTopic((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue());
            } else if (var2.equals("closedProgressOnServerTopic")) {
                this.publicInterface.closedProgressOnServerTopic((Long)var4[0].getValue());
            } else if (var2.equals("newExtendedData")) {
                this.publicInterface.newExtendedData((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("newProgressOnProjectTopic")) {
                this.publicInterface.newProgressOnProjectTopic((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("newProgressOnRevisionTopic")) {
                this.publicInterface.newProgressOnRevisionTopic((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue());
            } else if (var2.equals("newProgressOnServerTopic")) {
                this.publicInterface.newProgressOnServerTopic((Long)var4[0].getValue());
            } else if (var2.equals("newProgressTopic")) {
                this.publicInterface.newProgressTopic((Long)var4[0].getValue());
            } else if (var2.equals("newProject")) {
                this.publicInterface.newProject((Long)var4[0].getValue());
            } else if (var2.equals("newRevision")) {
                this.publicInterface.newRevision((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("newUser")) {
                this.publicInterface.newUser((Long)var4[0].getValue());
            } else if (var2.equals("progress")) {
                this.publicInterface.progress((Long)var4[0].getValue(), (SLongActionState)var4[1].getValue());
            }
        }

        return null;
    }
}
