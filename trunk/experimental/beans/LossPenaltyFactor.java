package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LossPenaltyFactor")
public class LossPenaltyFactor extends MarketFactors {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LossPenaltyFactor.lossFactor")
   private Collection<java.lang.Float> lossFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LossPenaltyFactor.ConnectivityNodes")
   private Collection<ConnectivityNode> ConnectivityNodes;
}
