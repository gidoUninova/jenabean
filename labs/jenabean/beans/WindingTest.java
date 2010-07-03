package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WindingTest")
public class WindingTest extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.fromTapStep")
   private Collection<java.math.BigInteger> fromTapStep;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.phaseShift")
   private Collection<java.lang.Float> phaseShift;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.To_TransformeWindings")
   private TransformerWinding To_TransformeWindings;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.noLoadLoss")
   private Collection<java.lang.Float> noLoadLoss;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.From_TransformerWinding")
   private TransformerWinding From_TransformerWinding;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.excitingCurrent")
   private Collection<java.lang.Float> excitingCurrent;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.loadLoss")
   private Collection<java.lang.Float> loadLoss;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.voltage")
   private Collection<java.lang.Float> voltage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.leakageImpedance")
   private Collection<java.lang.Float> leakageImpedance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WindingTest.toTapStep")
   private Collection<java.math.BigInteger> toTapStep;
}
