function ExpensePage() {
  return (
    <div className="space-y-8">
      <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Expenses</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Monitor spending habits</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Add expense
          </button>
        </div>
      </div>

      <div className="grid gap-6 md:grid-cols-2">
        {[
          { category: 'Housing', spent: '$1,220', trend: 'Stable' },
          { category: 'Transportation', spent: '$320', trend: 'Up 7%' },
          { category: 'Groceries', spent: '$420', trend: 'Down 4%' },
          { category: 'Entertainment', spent: '$180', trend: 'Steady' },
        ].map((item) => (
          <article key={item.category} className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5 shadow-glow">
            <div className="flex items-center justify-between">
              <h3 className="text-lg font-semibold text-white">{item.category}</h3>
              <span className="rounded-full bg-slate-800/80 px-3 py-1 text-xs uppercase tracking-[0.24em] text-slate-300">{item.trend}</span>
            </div>
            <p className="mt-5 text-3xl font-semibold text-white">{item.spent}</p>
            <p className="mt-3 text-sm text-slate-400">Review category goals, limits, and monthly variance.</p>
          </article>
        ))}
      </div>
    </div>
  );
}

export default ExpensePage;
