//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.List;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1LowLevelInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1LowLevelInterfaceReflector1 implements Reflector {
    Bimsie1LowLevelInterface publicInterface;

    public Bimsie1LowLevelInterfaceReflector1(Bimsie1LowLevelInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("abortTransaction")) {
                this.publicInterface.abortTransaction((Long)var4[0].getValue());
            } else if (var2.equals("addBooleanAttribute")) {
                this.publicInterface.addBooleanAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Boolean)var4[3].getValue());
            } else if (var2.equals("addDoubleAttribute")) {
                this.publicInterface.addDoubleAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Double)var4[3].getValue());
            } else if (var2.equals("addIntegerAttribute")) {
                this.publicInterface.addIntegerAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
            } else if (var2.equals("addReference")) {
                this.publicInterface.addReference((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Long)var4[3].getValue());
            } else if (var2.equals("addStringAttribute")) {
                this.publicInterface.addStringAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue());
            } else {
                if (var2.equals("commitTransaction")) {
                    return this.publicInterface.commitTransaction((Long)var4[0].getValue(), (String)var4[1].getValue());
                }

                if (var2.equals("count")) {
                    return this.publicInterface.count((Long)var4[0].getValue(), (String)var4[1].getValue());
                }

                if (var2.equals("createObject")) {
                    return this.publicInterface.createObject((Long)var4[0].getValue(), (String)var4[1].getValue(), (Boolean)var4[2].getValue());
                }

                if (var2.equals("getBooleanAttribute")) {
                    return this.publicInterface.getBooleanAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getBooleanAttributeAtIndex")) {
                    return this.publicInterface.getBooleanAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                }

                if (var2.equals("getBooleanAttributes")) {
                    return this.publicInterface.getBooleanAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getByteArrayAttribute")) {
                    return this.publicInterface.getByteArrayAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getByteArrayAttributes")) {
                    return this.publicInterface.getByteArrayAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getDataObjectByGuid")) {
                    return this.publicInterface.getDataObjectByGuid((Long)var4[0].getValue(), (String)var4[1].getValue());
                }

                if (var2.equals("getDataObjectByOid")) {
                    return this.publicInterface.getDataObjectByOid((Long)var4[0].getValue(), (Long)var4[1].getValue());
                }

                if (var2.equals("getDataObjects")) {
                    return this.publicInterface.getDataObjects((Long)var4[0].getValue());
                }

                if (var2.equals("getDataObjectsByType")) {
                    return this.publicInterface.getDataObjectsByType((Long)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue(), (Boolean)var4[3].getValue());
                }

                if (var2.equals("getDoubleAttribute")) {
                    return this.publicInterface.getDoubleAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getDoubleAttributeAtIndex")) {
                    return this.publicInterface.getDoubleAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                }

                if (var2.equals("getDoubleAttributes")) {
                    return this.publicInterface.getDoubleAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getEnumAttribute")) {
                    return this.publicInterface.getEnumAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getIntegerAttribute")) {
                    return this.publicInterface.getIntegerAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getIntegerAttributeAtIndex")) {
                    return this.publicInterface.getIntegerAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                }

                if (var2.equals("getIntegerAttributes")) {
                    return this.publicInterface.getIntegerAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getLongAttribute")) {
                    return this.publicInterface.getLongAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getLongAttributeAtIndex")) {
                    return this.publicInterface.getLongAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                }

                if (var2.equals("getReference")) {
                    return this.publicInterface.getReference((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getReferences")) {
                    return this.publicInterface.getReferences((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getStringAttribute")) {
                    return this.publicInterface.getStringAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("getStringAttributes")) {
                    return this.publicInterface.getStringAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("removeAllReferences")) {
                    this.publicInterface.removeAllReferences((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                } else if (var2.equals("removeAttribute")) {
                    this.publicInterface.removeAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                } else if (var2.equals("removeObject")) {
                    this.publicInterface.removeObject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                } else if (var2.equals("removeReference")) {
                    this.publicInterface.removeReference((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                } else if (var2.equals("removeReferenceByOid")) {
                    this.publicInterface.removeReferenceByOid((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Long)var4[3].getValue());
                } else if (var2.equals("setBooleanAttribute")) {
                    this.publicInterface.setBooleanAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Boolean)var4[3].getValue());
                } else if (var2.equals("setBooleanAttributeAtIndex")) {
                    this.publicInterface.setBooleanAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue(), (Boolean)var4[4].getValue());
                } else if (var2.equals("setBooleanAttributes")) {
                    this.publicInterface.setBooleanAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (List)var4[3].getValue());
                } else if (var2.equals("setByteArrayAttribute")) {
                    this.publicInterface.setByteArrayAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Byte[])var4[3].getValue());
                } else if (var2.equals("setDoubleAttribute")) {
                    this.publicInterface.setDoubleAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Double)var4[3].getValue());
                } else if (var2.equals("setDoubleAttributeAtIndex")) {
                    this.publicInterface.setDoubleAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue(), (Double)var4[4].getValue());
                } else if (var2.equals("setDoubleAttributes")) {
                    this.publicInterface.setDoubleAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (List)var4[3].getValue());
                } else if (var2.equals("setEnumAttribute")) {
                    this.publicInterface.setEnumAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue());
                } else if (var2.equals("setIntegerAttribute")) {
                    this.publicInterface.setIntegerAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue());
                } else if (var2.equals("setIntegerAttributeAtIndex")) {
                    this.publicInterface.setIntegerAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue(), (Integer)var4[4].getValue());
                } else if (var2.equals("setIntegerAttributes")) {
                    this.publicInterface.setIntegerAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (List)var4[3].getValue());
                } else if (var2.equals("setLongAttribute")) {
                    this.publicInterface.setLongAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Long)var4[3].getValue());
                } else if (var2.equals("setLongAttributeAtIndex")) {
                    this.publicInterface.setLongAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue(), (Long)var4[4].getValue());
                } else if (var2.equals("setLongAttributes")) {
                    this.publicInterface.setLongAttributes((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (List)var4[3].getValue());
                } else if (var2.equals("setReference")) {
                    this.publicInterface.setReference((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Long)var4[3].getValue());
                } else if (var2.equals("setStringAttribute")) {
                    this.publicInterface.setStringAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue());
                } else if (var2.equals("setStringAttributeAtIndex")) {
                    this.publicInterface.setStringAttributeAtIndex((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Integer)var4[3].getValue(), (String)var4[4].getValue());
                } else if (var2.equals("setWrappedBooleanAttribute")) {
                    this.publicInterface.setWrappedBooleanAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue(), (Boolean)var4[4].getValue());
                } else if (var2.equals("setWrappedDoubleAttribute")) {
                    this.publicInterface.setWrappedDoubleAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue(), (Double)var4[4].getValue());
                } else if (var2.equals("setWrappedIntegerAttribute")) {
                    this.publicInterface.setWrappedIntegerAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue(), (Integer)var4[4].getValue());
                } else if (var2.equals("setWrappedLongAttribute")) {
                    this.publicInterface.setWrappedLongAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue(), (Long)var4[4].getValue());
                } else if (var2.equals("setWrappedStringAttribute")) {
                    this.publicInterface.setWrappedStringAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue(), (String)var4[4].getValue());
                } else {
                    if (var2.equals("startTransaction")) {
                        return this.publicInterface.startTransaction((Long)var4[0].getValue());
                    }

                    if (var2.equals("unsetAttribute")) {
                        this.publicInterface.unsetAttribute((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                    } else if (var2.equals("unsetReference")) {
                        this.publicInterface.unsetReference((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                    }
                }
            }
        }

        return null;
    }
}
