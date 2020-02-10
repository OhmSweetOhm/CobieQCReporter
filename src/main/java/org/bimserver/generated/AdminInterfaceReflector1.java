//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class AdminInterfaceReflector1 implements Reflector {
    AdminInterface publicInterface;

    public AdminInterfaceReflector1(AdminInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("clearOutputFileCache")) {
                return this.publicInterface.clearOutputFileCache();
            }

            if (var2.equals("disablePlugin")) {
                this.publicInterface.disablePlugin((String)var4[0].getValue());
            } else if (var2.equals("enablePlugin")) {
                this.publicInterface.enablePlugin((String)var4[0].getValue());
            } else {
                if (var2.equals("getAllPlugins")) {
                    return this.publicInterface.getAllPlugins();
                }

                if (var2.equals("getBimServerInfo")) {
                    return this.publicInterface.getBimServerInfo();
                }

                if (var2.equals("getDatabaseInformation")) {
                    return this.publicInterface.getDatabaseInformation();
                }

                if (var2.equals("getJavaInfo")) {
                    return this.publicInterface.getJavaInfo();
                }

                if (var2.equals("getLastDatabaseReset")) {
                    return this.publicInterface.getLastDatabaseReset();
                }

                if (var2.equals("getLatestVersion")) {
                    return this.publicInterface.getLatestVersion();
                }

                if (var2.equals("getLogs")) {
                    return this.publicInterface.getLogs();
                }

                if (var2.equals("getMetrics")) {
                    return this.publicInterface.getMetrics();
                }

                if (var2.equals("getMigrations")) {
                    return this.publicInterface.getMigrations();
                }

                if (var2.equals("getProtocolBuffersFile")) {
                    return this.publicInterface.getProtocolBuffersFile((String)var4[0].getValue());
                }

                if (var2.equals("getServerInfo")) {
                    return this.publicInterface.getServerInfo();
                }

                if (var2.equals("getServerLog")) {
                    return this.publicInterface.getServerLog();
                }

                if (var2.equals("getServerStartTime")) {
                    return this.publicInterface.getServerStartTime();
                }

                if (var2.equals("getSystemInfo")) {
                    return this.publicInterface.getSystemInfo();
                }

                if (var2.equals("getVersion")) {
                    return this.publicInterface.getVersion();
                }

                if (var2.equals("migrateDatabase")) {
                    this.publicInterface.migrateDatabase();
                } else if (var2.equals("regenerateGeometry")) {
                    this.publicInterface.regenerateGeometry((Long)var4[0].getValue());
                } else if (var2.equals("setup")) {
                    this.publicInterface.setup((String)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue(), (String)var4[4].getValue(), (String)var4[5].getValue());
                } else if (var2.equals("upgradePossible")) {
                    return this.publicInterface.upgradePossible();
                }
            }
        }

        return null;
    }
}
