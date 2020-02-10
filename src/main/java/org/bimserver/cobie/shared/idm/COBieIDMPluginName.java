package org.bimserver.cobie.shared.idm;

public enum COBieIDMPluginName
{
    BAMieIDMPluginName("BAMie IDM Plugin"), BPieIDMPluginName("BPie IDM Plugin"), COBieIDMPluginName("COBieIDMPlugin"), COBieIDMNoProxyObjects(
            "COBieIDM IgnoreProxyObjects");
    private String pluginName;

    private COBieIDMPluginName(String pluginName)
    {
        this.pluginName = pluginName;
    }

    @Override
    public String toString()
    {
        return pluginName;
    }
}
