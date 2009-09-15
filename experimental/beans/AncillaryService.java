package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AncillaryService")
public class AncillaryService extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryService.ContractFor")
   private OpenAccessProduct ContractFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryService.Offering")
   private TransmissionProvider Offering;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryService.ReservedBy_ServiceReservation")
   private ServiceReservation ReservedBy_ServiceReservation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AncillaryService.Offers")
   private ControlAreaOperator Offers;
}
