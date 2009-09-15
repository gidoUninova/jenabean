package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ErpContact")
public class ErpContact extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.Reads_MeasurementValue")
   private MeasurementValue Reads_MeasurementValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.Crew")
   private Crew Crew;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.ErpTelephoneNumbers")
   private Collection<ErpTelephoneNumber> ErpTelephoneNumbers;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.SkillCertifications")
   private SkillCertification SkillCertifications;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.ErpAddresses")
   private Collection<ErpAddress> ErpAddresses;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.firstName")
   private Collection<java.lang.String> firstName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.ErpCompetency")
   private ErpCompetency ErpCompetency;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.lastName")
   private Collection<java.lang.String> lastName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.ErpPersonnel")
   private ErpPersonnel ErpPersonnel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.mName")
   private Collection<java.lang.String> mName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.specialNeeds")
   private Collection<java.lang.String> specialNeeds;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ErpContact.LaborItems")
   private Collection<LaborItem> LaborItems;
}
