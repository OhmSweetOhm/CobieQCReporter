package org.bimserver.cobie.shared.unit.length;

import org.bimserver.cobie.shared.unit.UnitTextMatcher;
import org.bimserver.models.ifc2x3tc1.Ifc2x3tc1Factory;
import org.bimserver.models.ifc2x3tc1.IfcSIPrefix;
import org.bimserver.models.ifc2x3tc1.IfcSIUnit;
import org.bimserver.models.ifc2x3tc1.IfcSIUnitName;
import org.bimserver.models.ifc2x3tc1.IfcUnit;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class CentimeterTextMatcher extends UnitTextMatcher
{
    private static final String[] CENTIMETER_STRINGS =
    {
            "cm", "centimeter", "centimeters", "centimetre", "centimetres"
    };

    public CentimeterTextMatcher(String searchString)
    {
        super(searchString);
    }

    @Override
    protected String[] getTargetStringArray()
    {
        return CENTIMETER_STRINGS;
    }

    @Override
    public IfcUnit getTargetUnit()
    {
        IfcSIUnit siUnit = Ifc2x3tc1Factory.eINSTANCE.createIfcSIUnit();
        siUnit.setUnitType(IfcUnitEnum.LENGTHUNIT);
        siUnit.setName(IfcSIUnitName.METRE);
        siUnit.setPrefix(IfcSIPrefix.CENTI);

        return siUnit;
    }
}
