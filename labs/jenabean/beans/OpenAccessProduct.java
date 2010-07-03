package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("OpenAccessProduct")
public class OpenAccessProduct extends Agreement {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OpenAccessProduct.ProvidedBy_AncillaryService")
   private AncillaryService ProvidedBy_AncillaryService;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#OpenAccessProduct.ProvidedBy_TransmissionService")
   private TransmissionService ProvidedBy_TransmissionService;
}
