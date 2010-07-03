package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Pole")
public class Pole extends Structure {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pole.Support_Streetlights")
   private Streetlight Support_Streetlights;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pole.treatment")
   private Collection<java.lang.String> treatment;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pole.base")
   private Collection<java.lang.String> base;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pole.preservative")
   private Collection<java.lang.String> preservative;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pole.breastBlock")
   private Collection<java.lang.Boolean> breastBlock;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Pole.PoleModel")
   private PoleModel PoleModel;
}
