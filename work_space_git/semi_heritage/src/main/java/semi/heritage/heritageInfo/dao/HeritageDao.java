package semi.heritage.heritageInfo.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;
import static semi.heritage.common.jdbc.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import semi.heritage.common.util.PageInfo;
import semi.heritage.heritageInfo.vo.HeritageImage;
import semi.heritage.heritageInfo.vo.HeritageMainVO;
import semi.heritage.heritageInfo.vo.HeritageVO;
import semi.heritage.heritageInfo.vo.HeritageVideo;





public class HeritageDao {

	public int insert(Connection conn, HeritageVO heritagevo) {
		try {
			String sql = "INSERT INTO HERITAGE(sn, no, ccmaName, crltsnoNm, ccbaMnm1, ccbaMnm2, ccbaCtcdNm, ccsiName, ccbaAdmin, ccbaKdcd, ccbaCtcd, ccbaAsno, ccbaCncl, ccbaCpno, longitude, latitude, gcodeName, bcodeName, mcodeName, scodeName, ccbaQuan, ccbaAsdt, ccbaLcad, ccceName, ccbaPoss, imageUrl, content) VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ? ,?, ?, ? ,?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			pstmt.setInt(cnt++, heritagevo.getSn());
			pstmt.setInt(cnt++, heritagevo.getNo());
			pstmt.setString(cnt++, heritagevo.getCcmaName());
			pstmt.setInt(cnt++, heritagevo.getCrltsnoNm());
			pstmt.setString(cnt++, heritagevo.getCcbaMnm1());
			pstmt.setString(cnt++, heritagevo.getCcbaMnm2());
			pstmt.setString(cnt++, heritagevo.getCcbaCtcdNm());
			pstmt.setString(cnt++, heritagevo.getCcsiName());
			pstmt.setString(cnt++, heritagevo.getCcbaAdmin());
			pstmt.setString(cnt++, heritagevo.getCcbaKdcd());
			pstmt.setString(cnt++, heritagevo.getCcbaCtcd());
			pstmt.setString(cnt++, heritagevo.getCcbaAsno());
			pstmt.setString(cnt++, heritagevo.getCcbaCncl());
			pstmt.setString(cnt++, heritagevo.getCcbaCpno());
			pstmt.setString(cnt++, heritagevo.getLongitude());
			pstmt.setString(cnt++, heritagevo.getLatitude());
			pstmt.setString(cnt++, heritagevo.getGcodeName());
			pstmt.setString(cnt++, heritagevo.getBcodeName());
			pstmt.setString(cnt++, heritagevo.getMcodeName());
			pstmt.setString(cnt++, heritagevo.getScodeName());
			pstmt.setString(cnt++, heritagevo.getCcbaQuan());
			pstmt.setString(cnt++, heritagevo.getCcbaAsdt());
			pstmt.setString(cnt++, heritagevo.getCcbaLcad());
			pstmt.setString(cnt++, heritagevo.getCcceName());
			pstmt.setString(cnt++, heritagevo.getCcbaPoss());
			pstmt.setString(cnt++, heritagevo.getImageUrl());
			pstmt.setString(cnt++, heritagevo.getContent());
		
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	
	public int insertImage(Connection conn, HeritageImage heritageimage) {
		try {
			String sql = "INSERT INTO heritageImage(imageNo, imageUrl, ccimDesc, sn, ccbaKdcd, ccbaCtcd, ccbaAsno) VALUES(SEQ_HERITAGE_Image.NEXTVAL, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			
			pstmt.setString(cnt++, heritageimage.getImageUrl());
			pstmt.setString(cnt++, heritageimage.getCcimDesc());
			pstmt.setInt(cnt++, heritageimage.getSn());
			pstmt.setString(cnt++, heritageimage.getCcbaKdcd());
			pstmt.setString(cnt++, heritageimage.getCcbaCtcd());
			pstmt.setString(cnt++, heritageimage.getCcbaAsno());
		
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	public int insertVideo(Connection conn, HeritageVideo heritagevideo) {
		try {
			String sql = "INSERT INTO heritageVideo(videoNo, videoUrl, sn, ccbaKdcd, ccbaCtcd, ccbaAsno) VALUES(SEQ_HERITAGE_Image.NEXTVAL, ?, ?, ?, ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);

			int cnt = 1;
			
			pstmt.setString(cnt++, heritagevideo.getVideoUrl());
			pstmt.setInt(cnt++, heritagevideo.getSn());
			pstmt.setString(cnt++, heritagevideo.getCcbaKdcd());
			pstmt.setString(cnt++, heritagevideo.getCcbaCtcd());
			pstmt.setString(cnt++, heritagevideo.getCcbaAsno());
		
			int result = pstmt.executeUpdate();
			pstmt.close();
			return result;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	// 메인 페이지 인기 문화재 명소 출력용 (이미지, 이름, 주소, 찜 개수, 리뷰 개수를 찜 개수가 많은 열개를 순서대로 정렬)
	public List<HeritageMainVO> mainByFavorite(Connection conn) {
		List<HeritageMainVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT "
					+ "ROWNUM, HFV.*, H.ccbaMnm1, H.ccbaCtcdNm, H.ccsiName, H.content, H.IMAGEURL, HR.* "
					+ "FROM"
					+ "(SELECT no, COUNT(uno) from hFavorite group by no order by COUNT(uno) desc) HFV, "
					+ "HERITAGE H, "
					+ "(SELECT NO, COUNT(revNo) FROM HertiageReview group by no order by COUNT(revNo) desc) HR "
					+ "WHERE "
					+ "H.no = HFV.no AND "
					+ "H.no = HR.no AND "
					+ "ROWNUM BETWEEN 1 AND 10";

			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				int no = rs.getInt(count++);
				int countHfavorite = rs.getInt(count++);
				String ccbaMnm1 = rs.getString(count++);
				String ccbaCtcdNm = rs.getString(count++);
				String ccsiName = rs.getString(count++);
				String content = rs.getString(count++);
				String imageUrl = rs.getString(count++);
				int rNo = rs.getInt(count++);
				int countHreview = rs.getInt(count++);

				HeritageMainVO mainByFv = new HeritageMainVO(rowNum, no, countHfavorite, ccbaMnm1, ccbaCtcdNm, ccsiName, content, imageUrl, rNo, countHreview);
				list.add(mainByFv);
			}
			System.out.println(list.toString());
			return list;
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		return null;
	}
		

		// 이름으로 검색한 문화재 전체 갯수를 가져오는 쿼리문
		public int getHeritageMainVOCount(Connection conn,String ccbaMnm) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			String query = "SELECT count(ROWNUM) FROM("
					+ "SELECT ROWNUM, H.* "
					+ "FROM (select sn, no, ccbaMnm1, ccbaCtcdNm, ccsiName, content, IMAGEURL from HERITAGE order by sn) H"
					+ "where H.ccbaMnm1 like ? ) SCH ";
			int result = 0;
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setString(1, "%" + ccbaMnm + "%");
				rs = pstmt.executeQuery();
				if (rs.next()) {
					result = rs.getInt(1);
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			return result;
		}
	
	// 메인페이지에서 이름 키워드로 전체검색시 출력용(이미지, 이름, 주소, 찜 개수를 순번대로 정렬) 
	public List<HeritageMainVO> selectByHeritageName(Connection conn, String ccbaMnm, PageInfo pageInfo) {
		List<HeritageMainVO> list = new ArrayList<>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			String sql = "SELECT ROWNUM, H.* "
					+ "FROM (select sn, no, ccbaMnm1, ccbaCtcdNm, ccsiName, content, IMAGEURL from HERITAGE order by sn) H"
					+ "where H.ccbaMnm1 like ? and ROWNUM between ? and ? ";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%" + ccbaMnm + "%");
			pstmt.setInt(2, pageInfo.getStartList());
			pstmt.setInt(3, pageInfo.getEndList());
			rs = pstmt.executeQuery();

			while (rs.next()) {
				int count = 1;
				int rowNum = rs.getInt(count++);
				int sn = rs.getInt(count++);
				int no = rs.getInt(count++);
				String ccbaMnm1 = rs.getString(count++);
				String ccbaCtcdNm = rs.getString(count++);
				String ccsiName = rs.getString(count++);
				String content = rs.getString(count++);
				String imageUrl = rs.getString(count++);
		
				HeritageMainVO info = new HeritageMainVO(rowNum, sn, no, ccbaMnm1, ccbaCtcdNm, ccsiName, content, imageUrl);
				list.add(info);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		System.out.println(list.toString());
		return list;
	}
	


	// 문화재 테이블에서 no로 상세조회
	//ccbaMnm1 -문화재명(국문) / ccbaMnm2 -문화재명(한자) / ccbaCtcdNm -시도명/ccsiName-시군구명/content-내용/ ccbaKdcd-종목코드/ ccbaQuan-수량/ccbaAsdt-지정(등록일)/ccbaLcad -소재지 상세/
	//ccceName-시대/ccbaPoss-소유자/imageUrl-메인노출이미지URL
		public HeritageVO findHertiageByNo(Connection conn, int hertiageNo) {
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			HeritageVO hv = null;
			String query = "SELECT   ccbaMnm1,  ccbaMnm2,  ccbaCtcdNm,  ccsiName,  content,  ccbaKdcd,  ccbaQuan,  ccbaAsdt,  ccbaLcad,  ccceName,  ccbaPoss,  imageUrl "
					+ "FROM HERITAGE WHERE no = ? ";
			try {
				pstmt = conn.prepareStatement(query);
				pstmt.setInt(1, hertiageNo);
				rs = pstmt.executeQuery();
				if (rs.next()) {
					hv = new HeritageVO();
					hv.setCcbaMnm1(rs.getString("ccbaMnm1"));
					hv.setCcbaMnm2(rs.getString("ccbaMnm2"));
					hv.setCcbaCtcdNm(rs.getString("ccbaCtcdNm"));
					hv.setCcsiName(rs.getString("ccsiName"));
					hv.setContent(rs.getString("content"));
					hv.setCcbaKdcd(rs.getString("ccbaKdcd"));
					hv.setCcbaQuan(rs.getString("ccbaQuan"));
					hv.setCcbaAsdt(rs.getString("ccbaAsdt"));
					hv.setCcbaLcad(rs.getString("ccbaLcad"));
					hv.setCcceName(rs.getString("ccceName"));
					hv.setCcbaPoss(rs.getString("ccbaPoss"));;
					hv.setImageUrl(rs.getString("imageUrl"));
				}
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				close(pstmt);
				close(rs);
			}
			return hv;
		}
		
		
		 // 문화재 이미지 테이블에서 no로 이미지 가져오기
		   public List<HeritageImage> findHeritageImageByNo(Connection conn, int no) {
		      List<HeritageImage> list = new ArrayList<>();
		      PreparedStatement pstmt = null;
		      ResultSet rs = null;
		      String query = "SELECT no, IMAGEURL FROM HERITAGEIMAGE WHERE no = ? ";
		      try {
		         pstmt = conn.prepareStatement(query);
		         pstmt.setInt(1, no);
		         rs = pstmt.executeQuery();
		         
		         while (rs.next()) {
		            int count = 1;
		            int hno = rs.getInt(count++);
		            String imageUrl = rs.getString(count++);
		            HeritageImage imageInfo = new HeritageImage(hno, imageUrl);
		            list.add(imageInfo);
		         }
		      } catch (Exception e) {
		         e.printStackTrace();
		      } finally {
		         close(pstmt);
		         close(rs);
		      }
		      System.out.println(list.toString());
		      return list;
		   }
	
		// 문화재 비디오 테이블에서 no로 상세조회
				public HeritageVideo findHeritageVideoByNo(Connection conn, int videoNo) {
					PreparedStatement pstmt = null;
					ResultSet rs = null;
					HeritageVideo hv = null;
					String query = "SELECT videoUrl FROM heritageVideo "
							+ "WHERE no = ? ";
					try {
						pstmt = conn.prepareStatement(query);
						pstmt.setInt(1, videoNo);
						rs = pstmt.executeQuery();
						if (rs.next()) {
							hv = new HeritageVideo();
							hv.setVideoUrl(rs.getString("videoUrl"));
						}
					} catch (Exception e) {
						e.printStackTrace();
					} finally {
						close(pstmt);
						close(rs);
					}
					System.out.println(hv);
					return hv;
				}
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		HeritageDao dao = new HeritageDao();
		
	}
}


