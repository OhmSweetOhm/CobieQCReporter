package org.bimserver.reflector;

import org.bimserver.generated.*;
import org.bimserver.shared.interfaces.*;
import org.bimserver.shared.interfaces.bimsie1.*;
import org.bimserver.shared.reflector.Reflector;
import org.bimserver.shared.reflector.ReflectorFactory;

public class ReflectorFactoryImpl1 implements ReflectorFactory {

    public PublicInterface createReflector(Class var1, Reflector var2) {
        if (true) {
            if (var1.getSimpleName().equals("ServiceInterface")) {
                return new ServiceInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("AdminInterface")) {
                return new AdminInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("MetaInterface")) {
                return new MetaInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("SettingsInterface")) {
                return new SettingsInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("AuthInterface")) {
                return new AuthInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("PluginInterface")) {
                return new PluginInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("Bimsie1ServiceInterface")) {
                return new Bimsie1ServiceInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("Bimsie1NotificationInterface")) {
                return new Bimsie1NotificationInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("Bimsie1RemoteServiceInterface")) {
                return new Bimsie1RemoteServiceInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("Bimsie1AuthInterface")) {
                return new Bimsie1AuthInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("Bimsie1LowLevelInterface")) {
                return new Bimsie1LowLevelInterfaceImpl1(var2);
            }

            if (var1.getSimpleName().equals("Bimsie1NotificationRegistryInterface")) {
                return new Bimsie1NotificationRegistryInterfaceImpl1(var2);
            }
        }

        return null;
    }

    public Reflector createReflector(Class var1, PublicInterface var2) {
        if (true) {
            if (var1.getSimpleName().equals("ServiceInterface")) {
                return new ServiceInterfaceReflector1((ServiceInterface) var2);
            }

            if (var1.getSimpleName().equals("AdminInterface")) {
                return new AdminInterfaceReflector1((AdminInterface) var2);
            }

            if (var1.getSimpleName().equals("MetaInterface")) {
                return new MetaInterfaceReflector1((MetaInterface) var2);
            }

            if (var1.getSimpleName().equals("SettingsInterface")) {
                return new SettingsInterfaceReflector1((SettingsInterface) var2);
            }

            if (var1.getSimpleName().equals("AuthInterface")) {
                return new AuthInterfaceReflector1((AuthInterface) var2);
            }

            if (var1.getSimpleName().equals("PluginInterface")) {
                return new PluginInterfaceReflector1((PluginInterface) var2);
            }

            if (var1.getSimpleName().equals("Bimsie1ServiceInterface")) {
                return new Bimsie1ServiceInterfaceReflector1((Bimsie1ServiceInterface) var2);
            }

            if (var1.getSimpleName().equals("Bimsie1NotificationInterface")) {
                return new Bimsie1NotificationInterfaceReflector1((Bimsie1NotificationInterface) var2);
            }

            if (var1.getSimpleName().equals("Bimsie1RemoteServiceInterface")) {
                return new Bimsie1RemoteServiceInterfaceReflector1((Bimsie1RemoteServiceInterface) var2);
            }

            if (var1.getSimpleName().equals("Bimsie1AuthInterface")) {
                return new Bimsie1AuthInterfaceReflector1((Bimsie1AuthInterface) var2);
            }

            if (var1.getSimpleName().equals("Bimsie1LowLevelInterface")) {
                return new Bimsie1LowLevelInterfaceReflector1((Bimsie1LowLevelInterface) var2);
            }

            if (var1.getSimpleName().equals("Bimsie1NotificationRegistryInterface")) {
                return new Bimsie1NotificationRegistryInterfaceReflector1((Bimsie1NotificationRegistryInterface) var2);
            }
        }

        return null;
    }

    public ReflectorFactoryImpl1() {
    }
}
