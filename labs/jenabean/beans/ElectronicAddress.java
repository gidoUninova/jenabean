package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ElectronicAddress")
public class ElectronicAddress extends Location {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectronicAddress.email")
   private Collection<java.lang.String> email;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectronicAddress.web")
   private Collection<java.lang.String> web;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectronicAddress.lan")
   private Collection<java.lang.String> lan;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ElectronicAddress.radio")
   private Collection<java.lang.String> radio;
}
