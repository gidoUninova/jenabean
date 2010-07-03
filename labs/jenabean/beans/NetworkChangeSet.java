package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("NetworkChangeSet")
public class NetworkChangeSet extends NetworkDataSet {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkChangeSet.Next.NetworkChangeSet")
   private NetworkChangeSet Next_NetworkChangeSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkChangeSet.Previous_NetworkChangeSet")
   private NetworkChangeSet Previous_NetworkChangeSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkChangeSet.EquipmentList")
   private EquipmentList EquipmentList;
}
