package com.sudhakar.notesoneffectivejava.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Text;

/**
 * The Class Note.
 *
 * @author Sudhakar Duraiswamy
 * The Class Note.
 */
@Entity
public class Note {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	/** The title. */
	@Column
	private String title;
	
	/** The description. */
	@Column
	private Text description;	
	
	/** The code sample. */
	@Column
	private String codeSample="";

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
	}


	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public Text getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(Text description) {
		this.description = description;
	}

	/**
	 * Gets the code sample.
	 *
	 * @return the code sample
	 */
	public String getCodeSample() {
		return codeSample;
	}

	/**
	 * Sets the code sample.
	 *
	 * @param codeSample the new code sample
	 */
	public void setCodeSample(String codeSample) {
		if(null != codeSample)this.codeSample = codeSample;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Note [id=" + id + ", title=" + title + ", description="
				+ description + ", codeSample=" + codeSample + "]";
	}


	
	
}
