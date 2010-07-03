package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Compensator")
public class Compensator extends RegulatingCondEq {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.nominalkV")
   private Collection<java.lang.Float> nominalkV;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.switchOnDate")
   private Collection<java.lang.String> switchOnDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.voltSensitivity")
   private Collection<java.lang.Float> voltSensitivity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.x")
   private Collection<java.lang.Float> x;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.compensatorType")
   private CompensatorType compensatorType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.switchOnCount")
   private Collection<java.math.BigInteger> switchOnCount;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.mVArPerSection")
   private Collection<java.lang.Float> mVArPerSection;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.nominalMVAr")
   private Collection<java.lang.Float> nominalMVAr;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.impedance")
   private Collection<java.lang.Float> impedance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.normalSections")
   private Collection<java.math.BigInteger> normalSections;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.yPerSection")
   private Collection<java.lang.Float> yPerSection;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.maximumSections")
   private Collection<java.math.BigInteger> maximumSections;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.r")
   private Collection<java.lang.Float> r;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.minimumkV")
   private Collection<java.lang.Float> minimumkV;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.maximumkV")
   private Collection<java.lang.Float> maximumkV;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Compensator.aVRDelay")
   private Collection<java.lang.Float> aVRDelay;
}
