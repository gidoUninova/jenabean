package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ValueAliasSet")
public class ValueAliasSet extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ValueAliasSet.Values")
   private ValueToAlias Values;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ValueAliasSet.Controls")
   private Control Controls;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ValueAliasSet.Measurements")
   private Measurement Measurements;
}
