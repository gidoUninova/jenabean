package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ControlHouseEquipment")
public class ControlHouseEquipment extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ControlHouseEquipment.controlHouseEquipType")
   private ControlHouseEquipmentType controlHouseEquipType;
}
