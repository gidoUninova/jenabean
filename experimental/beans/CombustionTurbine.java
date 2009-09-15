package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CombustionTurbine")
public class CombustionTurbine extends PrimeMover {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.auxPowerVersusVoltage")
   private Collection<java.lang.Float> auxPowerVersusVoltage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.powerVariationByTemp")
   private Collection<java.lang.Float> powerVariationByTemp;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.CTTempMWCurve")
   private CTTempMWCurve CTTempMWCurve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.referenceTemp")
   private Collection<java.lang.Float> referenceTemp;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.heatRecoveryFlag")
   private Collection<java.lang.Boolean> heatRecoveryFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.capabilityVersusFrequency")
   private Collection<java.lang.Float> capabilityVersusFrequency;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.timeConstant")
   private Collection<java.lang.Float> timeConstant;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.auxPowerVersusFrequency")
   private Collection<java.lang.Float> auxPowerVersusFrequency;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.ambientTemp")
   private Collection<java.lang.Float> ambientTemp;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.Drives_AirCompressor")
   private AirCompressor Drives_AirCompressor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombustionTurbine.HeatRecoveryBoiler")
   private HeatRecoveryBoiler HeatRecoveryBoiler;
}
