package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Quality61850")
public class Quality61850 extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.outOfRange")
   private Collection<java.lang.Boolean> outOfRange;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.estimatorReplaced")
   private Collection<java.lang.Boolean> estimatorReplaced;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.failure")
   private Collection<java.lang.Boolean> failure;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.overFlow")
   private Collection<java.lang.Boolean> overFlow;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.oldData")
   private Collection<java.lang.Boolean> oldData;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.badReference")
   private Collection<java.lang.Boolean> badReference;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.validity")
   private Validity validity;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.test")
   private Collection<java.lang.Boolean> test;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.suspect")
   private Collection<java.lang.Boolean> suspect;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.oscillatory")
   private Collection<java.lang.Boolean> oscillatory;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.source")
   private Source source;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Quality61850.operatorBlocked")
   private Collection<java.lang.Boolean> operatorBlocked;
}
