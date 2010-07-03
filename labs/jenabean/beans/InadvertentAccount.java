package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("InadvertentAccount")
public class InadvertentAccount extends AccountBalance {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#InadvertentAccount.HostControlArea")
   private HostControlArea HostControlArea;
}
