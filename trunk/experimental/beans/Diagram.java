package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Diagram")
public class Diagram extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Diagram.Presentations")
   private Collection<Presentation> Presentations;
}
