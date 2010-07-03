package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpPurchaseOrder")
public class ErpPurchaseOrder extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPurchaseOrder.Design")
   private Collection<Design> Design;
}
