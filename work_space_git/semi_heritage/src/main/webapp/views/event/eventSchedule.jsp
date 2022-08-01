<%@page import="semi.heritage.event.vo.Festival"%>
<%@page import="semi.heritage.common.util.PageInfo"%>
<%@page import="semi.heritage.community.vo.CommunityBoard"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!-- Header -->
<%@ include file="/views/common/headerLight.jsp" %>


<%
	List<Festival> list = (List<Festival>)request.getAttribute("list");
%>	

		<%for(Festival f : list){%>
			<%= f.toString() +"<br>" %>
		<% }%>

        <!-- Page content-->
        <!-- 상단배경 Hero-->
        <section class="jarallax bg-dark zindex-1 py-xxl-5" data-jarallax data-speed="0.5"><span class="img-overlay bg-transparent opacity-30" style="background-image: linear-gradient(0deg, rgba(31, 27, 45, .7), rgba(31, 27, 45, .7));"></span>
            <div class="jarallax-img" style="background-image: url(img/spsp/bg-eventSchedule3.jpg);"></div>
            <div class="content-overlay container ">
                <div class="mt-5 mb-md-5 py-5">
                    <div class="col-xl-6 col-lg-8 col-md-10 mx-auto mb-sm-5 mb-4 px-0 text-center">
                        <h1 class="display-5 text-light mt-sm-5 my-4">행사일정</h1>
                    </div>
                </div>
            </div>
            <div class="position-absolute d-none d-xxl-block bottom-0 start-0 w-100 bg-white zindex-1" style="border-top-left-radius: 30px; border-top-right-radius: 30px; height: 30px;"></div>
        </section>
        <!-- Page header-->
        <section class="container pt-1 mt-1">
            <!-- Breadcrumb-->
            <nav class="mb-2 pt-md-2" aria-label="breadcrumb">
                <section class="d-sm-flex justify-content-between pt-2">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="real-estate-home-v1.html"><i class="fi-home"></i> Home</a></li>
                        <li class="breadcrumb-item active" aria-current="page">행사일정</li>
                    </ol>
                </section>
                </div>
            </nav>
            <br>
            <!-- Light table head -->
            <div class=" mx-auto mb-sm-4 text-center">
                <h1 class="h2 mb-2"> <i class="fi-calendar text-center"></i> &nbsp;2022년 월별행사</h1>
            </div>
            <!-- 페이지 번호 Pagination-->
            <div class=" col-md-8 mx-auto mb-sm-5 px-0 text-center">
                <div class="btn-toolbar" role="toolbar" aria-label="Pagination">
                    <div class="btn-group me-2 mb-2" role="group" aria-label="First group">
                        <button type="button" class="btn btn-translucent-dark" href="#">1월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">2월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">3월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">4월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">5월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">6월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">7월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">8월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">9월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">10월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">11월</button>
                        <button type="button" class="btn btn-translucent-dark" href="#">12월</button>
                    </div>
                </div>
            </div>
            <div class="table-responsive">
                <table class="table" cellspacing="0" style="text-align:center">
                    <thead class="thead-light">
                        <tr>
                            <th>행사구분</th>
                            <th>프로그램명</th>
                            <th>장소</th>
                            <th>기간</th>
                            <th>상세정보 URL</th>
                            <!-- URL 주소 있을시에 방문 가능-->
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>전통산사문화재</td>
                            <td style="text-align:left">꽃장살 디자인학교</td>
                            <td>충청남도 논산시</td>
                            <td>20220413 - 20221026</td>
                            <td><a href="http://ssanggyesa.com" target="_blank">http://ssanggyesa.com</a></td>
                        </tr>
                        <tr>
                            <td>전통산사문화재</td>
                            <td style="text-align:left ">쌍계 목공아카데미</td>
                            <td>충청남도 논산시</td>
                            <td>20220602 - 20221026</td>
                            <td><a href="http://ssanggyesa.com" target="_blank">http://ssanggyesa.com</a></td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">흥미진진 인의예지</td>
                            <td>전라남도 강진군</td>
                            <td>20220701 - 20220701</td>
                            <td>
                                <a href="https://www.gjculture.or.kr/category/" target=" _blank ">https://www.gjculture.or.kr/category/ </a> </td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">향교에서 놀GO 배우GO</td>
                            <td>충청남도 논산시</td>
                            <td>20220701 - 20220701</td>
                            <td>
                                <a href="https://www.gjculture.or.kr/category/" target=" _blank ">https://www.gjculture.or.kr/category/ </a>
                            </td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">올 곧은 선비정신을 기른다</td>
                            <td>경상남도 창녕군</td>
                            <td>20220701 - 20220701</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">유생(幼生), 유생(儒生)을 만나다!</td>
                            <td>경상남도 함안군</td>
                            <td>20220701 - 20220701</td>
                            <td><a href="https://blog.naver.com/airfly0410" target=" _blank ">https://blog.naver.com/airfly0410 </a>
                        </tr>
                        <tr>
                            <td>전통산사문화재</td>
                            <td style="text-align:left">꽃장살 디자인학교</td>
                            <td>충청남도 논산시</td>
                            <td>20220413 - 20221026</td>
                            <td><a href="http://ssanggyesa.com" target="_blank">http://ssanggyesa.com</a></td>
                        </tr>
                        <tr>
                            <td>전통산사문화재</td>
                            <td style="text-align:left ">쌍계 목공아카데미</td>
                            <td>충청남도 논산시</td>
                            <td>20220602 - 20221026</td>
                            <td><a href="http://ssanggyesa.com" target="_blank">http://ssanggyesa.com</a></td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">흥미진진 인의예지</td>
                            <td>전라남도 강진군</td>
                            <td>20220701 - 20220701</td>
                            <td>
                                <a href="https://www.gjculture.or.kr/category/" target=" _blank ">https://www.gjculture.or.kr/category/ </a> </td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">향교에서 놀GO 배우GO</td>
                            <td>충청남도 논산시</td>
                            <td>20220701 - 20220701</td>
                            <td>
                                <a href="https://www.gjculture.or.kr/category/" target=" _blank ">https://www.gjculture.or.kr/category/ </a>
                            </td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">올 곧은 선비정신을 기른다</td>
                            <td>경상남도 창녕군</td>
                            <td>20220701 - 20220701</td>
                            <td>&nbsp;</td>
                        </tr>
                        <tr>
                            <td>살아숨쉬는 향교·서원</td>
                            <td style="text-align:left ">유생(幼生), 유생(儒生)을 만나다!</td>
                            <td>경상남도 함안군</td>
                            <td>20220701 - 20220701</td>
                            <td><a href="https://blog.naver.com/airfly0410" target=" _blank ">https://blog.naver.com/airfly0410 </a>
                        </tr>
                    </tbody>
                </table>
            </div>

        </section>
        <selection> <br><br><br><br> </selection>
    </main>
    <br><br><br><br>


<!-- Footer-->
<%@include file="/views/common/footer.jsp"%>