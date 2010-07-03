package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LocationGrant")
public class LocationGrant extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LocationGrant.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LocationGrant.RightOfWays")
   private Collection<RightOfWay> RightOfWays;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LocationGrant.Locations")
   private Collection<Location> Locations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LocationGrant.grantType")
   private Collection<java.lang.String> grantType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LocationGrant.propertyData")
   private Collection<java.lang.String> propertyData;
}
