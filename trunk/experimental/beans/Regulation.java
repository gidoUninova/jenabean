package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Regulation")
public class Regulation extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Regulation.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Regulation.regulationID")
   private Collection<java.lang.String> regulationID;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Regulation.regulationType")
   private Collection<java.lang.String> regulationType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Regulation.referenceNumber")
   private Collection<java.lang.String> referenceNumber;
}
