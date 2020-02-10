//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.interfaces.objects.SUser;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.json.ReflectorException;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class AuthInterfaceImpl1 implements AuthInterface {
    Reflector reflector;

    public AuthInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public Boolean changePassword(Long var1, String var2, String var3) throws Exception {
        return (Boolean)this.reflector.callMethod("AuthInterface", "changePassword", Boolean.class, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("oldPassword", var2), new KeyValuePair("newPassword", var3)});
    }

    public SUser getLoggedInUser() throws Exception {
        return (SUser)this.reflector.callMethod("AuthInterface", "getLoggedInUser", SUser.class, new KeyValuePair[0]);
    }

    public void requestPasswordChange(String var1, String var2) throws Exception {
        this.reflector.callMethod("AuthInterface", "requestPasswordChange", Void.TYPE, new KeyValuePair[]{new KeyValuePair("username", var1), new KeyValuePair("resetUrl", var2)});
    }

    public void setHash(Long var1, byte[] var2, byte[] var3) throws Exception {
        this.reflector.callMethod("AuthInterface", "setHash", Void.TYPE, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("hash", var2), new KeyValuePair("salt", var3)});
    }

    public SUser validateAccount(Long var1, String var2, String var3) throws Exception {
        return (SUser)this.reflector.callMethod("AuthInterface", "validateAccount", SUser.class, new KeyValuePair[]{new KeyValuePair("uoid", var1), new KeyValuePair("token", var2), new KeyValuePair("password", var3)});
    }
}
