import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;


public class writeNdx {

	// method for writing all Index file 
		static void WriteFile(DataPhar phar_data[]) throws IOException
		{
			// write id.ndx
			DataPhar.sorting_type = 0;
			Arrays.sort(phar_data, DataPhar.getCompar());
			RandomAccessFile raf =  new RandomAccessFile(new File("id.ndx"),"rw"); 
			for(int i=0;i<1000;i++)
				raf.writeBytes(phar_data[i].id+"\t"+phar_data[i].location+"\n");
			
			writeString.WriteStringIntoNdx(phar_data, 1, "company.ndx");
			
			writeString.WriteStringIntoNdx(phar_data, 2, "drug_id.ndx");
			
			writeInt.WriteIntIntoNdx(phar_data, 3, "trials.ndx");
			
			writeInt.WriteIntIntoNdx(phar_data, 4, "patients.ndx");
			
			writeInt.WriteIntIntoNdx(phar_data, 5, "dosage_mg.ndx");
			
			writeFloat.WriteFloatIntoNdx(phar_data, 6, "reading.ndx");
			
			writeBoo.WriteBooleanIntoNdx(phar_data, 7, "double_blind.ndx");
			
			writeBoo.WriteBooleanIntoNdx(phar_data, 8, "controlled_study.ndx");
			
			writeBoo.WriteBooleanIntoNdx(phar_data, 9, "govt_funded.ndx");
			
			writeBoo.WriteBooleanIntoNdx(phar_data, 10, "fda_approved.ndx");
			
			raf.close();
		}
}
