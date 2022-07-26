
package semi.heritage.heritageInfo.api;

import static semi.heritage.common.jdbc.JDBCTemplate.*;

import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.Connection;
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

import semi.heritage.heritageInfo.dao.heritageDao;
import semi.heritage.heritageInfo.vo.heritageDetail;
import semi.heritage.heritageInfo.vo.heritageList;
import semi.heritage.heritageInfo.vo.heritageVO;

public class practice2 {

	public static String CURRENT_HERITAGE_INFO_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiList.do";
	public static String CURRENT_HERITAGE_INFO_DETAIL_URL = "http://www.cha.go.kr/cha/SearchKindOpenapiDt.do";
	public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

	public static void main(String[] args) {
		practice2.callCurrentHeritageListByXML();
	}

	public static List<heritageVO> callCurrentHeritageListByXML() {

		List<heritageVO> list = new ArrayList<>();
		List<heritageList> list2 = new ArrayList<>();
		List<heritageDetail> list3 = new ArrayList<>();
		for (int j = 1; j < 167; j++) {

			try {
				StringBuilder urlBuilder = new StringBuilder();
				urlBuilder.append(CURRENT_HERITAGE_INFO_URL);
				urlBuilder.append("?" + "pageUnit=" + 100); // 첫 번째만 물음표로 설정
				urlBuilder.append("&" + "pageIndex=" + j);
				System.out.println(urlBuilder);

				URL url = new URL(urlBuilder.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestProperty("Content-type", "application/json");
				conn.setRequestProperty("Accept", "application/xml");

				int code = conn.getResponseCode(); // 실제 호출하는 부
				System.out.println("ResponseCode : " + code);
				if (code < 200 || code >= 300) {
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

					System.out.println("\nCurrent Element : " + node.getNodeName());
					if (node.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) node;

						int sn = getIntData(eElement, "sn");
						int no = getIntData(eElement, "no");
						String ccmaName = getStrData(eElement, "ccmaName");
						int crltsnoNm = getIntData(eElement, "crltsnoNm");
						String ccbaMnm1 = getStrData(eElement, "ccbaMnm1");
						String ccbaMnm2 = getStrData(eElement, "ccbaMnm2");
						String ccbaCtcdNm = getStrData(eElement, "ccbaCtcdNm");
						String ccsiName = getStrData(eElement, "ccsiName");
						String ccbaAdmin = getStrData(eElement, "ccbaAdmin");
						String ccbaKdcd = getStrData(eElement, "ccbaKdcd");
						String ccbaCtcd = getStrData(eElement, "ccbaCtcd");
						String ccbaAsno = getStrData(eElement, "ccbaAsno");
						String ccbaCncl = getStrData(eElement, "ccbaCncl");
						String ccbaCpno = getStrData(eElement, "ccbaCpno");
						String longitude = getStrData(eElement, "longitude");
						String latitude = getStrData(eElement, "latitude");

						heritageList heritage2 = new heritageList(sn, no, ccmaName, crltsnoNm, ccbaMnm1, ccbaMnm2,
								ccbaCtcdNm, ccsiName, ccbaAdmin, ccbaKdcd, ccbaCtcd, ccbaAsno, ccbaCncl, ccbaCpno,
								longitude, latitude);
						list2.add(heritage2);
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		Connection conn2 = getConnection();
		heritageDao dao = new heritageDao();

		for (int j = 0; j < dao.selectCode(conn2).size(); j++) {
			String ccnbactcd2 = (dao.selectCode(conn2)).get(j).getCcbaCtcd();
			String ccbaCtcd2 = (dao.selectCode(conn2)).get(j).getCcbaCtcd();
			String ccbaAsno2 = (dao.selectCode(conn2)).get(j).getCcbaAsno();

			try {
				StringBuffer urlBuffer = new StringBuffer();
				urlBuffer.append(CURRENT_HERITAGE_INFO_DETAIL_URL);
				urlBuffer.append("?" + "ccbaKdcd=" + ccnbactcd2); // 첫 번째만 물음표로 설정
				urlBuffer.append("&" + "ccbaAsno=" + ccbaCtcd2);
				urlBuffer.append("&" + "ccbaCtcd=" + ccbaAsno2);

				System.out.println(urlBuffer);

				URL url = new URL(urlBuffer.toString());
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				conn.setRequestProperty("Accept", "application/xml");
				int code = conn.getResponseCode(); // 실제 호출하는 부
				System.out.println("ResponseCode : " + code);

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
					System.out.println("\nCurrent Element : " + node.getNodeName());
					if (node.getNodeType() == Node.ELEMENT_NODE) {

						Element eElement = (Element) node;

						String gcodeName = getStrData(eElement, "gcodeName");
						String bcodeName = getStrData(eElement, "bcodeName");
						String mcodeName = getStrData(eElement, "mcodeName");
						String scodeName = getStrData(eElement, "scodeName");
						String ccbaQuan = getStrData(eElement, "ccbaQuan");
						String ccbaAsdt = getStrData(eElement, "ccbaAsdt");
						String ccbaLcad = getStrData(eElement, "ccbaLcad");
						String ccceName = getStrData(eElement, "ccceName");
						String ccbaPoss = getStrData(eElement, "ccbaPoss");
						String imageUrl = getStrData(eElement, "imageUrl");
						String content = getStrData(eElement, "content");

						heritageDetail heritage3 = new heritageDetail(gcodeName, bcodeName, mcodeName, scodeName,
								ccbaQuan, ccbaAsdt, ccbaLcad, ccceName, ccbaPoss, imageUrl, content);
						list3.add(heritage3);
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
//			