package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpProjectAccounting")
public class ErpProjectAccounting extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpProjectAccounting.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpProjectAccounting.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpProjectAccounting.Projects")
   private Project Projects;
}
