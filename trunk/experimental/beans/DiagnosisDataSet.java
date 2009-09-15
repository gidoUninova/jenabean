package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DiagnosisDataSet")
public class DiagnosisDataSet extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.preliminaryDate")
   private Collection<java.lang.String> preliminaryDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.failureMode")
   private Collection<java.lang.String> failureMode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.preliminaryCode")
   private Collection<java.lang.String> preliminaryCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.finalOrigin")
   private Collection<java.lang.String> finalOrigin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.finalRemarks")
   private Collection<java.lang.String> finalRemarks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.finalCode")
   private Collection<java.lang.String> finalCode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.rootOrigin")
   private Collection<java.lang.String> rootOrigin;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.preliminaryRemarks")
   private Collection<java.lang.String> preliminaryRemarks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.finalDate")
   private Collection<java.lang.String> finalDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.effect")
   private Collection<java.lang.String> effect;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.phase")
   private Collection<java.math.BigInteger> phase;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.finalCause")
   private Collection<java.lang.String> finalCause;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.Procedure")
   private Procedure Procedure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.rootRemarks")
   private Collection<java.lang.String> rootRemarks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DiagnosisDataSet.rootCause")
   private Collection<java.lang.String> rootCause;
}
