import java.io.*;
import java.util.Scanner;




public class MyDatabase {
	
	public static void main(String[] args) throws FileNotFoundException, IOException { 
		
		System.out.print("Please enter the .CSV file path:");
		Scanner sc= new Scanner(System.in);
		String CSVPath = sc.next();
		String DBPath = "data.db";
		
		//set a array for storing all data from the .csv file
		DataPhar[] phar_data = new DataPhar[1000];
		//parse .csv file and then write to .db file, put all data into phar_data array
		phar_data = ReadFromFileWriteDB(CSVPath,DBPath);
		System.out.println("------------File parse successful!-----------");
		writeNdx.WriteFile(phar_data);
		System.out.println("------------Index File has been created!-----------");
		menu.Main_menu();

     
	}
	// read data from file PHARMA_TRIALS_1000B.csv  and write data into file data.db 
	static DataPhar[] ReadFromFileWriteDB(String CSVPath, String DBPath)
	{
		 File file = new File(CSVPath);
		 
         String str = null;
         DataPhar[] phar_data = new DataPhar[1000];
         try {
        	 
        	
        	 InputStream is = new FileInputStream(file);
        	 BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        	 str = reader.readLine();   //read first lie of .csv file 
        	 RandomAccessFile raf =  new RandomAccessFile(new File(DBPath),"rw");   //creat the data.db file 
        	 
        	 str = reader.readLine(); //jump the attributes row
        	
        	int i_p = 0;
        	int location = 0;
        	 while(str!=null)
        	 {
        		 
        		 
        		  //set file address starts from 0
        		 // read id 
        		 int id = Integer.parseInt(str.substring(0, str.indexOf(',')));
        		 str = str.substring(str.indexOf(',')+1, str.length());  //cut the part which has been read
                 
                 //read company 
                 String company=null;
                 if(str.indexOf('"')>=0)    //if the string starts with ""
                 {
                	 company = str.substring(str.indexOf('"')+1, str.lastIndexOf('"'));
                     str = str.substring(str.lastIndexOf('"')+2, str.length());  //need plus two, otherwise it will read "
                 }
                 else
                 {
                	 company = str.substring(0, str.indexOf(','));   //some compnay name starts without "
                	 str = str.substring(str.indexOf(',')+1, str.length());  //cut the part which has been read
                 }
                 
                 
                 
                 // read drug id in drugid
                 String drugid = str.substring(0, str.indexOf(','));   
                 str = str.substring(str.indexOf(',')+1, str.length());
                 //read  trials
                 int trials  = Integer.parseInt(str.substring(0, str.indexOf(',')));
                 str = str.substring(str.indexOf(',')+1, str.length());
                 // read patients
                 int patients  = Integer.parseInt(str.substring(0, str.indexOf(',')));
                 str = str.substring(str.indexOf(',')+1, str.length());
               
                 //read dosage_mg
                 int dosage_mg  = Integer.parseInt(str.substring(0, str.indexOf(',')));
                 str = str.substring(str.indexOf(',')+1, str.length());
               
                 //read reading
                 float reading = Float.parseFloat(str.substring(0, str.indexOf(',')));
                 str = str.substring(str.indexOf(',')+1, str.length());
                 
                 //read double_blind
                 //read ture or false as 1 and 0, convert the result to int format, 
                 //e.g. true false true false------> 0000 1010 convert to 10, and then write byte format to the .db file
                 int booleanresult = 0;    
                 for(int i=0;i<4;i++)
                 {
                	 int end = str.length(); // without commas
                	 if(str.indexOf(',')>0)
                		 end = str.indexOf(','); // with commas
                	 if(str.substring(0, end).charAt(0)=='T'||str.substring(0, end).charAt(0)=='t')
	                	 booleanresult += Math.pow(2, (4-i-1));   //directly convert the result to decimal
	                	 str = str.substring(str.indexOf(',')+1, str.length());
                 }
                               
                 str = reader.readLine();  //read next line 
   
                 //write and convert all data to binary file
                 // starting write data to .db file
                 //write id
                 raf.write(Util.int2bytes(id,4));
                 
                 //write company
                 raf.write(company.length());    
                 for(int i=0;i<company.length();i++)
                 {   
                	
                	 raf.write((byte)company.charAt(i));

                 }
                 
                 // write drug id
                 for (int i = 0; i < drugid.length(); i++) 
                	raf.write((byte)drugid.charAt(i));
                 
                 //write trials
                 raf.write(Util.int2bytes(trials,2)); 
                  
                 //write patient
                 raf.write(Util.int2bytes(patients,2));
                 
                 //write dosage
                 raf.write(Util.int2bytes(dosage_mg,2));
                 
                 //write reading
                 raf.write(Util.float2bytes(reading));
               
                 //write reading, since the for fields of true and false has been converted to int format thus we can convert them to byte format

                 raf.write(Util.int2bytes(booleanresult,1));                  
                 
                 // this part is preparing for writing Index file
                 // an array put all data from the file
                 phar_data[i_p] = new DataPhar(id, company, drugid, trials, patients, dosage_mg, reading, booleanresult);   
                 
                 //calculate the file location of each filed 
                 /*
                  * id          4 bytes
					company	    (1 length byte + 1 byte/char)
					drug_id	    6 bytes
					trials	    2 bytes
					patients	2 bytes
					dosage_mg	2 bytes
					reading	    4 bytes
					
					double_blind		1 byte
					controlled_study	
					govt_funded	
					fda_approved	

                  * */
                 // set 
                 phar_data[i_p].setLocation(location); 
                 //calculate the starting location of next line
                 location += 22+company.length();
                 i_p++;
                 
        	 }
        	 
        	 raf.close();
        	 
        	 
         }catch(Exception e) {
        	 e.printStackTrace();
         }
         
         return phar_data;
         }
	
	
}
