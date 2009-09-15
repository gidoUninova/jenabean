package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TransmissionPath")
public class TransmissionPath extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.PointOfReceiptFor")
   private ServicePoint PointOfReceiptFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.DeliveryPointFor")
   private ServicePoint DeliveryPointFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.OfferedOn")
   private TransmissionService OfferedOn;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.availTransferCapability")
   private Collection<java.lang.Float> availTransferCapability;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.totalTransferCapability")
   private Collection<java.lang.Float> totalTransferCapability;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.LocatedOn")
   private TransmissionProduct LocatedOn;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.For")
   private TransmissionCorridor For;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TransmissionPath.parallelPathFlag")
   private Collection<java.lang.Boolean> parallelPathFlag;
}
