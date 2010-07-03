package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Collection")
public class CIMCollection extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Collection.collectionType")
   private Collection<java.lang.String> collectionType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Collection.collectionQuantity")
   private Collection<java.math.BigInteger> collectionQuantity;
}
