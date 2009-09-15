package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RemotePoint")
public class RemotePoint extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemotePoint.MemberOf_RemoteUnit")
   private RemoteUnit MemberOf_RemoteUnit;
}
