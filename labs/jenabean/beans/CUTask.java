package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CUTask")
public class CUTask extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUTask.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUTask.totalHours")
   private Collection<java.math.BigInteger> totalHours;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUTask.DesignLocationCU")
   private DesignLocationCU DesignLocationCU;
}
