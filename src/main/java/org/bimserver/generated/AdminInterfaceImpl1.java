//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.Date;
import java.util.List;
import org.bimserver.interfaces.objects.SBimServerInfo;
import org.bimserver.interfaces.objects.SDatabaseInformation;
import org.bimserver.interfaces.objects.SJavaInfo;
import org.bimserver.interfaces.objects.SMetrics;
import org.bimserver.interfaces.objects.SServerInfo;
import org.bimserver.interfaces.objects.SSystemInfo;
import org.bimserver.interfaces.objects.SVersion;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AdminInterface;
import org.bimserver.shared.json.ReflectorException;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class AdminInterfaceImpl1 implements AdminInterface {
    Reflector reflector;

    public AdminInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public Integer clearOutputFileCache() throws Exception {
        return (Integer)this.reflector.callMethod("AdminInterface", "clearOutputFileCache", Integer.class, new KeyValuePair[0]);
    }

    public void disablePlugin(String var1) throws Exception {
        this.reflector.callMethod("AdminInterface", "disablePlugin", Void.TYPE, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public void enablePlugin(String var1) throws Exception {
        this.reflector.callMethod("AdminInterface", "enablePlugin", Void.TYPE, new KeyValuePair[]{new KeyValuePair("name", var1)});
    }

    public List getAllPlugins() throws Exception {
        return (List)this.reflector.callMethod("AdminInterface", "getAllPlugins", List.class, new KeyValuePair[0]);
    }

    public SBimServerInfo getBimServerInfo() throws Exception {
        return (SBimServerInfo)this.reflector.callMethod("AdminInterface", "getBimServerInfo", SBimServerInfo.class, new KeyValuePair[0]);
    }

    public SDatabaseInformation getDatabaseInformation() throws Exception {
        return (SDatabaseInformation)this.reflector.callMethod("AdminInterface", "getDatabaseInformation", SDatabaseInformation.class, new KeyValuePair[0]);
    }

    public SJavaInfo getJavaInfo() throws Exception {
        return (SJavaInfo)this.reflector.callMethod("AdminInterface", "getJavaInfo", SJavaInfo.class, new KeyValuePair[0]);
    }

    public Date getLastDatabaseReset() throws Exception {
        return (Date)this.reflector.callMethod("AdminInterface", "getLastDatabaseReset", Date.class, new KeyValuePair[0]);
    }

    public SVersion getLatestVersion() throws Exception {
        return (SVersion)this.reflector.callMethod("AdminInterface", "getLatestVersion", SVersion.class, new KeyValuePair[0]);
    }

    public List getLogs() throws Exception {
        return (List)this.reflector.callMethod("AdminInterface", "getLogs", List.class, new KeyValuePair[0]);
    }

    public SMetrics getMetrics() throws Exception {
        return (SMetrics)this.reflector.callMethod("AdminInterface", "getMetrics", SMetrics.class, new KeyValuePair[0]);
    }

    public List getMigrations() throws Exception {
        return (List)this.reflector.callMethod("AdminInterface", "getMigrations", List.class, new KeyValuePair[0]);
    }

    public String getProtocolBuffersFile(String var1) throws Exception {
        return (String)this.reflector.callMethod("AdminInterface", "getProtocolBuffersFile", String.class, new KeyValuePair[]{new KeyValuePair("interfaceName", var1)});
    }

    public SServerInfo getServerInfo() throws Exception {
        return (SServerInfo)this.reflector.callMethod("AdminInterface", "getServerInfo", SServerInfo.class, new KeyValuePair[0]);
    }

    public String getServerLog() throws Exception {
        return (String)this.reflector.callMethod("AdminInterface", "getServerLog", String.class, new KeyValuePair[0]);
    }

    public Date getServerStartTime() throws Exception {
        return (Date)this.reflector.callMethod("AdminInterface", "getServerStartTime", Date.class, new KeyValuePair[0]);
    }

    public SSystemInfo getSystemInfo() throws Exception {
        return (SSystemInfo)this.reflector.callMethod("AdminInterface", "getSystemInfo", SSystemInfo.class, new KeyValuePair[0]);
    }

    public SVersion getVersion() throws Exception {
        return (SVersion)this.reflector.callMethod("AdminInterface", "getVersion", SVersion.class, new KeyValuePair[0]);
    }

    public void migrateDatabase() throws Exception {
        this.reflector.callMethod("AdminInterface", "migrateDatabase", Void.TYPE, new KeyValuePair[0]);
    }

    public void regenerateGeometry(Long var1) throws Exception {
        this.reflector.callMethod("AdminInterface", "regenerateGeometry", Void.TYPE, new KeyValuePair[]{new KeyValuePair("croid", var1)});
    }

    public void setup(String var1, String var2, String var3, String var4, String var5, String var6) throws Exception {
        this.reflector.callMethod("AdminInterface", "setup", Void.TYPE, new KeyValuePair[]{new KeyValuePair("siteAddress", var1), new KeyValuePair("smtpServer", var2), new KeyValuePair("smtpSender", var3), new KeyValuePair("adminName", var4), new KeyValuePair("adminUsername", var5), new KeyValuePair("adminPassword", var6)});
    }

    public Boolean upgradePossible() throws Exception {
        return (Boolean)this.reflector.callMethod("AdminInterface", "upgradePossible", Boolean.class, new KeyValuePair[0]);
    }
}
