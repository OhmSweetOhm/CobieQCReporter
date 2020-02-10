package org.bimserver.cobie.shared.deserialization.cobietab;

import java.util.ArrayList;
import java.util.HashMap;

import org.bimserver.cobie.shared.deserialization.cobietab.modelhandlers.IfcCommonHandler;
import org.bimserver.cobie.shared.utility.COBieUtility;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcObjectDefinition;
import org.bimserver.models.ifc2x3tc1.IfcRelAggregates;
import org.bimserver.models.ifc2x3tc1.IfcRelNests;
import org.bimserver.models.ifc2x3tc1.IfcRelationship;
import org.nibs.cobie.tab.AssemblyType;
import org.nibs.cobie.tab.COBIEType;

public class AssemblyDeserializer
{
    private COBieIfcModel model;
    private IfcCommonHandler ifcCommonHandler;
    private COBIEType.Assemblies assemblies;
    private HashMap<String, Long> assemblyNameToOid;

    public AssemblyDeserializer(COBieIfcModel cobieIfcModel, IfcCommonHandler ifcCommonHandler, COBIEType.Assemblies assemblies)
    {
        model = cobieIfcModel;
        this.ifcCommonHandler = ifcCommonHandler;
        this.assemblies = assemblies;
        assemblyNameToOid = model.getAssemblyNameToOid();
    }

    private boolean containsComponentAsListedInChildNames(String childNames)
    {
        boolean containsComponentAsListed = model.containsComponent(childNames);
        return containsComponentAsListed;
    }

    private boolean ContainsTypeAsListedInChildNames(String childNames)
    {
        boolean containsTypeAsListed = model.containsType(childNames);
        return containsTypeAsListed;
    }

    @SuppressWarnings("deprecation")
	public void deserializeAssemblies()
    {
        for (AssemblyType assembly : assemblies.getAssemblyArray())
        {
            try
            {
                String sheetName = assembly.getSheetName();
                String parentName = assembly.getParentName();
                String childNames = assembly.getChildNames();
                String name = nameFromAssembly(assembly);
                if (isValidSheetName(sheetName) && isIntegrityValid(sheetName, parentName, childNames))
                {
                    IfcRelationship assemblyRelation;
                    if (assemblyNameToOid.containsKey(name))
                    {
                        assemblyRelation = (IfcRelationship)model.get(assemblyNameToOid.get(name));
                    } else
                    {
                        assemblyRelation = relationshipFromExtObject(assembly.getExtObject());
                        assemblyRelation.setName(name);
                        assemblyRelation.setGlobalId(ifcCommonHandler.getGuidHandler().guidFromExternalIdentifier(assembly.getExtIdentifier())
                                .getWrappedValue());
                        assemblyRelation.setOwnerHistory(ifcCommonHandler.getOwnerHistoryHandler().ownerHistoryFromEmailTimestampAndApplication(
                                assembly.getCreatedBy(), assembly.getCreatedOn(), assembly.getExtSystem()));
                        assemblyRelation.setDescription(assembly.getDescription());

                        long assemblyOid = model.add(assemblyRelation, ifcCommonHandler.getOidProvider());
                        assemblyNameToOid.put(name, assemblyOid);
                        assemblyRelation = (IfcRelationship)model.get(assemblyOid);
                    }
                    populateAssemblyRelations(assemblyRelation, assembly);

                }
            } catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }

    private ArrayList<IfcObjectDefinition> getChildObjects(AssemblyType assembly)
    {
        ArrayList<IfcObjectDefinition> ifcObjDefs = new ArrayList<IfcObjectDefinition>();
        String sheetName = assembly.getSheetName();
        String childNames = assembly.getChildNames();
        ArrayList<String> childNamesArray = COBieUtility.arrayListFromDelimString(childNames);
        if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Type.toString().toLowerCase()))
        {
            if (ContainsTypeAsListedInChildNames(childNames))
            {
                ifcObjDefs.add((IfcObjectDefinition)model.get(model.getTypeOid(childNames)));
            } else
            {
                for (String childName : childNamesArray)
                {
                    ifcObjDefs.add((IfcObjectDefinition)model.get(model.getTypeOid(childName)));
                }
            }
        } else if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Component.toString().toLowerCase()))
        {
            if (containsComponentAsListedInChildNames(childNames))
            {
                ifcObjDefs.add((IfcObjectDefinition)model.get(model.getComponentOid(childNames)));
            } else
            {
                for (String childName : childNamesArray)
                {
                    ifcObjDefs.add((IfcObjectDefinition)model.get(model.getComponentOid(childName)));
                }
            }
        }
        return ifcObjDefs;
    }

    private IfcObjectDefinition getParentObject(AssemblyType assembly)
    {
        String sheetName = assembly.getSheetName();
        String parentName = assembly.getParentName();
        IfcObjectDefinition ifcObj = null;
        if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Type.toString().toLowerCase()))
        {
            ifcObj = (IfcObjectDefinition)model.get(model.getTypeOid(parentName));
        } else if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Component.toString().toLowerCase()))
        {
            ifcObj = (IfcObjectDefinition)model.get(model.getComponentOid(parentName));
        }
        return ifcObj;
    }

    private boolean isIntegrityValid(String sheetName, String parentName, String childNames)
    {
        ArrayList<String> splitChildNames = COBieUtility.arrayListFromDelimString(childNames);
        boolean integrityValid = true;

        if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Type.toString().toLowerCase()))
        {
            integrityValid = model.containsType(parentName);
            boolean containsTypeAsListed = ContainsTypeAsListedInChildNames(childNames);
            if (!containsTypeAsListed)
            {
                for (String typeName : splitChildNames)
                {
                    if (integrityValid)
                    {
                        integrityValid = model.containsType(typeName);
                    }
                }
            }
        } else if (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Component.toString().toLowerCase()))
        {
            integrityValid = model.containsComponent(parentName);
            boolean containsComponentAsListed = containsComponentAsListedInChildNames(childNames);
            if (!containsComponentAsListed)
            {
                for (String compName : splitChildNames)
                {
                    if (integrityValid)
                    {
                        integrityValid = model.containsComponent(compName);
                    }
                }
            }
        } else
        {
            // TODO: Write to log
        }
        return integrityValid;
    }

    private boolean isValidSheetName(String sheetName)
    {
        return (sheetName.toLowerCase().equals(COBieUtility.CobieSheetName.Type.toString().toLowerCase()) || sheetName.toLowerCase().equals(
                COBieUtility.CobieSheetName.Component.toString().toLowerCase()));
    }

    private String nameFromAssembly(AssemblyType assembly)
    {
        String name = assembly.getName();
        if (COBieUtility.isNA(name))
        {
            name = COBieUtility.getCOBieString(assembly.getParentName()) + " " + COBieUtility.getCOBieString(assembly.getChildNames()) + " Assembly";
        }
        return name;

    }

    private void populateAssemblyRelations(IfcRelationship ifcRelationship, AssemblyType assembly)
    {
        assembly.getParentName();
        assembly.getChildNames();
        ArrayList<IfcObjectDefinition> childObjs = getChildObjects(assembly);
        if (ifcRelationship instanceof IfcRelAggregates)
        {
            IfcRelAggregates relAgg = (IfcRelAggregates)ifcRelationship;
            relAgg.setRelatingObject(getParentObject(assembly));
            for (IfcObjectDefinition childObj : childObjs)
            {
                relAgg.getRelatedObjects().add(childObj);
            }

        } else if (ifcRelationship instanceof IfcRelNests)
        {
            IfcRelNests relNests = (IfcRelNests)ifcRelationship;
            relNests.setRelatingObject(getParentObject(assembly));
            for (IfcObjectDefinition childObj : childObjs)
            {
                relNests.getRelatedObjects().add(childObj);
            }
        }
    }

    private IfcRelationship relationshipFromExtObject(String extObject)
    {

        if (extObject.toLowerCase().equals("ifcrelnests"))
        {
            IfcRelNests relNests = Ifc2x3tc1Factory.eINSTANCE.createIfcRelNests();
            return relNests;
        } else
        {
            IfcRelAggregates relAggregates = Ifc2x3tc1Factory.eINSTANCE.createIfcRelAggregates();
            return relAggregates;
        }
    }
}
