package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("TieLine")
public class TieLine extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.SideA_HostControlArea")
   private HostControlArea SideA_HostControlArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.SideB_HostControlArea")
   private HostControlArea SideB_HostControlArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.ParentOfA")
   private ControlAreaOperator ParentOfA;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.DynamicEnergyTransaction")
   private Dynamic DynamicEnergyTransaction;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.SideB_SubControlArea")
   private SubControlArea SideB_SubControlArea;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.ParentOfB")
   private CustomerConsumer ParentOfB;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#TieLine.SideA_SubControlArea")
   private SubControlArea SideA_SubControlArea;
}
