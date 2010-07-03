package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Asset")
public class Asset extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.assetType")
   private Collection<java.lang.String> assetType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Dimensions")
   private Dimensions Dimensions;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.AssetLists")
   private Collection<AssetList> AssetLists;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Location")
   private Location Location;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.purchaseDate")
   private Collection<java.lang.String> purchaseDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Measurements")
   private Measurement Measurements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.purchaseOrderNumber")
   private Collection<java.lang.String> purchaseOrderNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.RightOfWays")
   private Collection<RightOfWay> RightOfWays;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.purchasePrice")
   private Collection<java.lang.Float> purchasePrice;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.currentStatus")
   private Collection<java.lang.String> currentStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.PowerSystemResource")
   private Collection<PowerSystemResource> PowerSystemResource;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.critical")
   private Collection<java.lang.Boolean> critical;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.financialValue")
   private Collection<java.lang.Float> financialValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.plantTransferDate")
   private Collection<java.lang.String> plantTransferDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Ratings")
   private Collection<Rating> Ratings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Zone")
   private Zone Zone;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.statusDate")
   private Collection<java.lang.String> statusDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.serialNumber")
   private Collection<java.lang.String> serialNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.maufacturedDate")
   private Collection<java.lang.String> maufacturedDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.utc")
   private Collection<java.lang.String> utc;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.usage")
   private Collection<java.lang.String> usage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.testStatus")
   private Collection<java.lang.Boolean> testStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.condition")
   private Collection<java.lang.String> condition;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Presentations")
   private Presentation Presentations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.Properties")
   private Collection<Property> Properties;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.lotNumber")
   private Collection<java.lang.String> lotNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Asset.warrantyDate")
   private Collection<java.lang.String> warrantyDate;
}
