package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("UtilityRequisition")
public class UtilityRequisition extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UtilityRequisition.MaterialItems")
   private MaterialItem MaterialItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UtilityRequisition.quantity")
   private Collection<java.math.BigInteger> quantity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UtilityRequisition.cost")
   private Collection<java.lang.Float> cost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#UtilityRequisition.code")
   private Collection<java.lang.String> code;
}
