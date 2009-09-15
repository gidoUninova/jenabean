package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("WorkCostDetail")
public class WorkCostDetail extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.CostType")
   private CostType CostType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.debitFlag")
   private Collection<java.lang.Boolean> debitFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.WorkTask")
   private WorkTask WorkTask;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.ErpProjectAccounting")
   private ErpProjectAccounting ErpProjectAccounting;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.Overhead")
   private Overhead Overhead;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.ContractorItems")
   private ContractorItem ContractorItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.PropertyUnits")
   private Collection<PropertyUnit> PropertyUnits;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.MaterialItems")
   private MaterialItem MaterialItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.VehicleItems")
   private VehicleItem VehicleItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.Design")
   private Design Design;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.LaborItems")
   private LaborItem LaborItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.WorkCostSummary")
   private WorkCostSummary WorkCostSummary;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.transactionDate")
   private Collection<java.lang.String> transactionDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.MiscCostItem")
   private MiscCostItem MiscCostItem;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#WorkCostDetail.amount")
   private Collection<java.lang.Float> amount;
}
