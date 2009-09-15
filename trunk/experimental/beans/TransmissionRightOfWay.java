package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TransmissionRightOfWay")
public class TransmissionRightOfWay extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionRightOfWay.Lines")
   private Line Lines;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionRightOfWay.TransmissionCorridor")
   private TransmissionCorridor TransmissionCorridor;
}
