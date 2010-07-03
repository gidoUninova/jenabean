package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MaintenanceDataSet")
public class MaintenanceDataSet extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaintenanceDataSet.maintDate")
   private Collection<java.lang.String> maintDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaintenanceDataSet.Properties")
   private Property Properties;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaintenanceDataSet.maintCode")
   private Collection<java.lang.String> maintCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaintenanceDataSet.conditionBefore")
   private Collection<java.lang.String> conditionBefore;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaintenanceDataSet.conditionAfter")
   private Collection<java.lang.String> conditionAfter;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaintenanceDataSet.Procedure")
   private Procedure Procedure;
}
