package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CostType")
public class CostType extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.level")
   private Collection<java.lang.String> level;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.amountAssignmentFlag")
   private Collection<java.lang.Boolean> amountAssignmentFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.parent_CostType")
   private CostType parent_CostType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.stage")
   private Collection<java.lang.String> stage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.CompatibleUnits")
   private CompatibleUnit CompatibleUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CostType.child_CostType")
   private CostType child_CostType;
}
