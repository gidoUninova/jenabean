package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MaterialItem")
public class MaterialItem extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.cost")
   private Collection<java.lang.Float> cost;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.UtilityRequisition")
   private UtilityRequisition UtilityRequisition;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.ErpIssue")
   private ErpIssue ErpIssue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.AssetModels")
   private Collection<AssetModel> AssetModels;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MaterialItem.WorkCostDetail")
   private WorkCostDetail WorkCostDetail;
}
