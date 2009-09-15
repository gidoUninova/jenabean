package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ControlType")
public class ControlType extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ControlType.Controls")
   private Control Controls;
}
