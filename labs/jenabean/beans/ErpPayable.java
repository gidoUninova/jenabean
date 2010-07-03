package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpPayable")
public class ErpPayable extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpPayable.ContractorItems")
   private Collection<ContractorItem> ContractorItems;
}
