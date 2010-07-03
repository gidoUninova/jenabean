package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("StandardIndustryCode")
public class StandardIndustryCode extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StandardIndustryCode.CustomerAgreement")
   private CustomerAgreement CustomerAgreement;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#StandardIndustryCode.code")
   private Collection<java.lang.String> code;
}
