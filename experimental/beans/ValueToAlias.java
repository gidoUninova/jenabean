package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ValueToAlias")
public class ValueToAlias extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ValueToAlias.value")
   private Numeric value;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ValueToAlias.ValueAliasSet")
   private ValueAliasSet ValueAliasSet;
}
