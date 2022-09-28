<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Page Responsable</title>
    <script src="../script.js"></script>
    <!-- plugins:css -->
    <link rel="stylesheet" href="template/vendors/feather/feather.css">
    <link rel="stylesheet" href="template/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" href="template/vendors/css/vendor.bundle.base.css">
    <!-- endinject -->
    <!-- Plugin css for this page -->
    <link rel="stylesheet" href="template/vendors/datatables.net-bs4/dataTables.bootstrap4.css">
    <link rel="stylesheet" href="template/vendors/ti-icons/css/themify-icons.css">
    <link rel="stylesheet" type="text/css" href="template/js/select.dataTables.min.css">
    <!-- End plugin css for this page -->
    <!-- inject:css -->
    <link rel="stylesheet" href="template/css/vertical-layout-light/style.css">
    <!-- endinject -->
    <link rel="shortcut icon" href="template/images/home.png" />
</head>
<body>
<div class="container-scroller">

    <!-- partial:partials/_navbar.html -->
    <script id="replace_with_navbar" src="template/partials/nav.js"></script>

    <!-- partial -->
    <div class="container-fluid page-body-wrapper">
        <!-- partial:partials/_settings-panel.html -->
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


        <!-- partial -->
        <!-- partial:partials/_sidebar.html -->
        <script id="replace_with_sidebar" src="template/partials/sidebar.js"></script>
        <!-- partial -->
        <div class="main-panel">
            <div class="content-wrapper">
                <div class="row">
                    <div class="col-md-6 grid-margin stretch-card">
                        <div class="card">
                            <div class="card-body">
                                <h4 class="card-title">Information du Ressource</h4>
                                <p class="card-description">
                                </p>
                                <form class="forms-sample" method="post" action="addRessource" onsubmit="check(this)">
                                    <div class="form-group">
                                        <label for="exampleInputUsername1">Code</label>
                                        <input type="text" name="code" class="form-control" id="exampleInputUsername1" placeholder="Code" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputEmail1">Marque</label>
                                        <input type="text"  name="marque" class="form-control" id="exampleInputEmail1" placeholder="Marque" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Date livraison</label>
                                        <input type="date" name="date_liv" class="form-control" id="exampleInputPassword1" placeholder="Date livraison" required>
                                    </div>
                                    <div class="form-group">
                                        <label for="exampleInputPassword1">Duree garantis (en mois)</label>
                                        <input type="number" name="duree_gar" value="6" class="form-control" id="exampleInputPassword1" placeholder="Date livraison" required>
                                    </div>
                                    <div class="form-group">
                                        <label>Type ressource</label>
                                            <select name="type" class="js-example-basic-single w-100">
                                                <option value="O">Ordinateur</option>
                                                <option value="I">Imprimente</option>
                                            </select>
                                    </div>
                                    <div class="form-group">
                                        <label>Fournisseur</label>
                                        <select name="nom_soc" onchange="hide()" class="js-example-basic-single w-100">
                                            <option selected disabled>Choisie fournisseur</option>
                                            <c:forEach var="listValue" items="${listFournisseurs}">
                                                <option value="${listValue}">${listValue}</option>
                                            </c:forEach>
                                        </select>
                                        <div id="nom_soc" style="display:inline" class="form-group">
                                            <label for="exampleInputUsername1"></label>
                                            ou  <input type="text" name="nom_soc" class="form-control" id="exampleInputUsername1" placeholder="Nom societe" required>
                                        </div>
                                    </div>
                                    <button type="submit" class="btn btn-primary mr-2">Suivant</button>
                                </form>
                            </div>
                        </div>
                    </div>
                    <!-- content-wrapper ends -->
                    <!-- partial:partials/_footer.html -->
                    <footer class="footer">

                    </footer>
                    <!-- partial -->
                </div>
                <!-- main-panel ends -->
            </div>
            <!-- page-body-wrapper ends -->
        </div>
        <!-- container-scroller -->

        <!-- plugins:js -->
        <script src="template/vendors/js/vendor.bundle.base.js"></script>
        <!-- endinject -->
        <!-- Plugin js for this page -->
        <script src="template/vendors/chart.js/Chart.min.js"></script>
        <script src="template/vendors/datatables.net/jquery.dataTables.js"></script>
        <script src="template/vendors/datatables.net-bs4/dataTables.bootstrap4.js"></script>
        <script src="template/js/dataTables.select.min.js"></script>

        <!-- End plugin js for this page -->
        <!-- inject:js -->
        <script src="template/js/off-canvas.js"></script>
        <script src="template/js/hoverable-collapse.js"></script>
        <script src="template/js/template.js"></script>
        <script src="template/js/settings.js"></script>
        <script src="template/js/todolist.js"></script>
        <!-- endinject -->
        <!-- Custom js for this page-->
        <script src="template/js/dashboard.js"></script>
        <script src="template/js/Chart.roundedBarCharts.js"></script>
        <!-- End custom js for this page-->
</body>

</html>

