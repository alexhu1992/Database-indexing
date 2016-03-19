import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Pattern;


public class menu {

	
	static void Main_menu() throws IOException {
		
		Scanner sc= new Scanner(System.in);
		drawTextLine('=', 80);
		System.out.println();
		System.out.println("1.Id");
		System.out.println("2.Compnay");
		System.out.println("3.drug_id");
		System.out.println("4.trials");
		System.out.println("5.patients");
		System.out.println("6.dosage_mg");
		System.out.println("7.reading");
		System.out.println("8.double_blind");
		System.out.println("9.controlled_study");
		System.out.println("10.govt_funded	");
		System.out.println("11.fda_approved	");
		System.out.println();
		drawTextLine('=', 80);
		System.out.println("please choose a field to query:");
	    int i=sc.nextInt();
	    
	    switch (i) {
		case 1:
			id_menu();
		    break;
		case 2:
			com_menu();
			break;
		case 3:
			drug_id_menu();
		    break;
		case 4:
			trials_menu();
			break;
		case 5:
			patients_menu();
		    break;
		case 6:
			dosage_menu();
			break;
		case 7:
			reading_menu();
		    break;
		case 8:
			boo1_menu();
			break;
		case 9:
			boo2_menu();
		    break;
		case 10:
			boo3_menu();
			break;
		case 11:
			boo4_menu();
		    break;
		default:
			System.out.println("Please enter number throguh 1 to 11!");
			Main_menu();
	    }
	}
	
	static void id_menu() throws IOException,NumberFormatException {
		 	
		  Scanner sc= new Scanner(System.in);
		  String input = null;
		  int i;
		  System.out.println("Please enter an ID number:");
		  input=sc.next();
		  Pattern pattern = Pattern.compile("[0-9]*");
			  
			  if (pattern.matcher(input).matches())
			  {Op_menu();}
              else {
            	  System.out.println("It's not an ID number!");
			  id_menu();
              }
			  int id = Integer.valueOf(input);
			  i=sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  System.out.print("the result is:"+"\n");
			  Result.query(id,1,"id.ndx");
			  break;
		  case 2:   //>
			  System.out.print("the result is:"+"\n");
			  Result.query(id,2,"id.ndx");
			  break;
		  case 3:  // <
			  System.out.print("the result is:"+"\n");
			  Result.query(id,3,"id.ndx");
			  break;
		  case 4:  // >=
			  System.out.print("the result is:"+"\n");
			  Result.query(id,4,"id.ndx");
			  break;
		  case 5:  //<=
			  System.out.print("the result is:"+"\n");
			  Result.query(id,5,"id.ndx");
			  break;
		  case 6:  //<=
			  System.out.print("the result is:"+"\n");
			  Result.query(id,6,"id.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  id_menu();
			  }
	}
	
	static void com_menu() throws IOException {
		  Scanner sc= new Scanner(System.in);
		  String company = null;
		  int i;
		  System.out.println("Please enter Company name:");
		  company=sc.next();
		  Pattern pattern = Pattern.compile("[A-Za-z]+$");
			  if (pattern.matcher(company).matches())
			  	{opc_menu();}
			  else 
			  {
				  System.out.println("It's not a Company name!");
				  com_menu();
              }
			  i=sc.nextInt();

		  switch(i) {
		  case 1: // = 
			  
			  Result.query(company,1,"company.ndx");
			  break;
		  case 2:   //>
			  
			  Result.query(company,2,"company.ndx");
			  break;
		  case 3:  // <
			  
			  Result.query(company,3,"company.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  com_menu();
			  
		  }
	}
	
	static void drug_id_menu() throws IOException {
		  Scanner sc= new Scanner(System.in);
		  System.out.println("please enter a drug id:");
		  String drug_id=sc.next();
		  opc_menu();
		  int i = sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(drug_id,1,"drug_id.ndx");
			  break;
		  case 2:   //>
			  
			  Result.query(drug_id,2,"drug_id.ndx");
			  break;
		  case 3:  // <
			  
			  Result.query(drug_id,3,"drug_id.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  drug_id_menu();
			  
		  }
		  
	}
	static void trials_menu() throws IOException {
		
		  Scanner sc= new Scanner(System.in);
		  int i;
		  System.out.println("Please enter a trials number:");
		  String input=sc.next();
		  Pattern pattern = Pattern.compile("[0-9]*");
			  
			  if (pattern.matcher(input).matches())
			  {Op_menu();}
            else {
          	  System.out.println("It's not a trials number!");
          	trials_menu();
            }
			  int trials = Integer.valueOf(input);
			  i=sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  Result.query(trials,1,"trials.ndx");
			  break;
		  case 2:   //>
			  
			  Result.query(trials,2,"trials.ndx");
			  break;
		  case 3:  // <
			  
			  Result.query(trials,3,"trials.ndx");
			  break;
		  case 4:  //>=
			  
			  Result.query(trials,4,"trials.ndx");
			  break;
		  case 5:  //<=
			  Result.query(trials,5,"trials.ndx");
			  break;
		  case 6:  //<=
			  Result.query(trials,6,"trials.ndx");  
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  trials_menu();
			  
		  }
	}
	
	static void patients_menu() throws IOException {
		
		  Scanner sc= new Scanner(System.in);
		  int i;
		  System.out.println("Please enter a patients number:");
		  String input=sc.next();
		  Pattern pattern = Pattern.compile("[0-9]*");
			  
			  if (pattern.matcher(input).matches())
			  {Op_menu();}
          else {
        	  System.out.println("It's not a patients number!");
        	  patients_menu();
          }
			  int patients = Integer.valueOf(input);
			  i=sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(patients,1,"patients.ndx");
			  break;
		  case 2:   //>
			  
			  Result.query(patients,2,"patients.ndx");
			  break;
		  case 3:  // <			  
			  Result.query(patients,3,"patients.ndx");
			  break;
		  case 4:  //>=
			  
			  Result.query(patients,4,"patients.ndx");
			  break;
		  case 5:  //<=
			  Result.query(patients,5,"patients.ndx");
			  break;
		  case 6:  //<=
			  Result.query(patients,6,"patients.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  patients_menu();
		  }
	}
	static void dosage_menu() throws IOException {
		
		  Scanner sc= new Scanner(System.in);
		  int i;
		  System.out.println("Please enter a dosage_mg number:");
		  String input=sc.next();
		  Pattern pattern = Pattern.compile("[0-9]*");
			  
			  if (pattern.matcher(input).matches())
			  	{Op_menu();}
			  else 
			  {
        		System.out.println("It's not a dosage_mg number!");
        		dosage_menu();
			  }
			  int dosage = Integer.valueOf(input);
			  i=sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(dosage,1,"dosage_mg.ndx");
			  break;
		  case 2:   //>
			  
			  Result.query(dosage,2,"dosage_mg.ndx");
			  break;
		  case 3:  // <
			  
			  Result.query(dosage,3,"dosage_mg.ndx");
			  break;
		  case 4:  //>=
			  
			  Result.query(dosage,4,"dosage_mg.ndx");
			  break;
		  case 5:  //<=
			  Result.query(dosage,5,"dosage_mg.ndx");
			  break;
		  case 6:  //<=
			  Result.query(dosage,6,"dosage_mg.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  dosage_menu();
		  }
		  
	}
	static void reading_menu() throws IOException {
		
		  Scanner sc= new Scanner(System.in);
		  int i;
		  System.out.println("Please enter a reading number:");
		  String input=sc.next();
		  Pattern pattern = Pattern.compile("[0-9]*");
			  
			  if (pattern.matcher(input).matches())
			  	{Op_menu();}
			  else 
			  {
				  System.out.println("It's not a reading number!");
      			  reading_menu();
			  }
			  int reading = Integer.valueOf(input);
			  i=sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(reading,1,"reading.ndx");
			  break;
		  case 2:   //>
			  
			  Result.query(reading,2,"reading.ndx");
			  break;
		  case 3:  // <
			  
			  Result.query(reading,3,"reading.ndx");
			  break;
		  case 4:  //>=
			  
			  Result.query(reading,4,"reading.ndx");
			  break;
		  case 5:  //<=
			  Result.query(reading,5,"reading.ndx");
			  break;
		  case 6:  //<=
			  Result.query(reading,6,"reading.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 6!");
			  reading_menu();
			  
		  }
	}
	static void boo1_menu() throws IOException {
		
		Scanner sc= new Scanner(System.in);
		  System.out.println("please enter the value of double_blind: True-1, False-0");
		  int double_blind=sc.nextInt();
		  boolean input = true;
		  if(double_blind==0) input = false;
		  Boo_menu();
		  int i =sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(input,1,"double_blind.ndx");
			  break;
		  case 2:   //！=
			  
			  Result.query(input,2,"double_blind.ndx");
			  break;
			  
			  
		  }
	}
	static void boo2_menu() throws IOException {
		
		  Scanner sc= new Scanner(System.in);
		  System.out.println("please enter the value of controlled_study: True-1, False-0");
		  int controlled_study=sc.nextInt();
		  boolean input = true;
		  if(controlled_study==0) input = false;
		  Boo_menu();
		  int i =sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(input,1,"controlled_study.ndx");
			  break;
		  case 2:   //!=
			  
			  Result.query(input,2,"controlled_study.ndx");
			  break;
		  default:
			  System.out.println("Please enter number throguh 1 to 2!");
			  Boo_menu();
			  
		  }
	}
	static void boo3_menu() throws IOException {
		
	      Scanner sc= new Scanner(System.in);
		  System.out.println("please enter the value of govt_funded: True-1, False-0");
		  int govt_funded=sc.nextInt();
		  boolean input = true;
		  if(govt_funded==0) input = false;
		  Boo_menu();
		  int i =sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(input,1,"govt_funded.ndx");
			  break;
		  case 2:   //!=
			  
			  Result.query(input,2,"govt_funded.ndx");
			  break;
			  
		  }
	}
	static void boo4_menu() throws IOException {
		
		  Scanner sc= new Scanner(System.in);
		  System.out.println("please enter the value of fda_approved: True-1, False-0");
		  int fda_approved=sc.nextInt();
		  boolean input = true;
		  if(fda_approved==0) input = false;
		  Boo_menu();
		  int i =sc.nextInt();
		  switch(i) {
		  case 1: // = 
			  
			  Result.query(input,1,"fda_approved.ndx");
			  break;
		  case 2:   //!=
			  
			  Result.query(input,2,"fda_approved.ndx");
			  break;
		  default:
			  
		  }
	}
	
	
	
	static void Op_menu() {
		drawTextLine('=', 80);
		System.out.println("please enter a number of query operators as listed below:");
		System.out.println();
		System.out.println("1.=");
		System.out.println("2.>");
		System.out.println("3.<");
		System.out.println("4.>=");
		System.out.println("5.<=");
		System.out.println("6.!=");
		drawTextLine('=', 80);
		System.out.println();
		
	}
	
	static void Boo_menu() {
		drawTextLine('=', 80);
		System.out.println("please enter a number of query operators as listed below:");
		System.out.println();
		System.out.println("1.=");
		System.out.println("2.>");
		drawTextLine('=', 80);
		System.out.println();
		
	}
	
	static void opc_menu() {
		drawTextLine('=', 80);
		System.out.println("please enter a number of query operators as listed below:");
		System.out.println();
		System.out.println("1.=");
		System.out.println("2.>");
		System.out.println("3.<");
		drawTextLine('=', 80);
		System.out.println();
		
	}
	static void drawTextLine(char c, int i) {
		for(int n=0;n<i;n++) { System.out.print(c); }
		System.out.println();
	}
}
