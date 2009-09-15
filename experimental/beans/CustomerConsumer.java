package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CustomerConsumer")
public class CustomerConsumer extends Organisation {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerConsumer.CustChildOf")
   private TieLine CustChildOf;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CustomerConsumer.Of")
   private ServicePoint Of;
}
