import { Link } from 'react-router-dom';

const features = [
  { title: 'Budget control', description: 'Plan monthly budgets and stay ahead of every expense.' },
  { title: 'Income tracking', description: 'Monitor all revenue streams from salary to side income.' },
  { title: 'Expense insights', description: 'See spending patterns and identify saving opportunities.' },
  { title: 'Smart reporting', description: 'Build reports that visualize cash flow and growth.' },
];

function LandingPage({ darkMode, onToggleTheme }) {
  return (
    <div className="min-h-screen bg-slate-950 text-slate-100">
      <div className="mx-auto flex min-h-screen max-w-7xl flex-col px-4 py-8 sm:px-6 lg:px-8">
        <header className="flex flex-col gap-4 border-b border-slate-800/70 pb-6 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-xs uppercase tracking-[0.32em] text-sky-300/70">Smart Finance</p>
            <h1 className="mt-3 max-w-3xl text-4xl font-semibold tracking-tight text-white sm:text-5xl">
              Finance intelligence for modern teams and personal goals.
            </h1>
          </div>
          <div className="flex items-center gap-3">
            <button
              type="button"
              onClick={onToggleTheme}
              className="rounded-2xl border border-slate-700/80 bg-slate-900/80 px-4 py-2 text-sm text-slate-200 transition hover:border-sky-400/70 hover:text-white"
            >
              {darkMode ? 'Switch to Light' : 'Switch to Dark'}
            </button>
            <Link
              to="/login"
              className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400"
            >
              Login
            </Link>
          </div>
        </header>

        <main className="mt-12 grid gap-10 lg:grid-cols-[1.3fr_0.9fr] lg:items-center">
          <section className="space-y-6">
            <p className="inline-flex rounded-full bg-sky-500/10 px-4 py-1 text-sm text-sky-200">
              Built for cash flow, savings, and financial clarity.
            </p>
            <h2 className="text-3xl font-semibold text-white sm:text-4xl">
              One dashboard for expenses, budgets, savings goals, analytics, and reporting.
            </h2>
            <p className="max-w-2xl text-slate-400">
              Smart Finance Platform helps you track every income source, manage spending, and turn financial goals into measurable results.
            </p>
            <div className="flex flex-col gap-3 sm:flex-row">
              <Link
                to="/register"
                className="rounded-2xl bg-sky-500 px-5 py-3 text-sm font-semibold text-slate-950 transition hover:bg-sky-400"
              >
                Create account
              </Link>
              <Link
                to="/dashboard"
                className="rounded-2xl border border-slate-700/80 px-5 py-3 text-sm text-slate-200 transition hover:border-sky-400/70 hover:text-white"
              >
                Explore dashboard
              </Link>
            </div>
          </section>

          <section className="rounded-[2rem] border border-slate-800/80 bg-slate-900/70 p-6 shadow-glow backdrop-blur-xl">
            <div className="space-y-4">
              <div className="rounded-3xl bg-slate-950/80 p-4 text-slate-100 shadow-inner shadow-slate-900/20">
                <p className="text-sm uppercase tracking-[0.3em] text-sky-300/80">Portfolio overview</p>
                <p className="mt-4 text-4xl font-semibold text-white">$24,980</p>
                <p className="mt-2 text-sm text-slate-400">Net balance across budgets and savings.</p>
              </div>
              <div className="grid gap-4 sm:grid-cols-2">
                <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-4">
                  <p className="text-sm text-slate-400">This month</p>
                  <p className="mt-3 text-2xl font-semibold text-white">$6,540</p>
                </div>
                <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-4">
                  <p className="text-sm text-slate-400">Savings pace</p>
                  <p className="mt-3 text-2xl font-semibold text-white">$1,720</p>
                </div>
              </div>
            </div>
          </section>
        </main>

        <section className="mt-16 grid gap-5 sm:grid-cols-2 lg:grid-cols-4">
          {features.map((feature) => (
            <div key={feature.title} className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow transition hover:-translate-y-0.5 hover:border-sky-400/40">
              <h3 className="text-xl font-semibold text-white">{feature.title}</h3>
              <p className="mt-3 text-slate-400">{feature.description}</p>
            </div>
          ))}
        </section>
      </div>
    </div>
  );
}

export default LandingPage;
