function ReportsPage() {
  return (
    <div className="space-y-8">
      <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Reports</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Generate financial summaries.</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Export report
          </button>
        </div>
      </div>

      <div className="grid gap-6 md:grid-cols-2">
        {[
          { title: 'Monthly performance', subtitle: 'Income vs. expenses' },
          { title: 'Budget vs. actual', subtitle: 'Track budget compliance' },
          { title: 'Savings outlook', subtitle: 'Progress toward goals' },
          { title: 'Category breakdown', subtitle: 'Visualize spending patterns' },
        ].map((item) => (
          <article key={item.title} className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
            <h3 className="text-xl font-semibold text-white">{item.title}</h3>
            <p className="mt-4 text-sm text-slate-400">{item.subtitle}</p>
            <div className="mt-6 rounded-3xl border border-slate-800/70 bg-slate-900/80 p-4 text-sm text-slate-200">
              <p>Ready to run and download as PDF or CSV.</p>
            </div>
          </article>
        ))}
      </div>
    </div>
  );
}

export default ReportsPage;
