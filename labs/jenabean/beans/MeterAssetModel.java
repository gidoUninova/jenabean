package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MeterAssetModel")
public class MeterAssetModel extends ElectricalAssetModel {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAssetModel.MeterAsset")
   private MeterAsset MeterAsset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAssetModel.form")
   private Collection<java.lang.String> form;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAssetModel.KH")
   private Collection<java.lang.Float> KH;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAssetModel.noDials")
   private Collection<java.math.BigInteger> noDials;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAssetModel.regRatio")
   private Collection<java.lang.Float> regRatio;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeterAssetModel.noWires")
   private Collection<java.math.BigInteger> noWires;
}
