package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ConductorType")
public class ConductorType extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorType.sheathReactance")
   private Collection<java.lang.Float> sheathReactance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorType.LinearConductorAsset")
   private LinearConductorAsset LinearConductorAsset;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorType.ConductorCatalogue")
   private ConductorCatalogue ConductorCatalogue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorType.WireArrangements")
   private WireArrangement WireArrangements;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorType.sheathResistance")
   private Collection<java.lang.Float> sheathResistance;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorType.Conductors")
   private Conductor Conductors;
}
