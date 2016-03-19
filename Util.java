import java.nio.ByteBuffer;
import java.nio.ByteOrder;


public class Util {

	
	// convert float format data to binary
	
		public static byte[] float2bytes(float f) {  
	        
	        int fbit = Float.floatToIntBits(f);  
	        return int2bytes(fbit,4);
	    } 
	    
		//convert int format data to binary
	    static byte[] int2bytes(int num, int size)
	    {
	    	byte[] result = new byte[size];
	    	for(int i=0;i<size;i++)
	    	{
	    		result[i] = (byte)((num>> 8*(size - i - 1))& 0xFF);
	    	}
	    	return result;
	    }        
		    
		static  int BytestoInt(byte[] bRefArr, int start, int length) {
		    int iOutcome = 0;
		    byte bLoop;
		    //System.out.println("start "+start+" "+length);
		    for (int i = start; i < start+ length; i++) {
		    	//System.out.println("caonima "+(bRefArr[i]&0xFF)+" ");
		    	bLoop = (byte) (bRefArr[i] & 0xFF);
		    	
		    	byte high4 = (byte) ((bLoop & 0xF0) >> 4);
		    	byte low4 = (byte) (bLoop & 0x0F);
		    	//System.out.println("high="+high4+", low4="+low4);
		        iOutcome += high4 * Math.pow(16, length*2-(i-start)*2-1)  +low4 * Math.pow(16, length*2-(i-start)*2-2);
		    }
		   // System.out.println();
		    return iOutcome;
		}
	
		static  float BytestoFloat(byte[] bRefArr, int start, int length) {
			byte[] bytes = new byte[length];
			for(int i=start;i<start+length;i++)
				bytes[i-start] = bRefArr[i];
			float f = ByteBuffer.wrap(bytes).order(ByteOrder.BIG_ENDIAN).getFloat();
		    return f;
		}
		
		static boolean[] BytestoBoolean(byte[] bRefArr, int start)
		{
			boolean[] result = new boolean[4];
			//System.out.println("caonima "+bRefArr[start]);
			result[0] = ((bRefArr[start] & 0x8) >> 3)==1?true:false;
			result[1] = ((bRefArr[start] & 0x4) >> 2)==1?true:false;
			result[2] = ((bRefArr[start] & 0x2) >> 1)==1?true:false;
			result[3] = ((bRefArr[start] & 0x1))==1?true:false;
			return result;
		}
	
}
