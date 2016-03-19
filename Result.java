import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;


public class Result {
	  
	    
	    //if the input is int 
	    static void query(int id, int operator, String path) throws IOException {
		
		
		RandomAccessFile data =  new RandomAccessFile("data.db","rw");
		
		
		File file = new File(path);
		InputStream is = new FileInputStream(file);
   	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
   	    //read a line
   	    String str = reader.readLine();
   	    
   	    boolean Found = false;
   	    switch(operator) 
   	    {
   	    	case 1: //=
   	    	
   	   	    while (str!=null)
   	   	    {
	   	   	  String cut = str.substring(0, str.indexOf('\t'));
	   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
	   	   	//  System.out.println("the id is"+id_lo_str);
	   	   	  while (id_lo_str !=null)
	   	   	  {
	   	   		  int end = id_lo_str.indexOf('\t');
	   	   		  int id_lo = 0;
	   	   		  if(end>=0)
	   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
	   	   		  else 
	   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
	   	   		
	   	   		  if(cut.equals(String.valueOf(id))) 
	   	   		   {
	   	   			   Query_output(data, id_lo);
	   	   			   break;
	   	   		   }
	   	   		  if(id_lo_str.indexOf('\t')<0) break;
	   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
    	   	  }
	   	   	 str = reader.readLine();
   	   	    }     
   	   	    break;
   	   	    
   	    	case 2: // >
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Integer.valueOf(cut)>id) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   break;
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;

   	    	case 3: // <
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Integer.valueOf(cut)<id) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);   		   	   			   
   		   	   		   }
   		   	   		  
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
   	   	   	    
	   	    case 4: // >=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Integer.valueOf(cut)>=id) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
	   	    case 5: // <=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Integer.valueOf(cut)<=id) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
	   	    case 6: // !=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Integer.valueOf(cut)!=id) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
   
   	    }
   	    
	}
	  //if the input is boolean 
	    static void query(boolean input, int operator, String path) throws IOException {
		
		
		RandomAccessFile data =  new RandomAccessFile("data.db","rw");
		
		
		File file = new File(path);
		InputStream is = new FileInputStream(file);
   	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
   	    //read a line
   	    String str = reader.readLine();
   	    
   	    //System.out.println("input="+input);
   	    switch(operator) 
   	    {
   	    	case 1: //=
   	    	
   	   	    while (str!=null)
   	   	    {
	   	   	  String cut = str.substring(0, str.indexOf('\t'));
	   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
	   	   	  //System.out.println("cut="+cut);
	   	   	  while (id_lo_str !=null)
	   	   	  {
	   	   		  int end = id_lo_str.indexOf('\t');
	   	   		  int id_lo = 0;
	   	   		  if(end>=0)
	   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
	   	   		  else 
	   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
	   	   		
	   	   		  if(cut.equalsIgnoreCase("true")&&input || cut.equalsIgnoreCase("false")&&!input) 
	   	   		   {
	   	   			   Query_output(data, id_lo);
	   	   		   }
	   	   		  if(id_lo_str.indexOf('\t')<0) break;
	   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
    	   	  }
	   	   	 str = reader.readLine();
   	   	    }     
   	   	    break;
   	   	    
   	    	case 2: // !=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(cut.equalsIgnoreCase("true")&&!input || cut.equalsIgnoreCase("false")&&input) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
   
   	    }
   	    
	}
	  //if the input is float 
	    static void query(float input, int operator, String path) throws IOException {
		
		
		RandomAccessFile data =  new RandomAccessFile("data.db","rw");
		
		
		File file = new File(path);
		InputStream is = new FileInputStream(file);
   	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
   	    //read a line
   	    String str = reader.readLine();
   	    
   	    boolean Found = false;
   	    switch(operator) 
   	    {
   	    	case 1: //=
   	    	
   	   	    while (str!=null)
   	   	    {
	   	   	  String cut = str.substring(0, str.indexOf('\t'));
	   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
	   	   	//  System.out.println("the id is"+id_lo_str);
	   	   	  while (id_lo_str !=null)
	   	   	  {
	   	   		  int end = id_lo_str.indexOf('\t');
	   	   		  int id_lo = 0;
	   	   		  if(end>=0)
	   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
	   	   		  else 
	   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
	   	   		
	   	   		  if(Float.valueOf(cut)==input)
	   	   		   {
	   	   			   Query_output(data, id_lo);
	   	   			   break;
	   	   		   }
	   	   		  if(id_lo_str.indexOf('\t')<0) break;
	   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
    	   	  }
	   	   	 str = reader.readLine();
   	   	    }     
   	   	    break;
   	   	    
   	    	case 2: // >
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Float.valueOf(cut)>input) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   break;
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;

   	    	case 3: // <
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Float.valueOf(cut)<input) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);   		   	   			   
   		   	   		   }
   		   	   		  
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
   	   	   	    
	   	    case 4: // >=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Float.valueOf(cut)>=input) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
	   	    case 5: // <=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Float.valueOf(cut)<=input) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
	   	    case 6: // !=
   	   	   	    while (str!=null)
   	   	   	    {
   		   	   	  String cut = str.substring(0, str.indexOf('\t'));
   		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
   		   	   	//  System.out.println("the id is"+id_lo_str);
   		   	   	  while (id_lo_str !=null)
   		   	   	  {
   		   	   		  int end = id_lo_str.indexOf('\t');
   		   	   		  int id_lo = 0;
   		   	   		  if(end>=0)
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
   		   	   		  else 
   		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
   		   	   		
   		   	   		  if(Float.valueOf(cut)!=input) 
   		   	   		   {
   		   	   			   Query_output(data, id_lo);
   		   	   			   
   		   	   		   }
   		   	   		  if(id_lo_str.indexOf('\t')<0) break;
   		   	   		  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
   	    	   	  }
   		   	   	 str = reader.readLine();
   	   	   	    }     
   	   	   	    break;
   
   	    }
   	    
	}
	    // if the input is string 
	    static void query(String str_in, int operator, String path) throws IOException {
			
			
			RandomAccessFile data =  new RandomAccessFile("data.db","rw");
			
			// read from id.ndx
			File file = new File(path);
			InputStream is = new FileInputStream(file);
	   	    BufferedReader reader = new BufferedReader(new InputStreamReader(is));
	   	    //read a line
	   	    String str = reader.readLine();
	   	    
	   	    boolean Found = false;
	   	    switch(operator) 
	   	    {
	   	    	case 1: //=
	   	    	
	   	   	    while (str!=null)
	   	   	    {
	   	   	    	//	   	   	    
		   	   	  String cut = str.substring(0, str.indexOf('\t'));
		   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
		   	   	  while(id_lo_str!=null)
		   	   	  {	
		   	   		 
		   	   		  int end = id_lo_str.indexOf('\t');
		   	   		  int id_lo = 0;
		   	   		  if(end>=0)
		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
		   	   		  else 
		   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
		   	   		  
		   		   	  if(cut.indexOf(str_in)>=0) 
		   		   	  {
		   		   	    Query_output(data, id_lo);
		   		   	    break;
		   		   	  }
		   		   	  if(id_lo_str.indexOf('\t')<0) break;
		   		   	  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
		   		   	  
		   	   	  }
		   	   	  str = reader.readLine();
	   	   	    }     
	   	   	    break;
	   	   	    
	   	    	case 2: // >
	   	    		
		   	     while (str!=null)
			   	 {
		   	    	 
		   	    	  String cut = str.substring(0, str.indexOf('\t'));
			   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	

			   	   	  while(id_lo_str!=null)
			   	   	  {	
			   	   		 
			   	   		  int end = id_lo_str.indexOf('\t');
			   	   		  int id_lo = 0;
			   	   		  if(end>=0)
			   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
			   	   		  else 
			   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
			   	   		  if(cut.compareTo(str_in)==1)
			   		   	  {
			   	   			
			   	   			  Query_output(data, id_lo);  		   	    
			   		   	  }
			   		   	  if(id_lo_str.indexOf('\t')<0) break;
			   		   	  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
			   		   	  
			   	   	  }
			   	   	  str = reader.readLine();
		   	   	    }     
		   	   	    break;
		   	    
	   	    	case 3: // <
	   	    		while (str!=null)
				   	 {
			   	    	String cut = str.substring(0, str.indexOf('\t'));
				   	   	  String id_lo_str = str.substring(str.indexOf('\t')+1, str.length());	
				   	   	  while(id_lo_str!=null)
				   	   	  {	
				   	   		 
				   	   		  int end = id_lo_str.indexOf('\t');
				   	   		  int id_lo = 0;
				   	   		  if(end>=0)
				   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, end));
				   	   		  else 
				   	   			  id_lo = Integer.parseInt(id_lo_str.substring(0, id_lo_str.length()));
				   	   		  
				   		   	  
					   		   	if(cut.compareTo(str_in)==-1)
					   		   	{
					   		   		Query_output(data, id_lo);  		   	    
					   		   	}
				   		   	  
				   		   	  if(id_lo_str.indexOf('\t')<0) break;
				   		   	  id_lo_str = id_lo_str.substring(id_lo_str.indexOf('\t')+1, id_lo_str.length());
				   		   	  
				   	   	  }
				   	   	  str = reader.readLine();
			   	   	    }     
			   	   	    break;
	   	    }
		}
	    
	    static void Query_output(RandomAccessFile data, int id_lo) throws IOException
	    {
	    	data.seek(id_lo+4);
  	    	int string_length = data.readByte();
  	    	byte[] result = new byte[string_length+22];
  	    	data.seek(id_lo);
  	    	data.read(result, 0, string_length+22);
  	    		
  	    	/*Id*/
  	    	System.out.print(Util.BytestoInt(result, 0, 4)+" ");
  	    		
  	    	for(int i=5;i<string_length;i++)
  	    	{
  	    		System.out.print((char)result[i]);
  	    	}
  	    	System.out.print(" ");
  	    		
  	    	for(int i=5+string_length;i<11+string_length;i++)
  	    	{
  	    		System.out.print((char)result[i]);
  	    	}
  	    	System.out.print(" ");
  	    		
  	    	System.out.print(Util.BytestoInt(result, 11+string_length, 2)+" ");
  	    		
  	    	System.out.print(Util.BytestoInt(result, 13+string_length, 2)+" ");

  	    	System.out.print(Util.BytestoInt(result, 15+string_length, 2)+" ");
  	    		
  	    	System.out.print(Util.BytestoFloat(result, 17+string_length, 4)+" ");
  	    		
  	    	boolean[] bool = Util.BytestoBoolean(result, 21+string_length);
  	    	for(int i=0;i<4;i++)
  	    		System.out.print(bool[i]+" ");
  	    	System.out.println();
	    }
}
