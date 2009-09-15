package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Streetlight")
public class Streetlight extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Streetlight.rating")
   private Collection<java.lang.String> rating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Streetlight.armLength")
   private Collection<java.lang.Float> armLength;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Streetlight.AttachedTo_Pole")
   private Pole AttachedTo_Pole;
}
