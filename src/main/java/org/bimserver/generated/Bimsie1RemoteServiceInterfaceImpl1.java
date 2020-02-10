//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1RemoteServiceInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1RemoteServiceInterfaceImpl1 implements Bimsie1RemoteServiceInterface {
    Reflector reflector;

    public Bimsie1RemoteServiceInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public List getPrivateProfiles(String var1, String var2) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1RemoteServiceInterface", "getPrivateProfiles", List.class, new KeyValuePair[]{new KeyValuePair("serviceIdentifier", var1), new KeyValuePair("token", var2)});
    }

    public List getPublicProfiles(String var1) throws Exception {
        return (List)this.reflector.callMethod("Bimsie1RemoteServiceInterface", "getPublicProfiles", List.class, new KeyValuePair[]{new KeyValuePair("serviceIdentifier", var1)});
    }

    public SServiceDescriptor getService(String var1) throws Exception {
        return (SServiceDescriptor)this.reflector.callMethod("Bimsie1RemoteServiceInterface", "getService", SServiceDescriptor.class, new KeyValuePair[]{new KeyValuePair("serviceIdentifier", var1)});
    }

    public void newExtendedDataOnProject(Long var1, Long var2, Long var3, String var4, String var5, String var6, String var7, String var8) throws
                                                                                                                                           Exception {
        this.reflector.callMethod("Bimsie1RemoteServiceInterface", "newExtendedDataOnProject", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("edid", var2), new KeyValuePair("soid", var3), new KeyValuePair("serviceIdentifier", var4), new KeyValuePair("profileIdentifier", var5), new KeyValuePair("userToken", var6), new KeyValuePair("token", var7), new KeyValuePair("apiUrl", var8)});
    }

    public void newExtendedDataOnRevision(Long var1, Long var2, Long var3, Long var4, String var5, String var6, String var7, String var8, String var9) throws
                                                                                                                                                       Exception {
        this.reflector.callMethod("Bimsie1RemoteServiceInterface", "newExtendedDataOnRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("roid", var2), new KeyValuePair("edid", var3), new KeyValuePair("soid", var4), new KeyValuePair("serviceIdentifier", var5), new KeyValuePair("profileIdentifier", var6), new KeyValuePair("userToken", var7), new KeyValuePair("token", var8), new KeyValuePair("apiUrl", var9)});
    }

    public void newRevision(Long var1, Long var2, Long var3, String var4, String var5, String var6, String var7, String var8) throws
                                                                                                                              Exception {
        this.reflector.callMethod("Bimsie1RemoteServiceInterface", "newRevision", Void.TYPE, new KeyValuePair[]{new KeyValuePair("poid", var1), new KeyValuePair("roid", var2), new KeyValuePair("soid", var3), new KeyValuePair("serviceIdentifier", var4), new KeyValuePair("profileIdentifier", var5), new KeyValuePair("userToken", var6), new KeyValuePair("token", var7), new KeyValuePair("apiUrl", var8)});
    }
}
