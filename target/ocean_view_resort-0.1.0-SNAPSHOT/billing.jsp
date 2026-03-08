<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Billing | Ocean View Resort</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.0/font/bootstrap-icons.css">
    <script src="https://cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <style>
        body { background-color: #f8f9fa; }
        /* Sidebar Styling */
        .sidebar { height: 100vh; background: #212529; color: white; padding-top: 20px; z-index: 1000; }
        .nav-link { color: rgba(255,255,255,.75); transition: 0.3s; }
        .nav-link:hover { color: white; background: rgba(255,255,255,.1); }
        .nav-link.active { color: white; background: #0d6efd; border-radius: 5px; }

        /* Layout Alignment */
        .main-content { margin-left: 16.666667%; padding: 20px; } /* Sidebar එකට ඉඩ තැබීම */

        .billing-card { border-radius: 15px; box-shadow: 0 4px 15px rgba(0,0,0,0.1); border: none; }

        @media print {
            .no-print { display: none !important; }
            .print-area { display: block !important; width: 100%; }
            body { background: white; }
        }
        .print-area { display: none; }
    </style>
</head>
<body>

<div class="container-fluid no-print">
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
                        <a class="nav-link active" href="billing.jsp"><i class="bi bi-calendar-check me-2"></i> Billing</a>
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

        <main class="col-md-10 main-content">
            <div class="d-flex justify-content-between align-items-center pt-3 pb-2 mb-4 border-bottom">
                <h1 class="h2">Billing Management</h1>
                <nav aria-label="breadcrumb">
                    <ol class="breadcrumb">
                        <li class="breadcrumb-item"><a href="staff_dashboard.jsp">Home</a></li>
                        <li class="breadcrumb-item active">Billing</li>
                    </ol>
                </nav>
            </div>

            <div class="row justify-content-center">
                <div class="col-md-7 col-lg-5">
                    <div class="card billing-card p-4">
                        <h4 class="text-center mb-4 text-primary"><i class="bi bi-receipt-cutoff me-2"></i>Generate Bill</h4>
                        <form id="billingForm">
                            <div class="row mb-3">
                                <div class="col">
                                    <label class="form-label small fw-bold">Bill ID</label>
                                    <input type="text" id="billId" class="form-control" placeholder="B001" required>
                                </div>
                                <div class="col">
                                    <label class="form-label small fw-bold">Reservation ID</label>
                                    <input type="text" id="resId" class="form-control" placeholder="R001" required>
                                </div>
                            </div>
                            <div class="row mb-3">
                                <div class="col">
                                    <label class="form-label small fw-bold">Rate per Night</label>
                                    <input type="number" id="rate" class="form-control" placeholder="0.00">
                                </div>
                                <div class="col">
                                    <label class="form-label small fw-bold">Nights</label>
                                    <input type="number" id="nights" class="form-control" placeholder="0">
                                </div>
                            </div>

                            <button type="button" onclick="calculateBill()" class="btn btn-outline-primary w-100 mb-4">
                                <i class="bi bi-calculator me-2"></i>Calculate Total
                            </button>

                            <div class="mb-3">
                                <label class="form-label small fw-bold text-secondary">Total Amount (LKR)</label>
                                <input type="text" id="totalAmount" class="form-control form-control-lg fw-bold text-dark bg-light" readonly value="0.00">
                            </div>

                            <div class="mb-4">
                                <label class="form-label small fw-bold text-danger">Discount (LKR)</label>
                                <input type="number" id="discount" class="form-control" value="0">
                            </div>

                            <hr class="my-4">

                            <button type="button" onclick="saveAndPrint()" class="btn btn-success btn-lg w-100 shadow-sm">
                                <i class="bi bi-printer me-2"></i>Save & Print Bill
                            </button>
                        </form>
                    </div>
                </div>
            </div>
        </main>
    </div>
</div>

<div class="container print-area p-5 border bg-white mt-5" id="receipt">
    <div class="text-center mb-4">
        <h2 class="fw-bold">OCEAN VIEW RESORT</h2>
        <p class="mb-0">123, Beach Road, Galle | Tel: 091-2345678</p>
        <p>Email: info@oceanview.com</p>
        <div style="border-top: 2px dashed #000; margin: 20px 0;"></div>
        <h4 class="fw-bold">INVOICE</h4>
    </div>

    <div class="row mb-4">
        <div class="col-6">
            <p class="mb-1"><strong>Bill ID:</strong> <span id="p-billId"></span></p>
            <p class="mb-1"><strong>Res ID:</strong> <span id="p-resId"></span></p>
        </div>
        <div class="col-6 text-end">
            <p class="mb-1"><strong>Date:</strong> <%= new java.util.Date().toString().substring(0, 16) %></p>
            <p class="mb-1"><strong>Status:</strong> PAID</p>
        </div>
    </div>

    <table class="table table-bordered">
        <thead class="table-light">
        <tr>
            <th>Description</th>
            <th class="text-end">Amount (LKR)</th>
        </tr>
        </thead>
        <tbody>
        <tr>
            <td>Room Charges (Nights x Rate)</td>
            <td class="text-end" id="p-total"></td>
        </tr>
        <tr>
            <td class="text-danger">Discount Applied</td>
            <td class="text-end text-danger" id="p-discount"></td>
        </tr>
        <tr class="table-secondary">
            <td class="fw-bold">Net Total Amount</td>
            <td class="text-end fw-bold" style="font-size: 1.2rem;" id="p-final"></td>
        </tr>
        </tbody>
    </table>

    <div class="text-center mt-5">
        <p class="fst-italic">Thank you for staying with us! Please visit again.</p>
        <small>Software by OceanView IT Solutions</small>
    </div>
</div>

<script>
    function calculateBill() {
        const rate = document.getElementById('rate').value;
        const nights = document.getElementById('nights').value;

        if (!rate || !nights) {
            Swal.fire('Warning', 'Please enter both Rate and Nights!', 'warning');
            return;
        }

        fetch('<%=request.getContextPath()%>/api/billing?rate=' + rate + '&nights=' + nights)
            .then(res => {
                if (!res.ok) throw new Error("Server error " + res.status);
                return res.text();
            })
            .then(data => {
                document.getElementById('totalAmount').value = parseFloat(data).toFixed(2);
            })
            .catch(err => {
                console.error(err);
                Swal.fire('Error', 'Calculation failed!', 'error');
            });
    }

    function saveAndPrint() {
        const billId = document.getElementById('billId').value;
        const resId = document.getElementById('resId').value;
        const totalAmount = document.getElementById('totalAmount').value;
        const discount = document.getElementById('discount').value;

        if (!billId || !resId || totalAmount == "0.00") {
            Swal.fire('Error', 'Please fill all details and calculate the total!', 'error');
            return;
        }

        const params = new URLSearchParams({ billId, resId, totalAmount, discount });

        fetch('<%=request.getContextPath()%>/api/billing', {
            method: 'POST',
            body: params,
            headers: {'Content-Type': 'application/x-www-form-urlencoded'}
        })
            .then(res => res.json())
            .then(data => {
                if(data.status) {
                    // Update Print Receipt
                    document.getElementById('p-billId').innerText = billId;
                    document.getElementById('p-resId').innerText = resId;
                    document.getElementById('p-total').innerText = totalAmount;
                    document.getElementById('p-discount').innerText = discount;
                    document.getElementById('p-final').innerText = (parseFloat(totalAmount) - parseFloat(discount)).toFixed(2);

                    Swal.fire('Success', 'Bill Saved Successfully!', 'success').then(() => {
                        window.print();
                    });
                } else {
                    Swal.fire('Error', data.message, 'error');
                }
            });
    }
</script>

</body>
</html>