package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PowerTransformer")
public class PowerTransformer extends Equipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.phases")
   private Collection<java.math.BigInteger> phases;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.CustomerMeters")
   private CustomerMeter CustomerMeters;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.transfCoolingType")
   private TransformerCoolingType transfCoolingType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.HeatExchanger")
   private HeatExchanger HeatExchanger;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.bmagSat")
   private Collection<java.lang.Float> bmagSat;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.magSatFlux")
   private Collection<java.lang.Float> magSatFlux;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.magBaseKV")
   private Collection<java.lang.Float> magBaseKV;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.Contains_TransformerWindings")
   private TransformerWinding Contains_TransformerWindings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerTransformer.transformerType")
   private TransformerType transformerType;
}
