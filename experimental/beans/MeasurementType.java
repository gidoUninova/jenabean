package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MeasurementType")
public class MeasurementType extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementType.Measurements")
   private Measurement Measurements;
}
