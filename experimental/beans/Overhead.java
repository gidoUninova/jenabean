package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Overhead")
public class Overhead extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Overhead.WorkTasks")
   private WorkTask WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Overhead.cost")
   private Collection<java.lang.Float> cost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Overhead.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Overhead.code")
   private Collection<java.lang.String> code;
}
