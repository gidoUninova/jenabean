package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Control")
public class Control extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.RemoteControl")
   private RemoteControl RemoteControl;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.MeasuredBy_Measurement")
   private Measurement MeasuredBy_Measurement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.ValueAliasSet")
   private ValueAliasSet ValueAliasSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.ControlledBy_RegulatingCondEq")
   private RegulatingCondEq ControlledBy_RegulatingCondEq;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.dataType")
   private NumericType dataType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.minValue")
   private Numeric minValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.Unit")
   private Unit Unit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.maxValue")
   private Numeric maxValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.value")
   private Numeric value;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.normalValue")
   private Numeric normalValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.operationInProgress")
   private Collection<java.lang.Boolean> operationInProgress;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.ControlType")
   private ControlType ControlType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Control.timeStamp")
   private Collection<java.lang.String> timeStamp;
}
