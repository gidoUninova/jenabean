package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CommunicationLink")
public class CommunicationLink extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CommunicationLink.Contain_RemoteUnits")
   private Collection<RemoteUnit> Contain_RemoteUnits;
}
