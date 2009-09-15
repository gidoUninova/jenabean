package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpPartner")
public class ErpPartner extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPartner.partnerTypeQualifier")
   private Collection<java.lang.String> partnerTypeQualifier;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPartner.ErpAddresses")
   private ErpAddress ErpAddresses;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPartner.Organisations")
   private Collection<Organisation> Organisations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPartner.optOut")
   private Collection<java.lang.Boolean> optOut;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPartner.marketRole")
   private Collection<java.lang.String> marketRole;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPartner.Customer")
   private Customer Customer;
}
