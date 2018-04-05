package xn.test.Range;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class RangeDemo {
	public static void main(String[] args) throws Exception {
		
		URL url = new URL("http://localhost:8080/day04/a.txt");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		conn.setRequestProperty("Range", "bytes=5-");
		
		InputStream in = conn.getInputStream();
		int len = 0;
		byte buffer[] = new byte[1024];
		FileOutputStream out = new FileOutputStream("c:\\a.txt", true);
		
		while((len=in.read(buffer))>0){
			out.write(buffer, 0, len);
		}
		
		in.close();
		out.close();
	}

}
