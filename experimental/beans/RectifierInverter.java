package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RectifierInverter")
public class RectifierInverter extends ConductingEquipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RectifierInverter.commutatingResistance")
   private Collection<java.lang.Float> commutatingResistance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RectifierInverter.commutatingReactance")
   private Collection<java.lang.Float> commutatingReactance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RectifierInverter.ratedKV")
   private Collection<java.lang.Float> ratedKV;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RectifierInverter.minCompoundVoltage")
   private Collection<java.lang.Float> minCompoundVoltage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RectifierInverter.bridges")
   private Collection<java.math.BigInteger> bridges;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RectifierInverter.compoundResistance")
   private Collection<java.lang.Float> compoundResistance;
}
