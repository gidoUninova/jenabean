package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AccessPermit")
public class AccessPermit extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AccessPermit.permitType")
   private Collection<java.lang.String> permitType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AccessPermit.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AccessPermit.permitID")
   private Collection<java.lang.String> permitID;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AccessPermit.applicationNumber")
   private Collection<java.lang.String> applicationNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AccessPermit.payment")
   private Collection<java.lang.Float> payment;
}
