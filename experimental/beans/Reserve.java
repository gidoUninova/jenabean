package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Reserve")
public class Reserve extends EnergyTransaction {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Reserve.AreaReserveSpec")
   private AreaReserveSpec AreaReserveSpec;
}
