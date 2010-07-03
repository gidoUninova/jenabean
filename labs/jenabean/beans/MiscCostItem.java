package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MiscCostItem")
public class MiscCostItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MiscCostItem.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MiscCostItem.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MiscCostItem.DesignLocation")
   private DesignLocation DesignLocation;
}
