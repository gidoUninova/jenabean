package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WorkCostSummary")
public class WorkCostSummary extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostSummary.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
}
