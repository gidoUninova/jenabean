package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("GenerationProvider")
public class GenerationProvider extends Organisation {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GenerationProvider.ProvidedBy")
   private EnergyProduct ProvidedBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GenerationProvider.For")
   private ServicePoint For;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#GenerationProvider.GeneratingUnits")
   private GeneratingUnit GeneratingUnits;
}
