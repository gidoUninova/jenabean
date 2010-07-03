package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Marketer")
public class Marketer extends Organisation {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Marketer.HoldsTitleTo_EnergyProducts")
   private EnergyProduct HoldsTitleTo_EnergyProducts;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Marketer.Resells_EnergyProduct")
   private EnergyProduct Resells_EnergyProduct;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Marketer.ResoldBy")
   private ServiceReservation ResoldBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Marketer.HeldBy")
   private ServiceReservation HeldBy;
}
