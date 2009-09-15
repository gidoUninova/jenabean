package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CUContractorItem")
public class CUContractorItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUContractorItem.CompatibleUnit")
   private CompatibleUnit CompatibleUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUContractorItem.bidAmount")
   private Collection<java.lang.Float> bidAmount;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUContractorItem.activityCode")
   private Collection<java.lang.String> activityCode;
}
