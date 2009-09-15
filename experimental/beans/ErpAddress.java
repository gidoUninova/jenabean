package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpAddress")
public class ErpAddress extends Location {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.ServiceLocation")
   private ServiceLocation ServiceLocation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.streetType")
   private Collection<java.lang.String> streetType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.addressGeneral")
   private Collection<java.lang.String> addressGeneral;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.city")
   private Collection<java.lang.String> city;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.stateOrProvince")
   private Collection<java.lang.String> stateOrProvince;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.ErpPartner")
   private ErpPartner ErpPartner;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.suiteNumber")
   private Collection<java.lang.String> suiteNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.WorkBillingInfo")
   private WorkBillingInfo WorkBillingInfo;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.postalCode")
   private Collection<java.lang.String> postalCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.townCode")
   private Collection<java.lang.String> townCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.streetNumber")
   private Collection<java.lang.String> streetNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.streetPrefix")
   private Collection<java.lang.String> streetPrefix;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.streetSuffix")
   private Collection<java.lang.String> streetSuffix;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.section")
   private Collection<java.lang.String> section;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.streetName")
   private Collection<java.lang.String> streetName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.ErpContacts")
   private Collection<ErpContact> ErpContacts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.country")
   private Collection<java.lang.String> country;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.poBox")
   private Collection<java.lang.String> poBox;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpAddress.Appointments")
   private Appointment Appointments;
}
