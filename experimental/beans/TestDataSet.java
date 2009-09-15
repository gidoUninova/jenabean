package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TestDataSet")
public class TestDataSet extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TestDataSet.Procedure")
   private Procedure Procedure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TestDataSet.conclusion")
   private Collection<java.lang.String> conclusion;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TestDataSet.specimenID")
   private Collection<java.lang.String> specimenID;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TestDataSet.conclusionDate")
   private Collection<java.lang.String> conclusionDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TestDataSet.specToLabDate")
   private Collection<java.lang.String> specToLabDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TestDataSet.Properties")
   private Property Properties;
}
