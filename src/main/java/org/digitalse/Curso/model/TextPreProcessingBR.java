package org.digitalse.Curso.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TextPreProcessingBR {
	private String[] defaultStopWords = {"a", "ao", "me", "mim", "ai", "ali", "e", "ou", "que", "para", "como", "aonde", "em", "o", "as"};
	private static HashSet stopWords = new HashSet();
	public TextPreProcessingBR() {
		stopWords.addAll(Arrays.asList(defaultStopWords));
	}
	public String[] removeStopWords(String[] words) {
		ArrayList<String> token = new ArrayList<String>(Arrays.asList(words));
		for(int i=0; i<token.size(); i++){
			if(stopWords.contains(token.get(i))) {
				token.remove(i);
			}
		}
		return (String[]) token.toArray(new String[token.size()]);
	}
	

}
