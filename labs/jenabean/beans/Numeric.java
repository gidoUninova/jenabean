package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Numeric")
public class Numeric extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.DATE_TIME_TYPE")
   private Collection<com.hp.hpl.jena.datatypes.xsd.XSDDateTime> DATE_TIME_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.ULONG_LONG_TYPE")
   private Collection<Long> ULONG_LONG_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.DOUBLE_TYPE")
   private Collection<java.lang.Double> DOUBLE_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.COMPLEX_TYPE")
   private Collection<java.lang.Float> COMPLEX_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.LONG_LONG_TYPE")
   private Collection<java.lang.Long> LONG_LONG_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.SHORT_TYPE")
   private Collection<java.lang.Short> SHORT_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.LONG_DOUBLE_TYPE")
   private Collection<java.lang.Double> LONG_DOUBLE_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.INT_TYPE")
   private Collection<java.math.BigInteger> INT_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.BOOLEAN_TYPE")
   private Collection<java.lang.Boolean> BOOLEAN_TYPE;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Numeric.UNSIGNED_TYPE")
   private Collection<Long> UNSIGNED_TYPE;
}
