import { Link } from 'react-router-dom';

function RegisterPage() {
  return (
    <div className="min-h-screen bg-slate-950 px-4 py-10 sm:px-6 lg:px-8">
      <div className="mx-auto flex max-w-3xl flex-col gap-8 rounded-[2rem] border border-slate-800/80 bg-slate-900/80 p-8 shadow-glow backdrop-blur-xl">
        <div className="space-y-2">
          <p className="text-sm uppercase tracking-[0.3em] text-sky-300/70">Create account</p>
          <h1 className="text-3xl font-semibold text-white">Start tracking your money smarter.</h1>
          <p className="max-w-2xl text-slate-400">Register and begin building budgets, tracking expenses, and planning savings goals.</p>
        </div>

        <form className="grid gap-6 rounded-3xl border border-slate-800/80 bg-slate-950/90 p-6">
          <label className="grid gap-2 text-sm text-slate-200">
            Full name
            <input className="rounded-2xl border border-slate-700/80 bg-slate-900/80 px-4 py-3 text-slate-100 outline-none transition focus:border-sky-400/80" placeholder="Jane Doe" />
          </label>
          <label className="grid gap-2 text-sm text-slate-200">
            Email
            <input type="email" className="rounded-2xl border border-slate-700/80 bg-slate-900/80 px-4 py-3 text-slate-100 outline-none transition focus:border-sky-400/80" placeholder="email@example.com" />
          </label>
          <label className="grid gap-2 text-sm text-slate-200">
            Username
            <input className="rounded-2xl border border-slate-700/80 bg-slate-900/80 px-4 py-3 text-slate-100 outline-none transition focus:border-sky-400/80" placeholder="username" />
          </label>
          <label className="grid gap-2 text-sm text-slate-200">
            Password
            <input type="password" className="rounded-2xl border border-slate-700/80 bg-slate-900/80 px-4 py-3 text-slate-100 outline-none transition focus:border-sky-400/80" placeholder="password" />
          </label>
          <button className="rounded-2xl bg-sky-500 px-5 py-3 text-sm font-semibold text-slate-950 transition hover:bg-sky-400">
            Register account
          </button>
        </form>

        <p className="text-center text-sm text-slate-400">
          Already registered?{' '}
          <Link to="/login" className="font-semibold text-sky-300 hover:text-sky-200">
            Sign in
          </Link>
          .
        </p>
      </div>
    </div>
  );
}

export default RegisterPage;
