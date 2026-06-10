function UserProfilePage() {
  return (
    <div className="space-y-8">
      <section className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-6 shadow-glow">
        <div className="flex flex-col gap-4 sm:flex-row sm:items-center sm:justify-between">
          <div>
            <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Profile</p>
            <h2 className="mt-2 text-2xl font-semibold text-white">Your account details.</h2>
          </div>
          <button className="rounded-2xl bg-sky-500 px-4 py-2 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Edit profile
          </button>
        </div>

        <div className="mt-8 grid gap-4 md:grid-cols-2">
          <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5">
            <p className="text-sm text-slate-400">Full name</p>
            <p className="mt-2 text-lg font-semibold text-white">Jane Doe</p>
          </div>
          <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5">
            <p className="text-sm text-slate-400">Email</p>
            <p className="mt-2 text-lg font-semibold text-white">jane.doe@example.com</p>
          </div>
          <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5">
            <p className="text-sm text-slate-400">Username</p>
            <p className="mt-2 text-lg font-semibold text-white">janedoe</p>
          </div>
          <div className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-5">
            <p className="text-sm text-slate-400">Role</p>
            <p className="mt-2 text-lg font-semibold text-white">Standard user</p>
          </div>
        </div>
      </section>

      <section className="rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6 shadow-glow">
        <h3 className="text-xl font-semibold text-white">Security</h3>
        <div className="mt-5 grid gap-4 md:grid-cols-2">
          <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-5">
            <p className="text-sm text-slate-400">Password</p>
            <p className="mt-2 text-sm text-slate-200">*************</p>
            <button className="mt-4 rounded-2xl bg-slate-800/70 px-4 py-2 text-sm text-slate-200 transition hover:bg-slate-700">
              Change password
            </button>
          </div>
          <div className="rounded-3xl border border-slate-800/80 bg-slate-900/80 p-5">
            <p className="text-sm text-slate-400">Two-factor authentication</p>
            <p className="mt-2 text-sm text-slate-200">Disabled</p>
            <button className="mt-4 rounded-2xl bg-slate-800/70 px-4 py-2 text-sm text-slate-200 transition hover:bg-slate-700">
              Enable 2FA
            </button>
          </div>
        </div>
      </section>
    </div>
  );
}

export default UserProfilePage;
