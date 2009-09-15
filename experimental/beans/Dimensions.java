package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Dimensions")
public class Dimensions extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.sizeLength")
   private Collection<java.lang.Float> sizeLength;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.sizeWidth")
   private Collection<java.lang.Float> sizeWidth;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.sizeDiameter")
   private Collection<java.lang.Float> sizeDiameter;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.orientation")
   private Collection<java.lang.String> orientation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.Assets")
   private Asset Assets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.sizeDepth")
   private Collection<java.lang.Float> sizeDepth;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.sizeUnits")
   private Collection<java.lang.String> sizeUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.AssetModels")
   private AssetModel AssetModels;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dimensions.Locations")
   private Location Locations;
}
