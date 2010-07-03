package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Rating")
public class Rating extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.Assets")
   private Collection<Asset> Assets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.property")
   private Collection<java.lang.String> property;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.units")
   private Collection<java.lang.String> units;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.ratingType")
   private Collection<java.lang.String> ratingType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.ratingValue")
   private Collection<java.lang.Float> ratingValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.AssetModel")
   private AssetModel AssetModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Rating.Limit")
   private Limit Limit;
}
