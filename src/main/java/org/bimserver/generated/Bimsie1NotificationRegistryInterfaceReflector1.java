//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProgressTopicType;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1NotificationRegistryInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1NotificationRegistryInterfaceReflector1 implements Reflector {
    Bimsie1NotificationRegistryInterface publicInterface;

    public Bimsie1NotificationRegistryInterfaceReflector1(Bimsie1NotificationRegistryInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("getProgress")) {
                return this.publicInterface.getProgress((Long)var4[0].getValue());
            }

            if (var2.equals("getProgressTopicsOnProject")) {
                return this.publicInterface.getProgressTopicsOnProject((Long)var4[0].getValue());
            }

            if (var2.equals("getProgressTopicsOnRevision")) {
                return this.publicInterface.getProgressTopicsOnRevision((Long)var4[0].getValue(), (Long)var4[1].getValue());
            }

            if (var2.equals("getProgressTopicsOnServer")) {
                return this.publicInterface.getProgressTopicsOnServer();
            }

            if (var2.equals("registerChangeProgressOnProject")) {
                this.publicInterface.registerChangeProgressOnProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("registerChangeProgressOnRevision")) {
                this.publicInterface.registerChangeProgressOnRevision((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue());
            } else if (var2.equals("registerChangeProgressOnServer")) {
                this.publicInterface.registerChangeProgressOnServer((Long)var4[0].getValue());
            } else if (var2.equals("registerNewExtendedDataOnRevisionHandler")) {
                this.publicInterface.registerNewExtendedDataOnRevisionHandler((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("registerNewProjectHandler")) {
                this.publicInterface.registerNewProjectHandler((Long)var4[0].getValue());
            } else if (var2.equals("registerNewRevisionHandler")) {
                this.publicInterface.registerNewRevisionHandler((Long)var4[0].getValue());
            } else if (var2.equals("registerNewRevisionOnSpecificProjectHandler")) {
                this.publicInterface.registerNewRevisionOnSpecificProjectHandler((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else if (var2.equals("registerNewUserHandler")) {
                this.publicInterface.registerNewUserHandler((Long)var4[0].getValue());
            } else if (var2.equals("registerProgressHandler")) {
                this.publicInterface.registerProgressHandler((Long)var4[0].getValue(), (Long)var4[1].getValue());
            } else {
                if (var2.equals("registerProgressOnProjectTopic")) {
                    return this.publicInterface.registerProgressOnProjectTopic((SProgressTopicType)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("registerProgressOnRevisionTopic")) {
                    return this.publicInterface.registerProgressOnRevisionTopic((SProgressTopicType)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue(), (String)var4[3].getValue());
                }

                if (var2.equals("registerProgressTopic")) {
                    return this.publicInterface.registerProgressTopic((SProgressTopicType)var4[0].getValue(), (String)var4[1].getValue());
                }

                if (var2.equals("unregisterChangeProgressOnProject")) {
                    this.publicInterface.unregisterChangeProgressOnProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                } else if (var2.equals("unregisterChangeProgressOnRevision")) {
                    this.publicInterface.unregisterChangeProgressOnRevision((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue());
                } else if (var2.equals("unregisterChangeProgressOnServer")) {
                    this.publicInterface.unregisterChangeProgressOnServer((Long)var4[0].getValue());
                } else if (var2.equals("unregisterNewExtendedDataOnRevisionHandler")) {
                    this.publicInterface.unregisterNewExtendedDataOnRevisionHandler((Long)var4[0].getValue(), (Long)var4[1].getValue());
                } else if (var2.equals("unregisterNewProjectHandler")) {
                    this.publicInterface.unregisterNewProjectHandler((Long)var4[0].getValue());
                } else if (var2.equals("unregisterNewRevisionHandler")) {
                    this.publicInterface.unregisterNewRevisionHandler((Long)var4[0].getValue());
                } else if (var2.equals("unregisterNewRevisionOnSpecificProjectHandler")) {
                    this.publicInterface.unregisterNewRevisionOnSpecificProjectHandler((Long)var4[0].getValue(), (Long)var4[1].getValue());
                } else if (var2.equals("unregisterNewUserHandler")) {
                    this.publicInterface.unregisterNewUserHandler((Long)var4[0].getValue());
                } else if (var2.equals("unregisterProgressHandler")) {
                    this.publicInterface.unregisterProgressHandler((Long)var4[0].getValue(), (Long)var4[1].getValue());
                } else if (var2.equals("unregisterProgressTopic")) {
                    this.publicInterface.unregisterProgressTopic((Long)var4[0].getValue());
                } else if (var2.equals("updateProgressTopic")) {
                    this.publicInterface.updateProgressTopic((Long)var4[0].getValue(), (SLongActionState)var4[1].getValue());
                }
            }
        }

        return null;
    }
}
