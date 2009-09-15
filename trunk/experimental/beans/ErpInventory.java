package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpInventory")
public class ErpInventory extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpInventory.Site")
   private Collection<Site> Site;
}
