//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.shared.interfaces.bimsie1.Bimsie1AuthInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1AuthInterfaceReflector1 implements Reflector {

    Bimsie1AuthInterface publicInterface;

    public Bimsie1AuthInterfaceReflector1(Bimsie1AuthInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("getAccessMethod")) {
                return this.publicInterface.getAccessMethod();
            }

            if (var2.equals("isLoggedIn")) {
                return this.publicInterface.isLoggedIn();
            }

            if (var2.equals("login")) {
                return this.publicInterface.login((String) var4[0].getValue(), (String) var4[1].getValue());
            }

            if (var2.equals("loginOpenId")) {
                return this.publicInterface.loginOpenId((String) var4[0].getValue(), (String) var4[1].getValue());
            }

            if (var2.equals("loginUserToken")) {
                return this.publicInterface.loginUserToken((String) var4[0].getValue());
            }

            if (var2.equals("logout")) {
                this.publicInterface.logout();
            } else if (var2.equals("validateOpenId")) {
                return this.publicInterface.validateOpenId((String) var4[0].getValue());
            }
        }

        return null;
    }
}
