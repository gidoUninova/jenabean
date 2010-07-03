package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DrumBoiler")
public class DrumBoiler extends FossilSteamSupply {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DrumBoiler.drumBoilerRating")
   private Collection<java.lang.Float> drumBoilerRating;
}
