//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class MetaInterfaceReflector1 implements Reflector {
    MetaInterface publicInterface;

    public MetaInterfaceReflector1(MetaInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("getAllAsJson")) {
                return this.publicInterface.getAllAsJson();
            }

            if (var2.equals("getEnumLiterals")) {
                return this.publicInterface.getEnumLiterals((String)var4[0].getValue());
            }

            if (var2.equals("getServiceInterface")) {
                return this.publicInterface.getServiceInterface((String)var4[0].getValue());
            }

            if (var2.equals("getServiceInterfaces")) {
                return this.publicInterface.getServiceInterfaces();
            }

            if (var2.equals("getServiceMethod")) {
                return this.publicInterface.getServiceMethod((String)var4[0].getValue(), (String)var4[1].getValue());
            }

            if (var2.equals("getServiceMethodParameters")) {
                return this.publicInterface.getServiceMethodParameters((String)var4[0].getValue(), (String)var4[1].getValue());
            }

            if (var2.equals("getServiceMethods")) {
                return this.publicInterface.getServiceMethods((String)var4[0].getValue());
            }

            if (var2.equals("getServiceTypes")) {
                return this.publicInterface.getServiceTypes();
            }
        }

        return null;
    }
}
