import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class writeBoo {

	static void WriteBooleanIntoNdx(DataPhar phar_data[], int sorting_type, String NdxPath) throws IOException
	{
		DataPhar.sorting_type = sorting_type;
		Arrays.sort(phar_data, DataPhar.getCompar());
		RandomAccessFile raf =  new RandomAccessFile(new File(NdxPath),"rw");   
		int flag=0;
		String att_current=null;
		for(int i=0;i<999;i++)
		{
			if(phar_data[i].bool[sorting_type-7]==0)
				att_current = "False";
			else
				att_current = "True";
			
			if(i==0)
				raf.writeBytes(att_current+"\t"+phar_data[i].location);
			else
			{
				raf.writeBytes("\t"+phar_data[i].location);
				
				if(phar_data[i].bool[sorting_type-7]==1&&flag==0)
				{
					raf.writeBytes("\n");
					raf.writeBytes(att_current+"\t"+phar_data[i].location);
					flag = 1;
				}
					
					
			}
			
		}
		raf.close();
	}
}
