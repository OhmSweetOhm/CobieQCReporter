package com.corballis.converter;

public class PickListRule {
    private final String name;
    private final String tabName;
    private final String columnName;

    public PickListRule(String name, String tabName, String columnName) {
        this.name = name;
        this.tabName = tabName;
        this.columnName = columnName;
    }

    public String getName() {
        return name;
    }

    public String getTabName() {
        return tabName;
    }

    public String getColumnName() {
        return columnName;
    }

}
