package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Vehicle")
public class Vehicle extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Vehicle.Crew")
   private Crew Crew;
}
