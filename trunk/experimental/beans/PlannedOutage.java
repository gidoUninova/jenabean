package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PlannedOutage")
public class PlannedOutage extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PlannedOutage.OutageSchedules")
   private OutageSchedule OutageSchedules;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PlannedOutage.CustomerList")
   private CustomerList CustomerList;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PlannedOutage.AffectedSupply_EquipmentList")
   private EquipmentList AffectedSupply_EquipmentList;
}
