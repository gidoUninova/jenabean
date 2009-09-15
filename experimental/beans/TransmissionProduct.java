package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TransmissionProduct")
public class TransmissionProduct extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProduct.TransmissionProvider")
   private TransmissionProvider TransmissionProvider;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProduct.LocationFor")
   private TransmissionPath LocationFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProduct.Offers")
   private Collection<TransmissionService> Offers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionProduct.transmissionProductType")
   private EnumeratedType transmissionProductType;
}
