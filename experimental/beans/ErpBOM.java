package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpBOM")
public class ErpBOM extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpBOM.ErpBomItemData")
   private ErpBomItemData ErpBomItemData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpBOM.Designs")
   private Design Designs;
}
