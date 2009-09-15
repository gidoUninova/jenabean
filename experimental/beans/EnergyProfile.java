package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("EnergyProfile")
public class EnergyProfile extends Profile {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProfile.Bid")
   private Bid Bid;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#EnergyProfile.EnergyTransaction")
   private EnergyTransaction EnergyTransaction;
}
