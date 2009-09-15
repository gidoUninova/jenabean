package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PrimeMover")
public class PrimeMover extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PrimeMover.primeMoverRating")
   private Collection<java.lang.Float> primeMoverRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PrimeMover.Drives_SynchronousMachines")
   private Collection<SynchronousMachine> Drives_SynchronousMachines;
}
