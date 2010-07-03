package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SteamSupply")
public class SteamSupply extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamSupply.SteamTurbines")
   private Collection<SteamTurbine> SteamTurbines;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamSupply.steamSupplyRating")
   private Collection<java.lang.Float> steamSupplyRating;
}
