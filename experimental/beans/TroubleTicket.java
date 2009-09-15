package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TroubleTicket")
public class TroubleTicket extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.hazardCode")
   private Collection<java.lang.String> hazardCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.priority")
   private EnumeratedType priority;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.timeOfCall")
   private Collection<java.lang.String> timeOfCall;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.numberCalls")
   private Collection<java.math.BigInteger> numberCalls;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.callBackRestore")
   private Collection<java.lang.Boolean> callBackRestore;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.restorationTime")
   private Collection<java.lang.String> restorationTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.typeOfTrouble")
   private Collection<java.lang.String> typeOfTrouble;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.Customer")
   private Customer Customer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TroubleTicket.callBackERT")
   private Collection<java.lang.Boolean> callBackERT;
}
