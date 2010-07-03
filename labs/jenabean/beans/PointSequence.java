package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PointSequence")
public class PointSequence extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PointSequence.CoordinatePairs")
   private CoordinatePair CoordinatePairs;
}
