package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ServicePoint")
public class ServicePoint extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.HasA_GenerationProvider")
   private GenerationProvider HasA_GenerationProvider;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.HasAPOD_")
   private TransmissionPath HasAPOD_;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.Declare_TiePoint")
   private TiePoint Declare_TiePoint;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.Registers")
   private TransmissionProvider Registers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.HasA_CustomerConsumer")
   private CustomerConsumer HasA_CustomerConsumer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.MemberOf")
   private SubControlArea MemberOf;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.HasAPOR_")
   private TransmissionPath HasAPOR_;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ServicePoint.InjectsEnergyInto")
   private EnergyProduct InjectsEnergyInto;
}
