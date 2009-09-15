package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Zone")
public class Zone extends Location {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Zone.PowerSystemResources")
   private Collection<PowerSystemResource> PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Zone.Assets")
   private Asset Assets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Zone.zoneType")
   private Collection<java.lang.String> zoneType;
}
