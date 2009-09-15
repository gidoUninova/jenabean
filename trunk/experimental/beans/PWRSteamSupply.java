package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PWRSteamSupply")
public class PWRSteamSupply extends SteamSupply {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coreNeutronicsEffTC")
   private Collection<java.lang.Float> coreNeutronicsEffTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coreHTLagTC2")
   private Collection<java.lang.Float> coreHTLagTC2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.steamFlowFG")
   private Collection<java.lang.Float> steamFlowFG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coldLegFBLeadTC2")
   private Collection<java.lang.Float> coldLegFBLeadTC2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coldLegFG1")
   private Collection<java.lang.Float> coldLegFG1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.feedbackFactor")
   private Collection<java.lang.Float> feedbackFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coldLegLagTC")
   private Collection<java.lang.Float> coldLegLagTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.throttlePressureSP")
   private Collection<java.lang.Float> throttlePressureSP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.hotLegSteamGain")
   private Collection<java.lang.Float> hotLegSteamGain;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coreNeutronicsHT")
   private Collection<java.lang.Float> coreNeutronicsHT;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coreHTLagTC1")
   private Collection<java.lang.Float> coreHTLagTC1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.throttlePressureFactor")
   private Collection<java.lang.Float> throttlePressureFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.pressureCG")
   private Collection<java.lang.Float> pressureCG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.steamPressureFG")
   private Collection<java.lang.Float> steamPressureFG;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.hotLegLagTC")
   private Collection<java.lang.Float> hotLegLagTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coldLegFBLeadTC1")
   private Collection<java.lang.Float> coldLegFBLeadTC1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.hotLegToColdLegGain")
   private Collection<java.lang.Float> hotLegToColdLegGain;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.steamPressureDropLagTC")
   private Collection<java.lang.Float> steamPressureDropLagTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coldLegFBLagTC")
   private Collection<java.lang.Float> coldLegFBLagTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PWRSteamSupply.coldLegFG2")
   private Collection<java.lang.Float> coldLegFG2;
}
