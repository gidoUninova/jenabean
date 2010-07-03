package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ControlAreaOperator")
public class ControlAreaOperator extends Organisation {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ControlAreaOperator.OfferedBy")
   private AncillaryService OfferedBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ControlAreaOperator.ControlledBy")
   private HostControlArea ControlledBy;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ControlAreaOperator.CAChildOf")
   private TieLine CAChildOf;
}
