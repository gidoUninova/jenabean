package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Tool")
public class Tool extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Tool.Crew")
   private Crew Crew;
}
