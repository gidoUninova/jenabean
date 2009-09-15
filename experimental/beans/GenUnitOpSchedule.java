package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("GenUnitOpSchedule")
public class GenUnitOpSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GenUnitOpSchedule.GeneratingUnit")
   private GeneratingUnit GeneratingUnit;
}
