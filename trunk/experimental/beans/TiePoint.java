package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TiePoint")
public class TiePoint extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TiePoint.tiePointMWRating")
   private Collection<java.lang.Float> tiePointMWRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TiePoint.Declares")
   private TransmissionProvider Declares;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TiePoint.For_Measurements")
   private Measurement For_Measurements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TiePoint.By_Measurements")
   private Measurement By_Measurements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TiePoint.Declared_ServicePoint")
   private ServicePoint Declared_ServicePoint;
}
