package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AssetList")
public class AssetList extends CIMCollection {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AssetList.Assets")
   private Collection<Asset> Assets;
}
