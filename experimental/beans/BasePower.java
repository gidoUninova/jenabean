package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("BasePower")
public class BasePower extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BasePower.basePower")
   private Collection<java.lang.Float> basePower;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#BasePower.BaseVoltage")
   private BaseVoltage BaseVoltage;
}
