package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SwitchAssetModel")
public class SwitchAssetModel extends ElectricalAssetModel {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchAssetModel.remote")
   private Collection<java.lang.Boolean> remote;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchAssetModel.gang")
   private Collection<java.lang.Boolean> gang;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SwitchAssetModel.interruptingRating")
   private Collection<java.lang.Float> interruptingRating;
}
