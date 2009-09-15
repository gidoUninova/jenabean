package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("IntSchedAgreement")
public class IntSchedAgreement extends Agreement {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#IntSchedAgreement.defaultIntegrationMethod")
   private EnumeratedType defaultIntegrationMethod;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#IntSchedAgreement.Organisations")
   private Collection<Organisation> Organisations;
}
