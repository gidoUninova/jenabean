package thewebsemantic;

public class Filler {
   
   private Object target;
   private RDF2Bean writer;

   public Filler(RDF2Bean writer, Object o) {
      this.writer = writer;
      target = o;
   }
   
   public void with(String propertyName) {
      writer.fill(target, propertyName);
   }

}
