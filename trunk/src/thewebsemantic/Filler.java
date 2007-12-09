package thewebsemantic;

public class Filler {
   
   private Object target;
   private RDF2Bean writer;

   public Filler(RDF2Bean writer, Object o) {
      this.writer = writer;
      target = o;
   }
   
   public <T> T with(String propertyName) {
      return writer.load(target, propertyName);
   }

}
