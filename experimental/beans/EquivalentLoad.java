package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EquivalentLoad")
public class EquivalentLoad extends EnergyConsumer {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquivalentLoad.feederLoadMgtFactor")
   private Collection<java.lang.Float> feederLoadMgtFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquivalentLoad.loadAllocationFactor")
   private Collection<java.lang.Float> loadAllocationFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquivalentLoad.mVArColdPickUpFactor")
   private Collection<java.lang.Float> mVArColdPickUpFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquivalentLoad.mWColdPickUpFactor")
   private Collection<java.lang.Float> mWColdPickUpFactor;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EquivalentLoad.phaseAmpRating")
   private Collection<java.lang.Float> phaseAmpRating;
}
