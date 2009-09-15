package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Profile")
public class Profile extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Profile.ProfileDatas")
   private Collection<ProfileData> ProfileDatas;
}
