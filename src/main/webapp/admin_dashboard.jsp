<%--
  Created by IntelliJ IDEA.
  User: USER
  Date: 3/4/2026
  Time: 8:44 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <title>Ocean View Resort — Admin</title>
    <link href="https://fonts.googleapis.com/css2?family=Inter:wght@300;400;500;600;700&display=swap" rel="stylesheet"/>
    <style>
        *, *::before, *::after { box-sizing: border-box; margin: 0; padding: 0; }
        :root {
            --primary: #1a56db;
            --primary-light: #eff4ff;
            --bg: #f5f7fa;
            --card: #ffffff;
            --text: #111928;
            --text-muted: #6b7280;
            --border: #e5e7eb;
            --sidebar-w: 230px;
            --success: #057a55; --success-bg: #def7ec;
            --warning: #92400e; --warning-bg: #fef3c7;
            --danger: #9b1c1c;  --danger-bg: #fde8e8;
            --info: #1e429f;    --info-bg: #e1effe;
        }
        body { font-family: 'Inter', sans-serif; background: var(--bg); color: var(--text); font-size: 14px; }

        /* SIDEBAR */
        .sidebar {
            position: fixed; top: 0; left: 0;
            width: var(--sidebar-w); height: 100vh;
            background: var(--card); border-right: 1px solid var(--border);
            display: flex; flex-direction: column; z-index: 100;
        }
        .logo {
            padding: 18px 20px; border-bottom: 1px solid var(--border);
            display: flex; align-items: center; gap: 10px;
        }
        .logo-mark {
            width: 34px; height: 34px; background: var(--primary); border-radius: 8px;
            display: flex; align-items: center; justify-content: center;
            color: #fff; font-size: 16px; flex-shrink: 0;
        }
        .logo-text { font-size: 13px; font-weight: 700; }
        .logo-sub { font-size: 11px; color: var(--text-muted); }
        .nav { flex: 1; padding: 14px 12px; overflow-y: auto; }
        .nav-label {
            font-size: 10px; font-weight: 600; text-transform: uppercase;
            letter-spacing: .08em; color: var(--text-muted); padding: 0 8px;
            margin: 14px 0 5px;
        }
        .nav-label:first-child { margin-top: 0; }
        .nav-item {
            display: flex; align-items: center; gap: 10px;
            padding: 8px 10px; border-radius: 6px; cursor: pointer;
            color: var(--text-muted); font-size: 13px; font-weight: 500;
            transition: all .15s; margin-bottom: 1px;
        }
        .nav-item:hover { background: var(--bg); color: var(--text); }
        .nav-item.active { background: var(--primary-light); color: var(--primary); font-weight: 600; }
        .nav-item svg { width: 16px; height: 16px; flex-shrink: 0; }
        .nav-count {
            margin-left: auto; background: var(--primary); color: #fff;
            font-size: 10px; font-weight: 700; padding: 1px 6px; border-radius: 10px;
        }
        .sidebar-user {
            padding: 14px 16px; border-top: 1px solid var(--border);
            display: flex; align-items: center; gap: 10px;
        }
        .user-av {
            width: 32px; height: 32px; border-radius: 50%; background: var(--primary);
            color: #fff; font-size: 12px; font-weight: 700;
            display: flex; align-items: center; justify-content: center; flex-shrink: 0;
        }
        .user-name { font-size: 13px; font-weight: 600; }
        .user-role { font-size: 11px; color: var(--text-muted); }

        /* MAIN */
        .main { margin-left: var(--sidebar-w); min-height: 100vh; }
        .topbar {
            background: var(--card); border-bottom: 1px solid var(--border);
            padding: 0 28px; height: 58px;
            display: flex; align-items: center; justify-content: space-between;
            position: sticky; top: 0; z-index: 50;
        }
        .topbar h2 { font-size: 16px; font-weight: 700; }
        .topbar p { font-size: 12px; color: var(--text-muted); }
        .topbar-right { display: flex; align-items: center; gap: 10px; }
        .search {
            display: flex; align-items: center; gap: 8px;
            border: 1px solid var(--border); border-radius: 6px;
            padding: 7px 12px; width: 210px; background: var(--bg);
        }
        .search input {
            border: none; background: none; outline: none;
            font-size: 13px; color: var(--text); font-family: 'Inter',sans-serif; width: 100%;
        }
        .search input::placeholder { color: var(--text-muted); }
        .search svg { width: 15px; height: 15px; color: var(--text-muted); flex-shrink: 0; }
        .btn {
            padding: 8px 16px; border-radius: 6px; font-size: 13px; font-weight: 600;
            cursor: pointer; border: none; font-family: 'Inter',sans-serif; transition: all .15s;
        }
        .btn-primary { background: var(--primary); color: #fff; }
        .btn-primary:hover { background: #1649c0; }
        .btn-ghost { background: var(--card); color: var(--text); border: 1px solid var(--border); }
        .btn-ghost:hover { background: var(--bg); }

        /* CONTENT */
        .content { padding: 24px 28px; }

        /* STATS */
        .stats { display: grid; grid-template-columns: repeat(4,1fr); gap: 16px; margin-bottom: 20px; }
        .stat { background: var(--card); border: 1px solid var(--border); border-radius: 8px; padding: 18px 20px; }
        .stat-top { display: flex; align-items: center; justify-content: space-between; margin-bottom: 10px; }
        .stat-label { font-size: 12px; color: var(--text-muted); font-weight: 500; }
        .stat-icon {
            width: 34px; height: 34px; border-radius: 7px;
            display: flex; align-items: center; justify-content: center;
        }
        .stat-icon svg { width: 17px; height: 17px; }
        .stat-icon.blue { background: var(--primary-light); color: var(--primary); }
        .stat-icon.green { background: var(--success-bg); color: var(--success); }
        .stat-icon.yellow { background: var(--warning-bg); color: var(--warning); }
        .stat-icon.red { background: var(--danger-bg); color: var(--danger); }
        .stat-value { font-size: 24px; font-weight: 700; margin-bottom: 4px; }
        .stat-meta { font-size: 12px; color: var(--text-muted); }
        .up { color: var(--success); font-weight: 600; }
        .dn { color: var(--danger); font-weight: 600; }

        /* LAYOUT */
        .row { display: grid; gap: 16px; margin-bottom: 20px; }
        .row-2 { grid-template-columns: 1fr 290px; }
        .row-2b { grid-template-columns: 1fr 1fr; }

        /* CARD */
        .card { background: var(--card); border: 1px solid var(--border); border-radius: 8px; overflow: hidden; }
        .card-head {
            padding: 14px 20px; border-bottom: 1px solid var(--border);
            display: flex; align-items: center; justify-content: space-between;
        }
        .card-title { font-size: 14px; font-weight: 700; }
        .card-sub { font-size: 12px; color: var(--text-muted); margin-top: 1px; }
        .card-actions { display: flex; gap: 8px; }

        /* TABLE */
        table { width: 100%; border-collapse: collapse; }
        th {
            text-align: left; padding: 10px 20px;
            font-size: 11px; font-weight: 600; color: var(--text-muted);
            background: #f9fafb; border-bottom: 1px solid var(--border);
        }
        td { padding: 12px 20px; font-size: 13px; border-bottom: 1px solid #f3f4f6; vertical-align: middle; }
        tr:last-child td { border-bottom: none; }
        tr:hover td { background: #f9fafb; }
        .guest-cell { display: flex; align-items: center; gap: 9px; }
        .gav { width: 28px; height: 28px; border-radius: 50%; color: #fff; font-size: 11px; font-weight: 700; display: flex; align-items: center; justify-content: center; flex-shrink: 0; }
        .gname { font-weight: 600; font-size: 13px; }
        .gid { font-size: 11px; color: var(--text-muted); }
        .badge { display: inline-block; padding: 3px 8px; border-radius: 4px; font-size: 11px; font-weight: 600; }
        .b-confirmed { background: var(--success-bg); color: var(--success); }
        .b-pending { background: var(--warning-bg); color: var(--warning); }
        .b-cancelled { background: var(--danger-bg); color: var(--danger); }
        .b-checkedin { background: var(--info-bg); color: var(--info); }
        .view-btn {
            padding: 4px 10px; border-radius: 5px; font-size: 12px; font-weight: 500;
            cursor: pointer; border: 1px solid var(--border); background: var(--card);
            color: var(--text-muted); font-family: 'Inter',sans-serif; transition: all .15s;
        }
        .view-btn:hover { border-color: var(--primary); color: var(--primary); }

        /* OCCUPANCY */
        .occ-body { padding: 20px; }
        .occ-big { text-align: center; padding: 18px 0 22px; }
        .occ-pct { font-size: 38px; font-weight: 700; color: var(--primary); }
        .occ-lbl { font-size: 12px; color: var(--text-muted); margin-top: 2px; }
        .occ-row { margin-bottom: 13px; }
        .occ-row-top { display: flex; justify-content: space-between; font-size: 12px; margin-bottom: 5px; }
        .occ-name { font-weight: 500; }
        .occ-val { color: var(--text-muted); }
        .bar { height: 6px; background: #f3f4f6; border-radius: 3px; overflow: hidden; }
        .bar-fill { height: 100%; border-radius: 3px; background: var(--primary); }

        /* QUICK ACTIONS */
        .qa-grid { display: grid; grid-template-columns: 1fr 1fr; gap: 10px; padding: 16px; }
        .qa-item {
            display: flex; align-items: center; gap: 10px;
            padding: 11px 12px; border: 1px solid var(--border); border-radius: 7px;
            cursor: pointer; transition: all .15s; font-size: 13px; font-weight: 500;
        }
        .qa-item:hover { border-color: var(--primary); background: var(--primary-light); color: var(--primary); }
        .qa-icon { width: 28px; height: 28px; border-radius: 6px; background: var(--bg); display: flex; align-items: center; justify-content: center; }
        .qa-icon svg { width: 14px; height: 14px; color: var(--text-muted); }
        .qa-item:hover .qa-icon { background: var(--primary); }
        .qa-item:hover .qa-icon svg { color: #fff; }

        /* ACTIVITY */
        .act-item { display: flex; gap: 12px; padding: 12px 20px; border-bottom: 1px solid #f3f4f6; }
        .act-item:last-child { border-bottom: none; }
        .act-dot { width: 7px; height: 7px; border-radius: 50%; margin-top: 5px; flex-shrink: 0; }
        .d-blue { background: var(--primary); }
        .d-green { background: var(--success); }
        .d-red { background: #e02424; }
        .d-yellow { background: #d97706; }
        .act-text { font-size: 13px; line-height: 1.4; }
        .act-time { font-size: 11px; color: var(--text-muted); margin-top: 2px; }

        /* MODAL */
        .overlay { display: none; position: fixed; inset: 0; background: rgba(0,0,0,.35); z-index: 200; align-items: center; justify-content: center; }
        .overlay.open { display: flex; }
        .modal { background: var(--card); border-radius: 10px; width: 500px; max-width: 95vw; border: 1px solid var(--border); }
        .modal-head { padding: 16px 22px; border-bottom: 1px solid var(--border); display: flex; align-items: center; justify-content: space-between; }
        .modal-title { font-size: 15px; font-weight: 700; }
        .modal-close { cursor: pointer; color: var(--text-muted); font-size: 22px; line-height: 1; }
        .modal-body { padding: 20px 22px; display: grid; grid-template-columns: 1fr 1fr; gap: 14px; }
        .field { display: flex; flex-direction: column; gap: 5px; }
        .field.full { grid-column: 1/-1; }
        .field label { font-size: 12px; font-weight: 600; color: var(--text-muted); }
        .field input, .field select {
            padding: 8px 12px; border: 1px solid var(--border); border-radius: 6px;
            font-size: 13px; font-family: 'Inter',sans-serif; color: var(--text);
            outline: none; transition: border-color .15s;
        }
        .field input:focus, .field select:focus { border-color: var(--primary); }
        .modal-foot { padding: 14px 22px; border-top: 1px solid var(--border); display: flex; justify-content: flex-end; gap: 10px; }
    </style>
</head>
<body>

<!-- SIDEBAR -->
<aside class="sidebar">
    <div class="logo">
        <div class="logo-mark">🌊</div>
        <div>
            <div class="logo-text">Ocean View Resort</div>
            <div class="logo-sub">Admin Portal</div>
        </div>
    </div>

    <nav class="nav">
        <div class="nav-label">Overview</div>
        <div class="nav-item active" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6"/></svg>
            Dashboard
        </div>

        <div class="nav-label">Management</div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2"/></svg>
            Reservations <span class="nav-count">12</span>
        </div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0"/></svg>
            Guests
        </div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16m14 0h2m-2 0h-5m-9 0H3m2 0h5M9 7h1m-1 4h1m4-4h1m-1 4h1m-5 10v-5a1 1 0 011-1h2a1 1 0 011 1v5m-4 0h4"/></svg>
            Rooms
        </div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M3 10h18M7 15h1m4 0h1m-7 4h12a3 3 0 003-3V8a3 3 0 00-3-3H6a3 3 0 00-3 3v8a3 3 0 003 3z"/></svg>
            Billing <span class="nav-count">3</span>
        </div>

        <div class="nav-label">Reports</div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z"/></svg>
            Occupancy Report
        </div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8c-1.657 0-3 .895-3 2s1.343 2 3 2 3 .895 3 2-1.343 2-3 2m0-8c1.11 0 2.08.402 2.599 1M12 8V7m0 1v8m0 0v1"/></svg>
            Revenue
        </div>

        <div class="nav-label">System</div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M8.228 9c.549-1.165 2.03-2 3.772-2 2.21 0 4 1.343 4 3 0 1.4-1.278 2.575-3.006 2.907-.542.104-.994.54-.994 1.093m0 3h.01M21 12a9 9 0 11-18 0 9 9 0 0118 0z"/></svg>
            Help
        </div>
        <div class="nav-item" onclick="setActive(this)">
            <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M10.325 4.317c.426-1.756 2.924-1.756 3.35 0a1.724 1.724 0 002.573 1.066c1.543-.94 3.31.826 2.37 2.37a1.724 1.724 0 001.065 2.572c1.756.426 1.756 2.924 0 3.35a1.724 1.724 0 00-1.066 2.573c.94 1.543-.826 3.31-2.37 2.37a1.724 1.724 0 00-2.572 1.065c-.426 1.756-2.924 1.756-3.35 0a1.724 1.724 0 00-2.573-1.066c-1.543.94-3.31-.826-2.37-2.37a1.724 1.724 0 00-1.065-2.572c-1.756-.426-1.756-2.924 0-3.35a1.724 1.724 0 001.066-2.573c-.94-1.543.826-3.31 2.37-2.37.996.608 2.296.07 2.572-1.065z"/><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M15 12a3 3 0 11-6 0 3 3 0 016 0z"/></svg>
            Settings
        </div>
    </nav>

    <div class="sidebar-user">
        <div class="user-av">AK</div>
        <div>
            <div class="user-name">Admin Kumar</div>
            <div class="user-role">Super Admin</div>
        </div>
    </div>
</aside>

<!-- MAIN -->
<main class="main">
    <div class="topbar">
        <div>
            <h2>Dashboard</h2>
            <p>Thursday, 05 March 2026 · Galle, Sri Lanka</p>
        </div>
        <div class="topbar-right">
            <div class="search">
                <svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/></svg>
                <input type="text" placeholder="Search reservations..."/>
            </div>
            <button class="btn btn-primary" onclick="openModal()">+ New Reservation</button>
        </div>
    </div>

    <div class="content">

        <!-- STATS -->
        <div class="stats">
            <div class="stat">
                <div class="stat-top">
                    <span class="stat-label">Total Reservations</span>
                    <div class="stat-icon blue"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 5H7a2 2 0 00-2 2v12a2 2 0 002 2h10a2 2 0 002-2V7a2 2 0 00-2-2h-2M9 5a2 2 0 002 2h2a2 2 0 002-2"/></svg></div>
                </div>
                <div class="stat-value">284</div>
                <div class="stat-meta"><span class="up">↑ 12%</span> vs last month</div>
            </div>
            <div class="stat">
                <div class="stat-top">
                    <span class="stat-label">Monthly Revenue</span>
                    <div class="stat-icon green"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8c-1.657 0-3 .895-3 2s1.343 2 3 2 3 .895 3 2-1.343 2-3 2m0-8c1.11 0 2.08.402 2.599 1M12 8V7m0 1v8m0 0v1"/></svg></div>
                </div>
                <div class="stat-value">$48.2k</div>
                <div class="stat-meta"><span class="up">↑ 8.4%</span> vs last month</div>
            </div>
            <div class="stat">
                <div class="stat-top">
                    <span class="stat-label">Rooms Occupied</span>
                    <div class="stat-icon yellow"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M19 21V5a2 2 0 00-2-2H7a2 2 0 00-2 2v16m14 0h2m-2 0h-5m-9 0H3m2 0h5"/></svg></div>
                </div>
                <div class="stat-value">37 / 50</div>
                <div class="stat-meta">74% occupancy rate</div>
            </div>
            <div class="stat">
                <div class="stat-top">
                    <span class="stat-label">Pending Check-ins</span>
                    <div class="stat-icon red"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 8v4l3 3m6-3a9 9 0 11-18 0 9 9 0 0118 0z"/></svg></div>
                </div>
                <div class="stat-value">8</div>
                <div class="stat-meta"><span class="dn">Arrivals today</span></div>
            </div>
        </div>

        <!-- TABLE + OCCUPANCY -->
        <div class="row row-2">
            <div class="card">
                <div class="card-head">
                    <div>
                        <div class="card-title">Recent Reservations</div>
                        <div class="card-sub">Latest guest bookings</div>
                    </div>
                    <div class="card-actions">
                        <button class="btn btn-ghost" style="font-size:12px;padding:6px 12px;">Filter</button>
                        <button class="btn btn-ghost" style="font-size:12px;padding:6px 12px;">Export</button>
                    </div>
                </div>
                <table>
                    <thead><tr><th>Guest</th><th>Room</th><th>Check-in</th><th>Check-out</th><th>Status</th><th>Amount</th><th></th></tr></thead>
                    <tbody>
                    <tr>
                        <td><div class="guest-cell"><div class="gav" style="background:#1a56db">RS</div><div><div class="gname">Ravi Silva</div><div class="gid">#RES-001</div></div></div></td>
                        <td>Ocean Suite</td><td>05 Mar</td><td>08 Mar</td>
                        <td><span class="badge b-checkedin">Checked In</span></td>
                        <td><strong>$720</strong></td><td><button class="view-btn">View</button></td>
                    </tr>
                    <tr>
                        <td><div class="guest-cell"><div class="gav" style="background:#057a55">AP</div><div><div class="gname">Amara Perera</div><div class="gid">#RES-002</div></div></div></td>
                        <td>Deluxe Beach</td><td>06 Mar</td><td>10 Mar</td>
                        <td><span class="badge b-confirmed">Confirmed</span></td>
                        <td><strong>$960</strong></td><td><button class="view-btn">View</button></td>
                    </tr>
                    <tr>
                        <td><div class="guest-cell"><div class="gav" style="background:#7e3af2">KJ</div><div><div class="gname">Kasun Jayasinghe</div><div class="gid">#RES-003</div></div></div></td>
                        <td>Garden Villa</td><td>07 Mar</td><td>09 Mar</td>
                        <td><span class="badge b-pending">Pending</span></td>
                        <td><strong>$480</strong></td><td><button class="view-btn">View</button></td>
                    </tr>
                    <tr>
                        <td><div class="guest-cell"><div class="gav" style="background:#e02424">NF</div><div><div class="gname">Nadia Fernando</div><div class="gid">#RES-004</div></div></div></td>
                        <td>Ocean Suite</td><td>04 Mar</td><td>06 Mar</td>
                        <td><span class="badge b-cancelled">Cancelled</span></td>
                        <td style="color:var(--text-muted)">$480</td><td><button class="view-btn">View</button></td>
                    </tr>
                    <tr>
                        <td><div class="guest-cell"><div class="gav" style="background:#0694a2">DW</div><div><div class="gname">Dilshan Wickrama</div><div class="gid">#RES-005</div></div></div></td>
                        <td>Deluxe Beach</td><td>08 Mar</td><td>12 Mar</td>
                        <td><span class="badge b-confirmed">Confirmed</span></td>
                        <td><strong>$1,200</strong></td><td><button class="view-btn">View</button></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <div class="card">
                <div class="card-head">
                    <div>
                        <div class="card-title">Room Occupancy</div>
                        <div class="card-sub">50 rooms total</div>
                    </div>
                </div>
                <div class="occ-body">
                    <div class="occ-big">
                        <div class="occ-pct">74%</div>
                        <div class="occ-lbl">Current occupancy rate</div>
                    </div>
                    <div class="occ-row">
                        <div class="occ-row-top"><span class="occ-name">Ocean Suite</span><span class="occ-val">8 / 10</span></div>
                        <div class="bar"><div class="bar-fill" style="width:80%"></div></div>
                    </div>
                    <div class="occ-row">
                        <div class="occ-row-top"><span class="occ-name">Deluxe Beach</span><span class="occ-val">15 / 20</span></div>
                        <div class="bar"><div class="bar-fill" style="width:75%"></div></div>
                    </div>
                    <div class="occ-row">
                        <div class="occ-row-top"><span class="occ-name">Garden Villa</span><span class="occ-val">7 / 10</span></div>
                        <div class="bar"><div class="bar-fill" style="width:70%"></div></div>
                    </div>
                    <div class="occ-row">
                        <div class="occ-row-top"><span class="occ-name">Standard Room</span><span class="occ-val">7 / 10</span></div>
                        <div class="bar"><div class="bar-fill" style="width:70%"></div></div>
                    </div>
                </div>
            </div>
        </div>

        <!-- BOTTOM -->
        <div class="row row-2b">
            <div class="card">
                <div class="card-head">
                    <div>
                        <div class="card-title">Quick Actions</div>
                        <div class="card-sub">Common tasks</div>
                    </div>
                </div>
                <div class="qa-grid">
                    <div class="qa-item" onclick="openModal()">
                        <div class="qa-icon"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M12 4v16m8-8H4"/></svg></div>
                        New Reservation
                    </div>
                    <div class="qa-item">
                        <div class="qa-icon"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M21 21l-6-6m2-5a7 7 0 11-14 0 7 7 0 0114 0z"/></svg></div>
                        Find Guest
                    </div>
                    <div class="qa-item">
                        <div class="qa-icon"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 12h6m-6 4h6m2 5H7a2 2 0 01-2-2V5a2 2 0 012-2h5.586a1 1 0 01.707.293l5.414 5.414a1 1 0 01.293.707V19a2 2 0 01-2 2z"/></svg></div>
                        Generate Bill
                    </div>
                    <div class="qa-item">
                        <div class="qa-icon"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 19v-6a2 2 0 00-2-2H5a2 2 0 00-2 2v6a2 2 0 002 2h2a2 2 0 002-2zm0 0V9a2 2 0 012-2h2a2 2 0 012 2v10m-6 0a2 2 0 002 2h2a2 2 0 002-2m0 0V5a2 2 0 012-2h2a2 2 0 012 2v14a2 2 0 01-2 2h-2a2 2 0 01-2-2z"/></svg></div>
                        View Reports
                    </div>
                    <div class="qa-item">
                        <div class="qa-icon"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M5 13l4 4L19 7"/></svg></div>
                        Check-in Guest
                    </div>
                    <div class="qa-item">
                        <div class="qa-icon"><svg fill="none" viewBox="0 0 24 24" stroke="currentColor"><path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M17 16l4-4m0 0l-4-4m4 4H7"/></svg></div>
                        Check-out Guest
                    </div>
                </div>
            </div>

            <div class="card">
                <div class="card-head">
                    <div>
                        <div class="card-title">Recent Activity</div>
                        <div class="card-sub">System log</div>
                    </div>
                    <button class="btn btn-ghost" style="font-size:12px;padding:6px 12px;">View All</button>
                </div>
                <div>
                    <div class="act-item"><div class="act-dot d-blue"></div><div><div class="act-text">Ravi Silva checked in — Ocean Suite #102</div><div class="act-time">Today, 10:30 AM</div></div></div>
                    <div class="act-item"><div class="act-dot d-green"></div><div><div class="act-text">Bill generated for Amara Perera — $960.00</div><div class="act-time">Today, 09:15 AM</div></div></div>
                    <div class="act-item"><div class="act-dot d-blue"></div><div><div class="act-text">New reservation — Dilshan Wickrama #RES-005</div><div class="act-time">Today, 08:50 AM</div></div></div>
                    <div class="act-item"><div class="act-dot d-red"></div><div><div class="act-text">Reservation cancelled — Nadia Fernando #RES-004</div><div class="act-time">Yesterday, 06:20 PM</div></div></div>
                    <div class="act-item"><div class="act-dot d-yellow"></div><div><div class="act-text">Check-out — M. Bandara — Garden Villa</div><div class="act-time">Yesterday, 11:00 AM</div></div></div>
                </div>
            </div>
        </div>

    </div>
</main>

<!-- MODAL -->
<div class="overlay" id="overlay" onclick="closeModal(event)">
    <div class="modal" onclick="event.stopPropagation()">
        <div class="modal-head">
            <div class="modal-title">New Reservation</div>
            <span class="modal-close" onclick="closeModal()">×</span>
        </div>
        <div class="modal-body">
            <div class="field full"><label>Guest Full Name</label><input type="text" placeholder="e.g. Ravi Silva"/></div>
            <div class="field"><label>Contact Number</label><input type="text" placeholder="+94 77 000 0000"/></div>
            <div class="field"><label>Room Type</label>
                <select><option>Ocean Suite</option><option>Deluxe Beach</option><option>Garden Villa</option><option>Standard Room</option><option>Standard Room</option></select>
            </div>
            <div class="field"><label>Check-in Date</label><input type="date"/></div>
            <div class="field"><label>Check-out Date</label><input type="date"/></div>
            <div class="field full"><label>Address</label><input type="text" placeholder="Guest address"/></div>
        </div>
        <div class="modal-foot">
            <button class="btn btn-ghost" onclick="closeModal()">Cancel</button>
            <button class="btn btn-primary">Confirm Reservation</button>
        </div>
    </div>
</div>

<script>
    function setActive(el) {
        document.querySelectorAll('.nav-item').forEach(i => i.classList.remove('active'));
        el.classList.add('active');
    }
    function openModal() { document.getElementById('overlay').classList.add('open'); }
    function closeModal(e) {
        if (!e || e.target === document.getElementById('overlay'))
            document.getElementById('overlay').classList.remove('open');
    }
</script>
</body>
</html>
