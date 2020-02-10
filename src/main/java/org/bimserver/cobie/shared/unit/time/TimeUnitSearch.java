package org.bimserver.cobie.shared.unit.time;

import org.bimserver.cobie.shared.unit.IfcUnitSearch;
import org.bimserver.models.ifc2x3tc1.IfcUnitEnum;

public class TimeUnitSearch extends IfcUnitSearch
{

    /**
     * 
     */
    private static final long serialVersionUID = -1489191551756369270L;

    public TimeUnitSearch(String searchString)
    {
        super(searchString, IfcUnitEnum.TIMEUNIT);
    }

    @Override
    protected void addSearchItems()
    {
        add(new DaysTextMatcher(searchString));
        add(new HoursTextMatcher(searchString));
        add(new MinutesTextMatcher(searchString));
        add(new MonthsTextMatcher(searchString));
        add(new SecondsTextMatcher(searchString));
        add(new WeeksTextMatcher(searchString));
        add(new YearsTextMatcher(searchString));
    }

}
