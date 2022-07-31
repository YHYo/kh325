<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@include file="/views/common/headerLight.jsp"%>
        <!-- Page content-->
        <!-- 리뷰남기기 Review modal-->
        <div class="modal fade" id="modal-review" tabindex="-1">
            <div class="modal-dialog modal-dialog-centered" role="document">
                <div class="modal-content">
                    <div class="modal-header d-block position-relative border-0 pb-0 px-sm-5 px-4">
                        <h3 class="modal-title mt-4 text-center">리뷰남기기</h3>
                        <button class="btn-close position-absolute top-0 end-0 mt-3 me-3" type="button" data-bs-dismiss="modal" aria-label="Close"></button>
                    </div>
                    <div class="modal-body px-sm-5 px-4">
                        <form class="needs-validation" novalidate>
                            <div class="mb-3">
                                <label class="form-label" for="review-name">Name <span
                                        class='text-danger'>*</span></label>
                                <input class="form-control" type="text" id="review-name" placeholder="Your name" required>
                                <div class="invalid-feedback">Please let us know your name.</div>
                            </div>
                            <div class="mb-3">
                                 <label class="form-label" for="review-email">Email <span
                                        class='text-danger'>*</span></label>
                                <input class="form-control" type="email" id="review-email" placeholder="Your email address" required>
                                <div class="invalid-feedback">Please provide a valid email address.</div>
                            </div>
                            <div class="mb-3">

                                <div class="invalid-feedback">Please rate the property.</div>
                            </div>
                            <div class="mb-4">
                                <label class="form-label" for="review-text">Review <span
                                        class='text-danger'>*</span></label>
                                <textarea class="form-control" id="review-text" rows="5" placeholder="Your review message" required></textarea>
                                <div class="invalid-feedback">Please write your review.</div>
                            </div>
                            <button class="btn btn-primary d-block w-100 mb-4" type="submit">제출하기</button>
                        </form>
                    </div>
                </div>
            </div>
        </div>
        <!-- Page header-->
        <section class="container pt-5 mt-5">
            <!-- Breadcrumb-->
            <nav class="mb-3 pt-md-3" aria-label="breadcrumb">
                <ol class="breadcrumb">
                    <li class="breadcrumb-item"><a href="real-estate-home-v1.html">Home</a></li>
                    <li class="breadcrumb-item"><a href="real-estate-catalog-rent.html">문화재검색</a></li>
                    <li class="breadcrumb-item active" aria-current="page">경복궁 향원정 (景福宮 香遠亭)</li>
                </ol>
            </nav>
            <h1 class="h2 mb-2">경복궁 향원정 (景福宮 香遠亭)</h1>
            <p class="mb-2 pb-1 fs-lg">Hyangwonjeong Pavilion of Gyeongbokgung Palace</p>
            <p class="mb-2 pb-1 fs-lg fi-map-pin">서울특별시 종로구 청와대로 1-0 (세종로)</p>
            <!-- 시작 :좋아요 likes + 리뷰 reviews 아이콘 / 숫자 넣기-->
            <div class="d-flex justify-content-between align-items-center">
                <ul class="d-flex mb-4 list-unstyled">

                </ul>
                <div class="text-nowrap">
                    <button class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle ms-2 mb-2" type="button" data-bs-toggle="tooltip" title="Add to Wishlist"><i class="fi-heart"></i></button>
                    <div class="dropdown d-inline-block" data-bs-toggle="tooltip" title="Share">
                        <button class="btn btn-icon btn-light-primary btn-xs shadow-sm rounded-circle ms-2 mb-2" type="button" data-bs-toggle="dropdown"><i class="fi-share"></i></button>
                        <div class="dropdown-menu dropdown-menu-end my-1">
                            <button class="dropdown-item" type="button"><i
                                    class="fi-facebook fs-base opacity-75 me-2"></i>Facebook</button>
                            <button class="dropdown-item" type="button"><i
                                    class="fi-twitter fs-base opacity-75 me-2"></i>Twitter</button>
                            <button class="dropdown-item" type="button"><i
                                    class="fi-instagram fs-base opacity-75 me-2"></i>Instagram</button>
                        </div>
                    </div>
                </div>
            </div>
            <!-- 끝 : 좋아요 likes + 리뷰 reviews 아이콘 / 숫자 넣기-->
        </section>
        <!-- Gallery-->
        <section class="container overflow-auto mb-4 pb-3" data-simplebar>
            <div class="row g-2 g-md-3 gallery" data-thumbnails="true" style="min-width: 30rem;">
                <div class="col-8">
                    <a class="gallery-item rounded rounded-md-3" href="img/heritage/01.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Bathroom&lt;/h6&gt;"><img src="img/heritage/01.jpg" alt="Gallery thumbnail"></a>
                </div>
                <div class="col-4">
                    <a class="gallery-item rounded rounded-md-3 mb-2 mb-md-3" href="img/heritage/02.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Bedroom&lt;/h6&gt;"><img src="img/heritage/02.jpg" alt="Gallery thumbnail"></a>
                    <a class="gallery-item rounded rounded-md-3" href="img/heritage/03.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Living room&lt;/h6&gt;"><img src="img/heritage/03.jpg" alt="Gallery thumbnail"></a>
                </div>
                <div class="col-12">
                    <div class="row g-2 g-md-3">
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" href="img/heritage/04.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Bedroom&lt;/h6&gt;"><img src="img/heritage/04.jpg" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" href="img/heritage/05.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Kitchen&lt;/h6&gt;"><img src="img/heritage/05.jpg" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" href="img/heritage/06.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Living room&lt;/h6&gt;"><img src="img/heritage/06.jpg" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item rounded-1 rounded-md-2" style="object-fit: contain" href="img/heritage/07.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Bathroom&lt;/h6&gt;"><img src="img/heritage/07.jpg" img class="img-contain" alt="Gallery thumbnail"></a>
                        </div>
                        <div class="col">
                            <a class="gallery-item more-item rounded-1 rounded-md-2" href="img/heritage/08.jpg" data-sub-html="&lt;h6 class=&quot;fs-sm text-light&quot;&gt;Bathroom&lt;/h6&gt;"><img src="img/heritage/08.jpg" img class="img-contain" alt="Gallery thumbnail"><span class="gallery-item-caption fs-base"><span class='d-none d-md-inline'>+ more
                                        photos</span></span>
                            </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- Post content-->
        <section class="container mb-5 pb-1">
            <div class="row">
                <div class="col-md-7 mb-md-0 mb-4">
                    <!-- 문화재설명-->
                    <div class="mb-4 pb-md-3">
                        <span>
                            <p class="subtitle text-sm text-primary" style="font-weight:bold">A B O U T</p>
                            <h3 class="h3">문화재설명</h3>
                            <!-- 스크롤 <div style="overflow:scroll; width:800px; height:500px;"> -->

                        </span>
                        <p class="mb-1">향원정은 경복궁 북쪽 후원에 있는 향원지 내의 가운데 섬 위에 건립된 육각형의 정자이다. 향원지의 ‘향원(香遠)’은 ‘향기가 멀리 간다’는 뜻으로 북송대 학자 주돈이(1017∼1073)가 지은 '애련설(愛蓮說)'에서 따온 말로서 왕이나 왕족들이 휴식하고 소요하던 침전의 후원으로 여기에는 향원지(香遠池)와 녹산(鹿山)등 원림 (苑林)공간이 된다. 향원지가 있던 곳에는 본래 세조 2년(1456)에 취로정(翠露亭)이란
                            정자를 짓고 연꽃을 심었다는 기록이「세조실록」에 보인다. 향원지는 4,605㎡의 넓이의 방형인데, 모서리를 둥글게 조성한 방형의 연지에 연꽃과 수초가 자라고, 잉어 등 물고기가 살고 있다. 향원지의 수원(水源)은 북쪽 언덕 밑에 솟아나는 '열상진원(洌上眞源)'이라는 샘물이다. 이 향원정에 들어가는 다리인 '취향교'는 본래 목교로서 1873년에 향원정의 북쪽에 건청궁 방향으로 설치되었다. 취향교는
                            건청궁에서 향원정으로 들어가도록 북쪽에 있었으나, 6·25전쟁 당시 없어졌으며, 현재는 1953년에 지은 다리가 향원지 남쪽에 있다. 본래의 취향교는 조선시대 원지에 놓인 목교로는 가장 긴 다리(길이 32m,폭 165cm)이다. 향원지의 북쪽으로 녹산지역에 있는 담장에는 인유문(麟遊門)이란 일각문(一角門)이 있으며, 그 남쪽에는 봉집문(鳳集門)이 있었는데 이로 인해 연못은 한층 아늑한 정취(情趣)에
                            싸여 있었다. 향원정은 고종이 아버지 흥선대원군의 간섭에서 벗어나 친정체제를 구축하면서 정치적 자립의 일환으로 건청궁을 지으면서 그 건청궁 앞에 연못을 파서 가운데 섬을 만들고 세운 2층 정자로, 고종 4년(1867)부터 고종 10년(1873)사이에 지어진 것으로 추정되며, 향원정으로 가는 섬에는 나무로 만들어진 취향교라는 다리가 있으며, 남쪽에는 함화당, 집경당이 위치해
                        </p>
                        <div class="collapse" id="seeMoreOverview">
                            <p class="mb-1">
                                있다. 정자의 평면은 정육각형으로 아래·위층이 똑같은 크기이며, 장대석으로 마무리한 낮은 기단 위에 육각형으로 된 초석을 놓고, 그 위에 일층과 이층을 관통하는 육모기둥을 세웠다. 공포는 이층 기둥 위에 짜여지는데, 기둥 윗몸을 창방(昌枋)으로 결구하고 기둥 위에 주두(柱枓:대접받침)를 놓고 끝이 둥글게 초각(草刻)된 헛첨차를 놓았다. 일출목(一出目)의 행공첨차를 받치고, 다시 소로를 두어 외목도리(外目道里)밑의 장혀를 받친 물익공이다. 일층 평면은
                                바닥 주위로 평난간을 두른 툇마루를 두었고, 이층 바닥 주위로는 계자난간을 두른 툇마루를 두었다. 천장은 우물천장이며 사방둘레의 모든 칸에는 완자살창틀을 달았다. 처마는 겹처마이며 육모지붕으로, 중앙의 추녀마루들이 모이는 중심점에 절병통(節甁桶)을 얹어 치장하였다. 향원정은 왕과 그 가족들이 휴식을 취하는 공간으로 경복궁 후원의 아름다운 풍광 속에 안겨있는 상징적 대표 건물이다. 육각형 초석,
                                육각형 평면, 육모지붕 등 육각형의 공간을 구성하여 섬세하고 미려하게 다듬은 모든 구성요소들이 절묘한 조화를 이룬 비례감이 뛰어난 정자로 역사적, 예술적, 건축적으로 가치가 높다.
                            </p>
                        </div>
                        <a class="collapse-label collapsed" href="#seeMoreOverview" data-bs-toggle="collapse" data-bs-label-collapsed="더보기" data-bs-label-expanded="접기" role="button" aria-expanded="false" aria-controls="seeMoreOverview"></a>
                    </div>
                    <!--스크롤 </div> -->
                    <!-- Post meta-->
                    <div class="mb-lg-5 mb-md-4 pb-lg-2 py-4 border-top">
                    </div>
                    <!-- 시작 : 리뷰 Reviews-->
                    <div class="mb-4 pb-4 border-bottom">
                        <p class="subtitle text-sm text-primary" style="font-weight:bold">R E V I E W S</p>
                        <h3 class="h3 pb-3">리뷰 (32개)
                        </h3>
                        <div class="d-flex flex-sm-row flex-column align-items-sm-center align-items-stretch justify-content-between">
                            <a class="btn btn-outline-primary mb-sm-0 mb-3" href="#modal-review" data-bs-toggle="modal"><i class="fi-edit me-1"></i>Add review</a>
                            <div class="d-flex align-items-center ms-sm-4">
                                <label class="me-2 pe-1 text-nowrap" for="reviews-sorting"><i
                                        class="fi-arrows-sort text-muted mt-n1 me-2"></i>Sort by:</label>
                                <select class="form-select" id="reviews-sorting">
                                    <option>Newest</option>
                                    <option>Oldest</option>
                                </select>
                            </div>
                        </div>
                    </div>
                    <!-- Review-->
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex justify-content-between mb-3">
                            <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/naIm.png" width="48" alt="Avatar">
                                <div class="ps-2">
                                    <h6 class="fs-base mb-0">Na-Im Kim</h6>
                                </div>
                            </div><span class="text-muted fs-sm">June 28, 2022</span>
                        </div>
                        <p>This place is huge. Be prepared to walk a lot and bring water as you will be in the sun. They offer English tours so best to check ahead and time your visit with the tours, otherwise you will be walking around looking at old buildings
                            which can be pretty boring w/o hearing the back story.</p>
                        <div class="d-flex align-items-center">
                            <button class="btn-like" type="button"><i class="fi-like"></i><span>(2)</span></button>
                            <div class="border-end me-1">&nbsp;</div>
                            <button class="btn-dislike" type="button"><i
                                    class="fi-dislike"></i><span>(1)</span></button>
                        </div>
                    </div>
                    <!-- Review-->
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex justify-content-between mb-3">
                            <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/sophie.jpg" width="48" alt="Avatar">
                                <div class="ps-2">
                                    <h6 class="fs-base mb-0">전소피아</h6>
                                </div>
                            </div><span class="text-muted fs-sm">May 14, 2022</span>
                        </div>
                        <p>어느 날 아침, 저는 경복궁 향원정을 가고 싶었죠. 저희집은 흑석동인데 파란 시내버스를 타고 가야한답니다. 1시간쯤은 걸릴 것 같아요. 근데 요즘 비가 계속 와서 힘들 것 같아요. 가을에나 가볼까요? 사랑스런 남친과 함께 가볼까 합니다. 아 자바해야 하는데, 왜이리 하고 싶은 게 많을까요? 작업하면서 보니 사진이 참 이쁘긴 하네요.
                        </p>
                        <div class="d-flex align-items-center">
                            <button class="btn-like" type="button"><i class="fi-like"></i><span>(0)</span></button>
                            <div class="border-end me-1">&nbsp;</div>
                            <button class="btn-dislike" type="button"><i
                                    class="fi-dislike"></i><span>(0)</span></button>
                        </div>
                    </div>

                    <!-- Review-->
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex justify-content-between mb-3">
                            <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/hc.png" width="48" alt="Avatar">
                                <div class="ps-2">
                                    <h6 class="fs-base mb-0">형채 선</h6>
                                    </span>
                                </div>
                            </div><span class="text-muted fs-sm">July 1, 2022</span>
                        </div>
                        <p>형채군 달팽이 잘 보듬어주어서 고맙습니다. 경복궁 향원정도 달팽이들 데리고 한 번 가보세요. 형채군 닮아서 밝고 씩씩하게 키우길 바래요. 그리고 이해성 강사님 바보바보. 메롱 히히.
                        </p>
                        <div class="d-flex align-items-center">
                            <button class="btn-like" type="button"><i class="fi-like"></i><span>(0)</span></button>
                            <div class="border-end me-1">&nbsp;</div>
                            <button class="btn-dislike" type="button"><i
                                    class="fi-dislike"></i><span>(1)</span></button>
                        </div>
                    </div>

                    <!-- Review-->
                    <div class="mb-4 pb-4 border-bottom">
                        <div class="d-flex justify-content-between mb-3">
                            <div class="d-flex align-items-center pe-2"><img class="rounded-circle me-1" src="img/avatars/48.png" width="48" alt="Avatar">
                                <div class="ps-2">
                                    <h6 class="fs-base mb-0">Brian J</h6>
                                </div>
                            </div><span class="text-muted fs-sm">July 17, 2022</span>
                        </div>
                        <p>Impressive and interesting palace though we preferred nearby Changdeokgung Palace, which has a more scenic setting. Gyeongbokgung is more out in the open. In addition to the palace buildings, the main things we liked about Gyeongbokgung
                            were the changing of the guard ceremony and nearby location to the Blue House and Bukchon Hanok Village, which were both worth visiting.</p>
                        <div class="d-flex align-items-center">
                            <button class="btn-like" type="button"><i class="fi-like"></i><span>(3)</span></button>
                            <div class="border-end me-1">&nbsp;</div>
                            <button class="btn-dislike" type="button"><i
                                    class="fi-dislike"></i><span>(0)</span></button>
                        </div>
                    </div>
                    <!-- Pagination-->
                    <nav class="mt-2 mb-4" aria-label="Reviews pagination">
                        <ul class="pagination">
                            <li class="page-item d-sm-none"><span class="page-link page-link-static">1 / 5</span></li>
                            <li class="page-item active d-none d-sm-block" aria-current="page"><span class="page-link">1<span class="visually-hidden">(current)</span></span>
                            </li>
                            <li class="page-item d-none d-sm-block"><a class="page-link" href="#">2</a></li>
                            <li class="page-item d-none d-sm-block"><a class="page-link" href="#">3</a></li>
                            <li class="page-item d-none d-sm-block">...</li>
                            <li class="page-item d-none d-sm-block"><a class="page-link" href="#">8</a></li>
                            <li class="page-item"><a class="page-link" href="#" aria-label="Next"><i
                                        class="fi-chevron-right"></i></a>
                            </li>
                        </ul>
                    </nav>
                </div>
                <!-- Sidebar-->
                <aside class="col-lg-4 col-md-5 ms-lg-auto pb-1">
                    <!-- 문화재정보 INFORMATION      //    아이콘 ?????????????-->
                    <div class="card border-0 shadow mb-5">
                        <div class="card-header py-4 border-0" style="background-color:rgb(245, 245, 245)">
                            <div class="d-flex align-items-center justify-content-between">
                                <div>
                                    <table>
                                        <tr>
                                            <th>
                                                <p class="subtitle text-sm text-primary">I N F O R M A T I O N</p>
                                                <h3>문화재정보</h3>
                                            </th>
                                            <th>
                                                <h1>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<i class="fi-info-circle"></i></h1>
                                            </th>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <div class="card-body">
                            <table class="table text-sm mb-0">
                                <tr>
                                    <th class="ps-0" style="width: 100px">분 류</th>
                                    <td class="pe-0">유적건조물 / 정치국방 / 궁궐·관아 / 궁궐</td>
                                </tr>
                                <tr>
                                    <th class="ps-0">수량/면적</th>
                                    <td class="pe-0 ">1동</td>
                                </tr>
                                <tr>
                                    <th class="ps-0">지정일</th>
                                    <td class="pe-0">2012.03.02</td>
                                </tr>
                                <tr>
                                    <th class="ps-0">소 재 지</th>
                                    <td class="pe-0">서울특별시 종로구 청와대로 1-0 (세종로)</td>
                                </tr>
                                <tr>
                                    <th class="ps-0">시 대</th>
                                    <td class="pe-0">조선시대</td>
                                </tr>
                                <tr>
                                    <th class="ps-0">소유자</th>
                                    <td class="pe-md-0">국유</td>
                                </tr>
                                <tr>
                                    <th class="ps-0">관리자</th>
                                    <td class="pe-0">문화재청 경복궁관리소</td>
                                </tr>
                            </table>
                        </div>
                    </div>
                    <!-- 위치 LOCATION (Map)-->
                    <div class="pt-2">
                        <p class="subtitle text-sm text-primary" style="font-weight:bold"> &nbsp;&nbsp;L O C A T I O N
                        </p>
                        <h3 class="h4 pb-3"><i class="mt-n1 me-2 lead align-middle text-warning" style="font-weight:bold"></i>위치
                        </h3>
                        <div class="position-relative mb-2"><img class="rounded-3" src="<%=path%>\resources\img\semi-img\map.jpg" alt="Map">
                            <div class="d-flex w-100 h-100 align-items-center justify-content-center position-absolute top-0 start-0">
                                <a class="btn btn-primary stretched-link" href="https://www.google.com/maps/embed?pb=!1m18!1m12!1m3!1d3022.6145424811048!2d-73.93999278406218!3d40.74850644331743!2m3!1f0!2f0!3f0!3m2!1i1024!2i768!4f13.1!3m3!1m2!1s0x89c2592979d4827f%3A0x3a5d8b3cf779f3b6!2s28%20Jackson%20Ave%2C%20Long%20Island%20City%2C%20NY%2011101%2C%20USA!5e0!3m2!1sen!2sua!4v1618074552281!5m2!1sen!2sua"
                                    data-iframe="true" data-bs-toggle="lightbox"><i class="fi-route me-2"></i>Get
                                    directions</a>
                            </div>
                        </div>
                    </div>
                    <br>

                    <!-- 동영상 video-->
                    <div class="pt-2">
                        <p class="subtitle text-sm text-primary" style="font-weight:bold"> &nbsp;&nbsp;V I D E O</p>
                        <h3 class="h4 pb-3"><i class="mt-n1 me-2 lead align-middle text-warning" style="font-weight:bold"></i>동영상
                        </h3>
                        <br><br><br><br>
                        <div class="position-relative mb-2">
                            <div class="d-flex w-100 h-100 align-items-center justify-content-center position-absolute top-0 start-0">
                                <video src="http://uci.k-heritage.tv/resolver/I801:1605002-014-V00006@N2R:1" controls width="400" height="350">
                                    <a class="btn btn-primary stretched-link"
                                        href="http://uci.k-heritage.tv/resolver/I801:1605002-014-V00006@N2R:1"
                                        data-iframe="true" data-bs-toggle="lightbox"><i class="fi-route me-2"></i>Get
                                        directions</a>
                                </video>
                                <!-- <div class="position-relative mb-2"><img class="rounded-3" src="img/real-estate/single/map.jpg" alt="Map">
                              <div class="d-flex w-100 h-100 align-items-center justify-content-center position-absolute top-0 start-0"> -->
                            </div>
                        </div>
                        <br><br><br><br> <br><br><br><br>
                        <div class="text-center">
                            <p>
                                <a style="color:rgb(220, 58, 85)" href="#">
                                    <i class="fi-heart-filled" style="color:rgb(220, 58, 85)"></i> Like this place</a>
                            </p><span>153명의 사람들이 이 장소에 좋아요를 눌렀습니다.</span>
                        </div>
                </aside>
                </div>
        </section>
        </div>
    </main>

<%@include file="/views/common/footer.jsp"%>
 