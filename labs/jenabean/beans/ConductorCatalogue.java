package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ConductorCatalogue")
public class ConductorCatalogue extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorCatalogue.NetworkDataSets")
   private NetworkDataSet NetworkDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ConductorCatalogue.ConductorTypes")
   private ConductorType ConductorTypes;
}
