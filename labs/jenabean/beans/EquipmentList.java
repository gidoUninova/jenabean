package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EquipmentList")
public class EquipmentList extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.NetworkDataSets")
   private NetworkDataSet NetworkDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.NetworkChangeSets")
   private NetworkChangeSet NetworkChangeSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.PowerSystemResources")
   private Collection<PowerSystemResource> PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.energizedState")
   private Collection<java.lang.String> energizedState;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.PlannedOutage")
   private PlannedOutage PlannedOutage;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.topologyState")
   private Collection<java.lang.String> topologyState;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquipmentList.IsolatedBy_SafetyDocuments")
   private SafetyDocument IsolatedBy_SafetyDocuments;
}
