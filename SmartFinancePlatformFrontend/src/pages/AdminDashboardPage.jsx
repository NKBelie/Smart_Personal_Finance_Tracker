function AdminDashboardPage() {
  return (
    <div className="space-y-8">
      <header className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Admin dashboard</p>
        <h2 className="mt-2 text-2xl font-semibold text-white">Manage users and system settings.</h2>
        <p className="mt-3 text-slate-400">Review platform usage, approve accounts, and audit recent activity.</p>
      </header>

      <div className="grid gap-6 lg:grid-cols-3">
        <article className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-slate-400">Active users</p>
          <p className="mt-4 text-4xl font-semibold text-white">1,254</p>
        </article>
        <article className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-slate-400">Pending approvals</p>
          <p className="mt-4 text-4xl font-semibold text-white">12</p>
        </article>
        <article className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
          <p className="text-sm uppercase tracking-[0.3em] text-slate-400">Revenue alerts</p>
          <p className="mt-4 text-4xl font-semibold text-white">3</p>
        </article>
      </div>

      <section className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <h3 className="text-xl font-semibold text-white">Recent activity</h3>
            <p className="mt-2 text-sm text-slate-400">Latest user requests and admin actions.</p>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Review requests
          </button>
        </div>

        <div className="mt-6 space-y-4 text-sm text-slate-300">
          {[
            'Account approval requested for user @mike_94',
            'System backup completed successfully',
            'Analytics export ready for May financial report',
          ].map((item) => (
            <div key={item} className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-4">
              {item}
            </div>
          ))}
        </div>
      </section>
    </div>
  );
}

export default AdminDashboardPage;
