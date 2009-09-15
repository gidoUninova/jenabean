package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HydroPumpOpSchedule")
public class HydroPumpOpSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HydroPumpOpSchedule.HydroPump")
   private HydroPump HydroPump;
}
