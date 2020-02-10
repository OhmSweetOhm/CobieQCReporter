//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.json.ReflectorException;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1AuthInterfaceImpl1 implements Bimsie1AuthInterface {
    Reflector reflector;

    public Bimsie1AuthInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public SAccessMethod getAccessMethod() throws Exception {
        return (SAccessMethod)this.reflector.callMethod("Bimsie1AuthInterface", "getAccessMethod", SAccessMethod.class, new KeyValuePair[0]);
    }

    public Boolean isLoggedIn() throws Exception {
        return (Boolean)this.reflector.callMethod("Bimsie1AuthInterface", "isLoggedIn", Boolean.class, new KeyValuePair[0]);
    }

    public String login(String var1, String var2) throws Exception {
        return (String)this.reflector.callMethod("Bimsie1AuthInterface", "login", String.class, new KeyValuePair[]{new KeyValuePair("username", var1), new KeyValuePair("password", var2)});
    }

    public String loginOpenId(String var1, String var2) throws Exception {
        return (String)this.reflector.callMethod("Bimsie1AuthInterface", "loginOpenId", String.class, new KeyValuePair[]{new KeyValuePair("op", var1), new KeyValuePair("returnUrl", var2)});
    }

    public String loginUserToken(String var1) throws Exception {
        return (String)this.reflector.callMethod("Bimsie1AuthInterface", "loginUserToken", String.class, new KeyValuePair[]{new KeyValuePair("token", var1)});
    }

    public void logout() throws Exception {
        this.reflector.callMethod("Bimsie1AuthInterface", "logout", Void.TYPE, new KeyValuePair[0]);
    }

    public String validateOpenId(String var1) throws Exception {
        return (String)this.reflector.callMethod("Bimsie1AuthInterface", "validateOpenId", String.class, new KeyValuePair[]{new KeyValuePair("queryString", var1)});
    }
}
