package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CableAssetModel")
public class CableAssetModel extends ElectricalAssetModel {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.outerJacket")
   private Collection<java.lang.String> outerJacket;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.conductorMaterial")
   private Collection<java.lang.String> conductorMaterial;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.insulatingCompound")
   private Collection<java.lang.String> insulatingCompound;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.LinearConductor")
   private LinearConductorAsset LinearConductor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.shieldType")
   private Collection<java.lang.String> shieldType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.neutralCondDesign")
   private Collection<java.lang.String> neutralCondDesign;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.strandFillFlag")
   private Collection<java.lang.Boolean> strandFillFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.insulationThickness")
   private Collection<java.lang.Float> insulationThickness;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.construction")
   private Collection<java.lang.String> construction;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.insulationType")
   private Collection<java.lang.String> insulationType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.sheathMaterial")
   private Collection<java.lang.String> sheathMaterial;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.nominalTemp")
   private Collection<java.lang.Float> nominalTemp;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.sheathNeutral")
   private Collection<java.lang.Boolean> sheathNeutral;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CableAssetModel.numConductors")
   private Collection<java.math.BigInteger> numConductors;
}
