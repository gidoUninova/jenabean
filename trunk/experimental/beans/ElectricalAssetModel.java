package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ElectricalAssetModel")
public class ElectricalAssetModel extends AssetModel {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectricalAssetModel.frequency")
   private Collection<java.lang.Float> frequency;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectricalAssetModel.ratedAmps")
   private Collection<java.lang.Float> ratedAmps;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectricalAssetModel.ratedVolts")
   private Collection<java.lang.Float> ratedVolts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectricalAssetModel.ratedMVA")
   private Collection<java.lang.Float> ratedMVA;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectricalAssetModel.bil")
   private Collection<java.lang.Float> bil;
}
