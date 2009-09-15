package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("HeatExchanger")
public class HeatExchanger extends Equipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#HeatExchanger.PowerTransformer")
   private PowerTransformer PowerTransformer;
}
