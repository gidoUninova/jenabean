package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TransmissionCorridor")
public class TransmissionCorridor extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionCorridor.ContainedIn")
   private TransmissionPath ContainedIn;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionCorridor.TransmissionRightOfWays")
   private TransmissionRightOfWay TransmissionRightOfWays;
}
