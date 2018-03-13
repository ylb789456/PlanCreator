package fr.polytech.com.main;

import java.awt.EventQueue;
import java.util.Locale;

import fr.polytech.com.models.Data;
import fr.polytech.com.pages.ChooseSallonPage;
import fr.polytech.com.pages.CreateSallonPage;

public class Main{
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private Data data;

			public void run() {
				try {
					
					data=new Data();
					Locale.setDefault(Locale.FRANCE);
					ChooseSallonPage chooseSallonPage=new ChooseSallonPage(data);
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
