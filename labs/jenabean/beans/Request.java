package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Request")
public class Request extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Request.Customers")
   private Collection<Customer> Customers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Request.Projects")
   private Collection<Project> Projects;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Request.Work")
   private Work Work;
}
