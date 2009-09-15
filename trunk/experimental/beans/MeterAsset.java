package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MeterAsset")
public class MeterAsset extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.sealNo")
   private Collection<java.lang.String> sealNo;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.password")
   private Collection<java.lang.String> password;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.CustomerMeter")
   private CustomerMeter CustomerMeter;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.kWCMultiplier")
   private Collection<java.math.BigInteger> kWCMultiplier;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.MeterAssetModel")
   private MeterAssetModel MeterAssetModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.kWhMultiplier")
   private Collection<java.math.BigInteger> kWhMultiplier;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.demandMultiplier")
   private Collection<java.math.BigInteger> demandMultiplier;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAsset.ServiceLocation")
   private ServiceLocation ServiceLocation;
}
