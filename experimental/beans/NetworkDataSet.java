package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("NetworkDataSet")
public class NetworkDataSet extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.Feeder")
   private Feeder Feeder;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.MachineCatalogues")
   private Collection<MachineCatalogue> MachineCatalogues;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.SecurityConstraintsLinear")
   private Collection<SecurityConstraintsLinear> SecurityConstraintsLinear;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.EquipmentLists")
   private EquipmentList EquipmentLists;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.PowerSystemResources")
   private Collection<PowerSystemResource> PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.LandBases")
   private Collection<LandBase> LandBases;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.ConductorCatalogue")
   private ConductorCatalogue ConductorCatalogue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.SecurityConstraintsClearing")
   private Collection<SecurityConstraintsClearing> SecurityConstraintsClearing;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.SecurityConstraints")
   private Collection<SecurityConstraints> SecurityConstraints;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#NetworkDataSet.LoadDataSet")
   private LoadDataSet LoadDataSet;
}
