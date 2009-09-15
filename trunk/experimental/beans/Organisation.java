package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Organisation")
public class Organisation extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.currentStatus")
   private Collection<java.lang.String> currentStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.mode")
   private Collection<java.lang.String> mode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.number")
   private Collection<java.lang.String> number;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.IntSchedAgreement")
   private Collection<IntSchedAgreement> IntSchedAgreement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.costCenterFlag")
   private Collection<java.lang.Boolean> costCenterFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.grants.RightOfWays")
   private Collection<RightOfWay> grants_RightOfWays;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.type")
   private Collection<java.lang.String> type;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.ErpPartner")
   private Collection<ErpPartner> ErpPartner;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.recipientOf.RightOfWays")
   private Collection<RightOfWay> recipientOf_RightOfWays;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Organisation.profitCenterFlag")
   private Collection<java.lang.Boolean> profitCenterFlag;
}
