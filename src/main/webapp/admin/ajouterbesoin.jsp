<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Lister Ressource</title>
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
    <script id="replace_with_navbar" src="template/partials/navA.js"></script>
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
        <script id="replace_with_sidebar" src="template/partials/sidebarA.js"></script>
        <!-- partial -->


                      <div class="main-panel">
                                <div class="content-wrapper">



                                    <div class="row">
                                        <div class="col-md-6 grid-margin stretch-card">
                                            <div class="card">
                                                <div class="card-body">
                                                    <h4 class="card-title">Ajouter Besoin</h4>
                                                    <p class="card-description">
                                                    </p>
                                                    <form class="forms-sample" method="post" action="AjouterBesoin">
                                                        <div class="form-group">
                                                            <label for="kkkk1">Ressource</label>
                                                            <select id="kkkk1" name="nom_ressource" class="form-control" required >
                                                                <option selected disabled>Choisie Ressource</option>

                                                                    <option value="Ordinateur">Ordinateur</option>
                                                                    <option value="Imprimante">Imprimante</option>
                                                                </select>

                                                        </div>

                                                        <div class="form-group">
                                                            <label for="exampleInputUsername1">Ajouter Quantite</label>
                                                            <input type="text" name="qte" class="form-control" id="exampleInputUsername1" placeholder="Quantite" required>

                                                        </div>
                    									<input type="hidden" name="id" value="${Besoin.getBesoin_id()}">
                                                        <button type="submit"  class="btn btn-primary mr-2">AjouterBesoin</button>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>

                                    </div>
                                    <div class="col-lg-12 grid-margin stretch-card">
                                <div class="card">
                                    <div class="card-body">
                                        <h4 class="card-title">Table des Besoins</h4>
                                        <p class="card-description">
                                            <code></code>
                                        </p>
                                        <div class="table-responsive">
                                            <table class="table table-striped">

                                                <thead>
                                                <tr>

                                                    <th>Ressource</th>
                                                    <th>Quantite</th>

                                                </tr>
                                                </thead>
                                                <tbody>
                                                <c:forEach var="b" items="${besoin}">
                                                    <tr>
                                                        <td>${b.getNom_ressource()}</td>
                                                        <td>${b.getQte()}</td>
                                                        <td>
                                                            <form method="post" action="BesoinAction">
                                                                <input type="hidden" name="id" value="${b.getBesoin_id()}">
                                                                <c:if test="${b.isDeletable()}">
                                                                    <button type="submit" name="action" value="delete" class="btn btn-danger">Supprimer</button>

                                                                </c:if>
                                                            </form>
                                                        </td>
                                                    </tr>
                                                </c:forEach>

                                                </tbody>
                    </table>
                                        </div>
                                    </div>
                                </div>
                            </div>

                                    <!-- main-panel ends -->
                                </div>
                                <!-- page-body-wrapper ends -->
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
