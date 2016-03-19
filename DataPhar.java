import java.util.Comparator;


public class DataPhar{

	int id = 0;
	String company;
	String drugid;
	int trials;
	int patients;
	int dosage_mg;
	float reading;
	int booleanresult;
	
	int location;
	
	int bool[];
	
	static int sorting_type = 0;
	
	static class compar implements Comparator<DataPhar>
	{
		//using comparator to sort all fields within one file 
		
		@Override
		public int compare(DataPhar o1, DataPhar o2) {
			switch(sorting_type)
			{
				case 0: // sorted by ID
					return o1.id - o2.id;
				case 1:// sorted by Company
					return o1.company.compareToIgnoreCase(o2.company);
				case 2: //sorted by drug id
					return o1.drugid.compareToIgnoreCase(o2.drugid);
				case 3://sorted by trials
					return o1.trials - o2.trials;
				case 4: //sorted by patients
					return o1.patients - o2.patients;
				case 5: // sorted by dosage_mg
					return o1.dosage_mg - o2.dosage_mg;
				case 6: // sorted by reading  
					return Float.floatToIntBits(o1.reading) - Float.floatToIntBits(o2.reading);
				case 7: 
					return o1.bool[0] - o2.bool[0];
				case 8:
					return o1.bool[1] - o2.bool[1];
				case 9:
					return o1.bool[2] - o2.bool[2];
				case 10:
					return o1.bool[3] - o2.bool[3];
			}
			return 0;
		}
		
	}
	static public Comparator<DataPhar> getCompar()
	{
		return new compar();
	}
	
	DataPhar(int id, String company, String drugid, int trials, int patients, int dosage_mg, float reading, int booleanresult)
	{
		this.id = id;
		this.company = company;
		this.drugid = drugid;
		this.trials = trials;
		this.patients = patients;
		this.dosage_mg = dosage_mg;
		this.reading = reading;
		this.booleanresult = booleanresult;
		SeparateBoolean();
	}
	
	void SeparateBoolean()
	{
		bool = new int[4];
		int i=3;
		int boolt = booleanresult;
		while(i>=0)
		{
			bool[i] = boolt % 2;
			boolt /= 2;
			i--;
			
		}
	}
	
	void setLocation(int location)
	{
		this.location = location;
	}

	
}
