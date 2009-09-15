package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("CombinedCyclePlant")
public class CombinedCyclePlant extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombinedCyclePlant.combCyclePlantRating")
   private Collection<java.lang.Float> combCyclePlantRating;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#CombinedCyclePlant.Contain_ThermalGeneratingUnits")
   private ThermalGeneratingUnit Contain_ThermalGeneratingUnits;
}
