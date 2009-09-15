package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Agreement")
public class Agreement extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Agreement.agreementStatus")
   private Collection<java.lang.String> agreementStatus;
}
