package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RightOfWay")
public class RightOfWay extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.LocationGrants")
   private Collection<LocationGrant> LocationGrants;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.Assets")
   private Collection<Asset> Assets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.date")
   private Collection<java.lang.String> date;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.propertyData")
   private Collection<java.lang.String> propertyData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.rightOfWayType")
   private Collection<java.lang.String> rightOfWayType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.recipient.Organisations")
   private Collection<Organisation> recipient_Organisations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RightOfWay.grantedBy.Organisations")
   private Collection<Organisation> grantedBy_Organisations;
}
