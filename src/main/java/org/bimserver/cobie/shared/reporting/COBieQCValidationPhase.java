package org.bimserver.cobie.shared.reporting;



import net.sf.saxon.s9api.QName;
import net.sf.saxon.s9api.XdmAtomicValue;

public enum COBieQCValidationPhase
{
    Design("Design"), Construction("Construction");
    private QName phaseParameterName = new QName("phase");
    private XdmAtomicValue phaseParameterValue;
    private QName titleParameterName = new QName("Title");
    private XdmAtomicValue titleParameterValue;
    private COBieQCValidationPhase(String parameterValue)
    {
        this.phaseParameterValue = new XdmAtomicValue(parameterValue);
        this.setTitleParameterValue(new XdmAtomicValue(getReportTitle()));
    }
    
    public QName getSchematronPhaseParameterName()
    {
        return this.phaseParameterName;
    }
    
    public XdmAtomicValue getSchematronPhaseParameterValue()
    {
        return this.phaseParameterValue;
    }
    
    public String getReportTitle()
    {
        return "COBie QC report - " + getSchematronPhaseParameterValue().getStringValue() + " Deliverable";
    }

    public QName getTitleParameterName()
    {
        return titleParameterName;
    }

    public void setTitleParameterName(QName titleParameterName)
    {
        this.titleParameterName = titleParameterName;
    }

    public XdmAtomicValue getTitleParameterValue()
    {
        return titleParameterValue;
    }

    public void setTitleParameterValue(XdmAtomicValue titleParameterValue)
    {
        this.titleParameterValue = titleParameterValue;
    }
    
    public static COBieQCValidationPhase fromString(String phase)
    {
    	COBieQCValidationPhase valPhase = null;
    	if(phase.equalsIgnoreCase(COBieQCValidationPhase.Construction.toString()))
    	{
    		valPhase = COBieQCValidationPhase.Construction;
    	}
    	else if (phase.equalsIgnoreCase(COBieQCValidationPhase.Design.toString()))
    	{
    		valPhase = COBieQCValidationPhase.Design;
    	}
    	return valPhase;
    }
}
