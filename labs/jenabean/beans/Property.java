package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("Property")
public class Property extends Naming {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.AssetModel")
   private AssetModel AssetModel;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.propertyType")
   private Collection<java.lang.String> propertyType;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.units")
   private Collection<java.lang.String> units;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.InspectionDataSet")
   private InspectionDataSet InspectionDataSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.propertyValue")
   private Collection<java.lang.String> propertyValue;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.MaintenanceDataSet")
   private MaintenanceDataSet MaintenanceDataSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.TestDataSet")
   private TestDataSet TestDataSet;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.Assets")
   private Collection<Asset> Assets;
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#Property.Measurements")
   private Measurement Measurements;
}
