package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HydroTurbine")
public class HydroTurbine extends PrimeMover {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.turbineRating")
   private Collection<java.lang.Float> turbineRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.gateRateLimit")
   private Collection<java.lang.Float> gateRateLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.maxEffMWatMaxHead")
   private Collection<java.lang.Float> maxEffMWatMaxHead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.transientDroopTime")
   private Collection<java.lang.Float> transientDroopTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.maxEffMWatMinHead")
   private Collection<java.lang.Float> maxEffMWatMinHead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.gateUpperLimit")
   private Collection<java.lang.Float> gateUpperLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.speedRating")
   private Collection<java.math.BigInteger> speedRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.transientRegulation")
   private Collection<java.lang.Float> transientRegulation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.speedRegulation")
   private Collection<java.lang.Float> speedRegulation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.turbineType")
   private TurbineType turbineType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroTurbine.waterStartingTime")
   private Collection<java.lang.Float> waterStartingTime;
}
