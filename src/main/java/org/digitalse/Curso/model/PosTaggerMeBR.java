package org.digitalse.Curso.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import opennlp.tools.postag.POSModel;
import opennlp.tools.postag.POSTaggerME;

public class PosTaggerMeBR {
	private InputStream modelIn;
	private String[] result;
	public PosTaggerMeBR(String[] text) {
		POSModel model = null;
		POSTaggerME tagger = null;
		try {
			modelIn = new FileInputStream(new File("data/", "pt-pos-maxent.bin"));
			model = new POSModel(modelIn);
			tagger = new POSTaggerME(model);
			this.result = tagger.tag(text);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	public String[] getResult() {
		return result;
	}
	
	

	
}
