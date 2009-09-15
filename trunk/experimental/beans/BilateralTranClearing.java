package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("BilateralTranClearing")
public class BilateralTranClearing extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTranClearing.dpClearedMW")
   private Collection<java.lang.Float> dpClearedMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTranClearing.rpClearedMW")
   private Collection<java.lang.Float> rpClearedMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BilateralTranClearing.BilateralTransactions")
   private BilateralTransaction BilateralTransactions;
}
