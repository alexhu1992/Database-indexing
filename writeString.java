import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class writeString {

	static void WriteStringIntoNdx(DataPhar phar_data[], int sorting_type, String NdxPath) throws IOException
	{
		DataPhar.sorting_type = sorting_type;
		Arrays.sort(phar_data, DataPhar.getCompar());
		RandomAccessFile raf =  new RandomAccessFile(new File(NdxPath),"rw");   //creat the data.db file 
		String att_prev = null,att_current=null;
		
		
		for(int i=0;i<1000;i++)
		{
			if(i==0)
			{
				if(sorting_type==1)
					raf.writeBytes(phar_data[0].company+"\t"+phar_data[0].location);
				else
					raf.writeBytes(phar_data[0].drugid+"\t"+phar_data[0].location);
			}
			else
			{
				if(sorting_type==1)
				{
					att_prev = phar_data[i-1].company;
					att_current = phar_data[i].company;
					
				}else if(sorting_type==2)
				{
					att_prev = phar_data[i-1].drugid;
					att_current = phar_data[i].drugid;
				}
				if(att_current.equalsIgnoreCase(att_prev))
					raf.writeBytes("\t"+phar_data[i].location);
				else
					raf.writeBytes("\n"+att_current+"\t"+phar_data[i].location);
				
			}
			
		}
		raf.close();
	}
}
