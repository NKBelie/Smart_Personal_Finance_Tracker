function DashboardPage() {
  return (
    <div className="space-y-8">
      <div className="grid gap-6 xl:grid-cols-3">
        <article className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Net balance</p>
          <p className="mt-4 text-4xl font-semibold text-white">$18,340</p>
          <p className="mt-2 text-sm text-slate-400">Available cash after expenses and budgets.</p>
        </article>
        <article className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Monthly income</p>
          <p className="mt-4 text-4xl font-semibold text-white">$7,680</p>
          <p className="mt-2 text-sm text-slate-400">Total income streams tracked this month.</p>
        </article>
        <article className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Expense ratio</p>
          <p className="mt-4 text-4xl font-semibold text-white">34%</p>
          <p className="mt-2 text-sm text-slate-400">Percentage of income spent this period.</p>
        </article>
      </div>

      <section className="grid gap-6 lg:grid-cols-2">
        <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
          <div className="flex items-center justify-between gap-4">
            <div>
              <p className="text-sm uppercase tracking-[0.3em] text-slate-400">Budget progress</p>
              <h2 className="mt-3 text-2xl font-semibold text-white">Goal to save $5,000</h2>
            </div>
            <span className="rounded-full bg-slate-800/70 px-3 py-1 text-xs text-sky-300">42% complete</span>
          </div>
          <div className="mt-6 h-3 overflow-hidden rounded-full bg-slate-800">
            <div className="h-full w-3/5 rounded-full bg-sky-500" />
          </div>
          <p className="mt-4 text-sm text-slate-400">Next target: emergency fund contribution.</p>
        </div>

        <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-slate-400">Recent activity</p>
          <ul className="mt-6 space-y-4 text-sm text-slate-300">
            <li className="rounded-3xl border border-slate-800/90 bg-slate-950/80 p-4">
              <div className="flex items-center justify-between">
                <p className="font-medium text-white">Salary deposit</p>
                <p className="text-sky-300">+ $4,200</p>
              </div>
              <p className="mt-1 text-slate-500">May 15 • Payroll</p>
            </li>
            <li className="rounded-3xl border border-slate-800/90 bg-slate-950/80 p-4">
              <div className="flex items-center justify-between">
                <p className="font-medium text-white">Groceries</p>
                <p className="text-slate-300">- $196</p>
              </div>
              <p className="mt-1 text-slate-500">May 18 • Food & household</p>
            </li>
            <li className="rounded-3xl border border-slate-800/90 bg-slate-950/80 p-4">
              <div className="flex items-center justify-between">
                <p className="font-medium text-white">Subscription</p>
                <p className="text-slate-300">- $29</p>
              </div>
              <p className="mt-1 text-slate-500">May 20 • Software</p>
            </li>
          </ul>
        </div>
      </section>
    </div>
  );
}

export default DashboardPage;
