package example;

import static example.AssemblerVocabulary.NS;
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;

@Namespace(NS)
public class Connection {
	
	private String dbClass;
	private String dbClassProperty;	
	private String dbPassword;
	private String dbPasswordProperty;	
	private String dbType;
	private String dbTypeProperty;	
	private String dbURL;	
	private String dbURLProperty;	
	private String dbUser;	
	private String dbUserProperty;
	
	@RdfProperty(NS + "dbClass")
	public String getDbClass() {
		return dbClass;
	}
	public void setDbClass(String dbClass) {
		this.dbClass = dbClass;
	}
	
	@RdfProperty(NS + "dbClassProperty")
	public String getDbClassProperty() {
		return dbClassProperty;
	}
	public void setDbClassProperty(String dbClassProperty) {
		this.dbClassProperty = dbClassProperty;
	}
	
	@RdfProperty(NS + "dbPassword")
	public String getDbPassword() {
		return dbPassword;
	}
	public void setDbPassword(String dbPassword) {
		this.dbPassword = dbPassword;
	}
	
	@RdfProperty(NS + "dbPasswordProperty")
	public String getDbPasswordProperty() {
		return dbPasswordProperty;
	}
	public void setDbPasswordProperty(String dbPasswordProperty) {
		this.dbPasswordProperty = dbPasswordProperty;
	}
	
	@RdfProperty(NS + "dbType")
	public String getDbType() {
		return dbType;
	}
	public void setDbType(String dbType) {
		this.dbType = dbType;
	}
	
	@RdfProperty(NS + "dbTypeProperty")
	public String getDbTypeProperty() {
		return dbTypeProperty;
	}
	public void setDbTypeProperty(String dbTypeProperty) {
		this.dbTypeProperty = dbTypeProperty;
	}
	
	
	@RdfProperty(NS + "dbURL")
	public String getDbURL() {
		return dbURL;
	}
	public void setDbURL(String dbURL) {
		this.dbURL = dbURL;
	}
	
	@RdfProperty(NS + "dbURLProperty")
	public String getDbURLProperty() {
		return dbURLProperty;
	}
	public void setDbURLProperty(String dbURLProperty) {
		this.dbURLProperty = dbURLProperty;
	}
	
	@RdfProperty(NS + "dbUser")
	public String getDbUser() {
		return dbUser;
	}
	public void setDbUser(String dbUser) {
		this.dbUser = dbUser;
	}
	
	@RdfProperty(NS + "dbUserProperty")
	public String getDbUserProperty() {
		return dbUserProperty;
	}
	public void setDbUserProperty(String dbUserProperty) {
		this.dbUserProperty = dbUserProperty;
	}	
}
