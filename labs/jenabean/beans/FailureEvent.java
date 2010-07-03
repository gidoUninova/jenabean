package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("FailureEvent")
public class FailureEvent extends ActivityRecord {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FailureEvent.isolationMethod")
   private Collection<java.lang.String> isolationMethod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FailureEvent.failureCode")
   private Collection<java.lang.String> failureCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FailureEvent.locationOfFailure")
   private Collection<java.lang.String> locationOfFailure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FailureEvent.faultLocatingMethod")
   private Collection<java.lang.String> faultLocatingMethod;
}
