<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lister Pannes</title>
    <!-- plugins:css -->
    <link rel="stylesheet" href="template/vendors/feather/feather.css">
    <link rel="stylesheet" href="template/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="template/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="template/css/vertical-layout-light/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="template/images/home.png" />
</head>

<body>
<div class="container-scroller">
    <!-- partial:template/partials/_navbar.html -->
    <script id="replace_with_navbar" src="template/partials/navM.js"></script>
    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:template/partials/_settings-panel.html -->
        <div class="theme-setting-wrapper">
            <div id="settings-trigger"><i class="ti-settings"></i></div>
            <div id="theme-settings" class="settings-panel">
                <i class="settings-close ti-close"></i>
                <p class="settings-heading">SIDEBAR SKINS</p>
                <div class="sidebar-bg-options selected" id="sidebar-light-theme"><div class="img-ss rounded-circle bg-light border mr-3"></div>Light</div>
                <div class="sidebar-bg-options" id="sidebar-dark-theme"><div class="img-ss rounded-circle bg-dark border mr-3"></div>Dark</div>
                <p class="settings-heading mt-2">HEADER SKINS</p>
                <div class="color-tiles mx-0 px-4">
                    <div class="tiles success"></div>
                    <div class="tiles warning"></div>
                    <div class="tiles danger"></div>
                    <div class="tiles info"></div>
                    <div class="tiles dark"></div>
                    <div class="tiles default"></div>
                </div>
            </div>
        </div>
        <!-- partial:template/partials/_sidebar.html -->
        <script id="replace_with_sidebar" src="template/partials/sidebarM.js"></script>
        <!-- partial -->
        <div class="col-lg-12 grid-margin stretch-card">
            <div class="card">
                <div class="card-body">
                    <h4 class="card-title">Table des Panne</h4>
                    <p class="card-description">
                        <code></code>
                    </p>
                    <div class="table-responsive">
                        <table class="table table-striped">
                            <thead>
                            <tr>
                                <th>id</th>
                                <th>code</th>
                                <th>date</th>
                                <th>ordre</th>
                                <th>Status</th>

                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach var="panne" items="${liste}">
                                <tr>

                                    <td>${panne.getId()}</td>
                                    <td>${panne.getCode()}</td>
                                    <td>${panne.getDate()}</td>
                                    <td>${panne.getOrdre()}</td>
                                    <td><c:if test="${panne.getStatus()==0}"> Pas d'action
                                        <div class="progress">
                                            <div class="progress-bar progress-bar-striped progress-bar-animated" style="width: 0%"></div>
                                        </div>
                                    </c:if>
                                        <c:if test="${panne.getStatus()==1}"> En Cours
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-striped progress-bar-animated" style="width: 60%"></div>
                                            </div>
                                        </c:if>
                                        <c:if test="${panne.getStatus()==2}"> Terminer
                                            <div class="progress">
                                                <div class="progress-bar progress-bar-striped progress-bar-animated" style="width: 100%"></div>
                                            </div>
                                        </c:if>
                                    </td>
                                    <td>
                                        <button type="submit" name="action" value="delete" data-toggle="modal" data-target="#exampleModal${panne.getId()}"  class="btn btn-link"> Details </button>
                                        <!-- Modal -->
                                        <div class="modal fade" id="exampleModal${panne.getId()}" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                            <div class="modal-dialog" role="document">
                                                <div class="modal-content">
                                                    <div class="modal-header">
                                                        <h5 class="modal-title" id="exampleModalLabel">Information de Panne :</h5>
                                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                                            <span aria-hidden="true">&times;</span>
                                                        </button>
                                                    </div>
                                                    <div class="modal-body">
                                                        <!-- <h4 class="card-title"> </h4>-->
                                                        <!-- <p class="card-description"></p> -->
                                                        <form class="forms-sample" >
                                                            <div class="form-group">
                                                                <label for="exampleInputUsername1">Id :</label>
                                                                <input type="text" name="code" class="form-control" id="exampleInputUsername1" value="${panne.getId()}"  readonly>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputUsername1">Code :</label>
                                                                <input type="text" name="code" class="form-control" id="exampleInputUsername1" value="${panne.getCode()}" readonly>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputEmail1">Date :</label>
                                                                <input type="text" name="date" class="form-control" id="exampleInputEmail1" value="${panne.getDate()}" readonly>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputPassword1">Frequence :</label>
                                                                <input type="text" name="frequence" class="form-control" id="exampleInputPassword1" value="${panne.getFrequence()}" readonly>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputPassword1">Ordre :</label>
                                                                <input name="ordre" class="form-control"  id="exampleInputPassword1" value="${panne.getOrdre()}" readonly>
                                                            </div>
                                                            <div class="form-group">
                                                                <label for="exampleInputPassword1">Explication :</label>
                                                                <input type="textarea" name="explication" class="form-control" id="exampleInputPassword1" value="${panne.getExplication()}" readonly>
                                                            </div>
                                                        </form>
                                                    </div>
                                                    <div class="modal-footer">
                                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                                        <c:if test="${panne.getOrdre()== 'logiciel' and panne.getStatus()==0}">
                                                            <form method="post" action="DeletePanne">
                                                                <input type="hidden" name="id" value="${panne.getId() }">
                                                                <button type="submit" name="action" value="delete" class="btn btn-primary mr-2">Reparer</button>
                                                            </form>
                                                        </c:if>
                                                        <c:if test="${panne.getOrdre()== 'material' and panne.getStatus()==0}">
                                                            <form method="post" action="SaisirConstat">
                                                                <input type="hidden" name="id" value="${panne.getId()}">
                                                                <button type="submit" name="action" value="delete" class="btn btn-primary mr-2">Generer Constat</button>
                                                            </form>
                                                        </c:if>
                                                    </div>
                                                </div>
                                            </div>
                                        </div>
                                        <!-- Modal -->
                                    </td>
                                </tr>
                            </c:forEach>

                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>

        <!-- content-wrapper ends -->
        <!-- partial:template/partials/_footer.html -->
        <footer class="footer">

        </footer>
        <!-- partial -->
    </div>
    <!-- main-panel ends -->
</div>
<!-- page-body-wrapper ends -->
<!-- container-scroller -->
<!-- plugins:js -->

<script src="template/vendors/js/vendor.bundle.base.js"></script>
<!-- endinject -->
<!-- Plugin js for this page -->
<!-- End plugin js for this page -->
<!-- inject:js -->
<script src="template/js/off-canvas.js"></script>
<script src="template/js/hoverable-collapse.js"></script>
<script src="template/js/template.js"></script>
<script src="template/js/settings.js"></script>
<script src="template/js/todolist.js"></script>
<!-- endinject -->
<!-- Custom js for this page-->
<!-- End custom js for this page-->
</body>

</html>
