package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RecloseSequence")
public class RecloseSequence extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RecloseSequence.recloseStep")
   private Collection<java.math.BigInteger> recloseStep;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RecloseSequence.recloseDelay")
   private Collection<java.lang.Float> recloseDelay;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RecloseSequence.Breaker")
   private Breaker Breaker;
}
