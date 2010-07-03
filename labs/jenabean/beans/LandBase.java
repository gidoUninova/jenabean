package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LandBase")
public class LandBase extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LandBase.NetworkDataSets")
   private Collection<NetworkDataSet> NetworkDataSets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LandBase.id")
   private Collection<java.lang.String> id;
}
