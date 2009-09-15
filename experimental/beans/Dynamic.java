package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Dynamic")
public class Dynamic extends EnergyTransaction {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Dynamic.TieLines")
   private TieLine TieLines;
}
