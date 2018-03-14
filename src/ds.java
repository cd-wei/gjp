import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ds {
	private static String httpRequest(String requestUrl){
		StringBuffer buffer = null;
		BufferedReader bufferedReader = null;
		InputStreamReader inputStreamReader = null;
		InputStream inputStream = null;
		HttpURLConnection httpUrlConn = null;
		
		try{
			URL url = new URL(requestUrl);
			httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");
			
			inputStream = httpUrlConn.getInputStream();  
			inputStreamReader = new InputStreamReader(inputStream, "utf-8");  
			bufferedReader = new BufferedReader(inputStreamReader);  
			
			buffer = new StringBuffer();
			String str = null;
			while((str = bufferedReader.readLine())!=null){
				buffer.append(str);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			if(bufferedReader!=null){
				try{
					bufferedReader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			if(inputStreamReader != null){
				try{
					inputStreamReader.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
			if(httpUrlConn != null){
				httpUrlConn.disconnect();
			}
		}
		return buffer.toString();
	}
	private static String htmlFiter(String html){
		StringBuffer buffer = new StringBuffer();
		String str1 = "";
		String str2 = "";
		buffer.append("今天:");
		
		Pattern p = Pattern.compile("(.*)(<li class=\'dn on\' data-dn=\'7d1\'>)(.*?)(</li>)(.*)"); 
		Matcher m = p.matcher(html);
		if(m.matches()){
			str1 = m.group(3);
			p = Pattern.compile("(.*)(<h2>)(.*?)(</h2>)(.*)");
			m = p.matcher(str1);
			if(m.matches()){
				str2 = m.group(3);
				buffer.append(str2);
				buffer.append("\n天气:");
			}
			p = Pattern.compile("(.*)(<p class=\"wea\" title=)(.*?)(>)(.*?)(</p>)(.*)");
			m = p.matcher(str1);
			if(m.matches()){
				str2 = m.group(5);
				buffer.append(str2);
				buffer.append("\n温度:");
			}
			
			p = Pattern.compile("(.*)(<p class=\"tem tem2\"> <span>)(.*?)(</span><i>)(.*)");
			m = p.matcher(str1);
			if(m.matches()){
				str2 = m.group(3);
				buffer.append(str2);
				buffer.append(".~");
			}
			p = Pattern.compile("(.*)(<p class=\"tem tem1\"> <span>)(.*?)(</span><i>)(.*)");
			
			m = p.matcher(str1);
			if(m.matches()){
				str2 = m.group(3);
				buffer.append(str2);
				buffer.append("\n风力：");
			}
			p = Pattern.compile("(.*)(<i>)(.*?)(</i>)(.*)");
			m = p.matcher(str1);
			if(m.matches()){
				str2 = m.group(3);
				buffer.append(str2);
			}
		}
		return buffer.toString();
	}
	public static String getTodayTemperatureInfo(){
		String html = httpRequest("http://www.weather.com.cn/html/weather/101280101.shtml");
		String result = htmlFiter(html);
		return result;
	}
	public static void main(String[] args) {
		String info = getTodayTemperatureInfo();
		System.out.println(info);
	}
}
