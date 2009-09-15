package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EmissionCurve")
public class EmissionCurve extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionCurve.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionCurve.emissionContent")
   private Collection<java.lang.Float> emissionContent;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionCurve.emissionType")
   private EmissionType emissionType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionCurve.netGrossMWFlag")
   private Collection<java.lang.Boolean> netGrossMWFlag;
}
