package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Pnode")
public class Pnode extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.BilateralTransaction")
   private BilateralTransaction BilateralTransaction;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.Bids")
   private Bid Bids;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.public")
   private Collection<java.lang.Boolean> Public;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.PnodeClearing")
   private PnodeClearing PnodeClearing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.beginPeriod")
   private Collection<java.lang.String> beginPeriod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.type")
   private Collection<java.lang.String> type;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.usage")
   private Collection<java.lang.String> usage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.RTOs")
   private RTO RTOs;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.ConnectivityNode")
   private ConnectivityNode ConnectivityNode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.BilateralTransactions")
   private BilateralTransaction BilateralTransactions;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pnode.endPeriod")
   private Collection<java.lang.String> endPeriod;
}
