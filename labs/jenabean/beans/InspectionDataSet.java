package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("InspectionDataSet")
public class InspectionDataSet extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InspectionDataSet.Properties")
   private Property Properties;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InspectionDataSet.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InspectionDataSet.Procedure")
   private Procedure Procedure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InspectionDataSet.AccordingTo.Schedule")
   private Schedule AccordingTo_Schedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InspectionDataSet.inspectDate")
   private Collection<java.lang.String> inspectDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InspectionDataSet.locationConditions")
   private Collection<java.lang.String> locationConditions;
}
