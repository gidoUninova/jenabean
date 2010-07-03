package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("DesignLocation")
public class DesignLocation extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocation.ErpBomItemData")
   private ErpBomItemData ErpBomItemData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocation.DesignLocationCU")
   private DesignLocationCU DesignLocationCU;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocation.Design")
   private Collection<Design> Design;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocation.Location")
   private Location Location;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#DesignLocation.MiscCostItems")
   private MiscCostItem MiscCostItems;
}
