package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OutageRecord")
public class OutageRecord extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.isPlanned")
   private Collection<java.lang.Boolean> isPlanned;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.OutageSteps")
   private OutageStep OutageSteps;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.currentStatus")
   private Collection<java.lang.String> currentStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.OutageCodes")
   private Collection<OutageCode> OutageCodes;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.OutageReport")
   private OutageReport OutageReport;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.startDateTime")
   private Collection<java.lang.String> startDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.damageCode")
   private Collection<java.lang.String> damageCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.mode")
   private Collection<java.lang.String> mode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.actionTaken")
   private Collection<java.lang.String> actionTaken;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.outageType")
   private EnumeratedType outageType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageRecord.endDateTime")
   private Collection<java.lang.String> endDateTime;
}
