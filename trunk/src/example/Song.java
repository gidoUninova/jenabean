package example;

import thewebsemantic.Id;
import thewebsemantic.RdfBean;

public class Song extends RdfBean<Song>{
	private String composer;
	private Genre genre; 
	private String title;
	
	@Id
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public String getComposer() {
		return composer;
	}
	public void setComposer(String composer) {
		this.composer = composer;
	}
	
	public Genre getGenre() {
		return genre;
	}
	public void setGenre(Genre genre) {
		this.genre = genre;
	}
}
