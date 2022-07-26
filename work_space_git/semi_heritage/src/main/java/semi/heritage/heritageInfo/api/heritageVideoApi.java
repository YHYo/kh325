//package semi.heritage.heritageInfo.api;
//
//import static semi.heritage.common.jdbc.JDBCTemplate.*;
//
//import java.net.HttpURLConnection;
//import java.net.URL;
//import java.sql.Connection;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.List;
//
//import javax.xml.parsers.DocumentBuilder;
//import javax.xml.parsers.DocumentBuilderFactory;
//
//import org.w3c.dom.Document;
//import org.w3c.dom.Element;
//import org.w3c.dom.Node;
//import org.w3c.dom.NodeList;
//
//import semi.heritage.heritageInfo.dao.heritageDao;
//import semi.heritage.heritageInfo.vo.heritageVideo;
//
//public class heritageVideoApi {
//
//		public static String CURRENT_HERITAGE_VIDEO = "http://www.cha.go.kr/cha/SearchVideoOpenapi.do";
//		public static final SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
//
//		public static void main(String[] args) {
//			heritageVideoApi.callCurrentHeritageVideoByXML();
//		}
//		
//		public static List<heritageVideo> callCurrentHeritageVideoByXML() {
//
//			List<heritageVideo> list = new ArrayList<>();
//
//			Connection conn2 = getConnection();
//			heritageDao dao = new heritageDao();
//
//			for (int j = 0; j < dao.selectCode(conn2).size(); j++) {
//				String ccnbactcd2 = (dao.selectCode(conn2)).get(j).getCcbaCtcd();
//				String ccbaCtcd2 = (dao.selectCode(conn2)).get(j).getCcbaCtcd();
//				String ccbaAsno2 = (dao.selectCode(conn2)).get(j).getCcbaAsno();
//
//				try {
//					StringBuffer urlBuffer = new StringBuffer();
//					urlBuffer.append(CURRENT_HERITAGE_VIDEO);
//					urlBuffer.append("?" + "ccbaKdcd=" + ccnbactcd2); // 첫 번째만 물음표로 설정
//					urlBuffer.append("&" + "ccbaAsno=" + ccbaCtcd2);
//					urlBuffer.append("&" + "ccbaCtcd=" + ccbaAsno2);
//
//					System.out.println(urlBuffer);
//
//					URL url = new URL(urlBuffer.toString());
//					HttpURLConnection conn = (HttpURLConnection) url.openConnection();
//					conn.setRequestMethod("GET");
//					conn.setRequestProperty("Accept", "application/xml");
//					int code = conn.getResponseCode(); // 실제 호출하는 부
//					System.out.println("ResponseCode : " + code);
//
//					if (code < 200 || code > 300) {
//						System.out.println("페이지가 잘못되었습니다.");
//						return null;
//					}
//
//					DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
//					DocumentBuilder db = dbf.newDocumentBuilder();
//					Document doc = db.parse(conn.getInputStream()); //
//					doc.normalizeDocument();
//
//					NodeList nList = doc.getElementsByTagName("item");
//					for (int i = 0; i < nList.getLength(); i++) {
//						Node node = nList.item(i);
//						System.out.println("\nCurrent Element : " + node.getNodeName());
//						if (node.getNodeType() == Node.ELEMENT_NODE) {
//
//							Element eElement = (Element) node;
//							
//							int videoNo = getIntData(eElement, "videoNo");
//							String videoUrl = getStrData(eElement, "videoUrl");
//							int sn = getIntData(eElement, "sn");
//				
//							heritageVideo heritagevideo= new heritageVideo(videoNo, videoUrl, sn);
//							list.add(heritagevideo);
//						}
//					}
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//			return list;
//
//		}
//
//		private static String getStrData(Element eElement, String tagName) {
//			try {
//				return eElement.getElementsByTagName(tagName).item(0).getTextContent();
//			} catch (Exception e) {
//				return "-";
//			}
//		}
//
//		private static int getIntData(Element eElement, String tagName) {
//			try {
//				return Integer.parseInt(eElement.getElementsByTagName(tagName).item(0).getTextContent());
//			} catch (Exception e) {
//				return 0;
//			}
//		}
//	}
//
//
