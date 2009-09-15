package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpBomItemData")
public class ErpBomItemData extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpBomItemData.DesignLocation")
   private DesignLocation DesignLocation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpBomItemData.ErpBOM")
   private ErpBOM ErpBOM;
}
