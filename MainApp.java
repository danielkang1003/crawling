package jobkorea;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class MainApp {
	private static String URL = "http://www.jobkorea.co.kr/Search/?";
	
	public static void main(String[] args) throws IOException {
		String KEY_WORD = "IT";
		System.out.println("URL: " +URL + getParameter(KEY_WORD, 2));
		//1. Document를 가져온다
		Document doc = Jsoup.connect(URL + getParameter(KEY_WORD, 2)).get();
		
		//2. 목록을 가져온다
		//System.out.println("" + doc.toString());
		Elements elements = doc.select("#smGiList .list .detailList li");
		
		//3. 목록(배열)에서 정보를 가져온다
		int idx = 0;
		for(Element element: elements) {
			System.out.println(++idx + " : " + element.text());	//toString은 모든 tag도 포함해 보여준다
			System.out.println("========================================\n\n");
		}
	}
	
	/**
	 * URL 완성
	 * Alt + Shift + j
	 * @param KEY_WORD
	 * @param PAGE
	 * @return
	 */
	public static String getParameter(String KEY_WORD, int PAGE) {
		String params = "stext=" + KEY_WORD +"&IsCoInfoSC=false&IsRecruit=false&ord=1&Order=1&page=" +PAGE+"&pageSize=10&pageType=HRP";
		return params;
	}
}
