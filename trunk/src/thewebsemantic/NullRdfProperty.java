package thewebsemantic;

import java.lang.annotation.Annotation;

public class NullRdfProperty implements RdfProperty {
	
		@Override
		public boolean symmetric() {
			return false;
		}

		@Override
		public boolean transitive() {
			return false;
		}

		@Override
		public String value() {
			return null;
		}

		@Override
		public Class<? extends Annotation> annotationType() {
			return null;
		}

}
