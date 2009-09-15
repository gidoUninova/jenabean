package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CUGroup")
public class CUGroup extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUGroup.DesignLocationCU")
   private Collection<DesignLocationCU> DesignLocationCU;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUGroup.CompatibleUnit")
   private CompatibleUnit CompatibleUnit;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUGroup.Child_CUGroup")
   private Collection<CUGroup> Child_CUGroup;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CUGroup.Parent_CUGroup")
   private Collection<CUGroup> Parent_CUGroup;
}
