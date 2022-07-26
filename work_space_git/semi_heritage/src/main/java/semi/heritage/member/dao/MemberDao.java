package semi.heritage.member.dao;

import static semi.heritage.common.jdbc.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;

import semi.heritage.member.vo.Member;

/*
 * 233, no=144, ccmaName=국보, crltsnoNm=224, ccbaMnm1=경복궁 경회루, ccbaMnm2=景福宮 慶會樓, ccbaCtcdNm=서울, ccsiName=종로구, ccbaAdmin=문화재청 경복궁관리소, ccbaKdcd=11, ccbaCtcd=11, ccbaAsno=02240000, ccbaCncl=N, ccbaCpno=1111102240000, longitude=126.975569, latitude=37.579201, gcodeName=유적건조물, bcodeName=정치국방, mcodeName=궁궐·관아, scodeName=궁궐, ccbaQuan=1동, ccbaAsdt=19850108, ccbaLcad=서울 종로구 삼청로 37, 경복궁 (세종로), ccceName=조선 고종 4년(1867), ccbaPoss=국유, imageUrl=http://www.cha.go.kr/unisearch/images/national_treasure/1611724.jpg, content=경복궁 근정전 서북쪽 연못 안에 세운 경회루는, 나라에 경사가 있거나 사신이 왔을 때 연회를 베풀던 곳이다.
 경복궁을 처음 지을 때의 경회루는 작은 규모였으나, 조선 태종 12년(1412)에 연못을 넓히면서 크게 다시 지었다. 그 후 임진왜란으로 불에 타 돌기둥만 남은 상태로 유지되어 오다가 270여 년이 지난 고종 4년(1867) 경복궁을 다시 지으면서 경회루도 다시 지었다. 연못 속에 잘 다듬은 긴 돌로 둑을 쌓아 네모 반듯한 섬을 만들고 그 안에 누각을 세웠으며, 돌다리 3개를 놓아 땅과 연결되도록 하였다. 
 앞면 7칸·옆면 5칸의 2층 건물로, 지붕은 옆면에서 볼 때 여덟 팔(八)자 모양을 한 팔작지붕이다. 지붕 처마를 받치기 위해 장식하여 만든 공포는 누각건물에서 많이 보이는 간결한 형태로 꾸몄다. 태종 때 처음 지어진 경회루는 성종 때 고쳐지으면서 누각의 돌기둥을 화려하게 용의 문양을 조각하였다고 전해지나, 임진왜란으로 소실된 이후 고종대에 다시 지으면서 지금과 같이 간결하게 바깥쪽에는 네모난 기둥을, 안쪽에는 둥근기둥을 세웠다. 1층 바닥에는 네모난 벽돌을 깔고 2층 바닥은 마루를 깔았는데, 마루의 높이를 3단으로 각각 달리하여 지위에 따라 맞는 자리에 앉도록 하였다.
 경복궁 경회루는 우리 나라에서 단일 평면으로는 규모가 가장 큰 누각으로, 간결하면서도 호화롭게 장식한 조선 후기 누각건축의 특징을 잘 나타내고 있는 소중한 건축 문화재이다.]
, 
 * */

public class MemberDao {

	Member memver = new Member();
	
	//회원가입
	public int insertMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String query = "INSERT INTO USERINFO VALUES(uNo.NEXTVAL, ?, ?, ?, ?, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT, DEFAULT )";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUemail());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
//	private int uno;
//	private String uemail;
//	private String upw;
//	private String uname;
//	private String upn;
//	private String uadr;
//	private String uphoto;
//	private String introduce;
//	private String twt;
//	private String insta;
//	private String facebook;
	// 회원정보 수정
	public int updateMember(Connection conn, Member member) {
		PreparedStatement pstmt = null;
		String query = "UPDATE USERINFO SET uemail=?, upw=?, uname=?, upn=?, uadr=?, uphoto=?, introduce=?,"
						+ " twt=?, insta=?, facebook=?, WHERE UNO=?";
		int result = 0;
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, member.getUemail());
			pstmt.setString(2, member.getUpw());
			pstmt.setString(3, member.getUname());
			pstmt.setString(4, member.getUpn());
			pstmt.setString(5, member.getUadr());
			pstmt.setString(6, member.getUphoto());
			pstmt.setString(7, member.getIntroduce());
			pstmt.setString(8, member.getTwt());
			pstmt.setString(9, member.getInsta());
			pstmt.setString(10, member.getFacebook());
			pstmt.setInt(11, member.getUno());
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	// 탈퇴하기
	public int updateStatus(Connection conn, int no, String status) {
		PreparedStatement pstmt = null;
		String query = "UPDATE MEMBER SET STATUS=? WHERE NO=?";
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, status); // Y,N (STATUS IN ('Y', 'N'))
			pstmt.setInt(2, no);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
}
