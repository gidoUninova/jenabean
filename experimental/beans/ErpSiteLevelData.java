package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpSiteLevelData")
public class ErpSiteLevelData extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpSiteLevelData.Sites")
   private Collection<Site> Sites;
}
