package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Procedure")
public class Procedure extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.proecdureText")
   private Collection<java.lang.String> proecdureText;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.GovernsDataFor_Interval")
   private Collection<Interval> GovernsDataFor_Interval;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.DiagnosisDataSets")
   private DiagnosisDataSet DiagnosisDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.sequence")
   private Collection<java.lang.String> sequence;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.MeasurementValues")
   private Collection<MeasurementValue> MeasurementValues;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.MaintenanceDataSets")
   private MaintenanceDataSet MaintenanceDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.TestDataSets")
   private TestDataSet TestDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.Limits")
   private Collection<Limit> Limits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.frequency")
   private Collection<java.lang.String> frequency;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.InspectionDataSets")
   private InspectionDataSet InspectionDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Procedure.ProcedureValues")
   private ProcedureValue ProcedureValues;
}
