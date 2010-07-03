package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Naming")
public class Naming extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Naming.pathName")
   private Collection<java.lang.String> pathName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Naming.description")
   private Collection<java.lang.String> description;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Naming.aliasName")
   private Collection<java.lang.String> aliasName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Naming.name")
   private Collection<java.lang.String> name;
}
