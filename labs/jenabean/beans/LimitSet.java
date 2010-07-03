package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LimitSet")
public class LimitSet extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LimitSet.Limits")
   private Limit Limits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LimitSet.isPercentageLimits")
   private Collection<java.lang.Boolean> isPercentageLimits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LimitSet.Measurements")
   private Collection<Measurement> Measurements;
}
