package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AirCompressor")
public class AirCompressor extends PowerSystemResource {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AirCompressor.MemberOf_CAESPlant")
   private CAESPlant MemberOf_CAESPlant;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AirCompressor.DrivenBy_CombustionTurbine")
   private CombustionTurbine DrivenBy_CombustionTurbine;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AirCompressor.airCompressorRating")
   private Collection<java.lang.Float> airCompressorRating;
}
