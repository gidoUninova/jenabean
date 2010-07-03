package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Document")
public class Document extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.comments")
   private Collection<java.lang.String> comments;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.subjectStatus")
   private Collection<java.lang.String> subjectStatus;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.revisionNumber")
   private Collection<java.lang.String> revisionNumber;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.type")
   private Collection<java.lang.String> type;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.Locations")
   private Collection<Location> Locations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.subjectStatusDate")
   private Collection<java.lang.String> subjectStatusDate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.lastModified")
   private Collection<java.lang.String> lastModified;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.title")
   private Collection<java.lang.String> title;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.PowerSystemResources")
   private Collection<PowerSystemResource> PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.Customers")
   private Collection<Customer> Customers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.subject")
   private Collection<java.lang.String> subject;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Document.docStatus")
   private Collection<java.lang.String> docStatus;
}
