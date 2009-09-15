package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DuctBank")
public class DuctBank extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DuctBank.numDucts")
   private Collection<java.math.BigInteger> numDucts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DuctBank.numCircuits")
   private Collection<java.math.BigInteger> numCircuits;
}
