package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OperationalRestriction")
public class OperationalRestriction extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OperationalRestriction.reason")
   private Collection<java.lang.String> reason;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OperationalRestriction.endDateTime")
   private Collection<java.lang.String> endDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OperationalRestriction.PowerSystemResources")
   private PowerSystemResource PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OperationalRestriction.startDateTime")
   private Collection<java.lang.String> startDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OperationalRestriction.restriction")
   private Collection<java.lang.String> restriction;
}
