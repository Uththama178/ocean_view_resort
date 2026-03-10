<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/4/2026
  Time: 10:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.oceanview.ocean_view_resort.api.dto.UserDTO" %>
<%

    response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
    UserDTO user = (UserDTO) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<html>
<head>
    <title>Help & Support | Ocean View Resort</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <style>
        body { background-color: #f8f9fa; }
        .sidebar { height: 100vh; background: #212529; color: white; padding-top: 20px; z-index: 1000; }
        .nav-link { color: rgba(255,255,255,.75); transition: 0.3s; }
        .nav-link:hover { color: white; background: rgba(255,255,255,.1); }
        .nav-link.active { color: white; background: #0d6efd; border-radius: 5px; }
        .main-content { margin-left: 16.666667%; padding: 20px; }
        .help-card { border: none; border-radius: 12px; box-shadow: 0 4px 6px rgba(0,0,0,0.05); }
        .accordion-button:not(.collapsed) { background-color: #e7f1ff; color: #0d6efd; }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block sidebar shadow-sm position-fixed">
            <div class="position-sticky text-center">
                <i class="bi bi-houses-fill fs-1 text-primary"></i>
                <h5 class="py-3 text-white">Ocean View Staff</h5>
                <hr class="mx-3 border-light">
                <ul class="nav flex-column px-2">
                    <li class="nav-item mb-2">
                        <a class="nav-link" href="staff_dashboard.jsp"><i class="bi bi-speedometer2 me-2"></i> Dashboard</a>
                    </li>
                    <li class="nav-item mb-2">
                        <a class="nav-link" href="billing.jsp"><i class="bi bi-receipt me-2"></i> Billing</a>
                    </li>
                    <li class="nav-item mb-2">
                        <a class="nav-link active" href="help.jsp"><i class="bi bi-question-circle me-2"></i> Help</a>
                    </li>
                    <li class="nav-item mt-5">
                        <a class="nav-link text-danger" href="<%=request.getContextPath()%>/logout"><i class="bi bi-box-arrow-right me-2"></i> Logout</a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="col-md-10 main-content">
            <div class="d-flex justify-content-between align-items-center pt-3 pb-2 mb-4 border-bottom">
                <h1 class="h2"><i class="bi bi-info-circle me-2 text-primary"></i>Help & Support Center</h1>
                <div class="text-secondary small">System Version 1.0.2 (2026)</div>
            </div>

            <div class="row">
                <div class="col-md-8">
                    <div class="card help-card p-4 mb-4">
                        <h4 class="mb-4">Frequently Asked Questions (FAQ)</h4>
                        <div class="accordion" id="helpAccordion">

                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne">
                                        How to add a new Reservation?
                                    </button>
                                </h2>
                                <div id="collapseOne" class="accordion-collapse collapse show" data-bs-parent="#helpAccordion">
                                    <div class="accordion-body">
                                        Go to the <strong>Dashboard</strong>. Fill in the "New Booking" form with Reservation ID, Guest ID, Room ID, and Dates. Click <strong>Confirm Booking</strong>. The list on the right will update automatically.
                                    </div>
                                </div>
                            </div>

                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo">
                                        How to generate and print a Bill?
                                    </button>
                                </h2>
                                <div id="collapseTwo" class="accordion-collapse collapse" data-bs-parent="#helpAccordion">
                                    <div class="accordion-body">
                                        Navigate to the <strong>Billing</strong> page. Enter the Bill ID and Reservation ID. Enter the Room Rate and Number of Nights. Click <strong>Calculate</strong>. If you want to give a discount, enter it and click <strong>Save & Print</strong>.
                                    </div>
                                </div>
                            </div>

                            <div class="accordion-item">
                                <h2 class="accordion-header">
                                    <button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree">
                                        What to do if "500 Internal Server Error" appears?
                                    </button>
                                </h2>
                                <div id="collapseThree" class="accordion-collapse collapse" data-bs-parent="#helpAccordion">
                                    <div class="accordion-body">
                                        This usually happens if data fields are empty or formatted incorrectly. Please check if you have entered numeric values for rates and IDs correctly. If the issue persists, contact the System Administrator.
                                    </div>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>

                <div class="col-md-4">
                    <div class="card help-card p-4 bg-primary text-white mb-4">
                        <h5><i class="bi bi-headset me-2"></i>Contact IT Support</h5>
                        <p class="small mt-3">If you encounter any technical difficulties, please reach out to the IT department.</p>
                        <hr class="border-light">
                        <p class="mb-1"><i class="bi bi-telephone me-2"></i> Ext: 404 / 405</p>
                        <p class="mb-1"><i class="bi bi-envelope me-2"></i> support@oceanview.com</p>
                    </div>

                    <div class="card help-card p-4">
                        <h5>System Shortcuts</h5>
                        <ul class="list-unstyled mt-2 mb-0">
                            <li class="mb-2"><span class="badge bg-secondary">Ctrl + P</span> - Print current page</li>
                            <li class="mb-2"><span class="badge bg-secondary">F5</span> - Refresh data</li>
                        </ul>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
