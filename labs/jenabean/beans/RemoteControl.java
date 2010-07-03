package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("RemoteControl")
public class RemoteControl extends RemotePoint {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteControl.remoteControlled")
   private Collection<java.lang.Boolean> remoteControlled;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteControl.actuatorMaximum")
   private Numeric actuatorMaximum;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteControl.actuatorMinimum")
   private Numeric actuatorMinimum;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#RemoteControl.Control")
   private Control Control;
}
