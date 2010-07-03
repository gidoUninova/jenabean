package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LinearConductorAsset")
public class LinearConductorAsset extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.insulated")
   private Collection<java.lang.Boolean> insulated;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.groundingMethod")
   private Collection<java.lang.String> groundingMethod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.ConductorType")
   private ConductorType ConductorType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.CircuitSection")
   private CircuitSection CircuitSection;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.CableAssetModel")
   private CableAssetModel CableAssetModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.ACLineSegments")
   private ACLineSegment ACLineSegments;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LinearConductorAsset.orientation")
   private Collection<java.lang.Boolean> orientation;
}
