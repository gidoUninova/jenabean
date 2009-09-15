package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("JointAsset")
public class JointAsset extends Asset {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#JointAsset.configuration")
   private Collection<java.lang.Integer> configuration;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#JointAsset.fill")
   private Collection<java.lang.String> fill;
}
