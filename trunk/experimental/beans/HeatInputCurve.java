package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HeatInputCurve")
public class HeatInputCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatInputCurve.netGrossMWFlag")
   private Collection<java.lang.Boolean> netGrossMWFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatInputCurve.auxPowerMult")
   private Collection<java.lang.Float> auxPowerMult;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatInputCurve.heatInputOffset")
   private Collection<java.lang.Float> heatInputOffset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatInputCurve.auxPowerOffset")
   private Collection<java.lang.Float> auxPowerOffset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatInputCurve.heatInputEff")
   private Collection<java.lang.Float> heatInputEff;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatInputCurve.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
}
