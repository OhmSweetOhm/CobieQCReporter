//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import org.bimserver.interfaces.objects.SServiceInterface;
import org.bimserver.interfaces.objects.SServiceMethod;
import org.bimserver.shared.interfaces.MetaInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class MetaInterfaceImpl1 implements MetaInterface {
    Reflector reflector;

    public MetaInterfaceImpl1(Reflector var1) {
        this.reflector = var1;
    }

    public String getAllAsJson() throws Exception {
        return (String)this.reflector.callMethod("MetaInterface", "getAllAsJson", String.class, new KeyValuePair[0]);
    }

    public List getEnumLiterals(String var1) throws Exception {
        return (List)this.reflector.callMethod("MetaInterface", "getEnumLiterals", List.class, new KeyValuePair[]{new KeyValuePair("enumName", var1)});
    }

    public SServiceInterface getServiceInterface(String var1) throws Exception {
        return (SServiceInterface)this.reflector.callMethod("MetaInterface", "getServiceInterface", SServiceInterface.class, new KeyValuePair[]{new KeyValuePair("getServiceInterface", var1)});
    }

    public List getServiceInterfaces() throws Exception {
        return (List)this.reflector.callMethod("MetaInterface", "getServiceInterfaces", List.class, new KeyValuePair[0]);
    }

    public SServiceMethod getServiceMethod(String var1, String var2) throws Exception {
        return (SServiceMethod)this.reflector.callMethod("MetaInterface", "getServiceMethod", SServiceMethod.class, new KeyValuePair[]{new KeyValuePair("serviceInterfaceName", var1), new KeyValuePair("methodName", var2)});
    }

    public List getServiceMethodParameters(String var1, String var2) throws Exception {
        return (List)this.reflector.callMethod("MetaInterface", "getServiceMethodParameters", List.class, new KeyValuePair[]{new KeyValuePair("serviceInterfaceName", var1), new KeyValuePair("serviceMethodName", var2)});
    }

    public List getServiceMethods(String var1) throws Exception {
        return (List)this.reflector.callMethod("MetaInterface", "getServiceMethods", List.class, new KeyValuePair[]{new KeyValuePair("serviceInterfaceName", var1)});
    }

    public List getServiceTypes() throws Exception {
        return (List)this.reflector.callMethod("MetaInterface", "getServiceTypes", List.class, new KeyValuePair[0]);
    }
}
