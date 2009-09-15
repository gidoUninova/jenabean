package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ProcedureValue")
public class ProcedureValue extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProcedureValue.property")
   private Collection<java.lang.String> property;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProcedureValue.value")
   private Collection<java.lang.Float> value;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProcedureValue.valueType")
   private Collection<java.lang.String> valueType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProcedureValue.units")
   private Collection<java.lang.String> units;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProcedureValue.Procedures")
   private Procedure Procedures;
}
