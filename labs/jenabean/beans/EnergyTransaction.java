package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EnergyTransaction")
public class EnergyTransaction extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.energyMin")
   private Collection<java.lang.Float> energyMin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.reason")
   private Collection<java.lang.String> reason;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.deliveryPointMW")
   private Collection<java.lang.Float> deliveryPointMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.CurtailmentProfiles")
   private CurtailmentProfile CurtailmentProfiles;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.EnergyProduct")
   private EnergyProduct EnergyProduct;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.state")
   private EnumeratedType state;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.firmInterchangeFlag")
   private Collection<java.lang.Boolean> firmInterchangeFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.EnergyPriceCurves")
   private Collection<EnergyPriceCurve> EnergyPriceCurves;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.congestChargeMax")
   private Collection<java.lang.Float> congestChargeMax;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.LossProfiles")
   private LossProfile LossProfiles;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.EnergyProfiles")
   private EnergyProfile EnergyProfiles;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.AssocatedWith")
   private Collection<ServiceReservation> AssocatedWith;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.Export_SubControlArea")
   private SubControlArea Export_SubControlArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.receiptPointMW")
   private Collection<java.lang.Float> receiptPointMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyTransaction.Import_SubControlArea")
   private SubControlArea Import_SubControlArea;
}
