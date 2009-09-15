package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CompositeSwitch")
public class CompositeSwitch extends EquipmentContainer {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompositeSwitch.MemberOf_Substation")
   private Substation MemberOf_Substation;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompositeSwitch.compositeSwitchType")
   private Collection<java.lang.String> compositeSwitchType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompositeSwitch.Switches")
   private Switch Switches;
}
