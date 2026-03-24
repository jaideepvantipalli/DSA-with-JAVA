/*import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
public class CountriesAndCapitals{
	static HashMap<String, ArrayList<String>> hm=new HashMap<>();
	static Scanner sc=new Scanner(System.in);
	public static void main(String[] args){
		
		System.out.println("Enter no of countries :");
		int countries=sc.nextInt();
		
		for(int i=0;i<countries;i++){
			
			sc.nextLine();
			System.out.println("Enter name of the Country : ");
			String countryname=sc.nextLine();
			
			System.out.println("Enter no of capitals : ");
			int n=sc.nextInt();
			sc.nextLine();
			ArrayList<String> capitals=new ArrayList<>();
			
			if(n>=1){
				System.out.println("Enter the name of Winter capital : ");
				capitals.add(sc.nextLine());
			}
			if(n>=2){
				System.out.println("Enter the name of Summer capital : ");
				capitals.add(sc.nextLine());
			}if(n>=3){
				System.out.println("Enter the name of Rainy capital : ");
				capitals.add(sc.nextLine());
			}
			hm.put(countryname,capitals);
		}
		menu();
	}
	private static void menu(){
		while(true){
			System.out.println();
            System.out.println("1. Print all countries and capitals");
            System.out.println("2. Print capitals of a specific country");
            System.out.println("3. Countries having 2 capitals");
            System.out.println("4. Countries having 3 capitals");
            System.out.println("5. Countries without summer capital");
            System.out.println("6. Capitals of countries starting with vowel");
            System.out.println("7. Summer capitals of countries starting with vowel");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();
			switch(ch){
                case 1: printallcountries(); 
						break;
                case 2: specific_country();
						break;
                case 3: twocapitals(); 
						break;
                case 4: threecapitals(); 
						break;
                case 5: nosummercapital(); 
						break;
                case 6: capitalsofvowelcountries(); 
						break;
                case 7: summercapitalsvowelcountries(); 
						break;
                case 8: System.exit(0);
                default: System.out.println("Invalid choice");
            }
		}
	}
	
	private static void printallcountries(){
        for(String country:hm.keySet()){
            System.out.println(country+" : "+hm.get(country));
        }
    }
	
    private static void specific_country(){
        System.out.print("Enter country name : ");
        String country = sc.nextLine();

        if(hm.containsKey(country))	System.out.println("Capitals: " + hm.get(country));
    }
	
    private static void twocapitals(){
        for(String c:hm.keySet()){
            if(hm.get(c).size()==2)	System.out.println(c);
        }
    }
	
    private static void threecapitals(){
        for(String c:hm.keySet()){
            if(hm.get(c).size()==3)	System.out.println(c);
        }
    }
	
    private static void nosummercapital(){
        for(String c : hm.keySet()){
            if(hm.get(c).size()<2)	System.out.println(c);
        }
    }
	static boolean startsWithVowel(String word){
		if(word==null || word.length()==0) return false;
        return "aeiouAEIOU".indexOf(word.charAt(0))!=-1;
    }
	
    private static void capitalsofvowelcountries(){
        for(String c:hm.keySet()){
            if(startsWithVowel(c)){
                System.out.println(c+" : "+hm.get(c));
            }
        }
    }
	
    private static void summercapitalsvowelcountries(){
        for(String c : hm.keySet()){
            if(startsWithVowel(c) && hm.get(c).size()>=2){
                System.out.println(c+" : " +hm.get(c).get(1));
            }
        }
    }
}*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CountriesAndCapitals {

    static HashMap<String, ArrayList<String>> hm = new HashMap<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.print("Enter number of countries: ");
        int countries = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < countries; i++) {

            System.out.print("\nEnter country name: ");
            String countryName = sc.nextLine().trim();

            System.out.print("Enter number of capitals : ");
            int n = sc.nextInt();
            sc.nextLine();

            ArrayList<String> capitals = new ArrayList<>();

            if (n >= 1) {
                System.out.print("Enter Winter capital: ");
                capitals.add(sc.nextLine());
            }

            if (n >= 2) {
                System.out.print("Enter Summer capital: ");
                capitals.add(sc.nextLine());
            }

            if (n >= 3) {
                System.out.print("Enter Rainy capital: ");
                capitals.add(sc.nextLine());
            }

            hm.put(countryName, capitals);
        }

        menu();
    }

    private static void menu() {

        while (true) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Print all countries and capitals");
            System.out.println("2. Print capitals of a specific country");
            System.out.println("3. Countries having 2 capitals");
            System.out.println("4. Countries having 3 capitals");
            System.out.println("5. Countries without summer capital");
            System.out.println("6. Capitals of countries starting with vowel");
            System.out.println("7. Summer capitals of countries starting with vowel");
            System.out.println("8. Exit");

            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1: printAllCountries(); break;
                case 2: specificCountry(); break;
                case 3: twoCapitals(); break;
                case 4: threeCapitals(); break;
                case 5: noSummerCapital(); break;
                case 6: capitalsOfVowelCountries(); break;
                case 7: summerCapitalsVowelCountries(); break;
                case 8: System.out.println("Exiting..."); return;
                default: System.out.println("Invalid choice!");
            }
        }
    }

    private static void printAllCountries() {
        for (String country : hm.keySet()) {
            System.out.println(country + " -> " + hm.get(country));
        }
    }

    private static void specificCountry() {
        System.out.print("Enter country name: ");
        String country = sc.nextLine();

        if (hm.containsKey(country))
            System.out.println("Capitals: " + hm.get(country));
        else
            System.out.println("Country not found.");
    }

    private static void twoCapitals() {
        for (String c : hm.keySet()) {
            if (hm.get(c).size() == 2)
                System.out.println(c);
        }
    }

    private static void threeCapitals() {
        for (String c : hm.keySet()) {
            if (hm.get(c).size() == 3)
                System.out.println(c);
        }
    }

    private static void noSummerCapital() {
        for (String c : hm.keySet()) {
            if (hm.get(c).size() < 2)
                System.out.println(c);
        }
    }

    static boolean startsWithVowel(String word) {
        if (word == null || word.isEmpty())
            return false;
        return "AEIOUaeiou".indexOf(word.charAt(0)) != -1;
    }

    private static void capitalsOfVowelCountries() {
        for (String c : hm.keySet()) {
            if (startsWithVowel(c)) {
                System.out.println(c + " -> " + hm.get(c));
            }
        }
    }

    private static void summerCapitalsVowelCountries() {
        for (String c : hm.keySet()) {
            if (startsWithVowel(c) && hm.get(c).size() >= 2) {
                System.out.println(c + " -> " + hm.get(c).get(1));
            }
        }
    }
}