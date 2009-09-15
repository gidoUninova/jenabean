package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Presentation")
public class Presentation extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Presentation.rendering")
   private gml_Feature rendering;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Presentation.PowerSystemResource")
   private PowerSystemResource PowerSystemResource;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Presentation.Asset")
   private Asset Asset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Presentation.Location")
   private Location Location;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Presentation.Diagram")
   private Collection<Diagram> Diagram;
}
