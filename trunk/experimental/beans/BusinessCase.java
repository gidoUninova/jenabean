package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("BusinessCase")
public class BusinessCase extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BusinessCase.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BusinessCase.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BusinessCase.Projects")
   private Project Projects;
}
