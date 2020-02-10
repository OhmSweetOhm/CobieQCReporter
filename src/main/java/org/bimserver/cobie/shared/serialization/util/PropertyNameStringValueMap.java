package org.bimserver.cobie.shared.serialization.util;

import java.util.HashMap;

import org.bimserver.models.ifc2x3tc1.IfcProperty;

public class PropertyNameStringValueMap extends HashMap<String, String>
{
    /**
     * 
     */
    private static final long serialVersionUID = 4270640288642678599L;
    private HashMap<String, IfcProperty> propertyMap;

    public PropertyNameStringValueMap()
    {
        super();
        propertyMap = new HashMap<String, IfcProperty>();
    }

    public IfcProperty getAssociatedProperty(String propertyName)
    {
        return propertyMap.get(propertyName);
    }

    public void put(String key, String value, IfcProperty property)
    {
        super.put(key, value);
        propertyMap.put(key, property);
    }
}
