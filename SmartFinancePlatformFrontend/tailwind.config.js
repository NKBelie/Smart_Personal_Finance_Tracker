export default {
  content: ['./index.html', './src/**/*.{js,jsx}'],
  darkMode: 'class',
  theme: {
    extend: {
      boxShadow: {
        glow: '0 24px 80px rgba(14, 165, 233, 0.18)',
      },
      colors: {
        surface: '#111827',
        panel: '#111827',
      },
    },
  },
  plugins: [],
};
