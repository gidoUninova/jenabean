package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LoadDemandModel")
public class LoadDemandModel extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LoadDemandModel.LoadDataSets")
   private Collection<LoadDataSet> LoadDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LoadDemandModel.EnergyConsumer")
   private EnergyConsumer EnergyConsumer;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LoadDemandModel.BasisFor")
   private Season BasisFor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LoadDemandModel.DayType")
   private DayType DayType;
}
