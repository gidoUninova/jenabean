package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ProtectionEquipment")
public class ProtectionEquipment extends Equipment {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.highLimit")
   private Collection<java.lang.Float> highLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.Operates_Breakers")
   private Collection<Breaker> Operates_Breakers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.lowLimit")
   private Collection<java.lang.Float> lowLimit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.powerDirectionFlag")
   private Collection<java.lang.Boolean> powerDirectionFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.Unit")
   private Unit Unit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.relayDelayTime")
   private Collection<java.lang.Float> relayDelayTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProtectionEquipment.ConductingEquipments")
   private Collection<ConductingEquipment> ConductingEquipments;
}
