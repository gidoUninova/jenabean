package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RTO")
public class RTO extends Organisation {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RTO.Pnodes")
   private Pnode Pnodes;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RTO.MarketOperations")
   private MarketOperation MarketOperations;
}
