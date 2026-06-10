function IncomePage() {
  return (
    <div className="space-y-8">
      <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Income</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Track revenue sources</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Add income
          </button>
        </div>
      </div>

      <div className="grid gap-6 lg:grid-cols-3">
        {[
          { name: 'Salary', amount: '$4,200', status: 'Primary source' },
          { name: 'Freelance', amount: '$1,320', status: 'Contract work' },
          { name: 'Interest', amount: '$120', status: 'Savings earnings' },
        ].map((item) => (
          <article key={item.name} className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5 shadow-glow">
            <h3 className="text-xl font-semibold text-white">{item.name}</h3>
            <p className="mt-4 text-3xl font-semibold text-sky-300">{item.amount}</p>
            <p className="mt-3 text-sm text-slate-400">{item.status}</p>
          </article>
        ))}
      </div>
    </div>
  );
}

export default IncomePage;
