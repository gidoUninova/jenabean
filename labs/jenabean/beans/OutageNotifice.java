package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OutageNotifice")
public class OutageNotifice extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OutageNotifice.CustomerList")
   private Collection<CustomerList> CustomerList;
}
