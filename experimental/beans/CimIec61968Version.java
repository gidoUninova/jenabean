package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CimIec61968Version")
public class CimIec61968Version extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CimIec61968Version.LastUpdate")
   private Collection<java.lang.String> LastUpdate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CimIec61968Version.Version")
   private Collection<java.lang.String> Version;
}
