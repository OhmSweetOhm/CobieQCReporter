//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import org.bimserver.interfaces.objects.SServerSettings;
import org.bimserver.shared.interfaces.SettingsInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class SettingsInterfaceImpl1 implements SettingsInterface {
    Reflector reflector;

    public SettingsInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public String getEmailSenderAddress() throws Exception {
        return (String)this.reflector.callMethod("SettingsInterface", "getEmailSenderAddress", String.class, new KeyValuePair[0]);
    }

    public Integer getProtocolBuffersPort() throws Exception {
        return (Integer)this.reflector.callMethod("SettingsInterface", "getProtocolBuffersPort", Integer.class, new KeyValuePair[0]);
    }

    public SServerSettings getServerSettings() throws Exception {
        return (SServerSettings)this.reflector.callMethod("SettingsInterface", "getServerSettings", SServerSettings.class, new KeyValuePair[0]);
    }

    public String getServiceRepositoryUrl() throws Exception {
        return (String)this.reflector.callMethod("SettingsInterface", "getServiceRepositoryUrl", String.class, new KeyValuePair[0]);
    }

    public String getSiteAddress() throws Exception {
        return (String)this.reflector.callMethod("SettingsInterface", "getSiteAddress", String.class, new KeyValuePair[0]);
    }

    public String getSmtpServer() throws Exception {
        return (String)this.reflector.callMethod("SettingsInterface", "getSmtpServer", String.class, new KeyValuePair[0]);
    }

    public Boolean isAllowSelfRegistration() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isAllowSelfRegistration", Boolean.class, new KeyValuePair[0]);
    }

    public Boolean isAllowUsersToCreateTopLevelProjects() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isAllowUsersToCreateTopLevelProjects", Boolean.class, new KeyValuePair[0]);
    }

    public Boolean isCacheOutputFiles() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isCacheOutputFiles", Boolean.class, new KeyValuePair[0]);
    }

    public Boolean isCheckinMergingEnabled() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isCheckinMergingEnabled", Boolean.class, new KeyValuePair[0]);
    }

    public Boolean isGenerateGeometryOnCheckin() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isGenerateGeometryOnCheckin", Boolean.class, new KeyValuePair[0]);
    }

    public Boolean isHideUserListForNonAdmin() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isHideUserListForNonAdmin", Boolean.class, new KeyValuePair[0]);
    }

    public Boolean isSendConfirmationEmailAfterRegistration() throws Exception {
        return (Boolean)this.reflector.callMethod("SettingsInterface", "isSendConfirmationEmailAfterRegistration", Boolean.class, new KeyValuePair[0]);
    }

    public void setAllowSelfRegistration(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setAllowSelfRegistration", Void.TYPE, new KeyValuePair[]{new KeyValuePair("allowSelfRegistration", var1)});
    }

    public void setAllowUsersToCreateTopLevelProjects(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setAllowUsersToCreateTopLevelProjects", Void.TYPE, new KeyValuePair[]{new KeyValuePair("allowUsersToCreateTopLevelProjects", var1)});
    }

    public void setCacheOutputFiles(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setCacheOutputFiles", Void.TYPE, new KeyValuePair[]{new KeyValuePair("cacheOutputFiles", var1)});
    }

    public void setCheckinMergingEnabled(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setCheckinMergingEnabled", Void.TYPE, new KeyValuePair[]{new KeyValuePair("checkinMergingEnabled", var1)});
    }

    public void setEmailSenderAddress(String var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setEmailSenderAddress", Void.TYPE, new KeyValuePair[]{new KeyValuePair("emailSenderAddress", var1)});
    }

    public void setGenerateGeometryOnCheckin(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setGenerateGeometryOnCheckin", Void.TYPE, new KeyValuePair[]{new KeyValuePair("generateGeometryOnCheckin", var1)});
    }

    public void setHideUserListForNonAdmin(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setHideUserListForNonAdmin", Void.TYPE, new KeyValuePair[]{new KeyValuePair("hideUserListForNonAdmin", var1)});
    }

    public void setProtocolBuffersPort(Integer var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setProtocolBuffersPort", Void.TYPE, new KeyValuePair[]{new KeyValuePair("port", var1)});
    }

    public void setSendConfirmationEmailAfterRegistration(Boolean var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setSendConfirmationEmailAfterRegistration", Void.TYPE, new KeyValuePair[]{new KeyValuePair("sendConfirmationEmailAfterRegistration", var1)});
    }

    public void setServerSettings(SServerSettings var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setServerSettings", Void.TYPE, new KeyValuePair[]{new KeyValuePair("serverSettings", var1)});
    }

    public void setServiceRepositoryUrl(String var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setServiceRepositoryUrl", Void.TYPE, new KeyValuePair[]{new KeyValuePair("url", var1)});
    }

    public void setSiteAddress(String var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setSiteAddress", Void.TYPE, new KeyValuePair[]{new KeyValuePair("siteAddress", var1)});
    }

    public void setSmtpServer(String var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setSmtpServer", Void.TYPE, new KeyValuePair[]{new KeyValuePair("smtpServer", var1)});
    }

    public void setWhiteListedDomains(List var1) throws Exception {
        this.reflector.callMethod("SettingsInterface", "setWhiteListedDomains", Void.TYPE, new KeyValuePair[]{new KeyValuePair("domains", var1)});
    }
}
