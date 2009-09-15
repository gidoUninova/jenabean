package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SteamTurbine")
public class SteamTurbine extends PrimeMover {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft2PowerIP")
   private Collection<java.lang.Float> shaft2PowerIP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft1PowerIP")
   private Collection<java.lang.Float> shaft1PowerIP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.SteamSupplys")
   private Collection<SteamSupply> SteamSupplys;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft1PowerLP1")
   private Collection<java.lang.Float> shaft1PowerLP1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft2PowerLP1")
   private Collection<java.lang.Float> shaft2PowerLP1;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft1PowerLP2")
   private Collection<java.lang.Float> shaft1PowerLP2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft1PowerHP")
   private Collection<java.lang.Float> shaft1PowerHP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft2PowerHP")
   private Collection<java.lang.Float> shaft2PowerHP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.shaft2PowerLP2")
   private Collection<java.lang.Float> shaft2PowerLP2;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.crossoverTC")
   private Collection<java.lang.Float> crossoverTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.steamChestTC")
   private Collection<java.lang.Float> steamChestTC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.reheater2TC")
   private Collection<java.lang.Float> reheater2TC;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamTurbine.reheater1TC")
   private Collection<java.lang.Float> reheater1TC;
}
