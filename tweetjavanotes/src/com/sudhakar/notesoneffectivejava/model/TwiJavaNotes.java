package com.sudhakar.notesoneffectivejava.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.google.appengine.api.datastore.Key;



/**
 * The Class TwiJavaNotes.
 *
 * @author Sudhakar Duraiswamy
 */
@Entity
public class TwiJavaNotes {
	
	/** The key. */
	@Id		
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Key key;
	
	/** The next note id. */
	@Column
	private int nextNoteId;
	
	/** The followers. */
	@Column
	private List<Long> followers;

	/**
	 * Gets the key.
	 *
	 * @return the key
	 */
	public Key getKey() {
		return key;
	}

	/**
	 * Sets the key.
	 *
	 * @param key the new key
	 */
	public void setKey(Key key) {
		this.key = key;
	}

	/**
	 * Gets the next note id.
	 *
	 * @return the next note id
	 */
	public int getNextNoteId() {
		return nextNoteId;
	}

	/**
	 * Sets the next note id.
	 *
	 * @param nextNoteId the new next note id
	 */
	public void setNextNoteId(int nextNoteId) {
		this.nextNoteId = nextNoteId;
	}

	/**
	 * Gets the followers.
	 *
	 * @return the followers
	 */
	public List<Long> getFollowers() {
		return followers;
	}

	/**
	 * Sets the followers.
	 *
	 * @param followers the new followers
	 */
	public void setFollowers(List<Long> followers) {
		this.followers = followers;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TwiJavaNotes [key=" + key + ", nextNoteId=" + nextNoteId
				+ ", followers=" + followers + "]";
	}
	
	
	

}
