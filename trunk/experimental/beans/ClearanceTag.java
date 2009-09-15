package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("ClearanceTag")
public class ClearanceTag extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.phaseCheckReqFlag")
   private Collection<java.lang.Boolean> phaseCheckReqFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.groundReqFlag")
   private Collection<java.lang.Boolean> groundReqFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.workEndTime")
   private Collection<java.lang.String> workEndTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.clearanceTagType")
   private ClearanceTagType clearanceTagType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.tagIssueTime")
   private Collection<java.lang.String> tagIssueTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.deenergizeReqFlag")
   private Collection<java.lang.Boolean> deenergizeReqFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.authorityName")
   private Collection<java.lang.String> authorityName;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.SafetyDocuments")
   private Collection<SafetyDocument> SafetyDocuments;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.ConductingEquipment")
   private ConductingEquipment ConductingEquipment;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.workStartTime")
   private Collection<java.lang.String> workStartTime;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#ClearanceTag.workDescription")
   private Collection<java.lang.String> workDescription;
}
