package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AssetModel")
public class AssetModel extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.QualificationRequirements")
   private Collection<QualificationRequirement> QualificationRequirements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.corpStandard")
   private Collection<java.lang.String> corpStandard;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.version")
   private Collection<java.lang.String> version;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.Properites")
   private Property Properites;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.number")
   private Collection<java.lang.String> number;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.usage")
   private Collection<java.lang.String> usage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.Ratings")
   private Rating Ratings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.Dimensions")
   private Dimensions Dimensions;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetModel.MaterialItems")
   private Collection<MaterialItem> MaterialItems;
}
