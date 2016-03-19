import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class writeFloat {

	
	static void WriteFloatIntoNdx(DataPhar phar_data[], int sorting_type, String NdxPath) throws IOException
	{
		DataPhar.sorting_type = sorting_type;
		Arrays.sort(phar_data, DataPhar.getCompar());
		RandomAccessFile raf =  new RandomAccessFile(new File(NdxPath),"rw");   //creat the data.db file 
		float att_prev = 0,att_current=0;
		for(int i=0;i<1000;i++)
		{
			
			
			
			if(i==0)
				
				raf.writeBytes(phar_data[0].reading+"\t"+phar_data[0].location);
			else
			{
				att_prev = phar_data[i-1].reading;
				att_current = phar_data[i].reading;
				if(att_current==att_prev)
					raf.writeBytes("\t"+phar_data[i].location);
				else
					raf.writeBytes("\n"+att_current+"\t"+phar_data[i].location);
			}
			
		}
		raf.close();
	}
}
