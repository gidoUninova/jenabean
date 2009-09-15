package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SynchrocheckRelay")
public class SynchrocheckRelay extends ProtectionEquipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SynchrocheckRelay.maxVoltDiff")
   private Collection<java.lang.Float> maxVoltDiff;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SynchrocheckRelay.maxFreqDiff")
   private Collection<java.lang.Float> maxFreqDiff;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SynchrocheckRelay.maxAngleDiff")
   private Collection<java.lang.Float> maxAngleDiff;
}
