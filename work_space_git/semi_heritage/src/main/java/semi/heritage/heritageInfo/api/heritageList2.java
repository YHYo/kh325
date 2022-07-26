package semi.heritage.heritageInfo.api;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import semi.heritage.heritageInfo.vo.heritageCode;

public class heritageList2 {

	public static String CURRENT_HERITAGE_INFO_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) {
		heritageList2.callCurrentHeritageListByXML();
	}

	public static List<heritageCode> callCurrentHeritageListByXML() {

		List<heritageCode> list = new ArrayList<>();

		for (int j = 1; j < 167; j++) {

			try {
				StringBuilder urlBuilder = new StringBuilder();
				urlBuilder.append(CURRENT_HERITAGE_INFO_URL);
				urlBuilder.append("?" + "pageUnit=" + 100); // 첫 번째만 물음표로 설정
				urlBuilder.append("&" + "pageIndex=" + j);
//				System.out.println(urlBuilder);

				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Content-type", "application/json");
				conn.setRequestProperty("Accept", "application/xml");

				int code = conn.getResponseCode(); // 실제 호출하는 부
//				System.out.println("ResponseCode : " + code);
				if (code < 200 || code >= 300) {
//					System.out.println("페이지가 잘못되었습니다.");
					return null;
				}

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(conn.getInputStream()); //
				doc.normalizeDocument();

				NodeList nList = doc.getElementsByTagName("item");
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);

//					System.out.println("\nCurrent Element : " + node.getNodeName());
					if (node.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) node;
						
						int no = getIntData(eElement, "sn");
						String ccbaKdcd = getStrData(eElement, "ccbaKdcd");
						String ccbaCtcd = getStrData(eElement, "ccbaCtcd");
						String ccbaAsno = getStrData(eElement, "ccbaAsno");

						heritageCode heritage = new heritageCode(no, ccbaKdcd, ccbaCtcd, ccbaAsno);
						list.add(heritage);
						
//						System.out.println(heritage.toString());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	private static String getStrData(Element eElement, String tagName) {
		try {
			return eElement.getElementsByTagName(tagName).item(0).getTextContent();
		} catch (Exception e) {
			return "-";
		}
	}

	private static int getIntData(Element eElement, String tagName) {
		try {
			return Integer.parseInt(eElement.getElementsByTagName(tagName).item(0).getTextContent());
		} catch (Exception e) {
			return 0;
		}
	}
}
