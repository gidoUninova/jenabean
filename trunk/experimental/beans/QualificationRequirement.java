package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("QualificationRequirement")
public class QualificationRequirement extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#QualificationRequirement.SkillCertifications")
   private Collection<SkillCertification> SkillCertifications;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#QualificationRequirement.Crews")
   private Collection<Crew> Crews;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#QualificationRequirement.AssetModels")
   private Collection<AssetModel> AssetModels;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#QualificationRequirement.WorkTasks")
   private Collection<WorkTask> WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#QualificationRequirement.CULaborItems")
   private Collection<CULaborItem> CULaborItems;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#QualificationRequirement.qualificationID")
   private Collection<java.lang.String> qualificationID;
}
