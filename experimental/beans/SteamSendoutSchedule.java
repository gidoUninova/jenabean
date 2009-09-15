package beans;

import thewebsemantic.*;
import java.util.*;

@Namespace("http://iec.ch/TC57/2003/CIM-schema-cim10#")
@RdfType("SteamSendoutSchedule")
public class SteamSendoutSchedule extends CurveSchedule {
   @RdfProperty("http://iec.ch/TC57/2003/CIM-schema-cim10#SteamSendoutSchedule.CogenerationPlant")
   private CogenerationPlant CogenerationPlant;
}
