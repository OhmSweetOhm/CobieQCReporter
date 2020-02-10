//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.AuthInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class AuthInterfaceReflector1 implements Reflector {
    AuthInterface publicInterface;

    public AuthInterfaceReflector1(AuthInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("changePassword")) {
                return this.publicInterface.changePassword((Long)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue());
            }

            if (var2.equals("getLoggedInUser")) {
                return this.publicInterface.getLoggedInUser();
            }

            if (var2.equals("requestPasswordChange")) {
                this.publicInterface.requestPasswordChange((String)var4[0].getValue(), (String)var4[1].getValue());
            } else if (var2.equals("setHash")) {
                this.publicInterface.setHash((Long)var4[0].getValue(), (byte[])var4[1].getValue(), (byte[])var4[2].getValue());
            } else if (var2.equals("validateAccount")) {
                return this.publicInterface.validateAccount((Long)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue());
            }
        }

        return null;
    }
}
