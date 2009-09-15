package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("FossilSteamSupply")
public class FossilSteamSupply extends SteamSupply {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.mechPowerSensorLag")
   private Collection<java.lang.Float> mechPowerSensorLag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.pressureFeedback")
   private Collection<java.math.BigInteger> pressureFeedback;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.fuelSupplyDelay")
   private Collection<java.lang.Float> fuelSupplyDelay;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.superHeaterPipePD")
   private Collection<java.lang.Float> superHeaterPipePD;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.fuelSupplyTC")
   private Collection<java.lang.Float> fuelSupplyTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.boilerControlMode")
   private BoilerControlMode boilerControlMode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.throttlePressureSP")
   private Collection<java.lang.Float> throttlePressureSP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.superHeater1Capacity")
   private Collection<java.lang.Float> superHeater1Capacity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.fuelDemandLimit")
   private Collection<java.lang.Float> fuelDemandLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.pressureCtrlPG")
   private Collection<java.lang.Float> pressureCtrlPG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.controlMWEB")
   private Collection<java.lang.Float> controlMWEB;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.controlPC")
   private Collection<java.lang.Float> controlPC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.feedWaterPG")
   private Collection<java.lang.Float> feedWaterPG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.controlIC")
   private Collection<java.lang.Float> controlIC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.pressureCtrlDG")
   private Collection<java.lang.Float> pressureCtrlDG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.mWMaximumER")
   private Collection<java.lang.Float> mWMaximumER;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.controlPED")
   private Collection<java.lang.Float> controlPED;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.pressureCtrlIG")
   private Collection<java.lang.Float> pressureCtrlIG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.feedWaterIG")
   private Collection<java.lang.Float> feedWaterIG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.superHeater2Capacity")
   private Collection<java.lang.Float> superHeater2Capacity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.auxPowerVersusFrequency")
   private Collection<java.lang.Float> auxPowerVersusFrequency;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.controlPEB")
   private Collection<java.lang.Float> controlPEB;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.auxPowerversusVoltage")
   private Collection<java.lang.Float> auxPowerversusVoltage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.controlTC")
   private Collection<java.lang.Float> controlTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.mWMinimumER")
   private Collection<java.lang.Float> mWMinimumER;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#FossilSteamSupply.feedWaterTC")
   private Collection<java.lang.Float> feedWaterTC;
}
