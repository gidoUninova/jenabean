package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("LossProfile")
public class LossProfile extends Profile {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LossProfile.HasLoss_")
   private TransmissionProvider HasLoss_;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#LossProfile.EnergyTransaction")
   private EnergyTransaction EnergyTransaction;
}
