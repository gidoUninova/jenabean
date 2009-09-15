package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ServiceLocation")
public class ServiceLocation extends Location {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.CustomerAreement")
   private CustomerAgreement CustomerAreement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.loadMgmt")
   private Collection<java.lang.String> loadMgmt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.accessMethod")
   private Collection<java.lang.String> accessMethod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.Route")
   private Collection<Route> Route;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.billingCycle")
   private Collection<java.lang.String> billingCycle;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.budgetBill")
   private Collection<java.lang.String> budgetBill;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.Serves_Site")
   private Site Serves_Site;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.servType")
   private Collection<java.lang.String> servType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.ErpAddress")
   private ErpAddress ErpAddress;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.MeterAssets")
   private MeterAsset MeterAssets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.CustomerMeters")
   private CustomerMeter CustomerMeters;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceLocation.code")
   private Collection<java.lang.String> code;
}
