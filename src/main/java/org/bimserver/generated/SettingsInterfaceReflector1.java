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

public class SettingsInterfaceReflector1 implements Reflector {
    SettingsInterface publicInterface;

    public SettingsInterfaceReflector1(SettingsInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("getEmailSenderAddress")) {
                return this.publicInterface.getEmailSenderAddress();
            }

            if (var2.equals("getProtocolBuffersPort")) {
                return this.publicInterface.getProtocolBuffersPort();
            }

            if (var2.equals("getServerSettings")) {
                return this.publicInterface.getServerSettings();
            }

            if (var2.equals("getServiceRepositoryUrl")) {
                return this.publicInterface.getServiceRepositoryUrl();
            }

            if (var2.equals("getSiteAddress")) {
                return this.publicInterface.getSiteAddress();
            }

            if (var2.equals("getSmtpServer")) {
                return this.publicInterface.getSmtpServer();
            }

            if (var2.equals("isAllowSelfRegistration")) {
                return this.publicInterface.isAllowSelfRegistration();
            }

            if (var2.equals("isAllowUsersToCreateTopLevelProjects")) {
                return this.publicInterface.isAllowUsersToCreateTopLevelProjects();
            }

            if (var2.equals("isCacheOutputFiles")) {
                return this.publicInterface.isCacheOutputFiles();
            }

            if (var2.equals("isCheckinMergingEnabled")) {
                return this.publicInterface.isCheckinMergingEnabled();
            }

            if (var2.equals("isGenerateGeometryOnCheckin")) {
                return this.publicInterface.isGenerateGeometryOnCheckin();
            }

            if (var2.equals("isHideUserListForNonAdmin")) {
                return this.publicInterface.isHideUserListForNonAdmin();
            }

            if (var2.equals("isSendConfirmationEmailAfterRegistration")) {
                return this.publicInterface.isSendConfirmationEmailAfterRegistration();
            }

            if (var2.equals("setAllowSelfRegistration")) {
                this.publicInterface.setAllowSelfRegistration((Boolean)var4[0].getValue());
            } else if (var2.equals("setAllowUsersToCreateTopLevelProjects")) {
                this.publicInterface.setAllowUsersToCreateTopLevelProjects((Boolean)var4[0].getValue());
            } else if (var2.equals("setCacheOutputFiles")) {
                this.publicInterface.setCacheOutputFiles((Boolean)var4[0].getValue());
            } else if (var2.equals("setCheckinMergingEnabled")) {
                this.publicInterface.setCheckinMergingEnabled((Boolean)var4[0].getValue());
            } else if (var2.equals("setEmailSenderAddress")) {
                this.publicInterface.setEmailSenderAddress((String)var4[0].getValue());
            } else if (var2.equals("setGenerateGeometryOnCheckin")) {
                this.publicInterface.setGenerateGeometryOnCheckin((Boolean)var4[0].getValue());
            } else if (var2.equals("setHideUserListForNonAdmin")) {
                this.publicInterface.setHideUserListForNonAdmin((Boolean)var4[0].getValue());
            } else if (var2.equals("setProtocolBuffersPort")) {
                this.publicInterface.setProtocolBuffersPort((Integer)var4[0].getValue());
            } else if (var2.equals("setSendConfirmationEmailAfterRegistration")) {
                this.publicInterface.setSendConfirmationEmailAfterRegistration((Boolean)var4[0].getValue());
            } else if (var2.equals("setServerSettings")) {
                this.publicInterface.setServerSettings((SServerSettings)var4[0].getValue());
            } else if (var2.equals("setServiceRepositoryUrl")) {
                this.publicInterface.setServiceRepositoryUrl((String)var4[0].getValue());
            } else if (var2.equals("setSiteAddress")) {
                this.publicInterface.setSiteAddress((String)var4[0].getValue());
            } else if (var2.equals("setSmtpServer")) {
                this.publicInterface.setSmtpServer((String)var4[0].getValue());
            } else if (var2.equals("setWhiteListedDomains")) {
                this.publicInterface.setWhiteListedDomains((List)var4[0].getValue());
            }
        }

        return null;
    }
}
