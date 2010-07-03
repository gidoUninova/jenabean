package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CimVersion")
public class CimVersion extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CimVersion.Version")
   private Collection<java.lang.String> Version;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CimVersion.LastUpdate")
   private Collection<java.lang.String> LastUpdate;
}
