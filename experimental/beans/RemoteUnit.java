package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RemoteUnit")
public class RemoteUnit extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteUnit.MemberOf_CommunicationLinks")
   private Collection<CommunicationLink> MemberOf_CommunicationLinks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteUnit.remoteUnitType")
   private RemoteUnitType remoteUnitType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteUnit.Contains_RemotePoints")
   private RemotePoint Contains_RemotePoints;
}
