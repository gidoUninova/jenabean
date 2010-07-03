package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PnodeClearing")
public class PnodeClearing extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PnodeClearing.Pnode")
   private Pnode Pnode;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PnodeClearing.costLMP")
   private Collection<java.lang.Float> costLMP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PnodeClearing.lossLMP")
   private Collection<java.lang.Float> lossLMP;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PnodeClearing.congestLMP")
   private Collection<java.lang.Float> congestLMP;
}
