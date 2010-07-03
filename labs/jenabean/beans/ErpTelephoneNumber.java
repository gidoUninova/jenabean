package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpTelephoneNumber")
public class ErpTelephoneNumber extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.areaCode")
   private Collection<java.lang.String> areaCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.extension")
   private Collection<java.lang.String> extension;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.ErpContacts")
   private Collection<ErpContact> ErpContacts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.countryCode")
   private Collection<java.lang.String> countryCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.usage")
   private Collection<java.lang.String> usage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.cityCode")
   private Collection<java.lang.String> cityCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpTelephoneNumber.localNumber")
   private Collection<java.lang.String> localNumber;
}
