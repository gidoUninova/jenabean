package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OutageStep")
public class OutageStep extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.averageCustMinIntrpt")
   private Collection<java.math.BigInteger> averageCustMinIntrpt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.jobPriority")
   private Collection<java.lang.String> jobPriority;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.fatality")
   private Collection<java.lang.Boolean> fatality;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.numberSpecialCustomers")
   private Collection<java.math.BigInteger> numberSpecialCustomers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.Crews")
   private Collection<Crew> Crews;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.shocks")
   private Collection<java.lang.Boolean> shocks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.numberCallers")
   private Collection<java.math.BigInteger> numberCallers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.injury")
   private Collection<java.lang.Boolean> injury;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.currentStatus")
   private Collection<java.lang.String> currentStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.offDateTime")
   private Collection<java.lang.String> offDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.OutageCodes")
   private Collection<OutageCode> OutageCodes;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.estRestoreDateTime")
   private Collection<java.lang.String> estRestoreDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.damage")
   private Collection<java.lang.Boolean> damage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.onDateTime")
   private Collection<java.lang.String> onDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.numberCriticalCustomers")
   private Collection<java.math.BigInteger> numberCriticalCustomers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.customerMinutesLost")
   private Collection<java.math.BigInteger> customerMinutesLost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.OutageRecord")
   private OutageRecord OutageRecord;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageStep.numberTotalCustomers")
   private Collection<java.math.BigInteger> numberTotalCustomers;
}
