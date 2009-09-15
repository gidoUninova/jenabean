package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Project")
public class Project extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.Schedule")
   private Schedule Schedule;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.budget")
   private Collection<java.lang.Float> budget;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.Work")
   private Work Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.Requests")
   private Collection<Request> Requests;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.BusinessCase")
   private BusinessCase BusinessCase;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.ErpProjectAccounting")
   private ErpProjectAccounting ErpProjectAccounting;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.sub_Project")
   private Project sub_Project;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Project.parent_Project")
   private Project parent_Project;
}
