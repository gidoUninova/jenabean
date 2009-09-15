package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Feeder")
public class Feeder extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Feeder.NetworkDataSets")
   private NetworkDataSet NetworkDataSets;
}
