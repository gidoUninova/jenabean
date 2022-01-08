jenabean uses Jena's flexible RDF/OWL api to persist java beans. It takes an unconventional approach to binding that is driven by the java object model rather than an OWL or RDF schema. jenabean is annotation based and does not place any interface or extension requirements on your java object model. By default jenabean uses typical java bean conventions to derive RDF property URI’s, for example, the java bean property “name” would become RDF property “:name”. jenabean allows for explicit binding between an object property and a particular RDF property. (See Book.java for an example of binding arbitrary bean properties to the Dublin Core schema.)

Code Examples

To get a quick idea of how using jenabean might look see the junit test class. There is also a very simple stripes application that provides an example of using jenabean within an app.
