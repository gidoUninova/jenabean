package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("AreaReserveSpec")
public class AreaReserveSpec extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.ReserveEnergyTransaction")
   private Reserve ReserveEnergyTransaction;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.opReserveReqt")
   private Collection<java.lang.Float> opReserveReqt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.primaryReserveReqt")
   private Collection<java.lang.Float> primaryReserveReqt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.areaReserveSpecName")
   private Collection<java.lang.String> areaReserveSpecName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.spinningReserveReqt")
   private Collection<java.lang.Float> spinningReserveReqt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.raiseRegMarginReqt")
   private Collection<java.lang.Float> raiseRegMarginReqt;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.HostControlAreas")
   private HostControlArea HostControlAreas;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#AreaReserveSpec.lowerRegMarginReqt")
   private Collection<java.lang.Float> lowerRegMarginReqt;
}
