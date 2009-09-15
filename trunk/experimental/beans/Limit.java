package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Limit")
public class Limit extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Limit.AssetRating")
   private Rating AssetRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Limit.LimitSet")
   private LimitSet LimitSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Limit.value")
   private Numeric value;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Limit.Procedures")
   private Collection<Procedure> Procedures;
}
