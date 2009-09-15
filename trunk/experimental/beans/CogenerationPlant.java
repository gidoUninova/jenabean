package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CogenerationPlant")
public class CogenerationPlant extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.cogenHPSteamRating")
   private Collection<java.lang.Float> cogenHPSteamRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.cogenPlantMWRating")
   private Collection<java.lang.Float> cogenPlantMWRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.cogenLPSteamRating")
   private Collection<java.lang.Float> cogenLPSteamRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.SteamSendoutSchedule")
   private SteamSendoutSchedule SteamSendoutSchedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.cogenLPSendoutRating")
   private Collection<java.lang.Float> cogenLPSendoutRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.cogenHPSendoutRating")
   private Collection<java.lang.Float> cogenHPSendoutRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CogenerationPlant.Contain_ThermalGeneratingUnits")
   private ThermalGeneratingUnit Contain_ThermalGeneratingUnits;
}
