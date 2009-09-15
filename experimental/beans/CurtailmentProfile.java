package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CurtailmentProfile")
public class CurtailmentProfile extends Profile {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CurtailmentProfile.EnergyTransaction")
   private EnergyTransaction EnergyTransaction;
}
