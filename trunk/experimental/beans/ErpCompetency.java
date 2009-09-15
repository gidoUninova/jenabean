package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpCompetency")
public class ErpCompetency extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpCompetency.ErpContacts")
   private ErpContact ErpContacts;
}
