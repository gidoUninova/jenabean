package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RemoteSource")
public class RemoteSource extends RemotePoint {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteSource.deadband")
   private Numeric deadband;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteSource.sensorMinimum")
   private Numeric sensorMinimum;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteSource.MeasurementValue")
   private MeasurementValue MeasurementValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteSource.sensorMaximum")
   private Numeric sensorMaximum;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteSource.scanInterval")
   private Collection<java.lang.Float> scanInterval;
}
