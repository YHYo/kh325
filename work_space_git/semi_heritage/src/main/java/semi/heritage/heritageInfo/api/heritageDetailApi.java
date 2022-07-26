package semi.heritage.heritageInfo.api;

import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import semi.heritage.heritageInfo.dao.heritageDao;
import semi.heritage.heritageInfo.vo.heritageDetail;
import semi.heritage.heritageInfo.vo.heritageVO_hy;

public class heritageDetailApi {

	// 목록 : http://www.cha.go.kr/cha/SearchKindOpenapiList.do
	// 상세 : http://www.cha.go.kr/cha/SearchKindOpenapiDt.do

	public static String CURRENT_HERITAGE_INFO_LIST_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do";
	public static String CURRENT_HERITAGE_INFO_DETAIL_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do";

	public static void main(String[] args) {
		heritageDetailApi.callCurrentHeritageDetailByXML();
	}

	public static List<heritageVO_hy> callCurrentHeritageDetailByXML() {

		List<heritageVO_hy> list = new ArrayList<>();

		Connection conn2 = getConnection();
		heritageDao dao = new heritageDao();

		for (int j = 0; j < dao.selectCode(conn2).size(); j++) {

			String ccnbactcd2 = (dao.selectCode(conn2)).get(j).getCcbaCtcd();
			String ccbaCtcd2 = (dao.selectCode(conn2)).get(j).getCcbaCtcd();
			String ccbaAsno2 = (dao.selectCode(conn2)).get(j).getCcbaAsno();

			try {
				StringBuffer urlBuffer = new StringBuffer();
				urlBuffer.append(CURRENT_HERITAGE_INFO_DETAIL_URL);
				urlBuffer.append("?" + "ccbaKdcd=" + ccnbactcd2);
				urlBuffer.append("&" + "ccbaAsno=" + ccbaAsno2);
				urlBuffer.append("&" + "ccbaCtcd=" + ccbaCtcd2);
				urlBuffer.append("&" + "pageUnit=" + 1);

//				System.out.println(urlBuffer);

				URL url = new URL(urlBuffer.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/xml");
				int code = conn.getResponseCode(); // 실제 호출하는 부

//				System.out.println("ResponseCode : " + code);
				if (code < 200 || code > 300) {
					System.out.println("페이지가 잘못되었습니다.");
					return null;
				}

				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder db = dbf.newDocumentBuilder();
				Document doc = db.parse(conn.getInputStream()); //
				doc.normalizeDocument();

				NodeList nList = doc.getElementsByTagName("item");
				for (int i = 0; i < nList.getLength(); i++) {
					Node node = nList.item(i);
					if (node.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) node;
						
//						int no = Integer.parseInt(eElement.getElementsByTagName("sn").item(0).getTextContent());
//						String ccmaName 	= eElement.getElementsByTagName("ccmaName").item(0).getTextContent();
//						int    crltsnoNm	= Integer.parseInt(eElement.getElementsByTagName("crltsnoNm").item(0).getTextContent());
//						String ccbaMnm1	   	= eElement.getElementsByTagName("ccbaMnm1").item(0).getTextContent();
//						String ccbaMnm2	   	= eElement.getElementsByTagName("ccbaMnm2").item(0).getTextContent();
//						String ccbaCtcdNm	= eElement.getElementsByTagName("ccbaCtcdNm").item(0).getTextContent();
//						String ccsiName	  	= eElement.getElementsByTagName("ccsiName").item(0).getTextContent();
//						String ccbaAdmin	= eElement.getElementsByTagName("ccbaAdmin").item(0).getTextContent();
//						String ccbaKdcd	  	= eElement.getElementsByTagName("ccbaKdcd").item(0).getTextContent();
//						String ccbaCtcd	  	= eElement.getElementsByTagName("ccbaCtcd").item(0).getTextContent();
//						String ccbaAsno	  	= eElement.getElementsByTagName("ccbaAsno").item(0).getTextContent();
//						String ccbaCncl	  	= eElement.getElementsByTagName("ccbaCncl").item(0).getTextContent();
//						String ccbaCpno	  	= eElement.getElementsByTagName("ccbaCpno").item(0).getTextContent();
//						String longitude	= eElement.getElementsByTagName("longitude").item(0).getTextContent();
//						String latitude	  	= eElement.getElementsByTagName("latitude").item(0).getTextContent();
//						
//						urlBuffer.delete(0, urlBuffer.length());
//						urlBuffer.append(CURRENT_HERITAGE_INFO_DETAIL_URL);
//						urlBuffer.append("?" + "ccbaKdcd=" + ccnbactcd2);
//						urlBuffer.append("&" + "ccbaAsno=" + ccbaCtcd2);
//						urlBuffer.append("&" + "ccbaCtcd=" + ccbaAsno2);
//						urlBuffer.append("&" + "pageUnit=" + 1);
//						
//						url = new URL(urlBuffer.toString());
//						conn = (HttpURLConnection) url.openConnection();
//						conn.setRequestMethod("GET");
//						conn.setRequestProperty("Accept", "application/xml");
//						code = conn.getResponseCode(); // 실제 호출하는 부
						
						String gcodeName 	= eElement.getElementsByTagName("gcodeName").item(0).getTextContent();
						String bcodeName 	= eElement.getElementsByTagName("bcodeName").item(0).getTextContent();
						String mcodeName 	= eElement.getElementsByTagName("mcodeName").item(0).getTextContent();
						String scodeName	= eElement.getElementsByTagName("scodeName").item(0).getTextContent();
						String ccbaQuan		= eElement.getElementsByTagName("ccbaQuan").item(0).getTextContent();
						String ccbaAsdt 	= eElement.getElementsByTagName("ccbaAsdt").item(0).getTextContent();
						String ccbaLcad		= eElement.getElementsByTagName("ccbaLcad").item(0).getTextContent();
						String ccceName		= eElement.getElementsByTagName("ccceName").item(0).getTextContent();
						String ccbaPoss		= eElement.getElementsByTagName("ccbaPoss").item(0).getTextContent();
						String imageUrl		= eElement.getElementsByTagName("imageUrl").item(0).getTextContent();
						String content		= eElement.getElementsByTagName("content").item(0).getTextContent();

						heritageVO_hy heritage = new heritageVO_hy(
//								no, ccmaName, crltsnoNm, ccbaMnm1, ccbaMnm2, ccbaCtcdNm, ccsiName, ccbaAdmin, ccbaKdcd, ccbaCtcd, ccbaAsno, ccbaCncl, ccbaCpno, longitude, latitude
//								, 
								gcodeName, bcodeName, mcodeName, scodeName, ccbaQuan, ccbaAsdt, ccbaLcad.trim(), ccceName, ccbaPoss.trim(), imageUrl, content
								);
						list.add(heritage);

						System.out.println(heritage.toString());
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
}
