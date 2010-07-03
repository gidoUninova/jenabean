package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OutageCode")
public class OutageCode extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageCode.subCode")
   private Collection<java.lang.String> subCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageCode.OutageRecords")
   private Collection<OutageRecord> OutageRecords;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageCode.OutageSteps")
   private Collection<OutageStep> OutageSteps;
}
