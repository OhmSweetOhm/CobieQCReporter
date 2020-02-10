//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1RemoteServiceInterfaceReflector1 implements Reflector {
    Bimsie1RemoteServiceInterface publicInterface;

    public Bimsie1RemoteServiceInterfaceReflector1(Bimsie1RemoteServiceInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("getPrivateProfiles")) {
                return this.publicInterface.getPrivateProfiles((String)var4[0].getValue(), (String)var4[1].getValue());
            }

            if (var2.equals("getPublicProfiles")) {
                return this.publicInterface.getPublicProfiles((String)var4[0].getValue());
            }

            if (var2.equals("getService")) {
                return this.publicInterface.getService((String)var4[0].getValue());
            }

            if (var2.equals("newExtendedDataOnProject")) {
                this.publicInterface.newExtendedDataOnProject((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue(), (String)var4[3].getValue(), (String)var4[4].getValue(), (String)var4[5].getValue(), (String)var4[6].getValue(), (String)var4[7].getValue());
            } else if (var2.equals("newExtendedDataOnRevision")) {
                this.publicInterface.newExtendedDataOnRevision((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue(), (Long)var4[3].getValue(), (String)var4[4].getValue(), (String)var4[5].getValue(), (String)var4[6].getValue(), (String)var4[7].getValue(), (String)var4[8].getValue());
            } else if (var2.equals("newRevision")) {
                this.publicInterface.newRevision((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue(), (String)var4[3].getValue(), (String)var4[4].getValue(), (String)var4[5].getValue(), (String)var4[6].getValue(), (String)var4[7].getValue());
            }
        }

        return null;
    }
}
