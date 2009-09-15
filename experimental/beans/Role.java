package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Role")
public class Role extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Role.status")
   private Collection<java.lang.String> status;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Role.privilege")
   private Collection<java.lang.String> privilege;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Role.roleType")
   private Collection<java.lang.String> roleType;
}
