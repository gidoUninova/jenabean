package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Appointment")
public class Appointment extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Appointment.startTime")
   private Collection<java.lang.String> startTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Appointment.ErpAddress")
   private ErpAddress ErpAddress;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Appointment.Customers")
   private Collection<Customer> Customers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Appointment.endTime")
   private Collection<java.lang.String> endTime;
}
