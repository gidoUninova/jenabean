package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("PoleModel")
public class PoleModel extends AssetModel {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PoleModel.Poles")
   private Pole Poles;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PoleModel.species")
   private Collection<java.lang.String> species;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#PoleModel.classification")
   private Collection<java.lang.String> classification;
}
