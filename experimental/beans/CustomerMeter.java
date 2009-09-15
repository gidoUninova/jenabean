package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CustomerMeter")
public class CustomerMeter extends EnergyConsumer {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.PowerTransformer")
   private PowerTransformer PowerTransformer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.Bids")
   private Bid Bids;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.ServiceLocation")
   private ServiceLocation ServiceLocation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.MeterAsset")
   private MeterAsset MeterAsset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.CustomerAgreements")
   private Collection<CustomerAgreement> CustomerAgreements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.Intervals")
   private Collection<Interval> Intervals;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerMeter.PowerQualityPricing")
   private PowerQualityPricing PowerQualityPricing;
}
