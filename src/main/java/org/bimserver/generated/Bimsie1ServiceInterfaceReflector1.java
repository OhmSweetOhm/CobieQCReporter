//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.bimserver.generated;

import java.util.Set;
import javax.activation.DataHandler;
import org.bimserver.interfaces.objects.SExtendedData;
import org.bimserver.shared.interfaces.bimsie1.Bimsie1ServiceInterface;
import org.bimserver.shared.reflector.KeyValuePair;
import org.bimserver.shared.reflector.Reflector;

public class Bimsie1ServiceInterfaceReflector1 implements Reflector {
    Bimsie1ServiceInterface publicInterface;

    public Bimsie1ServiceInterfaceReflector1(Bimsie1ServiceInterface var1) {
        this.publicInterface = var1;
    }

    public Object callMethod(String var1, String var2, Class var3, KeyValuePair[] var4) throws Exception {
        if (true) {
            if (var2.equals("addExtendedDataToRevision")) {
                this.publicInterface.addExtendedDataToRevision((Long)var4[0].getValue(), (SExtendedData)var4[1].getValue());
            } else {
                if (var2.equals("addProject")) {
                    return this.publicInterface.addProject((String)var4[0].getValue(), (String)var4[1].getValue());
                }

                if (var2.equals("addProjectAsSubProject")) {
                    return this.publicInterface.addProjectAsSubProject((String)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue());
                }

                if (var2.equals("branchToExistingProject")) {
                    return this.publicInterface.branchToExistingProject((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Boolean)var4[3].getValue());
                }

                if (var2.equals("branchToNewProject")) {
                    return this.publicInterface.branchToNewProject((Long)var4[0].getValue(), (String)var4[1].getValue(), (String)var4[2].getValue(), (Boolean)var4[3].getValue());
                }

                if (var2.equals("checkin")) {
                    return this.publicInterface.checkin((Long)var4[0].getValue(), (String)var4[1].getValue(), (Long)var4[2].getValue(), (Long)var4[3].getValue(), (String)var4[4].getValue(), (DataHandler)var4[5].getValue(), (Boolean)var4[6].getValue());
                }

                if (var2.equals("checkinFromUrl")) {
                    return this.publicInterface.checkinFromUrl((Long)var4[0].getValue(), (String)var4[1].getValue(), (Long)var4[2].getValue(), (String)var4[3].getValue(), (String)var4[4].getValue(), (Boolean)var4[5].getValue());
                }

                if (var2.equals("checkout")) {
                    return this.publicInterface.checkout((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Boolean)var4[2].getValue());
                }

                if (var2.equals("deleteProject")) {
                    return this.publicInterface.deleteProject((Long)var4[0].getValue());
                }

                if (var2.equals("download")) {
                    return this.publicInterface.download((Long)var4[0].getValue(), (Long)var4[1].getValue(), (Boolean)var4[2].getValue(), (Boolean)var4[3].getValue());
                }

                if (var2.equals("downloadByGuids")) {
                    return this.publicInterface.downloadByGuids((Set)var4[0].getValue(), (Set)var4[1].getValue(), (Long)var4[2].getValue(), (Boolean)var4[3].getValue(), (Boolean)var4[4].getValue());
                }

                if (var2.equals("downloadByJsonQuery")) {
                    return this.publicInterface.downloadByJsonQuery((Set)var4[0].getValue(), (String)var4[1].getValue(), (Long)var4[2].getValue(), (Boolean)var4[3].getValue());
                }

                if (var2.equals("downloadByNames")) {
                    return this.publicInterface.downloadByNames((Set)var4[0].getValue(), (Set)var4[1].getValue(), (Long)var4[2].getValue(), (Boolean)var4[3].getValue(), (Boolean)var4[4].getValue());
                }

                if (var2.equals("downloadByOids")) {
                    return this.publicInterface.downloadByOids((Set)var4[0].getValue(), (Set)var4[1].getValue(), (Long)var4[2].getValue(), (Boolean)var4[3].getValue(), (Boolean)var4[4].getValue());
                }

                if (var2.equals("downloadByTypes")) {
                    return this.publicInterface.downloadByTypes((Set)var4[0].getValue(), (String)var4[1].getValue(), (Set)var4[2].getValue(), (Long)var4[3].getValue(), (Boolean)var4[4].getValue(), (Boolean)var4[5].getValue(), (Boolean)var4[6].getValue(), (Boolean)var4[7].getValue());
                }

                if (var2.equals("downloadQuery")) {
                    return this.publicInterface.downloadQuery((Long)var4[0].getValue(), (Long)var4[1].getValue(), (String)var4[2].getValue(), (Boolean)var4[3].getValue(), (Long)var4[4].getValue());
                }

                if (var2.equals("downloadRevisions")) {
                    return this.publicInterface.downloadRevisions((Set)var4[0].getValue(), (Long)var4[1].getValue(), (Boolean)var4[2].getValue());
                }

                if (var2.equals("getAllExtendedDataOfRevision")) {
                    return this.publicInterface.getAllExtendedDataOfRevision((Long)var4[0].getValue());
                }

                if (var2.equals("getAllProjects")) {
                    return this.publicInterface.getAllProjects((Boolean)var4[0].getValue(), (Boolean)var4[1].getValue());
                }

                if (var2.equals("getAllProjectsSmall")) {
                    return this.publicInterface.getAllProjectsSmall();
                }

                if (var2.equals("getAllRevisionsOfProject")) {
                    return this.publicInterface.getAllRevisionsOfProject((Long)var4[0].getValue());
                }

                if (var2.equals("getDeserializerById")) {
                    return this.publicInterface.getDeserializerById((Long)var4[0].getValue());
                }

                if (var2.equals("getDeserializerByName")) {
                    return this.publicInterface.getDeserializerByName((String)var4[0].getValue());
                }

                if (var2.equals("getDownloadData")) {
                    return this.publicInterface.getDownloadData((Long)var4[0].getValue());
                }

                if (var2.equals("getExtendedData")) {
                    return this.publicInterface.getExtendedData((Long)var4[0].getValue());
                }

                if (var2.equals("getExtendedDataSchemaById")) {
                    return this.publicInterface.getExtendedDataSchemaById((Long)var4[0].getValue());
                }

                if (var2.equals("getExtendedDataSchemaByNamespace")) {
                    return this.publicInterface.getExtendedDataSchemaByNamespace((String)var4[0].getValue());
                }

                if (var2.equals("getProjectByPoid")) {
                    return this.publicInterface.getProjectByPoid((Long)var4[0].getValue());
                }

                if (var2.equals("getProjectSmallByPoid")) {
                    return this.publicInterface.getProjectSmallByPoid((Long)var4[0].getValue());
                }

                if (var2.equals("getProjectsByName")) {
                    return this.publicInterface.getProjectsByName((String)var4[0].getValue());
                }

                if (var2.equals("getQueryEngineById")) {
                    return this.publicInterface.getQueryEngineById((Long)var4[0].getValue());
                }

                if (var2.equals("getQueryEngineByName")) {
                    return this.publicInterface.getQueryEngineByName((String)var4[0].getValue());
                }

                if (var2.equals("getRevision")) {
                    return this.publicInterface.getRevision((Long)var4[0].getValue());
                }

                if (var2.equals("getSerializerByContentType")) {
                    return this.publicInterface.getSerializerByContentType((String)var4[0].getValue());
                }

                if (var2.equals("getSerializerById")) {
                    return this.publicInterface.getSerializerById((Long)var4[0].getValue());
                }

                if (var2.equals("getSerializerByName")) {
                    return this.publicInterface.getSerializerByName((String)var4[0].getValue());
                }

                if (var2.equals("getSubProjects")) {
                    return this.publicInterface.getSubProjects((Long)var4[0].getValue());
                }

                if (var2.equals("getSuggestedDeserializerForExtension")) {
                    return this.publicInterface.getSuggestedDeserializerForExtension((String)var4[0].getValue(), (Long)var4[1].getValue());
                }

                if (var2.equals("terminateLongRunningAction")) {
                    this.publicInterface.terminateLongRunningAction((Long)var4[0].getValue());
                } else if (var2.equals("undeleteProject")) {
                    return this.publicInterface.undeleteProject((Long)var4[0].getValue());
                }
            }
        }

        return null;
    }
}
