package example;

import java.util.Date;

import thewebsemantic.Id;
import thewebsemantic.Namespace;
import thewebsemantic.RdfProperty;

/**
 * Example domain object for storing book info.  Purposefully ripe
 * for DC applications.  @RdfProperty annotations are used to
 * indicate the DC property to bean property bindings.  The class itself
 * is given a required namespace of "http://example.org/".
 * 
 * Note, all properties need not be bound via the RdfProperty annotation.
 * Take for example the isbn property of this bean, which is mapped as part
 * of the beans own namespace.  The Id annotation is important, indicating which
 * property is the "natural key" for the bean.  If this were missing Bean2RDF would
 * use the beans hashCode() method instead...which is not ideal, and only advised once 
 * you've overidden the default hashCode() method with one of your own.
 * 
 * @author Taylor Cowan
 */
@Namespace("http://example.org/")
public class Book {
	private String contributor;  
	private String coverage;
	private String creator;
	private Date date;
	private String description;  
	private String format;  
	private String identifier;  
	private String language;  
	private String publisher;  
	private String relation;
	private String rights;  
	private String source;  
	private String subject;  
	private String title;  
	private String type;
	private String isbn;
	
	
	@Id
	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isdn) {
		this.isbn = isdn;
	}

	@RdfProperty(DublinCore.contributor)
	public String getContributor() {
		return contributor;
	}
	
	public void setContributor(String contributor) {
		this.contributor = contributor;
	}
	
	@RdfProperty(DublinCore.coverage)
	public String getCoverage() {
		return coverage;
	}
	
	public void setCoverage(String coverage) {
		this.coverage = coverage;
	}
	
	@RdfProperty(DublinCore.creator)
	public String getCreator() {
		return creator;
	}
	
	public void setCreator(String creator) {
		this.creator = creator;
	}
	
	@RdfProperty(DublinCore.date)
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	@RdfProperty(DublinCore.description)
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String description) {
		this.description = description;
	}
	
	@RdfProperty(DublinCore.format)
	public String getFormat() {
		return format;
	}
	
	public void setFormat(String format) {
		this.format = format;
	}
	
	@RdfProperty(DublinCore.identifier)
	public String getIdentifier() {
		return identifier;
	}
	
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	
	@RdfProperty(DublinCore.language)
	public String getLanguage() {
		return language;
	}
	
	public void setLanguage(String language) {
		this.language = language;
	}
	
	@RdfProperty(DublinCore.publisher)
	public String getPublisher() {
		return publisher;
	}
	
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@RdfProperty(DublinCore.relation)
	public String getRelation() {
		return relation;
	}
	
	public void setRelation(String relation) {
		this.relation = relation;
	}
	
	@RdfProperty(DublinCore.rights)
	public String getRights() {
		return rights;
	}
	
	public void setRights(String rights) {
		this.rights = rights;
	}
	
	@RdfProperty(DublinCore.source)
	public String getSource() {
		return source;
	}
	
	public void setSource(String source) {
		this.source = source;
	}
	
	@RdfProperty(DublinCore.subject)
	public String getSubject() {
		return subject;
	}
	
	public void setSubject(String subject) {
		this.subject = subject;
	}
	
	@RdfProperty(DublinCore.title)
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	@RdfProperty(DublinCore.type)
	public String getType() {
		return type;
	}
	
	public void setType(String type) {
		this.type = type;
	} 
}
