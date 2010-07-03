package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Site")
public class Site extends Location {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Site.demographic")
   private Collection<java.lang.String> demographic;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Site.ServiceLocations")
   private ServiceLocation ServiceLocations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Site.siteType")
   private Collection<java.lang.String> siteType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Site.ErpSiteLevelData")
   private Collection<ErpSiteLevelData> ErpSiteLevelData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Site.ErpInventory")
   private Collection<ErpInventory> ErpInventory;
}
