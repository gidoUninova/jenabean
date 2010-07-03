package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("gml_Feature")
public class gml_Feature extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#gml_Feature.units")
   private Collection<java.lang.String> units;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#gml_Feature.value")
   private Collection<java.lang.Float> value;
}
