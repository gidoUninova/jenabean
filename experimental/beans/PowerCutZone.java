package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PowerCutZone")
public class PowerCutZone extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerCutZone.EnergyConsumers")
   private EnergyConsumer EnergyConsumers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerCutZone.cutLevel2")
   private Collection<java.lang.Float> cutLevel2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PowerCutZone.cutLevel1")
   private Collection<java.lang.Float> cutLevel1;
}
