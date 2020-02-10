//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import javax.activation.DataHandler;
import org.bimserver.interfaces.objects.SCompareType;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.interfaces.objects.SExtendedDataSchema;
import org.bimserver.interfaces.objects.SFile;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SModelCheckerInstance;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SService;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.interfaces.ServiceInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class ServiceInterfaceReflector1 implements Reflector {
    ServiceInterface publicInterface;

    public ServiceInterfaceReflector1(ServiceInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("addExtendedDataSchema")) {
                return this.publicInterface.addExtendedDataSchema((SExtendedDataSchema)var4[0].getValue());
            }

            if (var2.equals("addExtendedDataToProject")) {
                this.publicInterface.addExtendedDataToProject((Long)var4[0].getValue(), (SExtendedData)var4[1].getValue());
            } else if (var2.equals("addLocalServiceToProject")) {
                this.publicInterface.addLocalServiceToProject((Long)var4[0].getValue(), (SService)var4[1].getValue(), (Long)var4[2].getValue());
            } else {
                if (var2.equals("addModelChecker")) {
                    return this.publicInterface.addModelChecker((SModelCheckerInstance)var4[0].getValue());
                }

                if (var2.equals("addModelCheckerToProject")) {
                    this.publicInterface.addModelCheckerToProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                } else {
                    if (var2.equals("addServiceToProject")) {
                        return this.publicInterface.addServiceToProject((Long)var4[0].getValue(), (SService)var4[1].getValue());
                    }

                    if (var2.equals("addUser")) {
                        return this.publicInterface.addUser((String)var4[0].getValue(), (String)var4[1].getValue(), (SUserType)var4[2].getValue(), (Boolean)var4[3].getValue(), (String)var4[4].getValue());
                    }

                    if (var2.equals("addUserToExtendedDataSchema")) {
                        this.publicInterface.addUserToExtendedDataSchema((Long)var4[0].getValue(), (Long)var4[1].getValue());
                    } else {
                        if (var2.equals("addUserToProject")) {
                            return this.publicInterface.addUserToProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                        }

                        if (var2.equals("addUserWithPassword")) {
                            return this.publicInterface.addUserWithPassword((String)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue(), (SUserType)var4[3].getValue(), (Boolean)var4[4].getValue(), (String)var4[5].getValue());
                        }

                        if (var2.equals("changeUserType")) {
                            this.publicInterface.changeUserType((Long)var4[0].getValue(), (SUserType)var4[1].getValue());
                        } else {
                            if (var2.equals("checkin")) {
                                return this.publicInterface.checkin((Long)var4[0].getValue(), (String)var4[1].getValue(), (Long)var4[2].getValue(), (Long)var4[3].getValue(), (String)var4[4].getValue(), (DataHandler)var4[5].getValue(), (Boolean)var4[6].getValue(), (Boolean)var4[7].getValue());
                            }

                            if (var2.equals("checkinFromUrl")) {
                                return this.publicInterface.checkinFromUrl((Long)var4[0].getValue(), (String)var4[1].getValue(), (Long)var4[2].getValue(), (String)var4[3].getValue(), (String)var4[4].getValue(), (Boolean)var4[5].getValue(), (Boolean)var4[6].getValue());
                            }

                            if (var2.equals("cleanupLongAction")) {
                                this.publicInterface.cleanupLongAction((Long)var4[0].getValue());
                            } else {
                                if (var2.equals("compare")) {
                                    return this.publicInterface.compare((Long)var4[0].getValue(), (Long)var4[1].getValue(), (SCompareType)var4[2].getValue(), (Long)var4[3].getValue());
                                }

                                if (var2.equals("deleteService")) {
                                    this.publicInterface.deleteService((Long)var4[0].getValue());
                                } else {
                                    if (var2.equals("deleteUser")) {
                                        return this.publicInterface.deleteUser((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("downloadCompareResults")) {
                                        return this.publicInterface.downloadCompareResults((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue(), (Long)var4[3].getValue(), (SCompareType)var4[4].getValue(), (Boolean)var4[5].getValue());
                                    }

                                    if (var2.equals("getAllAuthorizedUsersOfProject")) {
                                        return this.publicInterface.getAllAuthorizedUsersOfProject((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllCheckoutsByUser")) {
                                        return this.publicInterface.getAllCheckoutsByUser((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllCheckoutsOfProject")) {
                                        return this.publicInterface.getAllCheckoutsOfProject((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllCheckoutsOfProjectAndSubProjects")) {
                                        return this.publicInterface.getAllCheckoutsOfProjectAndSubProjects((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllCheckoutsOfRevision")) {
                                        return this.publicInterface.getAllCheckoutsOfRevision((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllExtendedDataSchemas")) {
                                        return this.publicInterface.getAllExtendedDataSchemas();
                                    }

                                    if (var2.equals("getAllLocalProfiles")) {
                                        return this.publicInterface.getAllLocalProfiles((String)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllLocalServiceDescriptors")) {
                                        return this.publicInterface.getAllLocalServiceDescriptors();
                                    }

                                    if (var2.equals("getAllModelCheckers")) {
                                        return this.publicInterface.getAllModelCheckers();
                                    }

                                    if (var2.equals("getAllModelCheckersOfProject")) {
                                        return this.publicInterface.getAllModelCheckersOfProject((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllNonAuthorizedProjectsOfUser")) {
                                        return this.publicInterface.getAllNonAuthorizedProjectsOfUser((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllNonAuthorizedUsersOfProject")) {
                                        return this.publicInterface.getAllNonAuthorizedUsersOfProject((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllPrivateProfiles")) {
                                        return this.publicInterface.getAllPrivateProfiles((String)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue());
                                    }

                                    if (var2.equals("getAllPublicProfiles")) {
                                        return this.publicInterface.getAllPublicProfiles((String)var4[0].getValue(), (String)var4[1].getValue());
                                    }

                                    if (var2.equals("getAllReadableProjects")) {
                                        return this.publicInterface.getAllReadableProjects();
                                    }

                                    if (var2.equals("getAllRelatedProjects")) {
                                        return this.publicInterface.getAllRelatedProjects((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllRepositoryExtendedDataSchemas")) {
                                        return this.publicInterface.getAllRepositoryExtendedDataSchemas();
                                    }

                                    if (var2.equals("getAllRepositoryModelCheckers")) {
                                        return this.publicInterface.getAllRepositoryModelCheckers();
                                    }

                                    if (var2.equals("getAllRevisionsByUser")) {
                                        return this.publicInterface.getAllRevisionsByUser((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllServiceDescriptors")) {
                                        return this.publicInterface.getAllServiceDescriptors();
                                    }

                                    if (var2.equals("getAllServicesOfProject")) {
                                        return this.publicInterface.getAllServicesOfProject((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getAllUsers")) {
                                        return this.publicInterface.getAllUsers();
                                    }

                                    if (var2.equals("getAllWritableProjects")) {
                                        return this.publicInterface.getAllWritableProjects();
                                    }

                                    if (var2.equals("getArea")) {
                                        return this.publicInterface.getArea((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                    }

                                    if (var2.equals("getAvailableClasses")) {
                                        return this.publicInterface.getAvailableClasses();
                                    }

                                    if (var2.equals("getAvailableClassesInRevision")) {
                                        return this.publicInterface.getAvailableClassesInRevision((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getCheckinWarnings")) {
                                        return this.publicInterface.getCheckinWarnings((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getCheckoutWarnings")) {
                                        return this.publicInterface.getCheckoutWarnings((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getExtendedDataSchemaFromRepository")) {
                                        return this.publicInterface.getExtendedDataSchemaFromRepository((String)var4[0].getValue());
                                    }

                                    if (var2.equals("getFile")) {
                                        return this.publicInterface.getFile((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getGeoTag")) {
                                        return this.publicInterface.getGeoTag((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getIfcHeader")) {
                                        return this.publicInterface.getIfcHeader((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getModelCheckerInstance")) {
                                        return this.publicInterface.getModelCheckerInstance((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getOidByGuid")) {
                                        return this.publicInterface.getOidByGuid((Long)var4[0].getValue(), (String)var4[1].getValue());
                                    }

                                    if (var2.equals("getQueryEngineExample")) {
                                        return this.publicInterface.getQueryEngineExample((Long)var4[0].getValue(), (String)var4[1].getValue());
                                    }

                                    if (var2.equals("getQueryEngineExampleKeys")) {
                                        return this.publicInterface.getQueryEngineExampleKeys((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getRevisionSummary")) {
                                        return this.publicInterface.getRevisionSummary((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getService")) {
                                        return this.publicInterface.getService((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getServiceDescriptor")) {
                                        return this.publicInterface.getServiceDescriptor((String)var4[0].getValue(), (String)var4[1].getValue());
                                    }

                                    if (var2.equals("getUserByUoid")) {
                                        return this.publicInterface.getUserByUoid((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getUserByUserName")) {
                                        return this.publicInterface.getUserByUserName((String)var4[0].getValue());
                                    }

                                    if (var2.equals("getUserRelatedLogs")) {
                                        return this.publicInterface.getUserRelatedLogs((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getUserSettings")) {
                                        return this.publicInterface.getUserSettings();
                                    }

                                    if (var2.equals("getUsersProjects")) {
                                        return this.publicInterface.getUsersProjects((Long)var4[0].getValue());
                                    }

                                    if (var2.equals("getVolume")) {
                                        return this.publicInterface.getVolume((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                    }

                                    if (var2.equals("importData")) {
                                        this.publicInterface.importData((String)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue(), (String)var4[3].getValue());
                                    } else if (var2.equals("removeModelCheckerFromProject")) {
                                        this.publicInterface.removeModelCheckerFromProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                    } else if (var2.equals("removeServiceFromProject")) {
                                        this.publicInterface.removeServiceFromProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                    } else if (var2.equals("removeUserFromExtendedDataSchema")) {
                                        this.publicInterface.removeUserFromExtendedDataSchema((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                    } else {
                                        if (var2.equals("removeUserFromProject")) {
                                            return this.publicInterface.removeUserFromProject((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                        }

                                        if (var2.equals("sendCompareEmail")) {
                                            this.publicInterface.sendCompareEmail((SCompareType)var4[0].getValue(), (Long)var4[1].getValue(), (Long)var4[2].getValue(), (Long)var4[3].getValue(), (Long)var4[4].getValue(), (String)var4[5].getValue());
                                        } else if (var2.equals("setRevisionTag")) {
                                            this.publicInterface.setRevisionTag((Long)var4[0].getValue(), (String)var4[1].getValue());
                                        } else {
                                            if (var2.equals("shareRevision")) {
                                                return this.publicInterface.shareRevision((Long)var4[0].getValue());
                                            }

                                            if (var2.equals("triggerNewExtendedData")) {
                                                this.publicInterface.triggerNewExtendedData((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                            } else if (var2.equals("triggerNewRevision")) {
                                                this.publicInterface.triggerNewRevision((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                            } else {
                                                if (var2.equals("undeleteUser")) {
                                                    return this.publicInterface.undeleteUser((Long)var4[0].getValue());
                                                }

                                                if (var2.equals("updateGeoTag")) {
                                                    this.publicInterface.updateGeoTag((SGeoTag)var4[0].getValue());
                                                } else if (var2.equals("updateModelChecker")) {
                                                    this.publicInterface.updateModelChecker((SModelCheckerInstance)var4[0].getValue());
                                                } else if (var2.equals("updateProject")) {
                                                    this.publicInterface.updateProject((SProject)var4[0].getValue());
                                                } else if (var2.equals("updateRevision")) {
                                                    this.publicInterface.updateRevision((SRevision)var4[0].getValue());
                                                } else {
                                                    if (var2.equals("uploadFile")) {
                                                        return this.publicInterface.uploadFile((SFile)var4[0].getValue());
                                                    }

                                                    if (var2.equals("userHasCheckinRights")) {
                                                        return this.publicInterface.userHasCheckinRights((Long)var4[0].getValue(), (Long)var4[1].getValue());
                                                    }

                                                    if (var2.equals("userHasRights")) {
                                                        return this.publicInterface.userHasRights((Long)var4[0].getValue());
                                                    }

                                                    if (var2.equals("validateModelChecker")) {
                                                        this.publicInterface.validateModelChecker((Long)var4[0].getValue());
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }
}
