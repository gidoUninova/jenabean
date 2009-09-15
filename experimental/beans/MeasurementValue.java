package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MeasurementValue")
public class MeasurementValue extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.MeasurementValueQuality")
   private MeasurementValueQuality MeasurementValueQuality;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.MemberOf_Measurement")
   private Measurement MemberOf_Measurement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.Procedures")
   private Collection<Procedure> Procedures;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.sensorAccuracy")
   private Collection<java.lang.Float> sensorAccuracy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.timeStamp")
   private Collection<java.lang.String> timeStamp;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.RemoteSource")
   private RemoteSource RemoteSource;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.MeasurementValueSource")
   private MeasurementValueSource MeasurementValueSource;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.value")
   private Numeric value;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MeasurementValue.ReadBy_ErpContact")
   private ErpContact ReadBy_ErpContact;
}
