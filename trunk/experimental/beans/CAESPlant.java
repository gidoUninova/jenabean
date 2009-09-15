package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CAESPlant")
public class CAESPlant extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CAESPlant.Contain_AirCompressor")
   private AirCompressor Contain_AirCompressor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CAESPlant.ratedCapacityMW")
   private Collection<java.lang.Float> ratedCapacityMW;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CAESPlant.Contain_ThermalGeneratingUnit")
   private ThermalGeneratingUnit Contain_ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CAESPlant.energyStorageCapacity")
   private Collection<java.lang.Float> energyStorageCapacity;
}
