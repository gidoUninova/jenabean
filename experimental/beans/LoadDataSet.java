package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LoadDataSet")
public class LoadDataSet extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LoadDataSet.LoadDemandModels")
   private Collection<LoadDemandModel> LoadDemandModels;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LoadDataSet.NetworkDataSet")
   private NetworkDataSet NetworkDataSet;
}
