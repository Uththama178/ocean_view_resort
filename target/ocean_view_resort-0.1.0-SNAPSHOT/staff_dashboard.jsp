<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/4/2026
  Time: 8:45 AM
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.oceanview.ocean_view_resort.api.dto.UserDTO" %>
<%
    // Session එක පරීක්ෂා කිරීම - Login නොවී ඇතුළු වීම වැළැක්වීමට
    UserDTO user = (UserDTO) session.getAttribute("currentUser");
    if (user == null) {
        response.sendRedirect("index.jsp");
        return;
    }
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Staff Dashboard | Ocean View Resort</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">

    <style>
        body { background-color: #f8f9fa; }
        .sidebar { height: 100vh; background: #212529; color: white; padding-top: 20px; }
        .nav-link { color: rgba(255,255,255,.75); transition: 0.3s; }
        .nav-link:hover { color: white; background: rgba(255,255,255,.1); }
        .nav-link.active { color: white; background: #0d6efd; border-radius: 5px; }
        .card { border: none; box-shadow: 0 0.125rem 0.25rem rgba(0, 0, 0, 0.075); border-radius: 10px; }
        .table-container { max-height: 500px; overflow-y: auto; }
    </style>
</head>
<body>

<div class="container-fluid">
    <div class="row">
        <nav class="col-md-2 d-none d-md-block sidebar shadow-sm position-fixed">
            <div class="position-sticky text-center">
                <i class="bi bi-houses-fill fs-1 text-primary"></i>
                <h5 class="py-3">Ocean View Staff</h5>
                <hr class="mx-3">
                <ul class="nav flex-column px-2">
                    <li class="nav-item mb-2">
                        <a class="nav-link active" href="#"><i class="bi bi-speedometer2 me-2"></i> Dashboard</a>
                    </li>
                    <li class="nav-item mb-2">
                        <a class="nav-link" href="billing.jsp"><i class="bi bi-calendar-check me-2"></i> Billing</a>
                    </li>
                    <li class="nav-item mb-2">
                        <a class="nav-link" href="help.jsp"><i class="bi bi-receipt me-2"></i> Help</a>
                    </li>
                    <li class="nav-item mt-5">
                        <a class="nav-link text-danger" href="<%=request.getContextPath()%>/logout">
                            <i class="bi bi-box-arrow-right me-2"></i> Logout
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <main class="col-md-10 ms-sm-auto px-md-4">
            <div class="d-flex justify-content-between flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-4 border-bottom">
                <h1 class="h2">Reservation Management</h1>
                <div class="text-secondary">
                    <i class="bi bi-person-circle me-1"></i> Welcome, <strong><%= user.getFullName() %></strong>
                </div>
            </div>

            <div class="row">
                <div class="col-md-4 mb-4">
                    <div class="card p-4">
                        <h5 class="mb-3 text-primary"><i class="bi bi-plus-circle me-2"></i>New Booking</h5>
                        <form id="reservationForm">
                            <div class="mb-2">
                                <label class="form-label small">Reservation ID</label>
                                <input type="text" name="resId" class="form-control form-control-sm" placeholder="RES-001" required>
                            </div>
                            <div class="mb-2">
                                <label class="form-label small">Guest ID</label>
                                <input type="text" name="guestId" class="form-control form-control-sm" placeholder="G-001" required>
                            </div>
                            <div class="mb-2">
                                <label class="form-label small">Room ID</label>
                                <input type="text" name="roomId" class="form-control form-control-sm" placeholder="R-101" required>
                            </div>
                            <div class="row mb-2">
                                <div class="col">
                                    <label class="form-label small">Check-In</label>
                                    <input type="date" name="checkIn" class="form-control form-control-sm" required>
                                </div>
                                <div class="col">
                                    <label class="form-label small">Check-Out</label>
                                    <input type="date" name="checkOut" class="form-control form-control-sm" required>
                                </div>
                            </div>
                            <div class="mb-3">
                                <label class="form-label small">Total Amount (LKR)</label>
                                <input type="number" name="totalAmount" class="form-control form-control-sm" placeholder="5000.00" required>
                            </div>
                            <button type="button" onclick="submitReservation()" class="btn btn-primary w-100 shadow-sm">
                                <i class="bi bi-check2-circle me-1"></i> Confirm Booking
                            </button>
                        </form>
                    </div>
                </div>

                <div class="col-md-8 mb-4">
                    <div class="card p-3 h-100">
                        <div class="d-flex justify-content-between align-items-center mb-3">
                            <h5 class="m-0"><i class="bi bi-list-ul me-2"></i>Recent Reservations</h5>
                            <button onclick="loadTable()" class="btn btn-sm btn-outline-secondary">
                                <i class="bi bi-arrow-clockwise"></i> Refresh
                            </button>
                        </div>
                        <div class="table-responsive table-container">
                            <table class="table table-hover align-middle">
                                <thead class="table-light sticky-top">
                                <tr>
                                    <th>Res ID</th>
                                    <th>Guest ID</th>
                                    <th>Room</th>
                                    <th>Check In</th>
                                    <th>Status</th>
                                    <th>Amount</th>
                                </tr>
                                </thead>
                                <tbody id="resTableBody">
                                <tr>
                                    <td colspan="6" class="text-center py-4 text-muted">
                                        <div class="spinner-border spinner-border-sm me-2" role="status"></div>
                                        Loading reservations...
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </div>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script>
    // පිටුව load වන විටම දත්ත ගෙන්වන්න
    document.addEventListener("DOMContentLoaded", loadTable);

    // Database එකෙන් සියලුම Reservation ලබාගෙන Table එකට පිරවීම
    function loadTable() {
        fetch('api/reservation')
            .then(res => {
                if (!res.ok) throw new Error('Network response was not ok');
                return res.json();
            })
            .then(data => {
                let tableBody = document.getElementById('resTableBody');
                tableBody.innerHTML = ''; // පැරණි දත්ත ඉවත් කරන්න

                if (data.length === 0) {
                    tableBody.innerHTML = '<tr><td colspan="6" class="text-center text-muted">No reservations found.</td></tr>';
                    return;
                }

                data.forEach(r => {
                    // Status එක අනුව Badge එකේ වර්ණය වෙනස් කිරීම
                    let statusBadge = r.status === 'CONFIRMED' ? 'bg-success' : 'bg-warning text-dark';

                    tableBody.innerHTML += `
    <tr>
        <td><strong>\${r.resId}</strong></td>
        <td>\${r.guestId}</td>
        <td><span class="badge bg-info text-dark">\${r.roomId}</span></td>
        <td>\${r.checkIn}</td>
        <td><span class="badge \${statusBadge}">\${r.status}</span></td>
        <td class="text-end fw-bold text-success">LKR ` + parseFloat(r.amount).toFixed(2) + `</td>
    </tr>`;
                });
            })
            .catch(err => {
                console.error('Error loading table:', err);
                document.getElementById('resTableBody').innerHTML = '<tr><td colspan="6" class="text-center text-danger">Failed to load data.</td></tr>';
            });
    }

    // නව Reservation එකක් ඇතුළත් කිරීම (POST Request)
    function submitReservation() {
        const form = document.getElementById('reservationForm');

        // Form Validation පරීක්ෂාව
        if (!form.checkValidity()) {
            form.reportValidity();
            return;
        }

        const formData = new URLSearchParams(new FormData(form));

        fetch('api/reservation', {
            method: 'POST',
            body: formData,
            headers: { 'Content-Type': 'application/x-www-form-urlencoded' }
        })
            .then(response => response.json())
            .then(data => {
                if(data.status) {
                    Swal.fire({
                        title: 'Saved!',
                        text: 'Reservation successfully added',
                        icon: 'success',
                        timer: 2000,
                        showConfirmButton: false
                    });

                    form.reset(); // Form එක හිස් කරන්න
                    loadTable();  // <--- මෙන්න මෙතැනදී Table එක Refresh වේ! 🚀
                } else {
                    Swal.fire('Error', data.message || data.error, 'error');
                }
            })
            .catch(err => {
                console.error('Error submitting form:', err);
                Swal.fire('Error', 'Server connection failed!', 'error');
            });
    }
</script>

</body>
</html>