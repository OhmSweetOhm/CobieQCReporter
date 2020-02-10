//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.Set;
import org.bimserver.interfaces.objects.SDeserializerPluginConfiguration;
import org.bimserver.interfaces.objects.SInternalServicePluginConfiguration;
import org.bimserver.interfaces.objects.SModelComparePluginConfiguration;
import org.bimserver.interfaces.objects.SModelMergerPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectIDMPluginConfiguration;
import org.bimserver.interfaces.objects.SObjectType;
import org.bimserver.interfaces.objects.SQueryEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SRenderEnginePluginConfiguration;
import org.bimserver.interfaces.objects.SSerializerPluginConfiguration;
import org.bimserver.shared.interfaces.PluginInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class PluginInterfaceReflector1 implements Reflector {
    PluginInterface publicInterface;

    public PluginInterfaceReflector1(PluginInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("addDeserializer")) {
                this.publicInterface.addDeserializer((SDeserializerPluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addInternalService")) {
                this.publicInterface.addInternalService((SInternalServicePluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addModelCompare")) {
                this.publicInterface.addModelCompare((SModelComparePluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addModelMerger")) {
                this.publicInterface.addModelMerger((SModelMergerPluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addObjectIDM")) {
                this.publicInterface.addObjectIDM((SObjectIDMPluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addQueryEngine")) {
                this.publicInterface.addQueryEngine((SQueryEnginePluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addRenderEngine")) {
                this.publicInterface.addRenderEngine((SRenderEnginePluginConfiguration)var4[0].getValue());
            } else if (var2.equals("addSerializer")) {
                this.publicInterface.addSerializer((SSerializerPluginConfiguration)var4[0].getValue());
            } else if (var2.equals("deleteDeserializer")) {
                this.publicInterface.deleteDeserializer((Long)var4[0].getValue());
            } else if (var2.equals("deleteInternalService")) {
                this.publicInterface.deleteInternalService((Long)var4[0].getValue());
            } else if (var2.equals("deleteModelChecker")) {
                this.publicInterface.deleteModelChecker((Long)var4[0].getValue());
            } else if (var2.equals("deleteModelCompare")) {
                this.publicInterface.deleteModelCompare((Long)var4[0].getValue());
            } else if (var2.equals("deleteModelMerger")) {
                this.publicInterface.deleteModelMerger((Long)var4[0].getValue());
            } else if (var2.equals("deleteObjectIDM")) {
                this.publicInterface.deleteObjectIDM((Long)var4[0].getValue());
            } else if (var2.equals("deleteQueryEngine")) {
                this.publicInterface.deleteQueryEngine((Long)var4[0].getValue());
            } else if (var2.equals("deleteRenderEngine")) {
                this.publicInterface.deleteRenderEngine((Long)var4[0].getValue());
            } else if (var2.equals("deleteSerializer")) {
                this.publicInterface.deleteSerializer((Long)var4[0].getValue());
            } else {
                if (var2.equals("getAllDeserializerPluginDescriptors")) {
                    return this.publicInterface.getAllDeserializerPluginDescriptors();
                }

                if (var2.equals("getAllDeserializers")) {
                    return this.publicInterface.getAllDeserializers((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllDeserializersForProject")) {
                    return this.publicInterface.getAllDeserializersForProject((Boolean)var4[0].getValue(), (Long)var4[1].getValue());
                }

                if (var2.equals("getAllInternalServices")) {
                    return this.publicInterface.getAllInternalServices((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllModelCheckerPluginDescriptors")) {
                    return this.publicInterface.getAllModelCheckerPluginDescriptors();
                }

                if (var2.equals("getAllModelComparePluginDescriptors")) {
                    return this.publicInterface.getAllModelComparePluginDescriptors();
                }

                if (var2.equals("getAllModelCompares")) {
                    return this.publicInterface.getAllModelCompares((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllModelMergerPluginDescriptors")) {
                    return this.publicInterface.getAllModelMergerPluginDescriptors();
                }

                if (var2.equals("getAllModelMergers")) {
                    return this.publicInterface.getAllModelMergers((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllObjectIDMPluginDescriptors")) {
                    return this.publicInterface.getAllObjectIDMPluginDescriptors();
                }

                if (var2.equals("getAllObjectIDMs")) {
                    return this.publicInterface.getAllObjectIDMs((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllQueryEnginePluginDescriptors")) {
                    return this.publicInterface.getAllQueryEnginePluginDescriptors();
                }

                if (var2.equals("getAllQueryEngines")) {
                    return this.publicInterface.getAllQueryEngines((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllRenderEnginePluginDescriptors")) {
                    return this.publicInterface.getAllRenderEnginePluginDescriptors();
                }

                if (var2.equals("getAllRenderEngines")) {
                    return this.publicInterface.getAllRenderEngines((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllSerializerPluginDescriptors")) {
                    return this.publicInterface.getAllSerializerPluginDescriptors();
                }

                if (var2.equals("getAllSerializers")) {
                    return this.publicInterface.getAllSerializers((Boolean)var4[0].getValue());
                }

                if (var2.equals("getAllSerializersForRoids")) {
                    return this.publicInterface.getAllSerializersForRoids((Boolean)var4[0].getValue(), (Set)var4[1].getValue());
                }

                if (var2.equals("getAllServicePluginDescriptors")) {
                    return this.publicInterface.getAllServicePluginDescriptors();
                }

                if (var2.equals("getAllWebModulePluginDescriptors")) {
                    return this.publicInterface.getAllWebModulePluginDescriptors();
                }

                if (var2.equals("getAllWebModules")) {
                    return this.publicInterface.getAllWebModules((Boolean)var4[0].getValue());
                }

                if (var2.equals("getDefaultModelCompare")) {
                    return this.publicInterface.getDefaultModelCompare();
                }

                if (var2.equals("getDefaultModelMerger")) {
                    return this.publicInterface.getDefaultModelMerger();
                }

                if (var2.equals("getDefaultObjectIDM")) {
                    return this.publicInterface.getDefaultObjectIDM();
                }

                if (var2.equals("getDefaultQueryEngine")) {
                    return this.publicInterface.getDefaultQueryEngine();
                }

                if (var2.equals("getDefaultRenderEngine")) {
                    return this.publicInterface.getDefaultRenderEngine();
                }

                if (var2.equals("getDefaultSerializer")) {
                    return this.publicInterface.getDefaultSerializer();
                }

                if (var2.equals("getDefaultWebModule")) {
                    return this.publicInterface.getDefaultWebModule();
                }

                if (var2.equals("getInternalServiceById")) {
                    return this.publicInterface.getInternalServiceById((Long)var4[0].getValue());
                }

                if (var2.equals("getMessagingSerializerByPluginClassName")) {
                    return this.publicInterface.getMessagingSerializerByPluginClassName((String)var4[0].getValue());
                }

                if (var2.equals("getModelCompareById")) {
                    return this.publicInterface.getModelCompareById((Long)var4[0].getValue());
                }

                if (var2.equals("getModelCompareByName")) {
                    return this.publicInterface.getModelCompareByName((String)var4[0].getValue());
                }

                if (var2.equals("getModelMergerById")) {
                    return this.publicInterface.getModelMergerById((Long)var4[0].getValue());
                }

                if (var2.equals("getModelMergerByName")) {
                    return this.publicInterface.getModelMergerByName((String)var4[0].getValue());
                }

                if (var2.equals("getObjectIDMById")) {
                    return this.publicInterface.getObjectIDMById((Long)var4[0].getValue());
                }

                if (var2.equals("getObjectIDMByName")) {
                    return this.publicInterface.getObjectIDMByName((String)var4[0].getValue());
                }

                if (var2.equals("getPluginDescriptor")) {
                    return this.publicInterface.getPluginDescriptor((Long)var4[0].getValue());
                }

                if (var2.equals("getPluginObjectDefinition")) {
                    return this.publicInterface.getPluginObjectDefinition((Long)var4[0].getValue());
                }

                if (var2.equals("getPluginSettings")) {
                    return this.publicInterface.getPluginSettings((Long)var4[0].getValue());
                }

                if (var2.equals("getRenderEngineById")) {
                    return this.publicInterface.getRenderEngineById((Long)var4[0].getValue());
                }

                if (var2.equals("getRenderEngineByName")) {
                    return this.publicInterface.getRenderEngineByName((String)var4[0].getValue());
                }

                if (var2.equals("getSerializerByPluginClassName")) {
                    return this.publicInterface.getSerializerByPluginClassName((String)var4[0].getValue());
                }

                if (var2.equals("getSerializerPluginDescriptor")) {
                    return this.publicInterface.getSerializerPluginDescriptor((String)var4[0].getValue());
                }

                if (var2.equals("getWebModuleById")) {
                    return this.publicInterface.getWebModuleById((Long)var4[0].getValue());
                }

                if (var2.equals("getWebModuleByName")) {
                    return this.publicInterface.getWebModuleByName((String)var4[0].getValue());
                }

                if (var2.equals("hasActiveSerializer")) {
                    return this.publicInterface.hasActiveSerializer((String)var4[0].getValue());
                }

                if (var2.equals("setDefaultModelCompare")) {
                    this.publicInterface.setDefaultModelCompare((Long)var4[0].getValue());
                } else if (var2.equals("setDefaultModelMerger")) {
                    this.publicInterface.setDefaultModelMerger((Long)var4[0].getValue());
                } else if (var2.equals("setDefaultObjectIDM")) {
                    this.publicInterface.setDefaultObjectIDM((Long)var4[0].getValue());
                } else if (var2.equals("setDefaultQueryEngine")) {
                    this.publicInterface.setDefaultQueryEngine((Long)var4[0].getValue());
                } else if (var2.equals("setDefaultRenderEngine")) {
                    this.publicInterface.setDefaultRenderEngine((Long)var4[0].getValue());
                } else if (var2.equals("setDefaultSerializer")) {
                    this.publicInterface.setDefaultSerializer((Long)var4[0].getValue());
                } else if (var2.equals("setDefaultWebModule")) {
                    this.publicInterface.setDefaultWebModule((Long)var4[0].getValue());
                } else if (var2.equals("setPluginSettings")) {
                    this.publicInterface.setPluginSettings((Long)var4[0].getValue(), (SObjectType)var4[1].getValue());
                } else if (var2.equals("updateDeserializer")) {
                    this.publicInterface.updateDeserializer((SDeserializerPluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateInternalService")) {
                    this.publicInterface.updateInternalService((SInternalServicePluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateModelCompare")) {
                    this.publicInterface.updateModelCompare((SModelComparePluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateModelMerger")) {
                    this.publicInterface.updateModelMerger((SModelMergerPluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateObjectIDM")) {
                    this.publicInterface.updateObjectIDM((SObjectIDMPluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateQueryEngine")) {
                    this.publicInterface.updateQueryEngine((SQueryEnginePluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateRenderEngine")) {
                    this.publicInterface.updateRenderEngine((SRenderEnginePluginConfiguration)var4[0].getValue());
                } else if (var2.equals("updateSerializer")) {
                    this.publicInterface.updateSerializer((SSerializerPluginConfiguration)var4[0].getValue());
                }
            }
        }

        return null;
    }
}
