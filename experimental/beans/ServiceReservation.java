package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ServiceReservation")
public class ServiceReservation extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceReservation.SecuredBy")
   private Collection<EnergyTransaction> SecuredBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceReservation.Sells")
   private TransmissionProvider Sells;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceReservation.Resells")
   private Marketer Resells;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceReservation.Reserves_AncillaryServices")
   private AncillaryService Reserves_AncillaryServices;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceReservation.Reserves_TransmissionService")
   private TransmissionService Reserves_TransmissionService;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServiceReservation.Holds")
   private Marketer Holds;
}
