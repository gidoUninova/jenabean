package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HydroPump")
public class HydroPump extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.DrivenBy_SynchronousMachine")
   private SynchronousMachine DrivenBy_SynchronousMachine;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.pumpPowerAtMaxHead")
   private Collection<java.lang.Float> pumpPowerAtMaxHead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.MemberOf_HydroPowerPlant")
   private HydroPowerPlant MemberOf_HydroPowerPlant;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.pumpDischAtMinHead")
   private Collection<java.lang.Float> pumpDischAtMinHead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.HydroPumpOpSchedule")
   private HydroPumpOpSchedule HydroPumpOpSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.pumpDischAtMaxHead")
   private Collection<java.lang.Float> pumpDischAtMaxHead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPump.pumpPowerAtMinHead")
   private Collection<java.lang.Float> pumpPowerAtMinHead;
}
