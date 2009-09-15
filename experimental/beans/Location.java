package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Location")
public class Location extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.DesignLocations")
   private DesignLocation DesignLocations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.Work")
   private Collection<Work> Work;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.code")
   private Collection<java.lang.String> code;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.type")
   private Collection<java.lang.String> type;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.Dimensions")
   private Dimensions Dimensions;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.polygonFlag")
   private Collection<java.lang.Boolean> polygonFlag;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.LocationGrants")
   private Collection<LocationGrant> LocationGrants;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.Presentations")
   private Presentation Presentations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.IsPartOf.Location")
   private Location IsPartOf_Location;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.coordinate")
   private CoordinatePair coordinate;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.PowerSystemResources")
   private PowerSystemResource PowerSystemResources;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.coordinateList")
   private PointSequence coordinateList;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.WorkTasks")
   private Collection<WorkTask> WorkTasks;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.Contains.Locations")
   private Location Contains_Locations;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.Documents")
   private Collection<Document> Documents;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Location.Assets")
   private Asset Assets;
}
