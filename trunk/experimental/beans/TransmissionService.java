package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TransmissionService")
public class TransmissionService extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionService.TransContractFor")
   private OpenAccessProduct TransContractFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionService.Offering")
   private TransmissionPath Offering;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionService.OfferedAs")
   private Collection<TransmissionProduct> OfferedAs;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionService.ScheduledBy")
   private AvailableTransmissionCapacity ScheduledBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionService.ReservedBy_ServiceReservation")
   private ServiceReservation ReservedBy_ServiceReservation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionService.Offers")
   private TransmissionProvider Offers;
}
