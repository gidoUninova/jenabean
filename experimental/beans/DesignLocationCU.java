package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DesignLocationCU")
public class DesignLocationCU extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocationCU.CUGroups")
   private Collection<CUGroup> CUGroups;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocationCU.CompatibleUnits")
   private Collection<CompatibleUnit> CompatibleUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocationCU.CUTasks")
   private CUTask CUTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocationCU.DesignLocation")
   private DesignLocation DesignLocation;
}
