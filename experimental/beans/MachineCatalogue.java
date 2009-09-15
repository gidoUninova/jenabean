package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("MachineCatalogue")
public class MachineCatalogue extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MachineCatalogue.NetworkDataSets")
   private Collection<NetworkDataSet> NetworkDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#MachineCatalogue.SynchronousMachines")
   private SynchronousMachine SynchronousMachines;
}
