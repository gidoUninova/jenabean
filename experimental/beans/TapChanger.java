package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TapChanger")
public class TapChanger extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.subsequentDelay")
   private Collection<java.lang.Float> subsequentDelay;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.stepVoltageIncrement")
   private Collection<java.lang.Float> stepVoltageIncrement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.Measurement")
   private Measurement Measurement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.RegulationSchedule")
   private RegulationSchedule RegulationSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.tculControlMode")
   private TransformerControlMode tculControlMode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.highStep")
   private Collection<java.math.BigInteger> highStep;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.neutralKV")
   private Collection<java.lang.Float> neutralKV;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.normalStep")
   private Collection<java.math.BigInteger> normalStep;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.neutralStep")
   private Collection<java.math.BigInteger> neutralStep;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.stepPhaseShiftIncrement")
   private Collection<java.lang.Float> stepPhaseShiftIncrement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.initialDelay")
   private Collection<java.lang.Float> initialDelay;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.TransformerWinding")
   private TransformerWinding TransformerWinding;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TapChanger.lowStep")
   private Collection<java.math.BigInteger> lowStep;
}
