package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpIssue")
public class ErpIssue extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpIssue.MaterialItems")
   private MaterialItem MaterialItems;
}
