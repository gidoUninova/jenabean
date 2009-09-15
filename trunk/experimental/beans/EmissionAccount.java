package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EmissionAccount")
public class EmissionAccount extends AccountBalance {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionAccount.emissionValueSource")
   private EmissionValueSource emissionValueSource;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionAccount.ThermalGeneratingUnit")
   private ThermalGeneratingUnit ThermalGeneratingUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EmissionAccount.emissionType")
   private EmissionType emissionType;
}
