package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TransmissionProvider")
public class TransmissionProvider extends Organisation {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.For")
   private LossProfile For;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.RegisteredBy")
   private ServicePoint RegisteredBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.DeclaredBy")
   private TiePoint DeclaredBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.TransmissionProducts")
   private TransmissionProduct TransmissionProducts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.SoldBy")
   private ServiceReservation SoldBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.ServiceOf")
   private AncillaryService ServiceOf;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProvider.OfferedBy")
   private TransmissionService OfferedBy;
}
