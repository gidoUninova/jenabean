package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ProfileData")
public class ProfileData extends Object {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProfileData.sequenceNumber")
   private Collection<java.math.BigInteger> sequenceNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProfileData.energyLevel")
   private Collection<java.lang.Float> energyLevel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProfileData.capacityLevel")
   private Collection<java.lang.Float> capacityLevel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProfileData.Profile")
   private Collection<Profile> Profile;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProfileData.startDateTime")
   private Collection<java.lang.String> startDateTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ProfileData.stopDateTime")
   private Collection<java.lang.String> stopDateTime;
}
