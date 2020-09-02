/**
 * 
 */
package fr.lusseau.bibliotheque.utils;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;

import fr.lusseau.bibliotheque.configuration.StringToDate;
import fr.lusseau.bibliotheque.configuration.DateToString;

/**
 * Classe en charge de
 * @Version Bibliotheque -v1,0
 * @date  2 sept. 2020 - 10:21:33
 * @author Claude LUSSEAU
 *
 */
public class TestDate {

	@Autowired
	static DateToString dts = new DateToString();
	@Autowired
	static StringToDate std = new StringToDate();
	
	/**
	 * Methode en charge de
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		LocalDateTime now = LocalDateTime.now();
		
		System.out.println("Before : " + now);
		
		System.out.println("After : " +  dts.convert(now));
		
		String date = dts.convert(now);
		String date2 = "02/03/2017 03:02";
		LocalDateTime date3 = std.convert(date2);
		
		System.out.println("Again After : " +  date);
		System.out.println("Again After : " +  std.convert(date));
		System.out.println("Again After : " +  date3);
		System.out.println("Again After : " +  dts.convert(date3));
	}
	

}
