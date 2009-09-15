package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("UnitInitialConditions")
public class UnitInitialConditions extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.GeneratingUnit")
   private GeneratingUnit GeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.cumStatusChanges")
   private Collection<java.math.BigInteger> cumStatusChanges;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.timeInStatus")
   private Collection<java.lang.Float> timeInStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.resourceStatus")
   private Collection<java.math.BigInteger> resourceStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.cumEnergy")
   private Collection<java.lang.Float> cumEnergy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.statusDate")
   private Collection<java.lang.String> statusDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UnitInitialConditions.resourceMW")
   private Collection<java.lang.Float> resourceMW;
}
