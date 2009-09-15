package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Fuse")
public class Fuse extends Switch {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Fuse.ampRating")
   private Collection<java.lang.Float> ampRating;
}
