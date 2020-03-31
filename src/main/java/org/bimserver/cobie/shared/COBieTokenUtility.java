package org.bimserver.cobie.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.bimserver.cobie.shared.utility.COBieUtility.CobieSheetName;

public class COBieTokenUtility
{
    public enum AssemblyColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, SheetName, ParentName, ChildNames, AssemblyType,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description
    }

    public enum AttributeColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, SheetName, RowName, Value, Unit,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description, AllowedValues
    }

    public enum ComponentColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, TypeName, Space, Description,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, SerialNumber, InstallationDate, WarrantyStartDate, TagNumber, BarCode, AssetIdentifier
    }

    public enum ConnectionColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, ConnectionType, SheetName, RowName1, RowName2, RealizingElement, PortName1, PortName2,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description
    }

    public enum ContactColumnNameLiterals
    {
        Email, CreatedBy, CreatedOn, Category, Company, Phone, ExternalSystem, ExternalObject, ExternalIdentifier, Department, OrganizationCode, GivenName, FamilyName, Street, PostalBox, Town, StateRegion, PostalCode, Country
    }

    public enum CoordinateColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, SheetName, RowName, CoordinateXAxis, CoordinateYAxis, CoordinateZAxis,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, ClockwiseRotation, ElevationalRotation, YawRotation
    }

    public enum DocumentColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ApprovalBy, Stage, SheetName, RowName, Directory, File,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description, Reference
    }

    public enum FacilityColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ProjectName, SiteName, LinearUnits, AreaUnits, VolumeUnits, CurrencyUnit, AreaMeasurement, ExternalSystem, ExternalProjectObject, ExternalProjectIdentifier, ExternalSiteObject, ExternalSiteIdentifier, ExternalFacilityObject, ExternalFacilityIdentifier, Description, ProjectDescription, SiteDescription, Phase
    }

    public enum FloorColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description, Elevation, Height
    }

    public enum ImpactColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, ImpactType, ImpactStage, SheetName, RowName, Value, ImpactUnit, LeadInTime, Duration, LeadOutTime,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description
    }

    public enum IssueColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Type, Risk, Chance, Impact, SheetName1, RowName1, SheetName2, RowName2, Description, Owner, Mitigation,
        ExternalSystem
    }

    public enum JobColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, Status, TypeName, Description, Duration, DurationUnit, Start, TaskStartUnit, Frequency, FrequencyUnit,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, TaskNumber, Priors, ResourceNames
    }

    public enum ResourceColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description
    }

    public enum SpaceColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, FloorName, Description,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, RoomTag, UsableHeight, GrossArea, NetArea
    }

    public enum SpareColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, TypeName, Suppliers,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description, SetNumber, PartNumber
    }

    public enum SystemColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, ComponentNames,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description
    }

    public enum TypeColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, Description, AssetType, Manufacturer, ModelNumber, WarrantyGuarantorParts, WarrantyDurationParts, WarrantyGuarantorLabor, WarrantyDurationLabor, WarrantyDurationUnit,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, ReplacementCost, ExpectedLife, DurationUnit, WarrantyDescription, NominalLength, NominalWidth, NominalHeight, ModelReference, Shape, Size, Color, Finish, Grade, Material, Constituents, Features, AccessibilityPerformance, CodePerformance, SustainabilityPerformance
    }

    public enum ZoneColumnNameLiterals
    {
        Name, CreatedBy, CreatedOn, Category, SpaceNames,
        ExternalSystem,
        ExternalObject,
        ExternalIdentifier, Description
    }

    // TODO Move all column name,sheet name enums/lists here
    public static final ArrayList<String> AssemblyColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                              "CreatedBy",
                                                                                              "CreatedOn",
                                                                                              "SheetName",
                                                                                              "ParentName",
                                                                                              "ChildNames",
                                                                                              "AssemblyType",
                                                                                              "ExternalSystem",
                                                                                              "ExternalObject",
                                                                                              "ExternalIdentifier",
                                                                                              "Description"));

    public static ArrayList<String> AttributeColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                         "CreatedBy",
                                                                                         "CreatedOn",
                                                                                         "Category",
                                                                                         "SheetName",
                                                                                         "RowName",
                                                                                         "Value",
                                                                                         "Unit",
                                                                                         "ExternalSystem",
                                                                                         "ExternalObject",
                                                                                         "ExternalIdentifier",
                                                                                         "Description",
                                                                                         "AllowedValues"));

    public static ArrayList<String> ComponentColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                         "CreatedBy",
                                                                                         "CreatedOn",
                                                                                         "TypeName",
                                                                                         "Space",
                                                                                         "Description",
                                                                                         "ExternalSystem",
                                                                                         "ExternalObject",
                                                                                         "ExternalIdentifier",
                                                                                         "SerialNumber",
                                                                                         "InstallationDate",
                                                                                         "WarrantyStartDate",
                                                                                         "TagNumber",
                                                                                         "BarCode",
                                                                                         "AssetIdentifier"));

    public static ArrayList<String> ConnectionColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                          "CreatedBy",
                                                                                          "CreatedOn",
                                                                                          "ConnectionType",
                                                                                          "SheetName",
                                                                                          "RowName1",
                                                                                          "RowName2",
                                                                                          "RealizingElement",
                                                                                          "PortName1",
                                                                                          "PortName2",
                                                                                          "ExternalSystem",
                                                                                          "ExternalObject",
                                                                                          "ExternalIdentifier",
                                                                                          "Description"));

    public static ArrayList<String> ContactColumnNames = new ArrayList<>(Arrays.asList("Email",
                                                                                       "CreatedBy",
                                                                                       "CreatedOn",
                                                                                       "Category",
                                                                                       "Company",
                                                                                       "Phone",
                                                                                       "ExternalSystem",
                                                                                       "ExternalObject",
                                                                                       "ExternalIdentifier",
                                                                                       "Department",
                                                                                       "OrganizationCode",
                                                                                       "GivenName",
                                                                                       "FamilyName",
                                                                                       "Street",
                                                                                       "PostalBox",
                                                                                       "Town",
                                                                                       "StateRegion",
                                                                                       "PostalCode",
                                                                                       "Country"));

    public static ArrayList<String> CoordinateColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                          "CreatedBy",
                                                                                          "CreatedOn",
                                                                                          "Category",
                                                                                          "SheetName",
                                                                                          "RowName",
                                                                                          "CoordinateXAxis",
                                                                                          "CoordinateYAxis",
                                                                                          "CoordinateZAxis",
                                                                                          "ExternalSystem",
                                                                                          "ExternalObject",
                                                                                          "ExternalIdentifier",
                                                                                          "ClockwiseRotation",
                                                                                          "ElevationalRotation",
                                                                                          "YawRotation"));

    public static ArrayList<String> DocumentColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                        "CreatedBy",
                                                                                        "CreatedOn",
                                                                                        "Category",
                                                                                        "ApprovalBy",
                                                                                        "Stage",
                                                                                        "SheetName",
                                                                                        "RowName",
                                                                                        "Directory",
                                                                                        "File",
                                                                                        "ExternalSystem",
                                                                                        "ExternalObject",
                                                                                        "ExternalIdentifier",
                                                                                        "Description",
                                                                                        "Reference"));

    public static ArrayList<String> FacilityColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                        "CreatedBy",
                                                                                        "CreatedOn",
                                                                                        "Category",
                                                                                        "ProjectName",
                                                                                        "SiteName",
                                                                                        "LinearUnits",
                                                                                        "AreaUnits",
                                                                                        "VolumeUnits",
                                                                                        "CurrencyUnit",
                                                                                        "AreaMeasurement",
                                                                                        "ExternalSystem",
                                                                                        "ExternalProjectObject",
                                                                                        "ExternalProjectIdentifier",
                                                                                        "ExternalSiteObject",
                                                                                        "ExternalSiteIdentifier",
                                                                                        "ExternalFacilityObject",
                                                                                        "ExternalFacilityIdentifier",
                                                                                        "Description",
                                                                                        "ProjectDescription",
                                                                                        "SiteDescription",
                                                                                        "Phase"));

    public static ArrayList<String> FloorColumnNames = new ArrayList<>(Arrays.asList("Name", "CreatedBy", "CreatedOn", "Category", "ExternalSystem",
            "ExternalObject", "ExternalIdentifier", "Description", "Elevation", "Height"));

    public static ArrayList<String> ImpactColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                      "CreatedBy",
                                                                                      "CreatedOn",
                                                                                      "ImpactType",
                                                                                      "ImpactStage",
                                                                                      "SheetName",
                                                                                      "RowName",
                                                                                      "Value",
                                                                                      "ImpactUnit",
                                                                                      "LeadInTime",
                                                                                      "Duration",
                                                                                      "LeadOutTime",
                                                                                      "ExternalSystem",
                                                                                      "ExternalObject",
                                                                                      "ExternalIdentifier",
                                                                                      "Description"));

    public static ArrayList<String> IssueColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                     "CreatedBy",
                                                                                     "CreatedOn",
                                                                                     "Type",
                                                                                     "Risk",
                                                                                     "Chance",
                                                                                     "Impact",
                                                                                     "SheetName1",
                                                                                     "RowName1",
                                                                                     "SheetName2",
                                                                                     "RowName2",
                                                                                     "Description",
                                                                                     "Owner",
                                                                                     "Mitigation",
                                                                                     "ExternalSystem"));

    public static ArrayList<String> JobColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                   "CreatedBy",
                                                                                   "CreatedOn",
                                                                                   "Category",
                                                                                   "Status",
                                                                                   "TypeName",
                                                                                   "Description",
                                                                                   "Duration",
                                                                                   "DurationUnit",
                                                                                   "Start",
                                                                                   "TaskStartUnit",
                                                                                   "Frequency",
                                                                                   "FrequencyUnit",
                                                                                   "ExternalSystem",
                                                                                   "ExternalObject",
                                                                                   "ExternalIdentifier",
                                                                                   "TaskNumber",
                                                                                   "Priors",
                                                                                   "ResourceNames"));

    public static ArrayList<String> ResourceColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                        "CreatedBy",
                                                                                        "CreatedOn",
                                                                                        "Category",
                                                                                        "ExternalSystem",
                                                                                        "ExternalObject",
                                                                                        "ExternalIdentifier",
                                                                                        "Description"));

    public static ArrayList<String> SpaceColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                     "CreatedBy",
                                                                                     "CreatedOn",
                                                                                     "Category",
                                                                                     "FloorName",
                                                                                     "Description",
                                                                                     "ExternalSystem",
                                                                                     "ExternalObject",
                                                                                     "ExternalIdentifier",
                                                                                     "RoomTag",
                                                                                     "UsableHeight",
                                                                                     "GrossArea",
                                                                                     "NetArea"));

    public static ArrayList<String> SpareColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                     "CreatedBy",
                                                                                     "CreatedOn",
                                                                                     "Category",
                                                                                     "TypeName",
                                                                                     "Suppliers",
                                                                                     "ExternalSystem",
                                                                                     "ExternalObject",
                                                                                     "ExternalIdentifier",
                                                                                     "Description",
                                                                                     "SetNumber",
                                                                                     "PartNumber"));

    public static ArrayList<String> SystemColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                      "CreatedBy",
                                                                                      "CreatedOn",
                                                                                      "Category",
                                                                                      "ComponentNames",
                                                                                      "ExternalSystem",
                                                                                      "ExternalObject",
                                                                                      "ExternalIdentifier",
                                                                                      "Description"));

    public static ArrayList<String> TypeColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                    "CreatedBy",
                                                                                    "CreatedOn",
                                                                                    "Category",
                                                                                    "Description",
                                                                                    "AssetType",
                                                                                    "Manufacturer",
                                                                                    "ModelNumber",
                                                                                    "WarrantyGuarantorParts",
                                                                                    "WarrantyDurationParts",
                                                                                    "WarrantyGuarantorLabor",
                                                                                    "WarrantyDurationLabor",
                                                                                    "WarrantyDurationUnit",
                                                                                    "ExternalSystem",
                                                                                    "ExternalObject",
                                                                                    "ExternalIdentifier",
                                                                                    "ReplacementCost",
                                                                                    "ExpectedLife",
                                                                                    "DurationUnit",
                                                                                    "WarrantyDescription",
                                                                                    "NominalLength",
                                                                                    "NominalWidth",
                                                                                    "NominalHeight",
                                                                                    "ModelReference",
                                                                                    "Shape",
                                                                                    "Size",
                                                                                    "Color",
                                                                                    "Finish",
                                                                                    "Grade",
                                                                                    "Material",
                                                                                    "Constituents",
                                                                                    "Features",
                                                                                    "AccessibilityPerformance",
                                                                                    "CodePerformance",
                                                                                    "SustainabilityPerformance"));

    public static ArrayList<String> ZoneColumnNames = new ArrayList<>(Arrays.asList("Name",
                                                                                    "CreatedBy",
                                                                                    "CreatedOn",
                                                                                    "Category",
                                                                                    "SpaceNames",
                                                                                    "ExternalSystem",
                                                                                    "ExternalObject",
                                                                                    "ExternalIdentifier",
                                                                                    "Description"));

    public static HashMap<CobieSheetName, ArrayList<String>> getCobieSheetNameColumnMappings()
    {
        // TODO complete this with the other sheets
        HashMap<CobieSheetName, ArrayList<String>> columnMappings = new HashMap<>();
        columnMappings.put(CobieSheetName.Contact, ContactColumnNames);
        columnMappings.put(CobieSheetName.Facility, FacilityColumnNames);
        columnMappings.put(CobieSheetName.Floor, FloorColumnNames);
        columnMappings.put(CobieSheetName.Space, SpaceColumnNames);
        columnMappings.put(CobieSheetName.Zone, ZoneColumnNames);
        columnMappings.put(CobieSheetName.Type, TypeColumnNames);
        columnMappings.put(CobieSheetName.Component, ComponentColumnNames);
        columnMappings.put(CobieSheetName.System, SystemColumnNames);
        columnMappings.put(CobieSheetName.Assembly, AssemblyColumnNames);
        columnMappings.put(CobieSheetName.Connection, ConnectionColumnNames);
        columnMappings.put(CobieSheetName.Spare, SpareColumnNames);
        columnMappings.put(CobieSheetName.Resource, ResourceColumnNames);
        columnMappings.put(CobieSheetName.Job, JobColumnNames);
        columnMappings.put(CobieSheetName.Impact, ImpactColumnNames);
        columnMappings.put(CobieSheetName.Document, DocumentColumnNames);
        columnMappings.put(CobieSheetName.Attribute, AttributeColumnNames);
        columnMappings.put(CobieSheetName.Coordinate, CoordinateColumnNames);
        columnMappings.put(CobieSheetName.Issue, IssueColumnNames);
        return columnMappings;
    }

}
