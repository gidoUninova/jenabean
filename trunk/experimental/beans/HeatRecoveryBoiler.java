package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HeatRecoveryBoiler")
public class HeatRecoveryBoiler extends FossilSteamSupply {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatRecoveryBoiler.steamSupplyRating2")
   private Collection<java.lang.Float> steamSupplyRating2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatRecoveryBoiler.CombustionTurbines")
   private CombustionTurbine CombustionTurbines;
}
