package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("NonStandardItem")
public class NonStandardItem extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NonStandardItem.amount")
   private Collection<java.lang.Float> amount;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NonStandardItem.code")
   private Collection<java.lang.String> code;
}
