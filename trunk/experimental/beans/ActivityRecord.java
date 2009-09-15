package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ActivityRecord")
public class ActivityRecord extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.statusDate")
   private Collection<java.lang.String> statusDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.statusReason")
   private Collection<java.lang.String> statusReason;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.planned")
   private Collection<java.lang.Boolean> planned;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.MarketFactors")
   private Collection<MarketFactors> MarketFactors;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.History")
   private History History;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ActivityRecord.remarks")
   private Collection<java.lang.String> remarks;
}
