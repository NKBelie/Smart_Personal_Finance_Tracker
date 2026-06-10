function SavingsGoalsPage() {
  return (
    <div className="space-y-8">
      <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Savings goals</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Keep your milestones visible.</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Add goal
          </button>
        </div>
      </div>

      <div className="grid gap-6 lg:grid-cols-2">
        {[
          { goal: 'Emergency fund', target: '$6,000', progress: '75%' },
          { goal: 'Vacation trip', target: '$2,800', progress: '38%' },
        ].map((item) => (
          <article key={item.goal} className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
            <div className="mb-5 flex items-center justify-between gap-4">
              <div>
                <h3 className="text-xl font-semibold text-white">{item.goal}</h3>
                <p className="text-sm text-slate-400">Target: {item.target}</p>
              </div>
              <span className="rounded-full bg-slate-800/80 px-3 py-1 text-xs uppercase tracking-[0.24em] text-sky-300">{item.progress}</span>
            </div>
            <div className="h-3 overflow-hidden rounded-full bg-slate-800">
              <div className="h-full w-4/5 rounded-full bg-sky-400" />
            </div>
            <p className="mt-4 text-sm text-slate-400">Automatic transfers can help you hit your target faster.</p>
          </article>
        ))}
      </div>
    </div>
  );
}

export default SavingsGoalsPage;
