package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CompatibleUnit")
public class CompatibleUnit extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.CULaborItems")
   private CULaborItem CULaborItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.CUGroup")
   private CUGroup CUGroup;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.DesignLocationCU")
   private Collection<DesignLocationCU> DesignLocationCU;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.CostType")
   private CostType CostType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.CUContractorItems")
   private CUContractorItem CUContractorItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.CUMaterialItems")
   private CUMaterialItem CUMaterialItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CompatibleUnit.CUVehicleItems")
   private CUVehicleItem CUVehicleItems;
}
