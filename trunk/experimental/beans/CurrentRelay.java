package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CurrentRelay")
public class CurrentRelay extends ProtectionEquipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.currentLimit2")
   private Collection<java.lang.Float> currentLimit2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.inverseTimeFlag")
   private Collection<java.lang.Boolean> inverseTimeFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.timeDelay3")
   private Collection<java.lang.Float> timeDelay3;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.currentLimit1")
   private Collection<java.lang.Float> currentLimit1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.timeDelay2")
   private Collection<java.lang.Float> timeDelay2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.timeDelay1")
   private Collection<java.lang.Float> timeDelay1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurrentRelay.currentLimit3")
   private Collection<java.lang.Float> currentLimit3;
}
