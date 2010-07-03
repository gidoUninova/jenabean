package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SkillCertification")
public class SkillCertification extends Document {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SkillCertification.ErpContact")
   private ErpContact ErpContact;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SkillCertification.type")
   private Collection<java.lang.String> type;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SkillCertification.QualificationRequirements")
   private Collection<QualificationRequirement> QualificationRequirements;
}
