function BudgetPage() {
  return (
    <div className="space-y-8">
      <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Budgets</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Plan your spending categories.</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Create budget
          </button>
        </div>
      </div>

      <div className="grid gap-6 xl:grid-cols-3">
        {[
          { name: 'Essentials', limit: '$2,400', used: '$1,880' },
          { name: 'Discretionary', limit: '$980', used: '$540' },
          { name: 'Savings', limit: '$1,200', used: '$760' },
        ].map((item) => (
          <article key={item.name} className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5 shadow-glow">
            <h3 className="text-xl font-semibold text-white">{item.name}</h3>
            <p className="mt-4 text-3xl font-semibold text-sky-300">{item.used}</p>
            <p className="text-sm text-slate-400">of {item.limit} budgeted</p>
            <div className="mt-5 h-3 overflow-hidden rounded-full bg-slate-800">
              <div className="h-full w-3/4 rounded-full bg-sky-500" />
            </div>
          </article>
        ))}
      </div>
    </div>
  );
}

export default BudgetPage;
