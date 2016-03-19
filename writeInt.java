import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class writeInt {

	static void WriteIntIntoNdx(DataPhar phar_data[], int sorting_type, String NdxPath) throws IOException
	{
		DataPhar.sorting_type = sorting_type;
		Arrays.sort(phar_data, DataPhar.getCompar());
		RandomAccessFile raf =  new RandomAccessFile(new File(NdxPath),"rw");   //creat the data.db file 
		int att_current=0,att_prev=0;
		for(int i=0;i<1000;i++)
		{
			
			if(i==0)
			{
				if(sorting_type==3)
					raf.writeBytes(phar_data[0].trials+"\t"+phar_data[0].location);
				else if(sorting_type==4)
					raf.writeBytes(phar_data[0].patients+"\t"+phar_data[0].location);
				else
					raf.writeBytes(phar_data[0].dosage_mg+"\t"+phar_data[0].location);
			}
			else
			{
				switch (sorting_type)
				{
				
				case 3:
					att_prev = phar_data[i-1].trials;
					att_current = phar_data[i].trials;
					break;
				case 4:
					att_prev = phar_data[i-1].patients;
					att_current = phar_data[i].patients;
					break;
				case 5:
					att_prev = phar_data[i-1].dosage_mg;
					att_current = phar_data[i].dosage_mg;
					break;
				}
				
				if(att_current==att_prev)
					raf.writeBytes("\t"+phar_data[i].location);
				else
					raf.writeBytes("\n"+att_current+"\t"+phar_data[i].location);
				
			
				
			}
			
		}
	
		raf.close();
	}
}
