package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MeasurementValueQuality")
public class MeasurementValueQuality extends Quality61850 {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValueQuality.MeasurementValue")
   private MeasurementValue MeasurementValue;
}
