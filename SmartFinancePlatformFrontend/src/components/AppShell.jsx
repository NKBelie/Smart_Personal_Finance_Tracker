import { NavLink, Outlet } from 'react-router-dom';

const navItems = [
  { to: '/dashboard', label: 'Dashboard' },
  { to: '/income', label: 'Income' },
  { to: '/expense', label: 'Expenses' },
  { to: '/budget', label: 'Budget' },
  { to: '/savings', label: 'Savings' },
  { to: '/analytics', label: 'Analytics' },
  { to: '/reports', label: 'Reports' },
  { to: '/profile', label: 'Profile' },
  { to: '/admin', label: 'Admin' },
];

function AppShell({ darkMode, onToggleTheme }) {
  return (
    <div className="min-h-screen bg-slate-950 text-slate-100">
      <div className="mx-auto flex min-h-screen max-w-7xl flex-col px-4 py-6 sm:px-6 lg:px-8">
        <div className="grid gap-6 lg:grid-cols-[280px_1fr]">
          <aside className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5 shadow-glow backdrop-blur-xl">
            <div className="flex items-center justify-between gap-3 pb-6">
              <div>
                <p className="text-xs uppercase tracking-[0.24em] text-sky-300/70">Smart Finance</p>
                <h2 className="mt-2 text-2xl font-semibold text-white">Control center</h2>
              </div>
              <button
                type="button"
                onClick={onToggleTheme}
                className="rounded-2xl border border-slate-700/80 bg-slate-900/80 px-3 py-2 text-sm text-slate-200 transition hover:border-sky-400/70 hover:text-white"
              >
                {darkMode ? 'Light' : 'Dark'}
              </button>
            </div>

            <nav className="space-y-2">
              {navItems.map((item) => (
                <NavLink
                  key={item.to}
                  to={item.to}
                  className={({ isActive }) =>
                    `block rounded-3xl px-4 py-3 text-sm transition ${
                      isActive
                        ? 'bg-sky-500/15 text-sky-200 shadow-sm shadow-sky-500/10'
                        : 'text-slate-300 hover:bg-slate-900/80 hover:text-white'
                    }`
                  }
                >
                  {item.label}
                </NavLink>
              ))}
            </nav>

            <div className="mt-8 rounded-3xl border border-slate-800/80 bg-slate-900/80 p-5 text-sm text-slate-300">
              <p className="text-slate-100">Need help?</p>
              <p className="mt-2 leading-relaxed text-slate-400">
                Use the analytics page to compare categories, monitor cash flow, and export monthly reports.
              </p>
            </div>
          </aside>

          <main className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow backdrop-blur-xl">
            <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
              <div>
                <p className="text-xs uppercase tracking-[0.24em] text-sky-300/70">Welcome back</p>
                <h1 className="mt-2 text-3xl font-semibold text-white">Your finance workspace</h1>
                <p className="mt-3 max-w-2xl text-sm text-slate-400">
                  Navigate between income, expenses, budgets, and reports with a unified modern dashboard.
                </p>
              </div>
              <div className="flex flex-wrap gap-3">
                <NavLink
                  to="/dashboard"
                  className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400"
                >
                  Open dashboard
                </NavLink>
                <NavLink
                  to="/reports"
                  className="rounded-2xl border border-slate-700/80 px-4 py-2 text-sm text-slate-200 transition hover:border-sky-400/70 hover:text-white"
                >
                  View reports
                </NavLink>
              </div>
            </div>

            <div className="mt-8">
              <Outlet />
            </div>
          </main>
        </div>
      </div>
    </div>
  );
}

export default AppShell;
