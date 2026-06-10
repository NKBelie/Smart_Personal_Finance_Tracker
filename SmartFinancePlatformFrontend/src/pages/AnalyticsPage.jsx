function AnalyticsPage() {
  return (
    <div className="space-y-8">
      <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Analytics</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Understand your financial trends.</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Refresh data
          </button>
        </div>
      </div>

      <div className="grid gap-6 xl:grid-cols-2">
        <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
          <h3 className="text-xl font-semibold text-white">Spending by category</h3>
          <div className="mt-6 space-y-4 text-sm text-slate-300">
            <div className="flex items-center justify-between">
              <span>Housing</span>
              <span className="text-slate-100">38%</span>
            </div>
            <div className="h-2 w-full overflow-hidden rounded-full bg-slate-800">
              <div className="h-full w-3/5 rounded-full bg-sky-500" />
            </div>
            <div className="flex items-center justify-between">
              <span>Food</span>
              <span className="text-slate-100">18%</span>
            </div>
            <div className="h-2 w-full overflow-hidden rounded-full bg-slate-800">
              <div className="h-full w-2/5 rounded-full bg-sky-400" />
            </div>
          </div>
        </div>

        <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
          <h3 className="text-xl font-semibold text-white">Cash flow trends</h3>
          <div className="mt-6 grid gap-4 text-slate-300">
            {[
              { subtitle: 'Income growth', value: '+14%' },
              { subtitle: 'Expense reduction', value: '-8%' },
              { subtitle: 'Savings increase', value: '+9%' },
            ].map((item) => (
              <div key={item.subtitle} className="rounded-3xl bg-slate-900/80 p-4">
                <p className="text-sm text-slate-400">{item.subtitle}</p>
                <p className="mt-2 text-2xl font-semibold text-white">{item.value}</p>
              </div>
            ))}
          </div>
        </div>
      </div>
    </div>
  );
}

export default AnalyticsPage;
