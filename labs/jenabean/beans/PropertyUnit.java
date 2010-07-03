package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PropertyUnit")
public class PropertyUnit extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PropertyUnit.costCode")
   private Collection<java.lang.String> costCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PropertyUnit.propertyAccount")
   private Collection<java.lang.String> propertyAccount;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PropertyUnit.WorkCostDetail")
   private Collection<WorkCostDetail> WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PropertyUnit.materialCode")
   private Collection<java.lang.String> materialCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PropertyUnit.activityCode")
   private Collection<java.lang.String> activityCode;
}
