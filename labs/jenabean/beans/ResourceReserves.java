package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ResourceReserves")
public class ResourceReserves extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ResourceReserves.minimumAllowableSpinningReserve")
   private Collection<java.lang.Float> minimumAllowableSpinningReserve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ResourceReserves.maximumAllowableSpinningReserve")
   private Collection<java.lang.Float> maximumAllowableSpinningReserve;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ResourceReserves.spinReserveRamp")
   private Collection<java.lang.Float> spinReserveRamp;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ResourceReserves.EnergyConsumers")
   private EnergyConsumer EnergyConsumers;
}
