package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("BilateralTransaction")
public class BilateralTransaction extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.transactionType")
   private Collection<java.lang.String> transactionType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.Receipt_Pnode")
   private Pnode Receipt_Pnode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.marketType")
   private Collection<java.lang.String> marketType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.scope")
   private Collection<java.lang.String> scope;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.BilateralTranClearing")
   private BilateralTranClearing BilateralTranClearing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.curtailTimeMin")
   private Collection<java.math.BigInteger> curtailTimeMin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.purchaseTimeMin")
   private Collection<java.math.BigInteger> purchaseTimeMin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.EnergyProducts")
   private Collection<EnergyProduct> EnergyProducts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.Delivery_Pnode")
   private Pnode Delivery_Pnode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.purchaseTimeMax")
   private Collection<java.math.BigInteger> purchaseTimeMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.curtailTimeMax")
   private Collection<java.math.BigInteger> curtailTimeMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTransaction.totalTranChargeMax")
   private Collection<java.lang.Float> totalTranChargeMax;
}
