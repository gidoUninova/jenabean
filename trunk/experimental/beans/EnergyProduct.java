package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EnergyProduct")
public class EnergyProduct extends Agreement {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.EnergyTransactions")
   private EnergyTransaction EnergyTransactions;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.ResoldBy_Marketer")
   private Marketer ResoldBy_Marketer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.TitleHeldBy_Marketer")
   private Marketer TitleHeldBy_Marketer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.GenerationProvider")
   private GenerationProvider GenerationProvider;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.InjectionPointFor")
   private ServicePoint InjectionPointFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.Bids")
   private Collection<Bid> Bids;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProduct.BilateralTransactions")
   private Collection<BilateralTransaction> BilateralTransactions;
}
