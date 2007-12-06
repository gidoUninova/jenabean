package example;

import java.util.Collection;
import java.util.LinkedHashSet;

import thewebsemantic.Inverse;
import thewebsemantic.Namespace;


public class Taggable {
	private Collection<Tag> tags = new LinkedHashSet<Tag>();

	public void addTag(Tag t) {
		tags.add(t);
	}

	public void setTags(Collection<Tag> tags) {
		this.tags = tags;
	}

	@Inverse("elements")
	public Collection<Tag> getTags() {
		return tags;
	}
}
