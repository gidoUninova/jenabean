package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Tariff")
public class Tariff extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Tariff.PricingStructures")
   private Collection<PricingStructure> PricingStructures;
}
