package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WorkFlow")
public class WorkFlow extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkFlow.sequence")
   private Collection<java.math.BigInteger> sequence;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkFlow.Work")
   private Work Work;
}
