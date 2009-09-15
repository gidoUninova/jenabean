package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CULaborItem")
public class CULaborItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborItem.CompatibleUnit")
   private CompatibleUnit CompatibleUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborItem.QualificationRequirements")
   private Collection<QualificationRequirement> QualificationRequirements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborItem.laborRate")
   private Collection<java.lang.Float> laborRate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborItem.activityCode")
   private Collection<java.lang.String> activityCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborItem.CULaborCode")
   private CULaborCode CULaborCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CULaborItem.laborHours")
   private Collection<java.lang.Float> laborHours;
}
