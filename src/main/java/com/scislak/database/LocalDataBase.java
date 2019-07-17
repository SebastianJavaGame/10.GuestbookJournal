package com.scislak.database;

import java.util.ArrayList;
import java.util.List;

public class LocalDataBase {
	private static List<Guest> guests;
	private static List<Sentence> sentences;
	private static List<Comment> comments;
	
	static {
		guests = new ArrayList<>();
		sentences = new ArrayList<>();
		comments = new ArrayList<>();
	}
	
	public static void addGuest(Guest guest) {
		guests.add(guest);
	}
	
	public static Guest getGuest(int index) {
		return guests.get(index);
	}
	
	public static void deleteGuest(Guest guest) {
		guests.remove(guest);
	}
	
	public static void addSentence(Sentence sentence) {
		sentences.add(sentence);
	}
	
	public static int getSizeGuest() {
		return guests.size();
	}
	
	public static Sentence getSentence(int index) {
		return sentences.get(index);
	}
	
	public static void deleteSentence(Sentence sentence) {
		sentences.remove(sentence);
	}
	
	public static int getSizeSentence() {
		return sentences.size();
	}
	
	public static void addComment(Comment comment) {
		comments.add(comment);
	}
	
	public static Comment getComment(int index) {
		return comments.get(index);
	}
	
	public static void deleteComment(Comment comment) {
		comments.remove(comment);
	}
	
	public static int getSizeComment() {
		return comments.size();
	}
}
