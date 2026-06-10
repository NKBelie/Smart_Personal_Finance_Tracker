# Smart Personal Finance & Financial Insights Platform

## 1. Project Charter

**Project Name:** Smart Finance Platform

**Purpose:** Build a professional fintech-style personal finance management system for portfolio demonstration and learning.

**Objectives:**

- Enable users to track income, expenses, budgets, savings goals, and financial health.
- Provide analytics, reports, and personalized recommendations.
- Secure the system with Spring Security, JWT authentication, and role-based access control.
- Use PostgreSQL for persistent storage and Spring Boot for the backend.

**Scope:**

- User authentication, profile management, and role-based access.
- Income, expense, budget, savings goal, analytics, report generation, and notifications.
- Administrator capabilities for user and platform-level oversight.

**Stakeholders:**

- Project Owner / Developer
- End users (standard users)
- Administrators
- Reviewers / Portfolio evaluators

**Success Criteria:**

- Working Spring Boot backend with authenticated REST APIs.
- Persisted financial data in PostgreSQL.
- Clear documentation and architecture artifacts.
- Demonstrable analytics and reporting flows.

---

## 2. Scope Statement

**In scope:**

- Registration, login, JWT-based authentication, logout, password management.
- CRUD APIs for income, expenses, budgets, savings goals.
- Dashboard metrics, spending analytics, savings analytics, budget utilization.
- Role management for standard users and administrators.
- PostgreSQL schema and entity modeling.
- Project documentation, tests, deployment guidance.

**Out of scope for MVP:**

- Full React frontend.
- Docker containerization and CI/CD pipelines.
- PDF/Excel export implementation beyond API design.
- Advanced AI-powered recommendations.

---

## 3. Functional Requirements

### User Management

- Register new user.
- Login and logout.
- Update user profile.
- Change password.
- Upload profile picture (API placeholder).
- Deactivate account.

### Dashboard

- Display total income, total expenses, total savings, net balance.
- Monthly budget status and savings progress.
- Financial health score.
- Recent transactions overview.

### Income Management

- Add, edit, delete, search, filter income.
- Income categories: Salary, Business, Freelance, Scholarship, Investment, Gift, Other.
- Track amount, source, category, date, description.

### Expense Management

- Add, edit, delete, search, filter expenses.
- Expense categories: Food, Transport, Rent, Utilities, Healthcare, Education, Shopping, Entertainment, Internet, Insurance, Other.
- Track amount, category, date, description, payment method.

### Budget Management

- Create, edit, delete budgets.
- Monthly budgets and category budgets.
- Budget utilization, remaining budget, overspending alerts.

### Savings Goals

- Create savings goals with target amount and target date.
- Monitor progress, remaining amount, estimated completion date.

### Analytics

- Spending by category, monthly/weekly/yearly trends.
- Income source breakdown, growth, monthly comparisons.
- Savings trends and goal achievement.
- Budget vs actual spending and overspending categories.

### Financial Health Score

- Calculate based on savings rate, budget compliance, expense control, income stability.
- Display status: Poor, Fair, Good, Excellent.

### Recommendations

- Suggest reducing spending on categories like Food.
- Encourage increasing savings.
- Warn when budgets are exceeded or goals are behind schedule.

### Reports

- Generate monthly, quarterly, yearly reports.
- Export design for PDF and Excel.

### Notifications

- Budget limit exceeded.
- Savings milestone reached.
- Monthly report ready.

### Administrator

- Manage users.
- View platform statistics.
- Generate system reports.
- Monitor platform activity.

---

## 4. Non-Functional Requirements

- Secure: BCrypt hashing, JWT authentication, role-based access control.
- Responsive: Mobile-first UI design.
- Scalable: Layered Spring Boot architecture and PostgreSQL backend.
- Reliable: Input validation, error handling, database constraints.
- Maintainable: Modular package structure and clean API design.
- User-friendly: Intuitive dashboard and workflows.

---

## 5. User Stories

1. As a user, I want to register so I can securely access the platform.
2. As a user, I want to login so I can access my financial data.
3. As a user, I want to add income entries to track my earnings.
4. As a user, I want to add expense entries to monitor spending.
5. As a user, I want to set budgets so I can control my spending.
6. As a user, I want to create savings goals so I can plan for future purchases.
7. As a user, I want to see analytics so I can understand my spending habits.
8. As a user, I want notifications when I exceed budgets.
9. As a user, I want a financial health score so I can assess my financial condition.
10. As an administrator, I want to manage users and review platform statistics.

---

## 6. Use Case Diagram

**Actors:** Standard User, Administrator.

**Primary use cases:**

- Register / Login / Logout
- Manage Profile
- Manage Income
- Manage Expenses
- Manage Budgets
- Manage Savings Goals
- View Dashboard
- View Analytics
- Generate Reports
- Receive Notifications
- Admin: Manage Users
- Admin: View Platform Stats

> A visual use case diagram can be derived from these actors and flows.

---

## 7. Use Case Descriptions

### Register

- Actor: Standard User
- Description: Create a new account with full name, username, email, and password.
- Preconditions: None.
- Postconditions: User account created and able to login.

### Login

- Actor: Standard User
- Description: Authenticate with credentials to receive JWT.
- Preconditions: Registered user exists.
- Postconditions: Authenticated session token issued.

### Manage Income

- Actor: Standard User
- Description: Add, edit, delete, search, and filter income records.
- Preconditions: User logged in.
- Postconditions: Income data stored and included in dashboard metrics.

### Manage Expenses

- Actor: Standard User
- Description: Add, edit, delete, search, and filter expense records.
- Preconditions: User logged in.
- Postconditions: Expense data stored and included in analytics.

### Manage Budgets

- Actor: Standard User
- Description: Create and track budgets by month or category.
- Preconditions: User logged in.
- Postconditions: Budget status updates and alerts are available.

### Manage Savings Goals

- Actor: Standard User
- Description: Create goals with target amount/date and track progress.
- Preconditions: User logged in.
- Postconditions: Goal progress displayed on dashboard.

### View Analytics

- Actor: Standard User
- Description: Review spending, income, savings, and budget analytics.
- Preconditions: Data exists for the user.
- Postconditions: Insights displayed.

### Admin Manage Users

- Actor: Administrator
- Description: View, update, deactivate platform users.
- Preconditions: Admin logged in.
- Postconditions: User management actions completed.

---

## 8. ER Diagram

**Entities:**

- User
- Role
- Income
- Expense
- IncomeCategory
- ExpenseCategory
- Budget
- SavingsGoal
- Transaction
- Notification
- Report
- AuditLog

**Relationships:**

- User has many Income, Expense, Budget, SavingsGoal, Transaction, Notification, Report, AuditLog.
- User has one Role.
- Budget and SavingsGoal are owned by User.
- Transaction may link to Income or Expense.

> Use this entity list to build an ER diagram in a diagramming tool.

---

## 9. Relational Schema

### users

- id (PK)
- full_name
- username
- email
- password_hash
- profile_picture_url
- status
- created_at
- updated_at

### roles

- id (PK)
- name
- description

### incomes

- id (PK)
- user_id (FK -> users.id)
- category_id (FK -> income_categories.id)
- amount
- source
- description
- date
- created_at
- updated_at

### income_categories

- id (PK)
- name

### expenses

- id (PK)
- user_id (FK -> users.id)
- category_id (FK -> expense_categories.id)
- amount
- payment_method
- description
- date
- created_at
- updated_at

### expense_categories

- id (PK)
- name

### budgets

- id (PK)
- user_id (FK -> users.id)
- budget_type
- category_id (FK -> expense_categories.id, nullable)
- amount
- period_start
- period_end
- status
- created_at
- updated_at

### savings_goals

- id (PK)
- user_id (FK -> users.id)
- name
- target_amount
- current_amount
- target_date
- status
- created_at
- updated_at

### transactions

- id (PK)
- user_id (FK -> users.id)
- transaction_type
- related_id
- amount
- category
- date
- description
- created_at

### notifications

- id (PK)
- user_id (FK -> users.id)
- title
- message
- notification_type
- is_read
- created_at

### reports

- id (PK)
- user_id (FK -> users.id)
- report_type
- period_start
- period_end
- status
- generated_at
- download_url

### audit_logs

- id (PK)
- user_id (FK -> users.id)
- event_type
- event_details
- ip_address
- created_at

---

## 10. Data Dictionary

### users

- `id`: Unique user identifier.
- `full_name`: Display name.
- `username`: Login handle.
- `email`: User email.
- `password_hash`: BCrypt password storage.
- `profile_picture_url`: Optional profile picture.
- `status`: ACTIVE or DEACTIVATED.
- `created_at`, `updated_at`: Audit timestamps.

### roles

- `id`: Unique role identifier.
- `name`: Role name (ROLE_USER, ROLE_ADMIN).
- `description`: Purpose of the role.

### incomes

- `user_id`: Owner of the income.
- `category_id`: Category reference.
- `amount`: Income amount.
- `source`: Income source label.
- `description`: Optional notes.
- `date`: Income date.

### expenses

- `user_id`: Owner of the expense.
- `payment_method`: e.g., Cash, Card, Digital.

### budgets

- `budget_type`: MONTHLY or CATEGORY.
- `period_start`, `period_end`: Budget interval.
- `status`: VALID, OVERSPIENT.

### savings_goals

- `target_amount`: Goal amount.
- `current_amount`: Saved amount.
- `target_date`: Goal deadline.
- `status`: ON_TRACK, AT_RISK, COMPLETED.

### transactions

- `transaction_type`: INCOME or EXPENSE.
- `related_id`: Linked income/expense.

### notifications

- `notification_type`: BUDGET_ALERT, GOAL_MILESTONE, REPORT_READY.
- `is_read`: Boolean flag.

### reports

- `report_type`: MONTHLY, QUARTERLY, YEARLY.
- `download_url`: Export link.

### audit_logs

- `event_type`: LOGIN, DATA_CHANGE, SECURITY_EVENT.

---

## 11. PostgreSQL Scripts

See `database-schema.sql` for table creation scripts, constraints, and sample category seed values.

---

## 12. Spring Boot Architecture

**Layered architecture:**

- `controller` layer for REST endpoints.
- `service` layer for business logic.
- `repository` layer for JPA persistence.
- `model/entity` layer for domain objects.
- `security` layer for JWT, authentication, and authorization.
- `dto` layer for API request/responses.

**Key components:**

- Spring Boot Web MVC
- Spring Data JPA
- Spring Security
- Validation
- PostgreSQL runtime dependency

---

## 13. API Documentation

### Authentication

- `POST /api/auth/register` -> register a new user.
- `POST /api/auth/login` -> authenticate and return JWT.
- `POST /api/auth/logout` -> revoke session token.
- `POST /api/auth/refresh` -> refresh JWT.

### Users

- `GET /api/users/{id}` -> get user profile.
- `PUT /api/users/{id}` -> update profile.
- `PATCH /api/users/{id}/password` -> change password.
- `DELETE /api/users/{id}` -> deactivate account.

### Income

- `GET /api/incomes` -> list incomes.
- `POST /api/incomes` -> create income.
- `GET /api/incomes/{id}` -> retrieve income.
- `PUT /api/incomes/{id}` -> update income.
- `DELETE /api/incomes/{id}` -> delete income.

### Expenses

- `GET /api/expenses`
- `POST /api/expenses`
- `GET /api/expenses/{id}`
- `PUT /api/expenses/{id}`
- `DELETE /api/expenses/{id}`

### Budgets

- `GET /api/budgets`
- `POST /api/budgets`
- `GET /api/budgets/{id}`
- `PUT /api/budgets/{id}`
- `DELETE /api/budgets/{id}`

### Savings Goals

- `GET /api/savings-goals`
- `POST /api/savings-goals`
- `GET /api/savings-goals/{id}`
- `PUT /api/savings-goals/{id}`
- `DELETE /api/savings-goals/{id}`

### Reports

- `POST /api/reports/generate` -> generate a report.
- `GET /api/reports` -> retrieve reports.
- `GET /api/reports/{id}/download` -> download report.

### Analytics

- `GET /api/analytics/spending`
- `GET /api/analytics/income`
- `GET /api/analytics/savings`
- `GET /api/analytics/budget`

---

## 14. UI Wireframes

**Pages:**

- Landing page
- Login page
- Registration page
- Dashboard
- Income page
- Expense page
- Budget page
- Savings Goals page
- Analytics page
- Reports page
- User profile page
- Admin dashboard

**Design notes:**

- Use Tailwind CSS with a modern dashboard layout.
- Mobile-first responsive grid.
- Dark mode support.
- Cards for metrics, charts for trends, tables for transactions.

---

## 15. Testing Plan

**Unit tests:** Service and security logic.
**Integration tests:** API flows with Spring Boot test support.
**Validation tests:** Input constraints and DTO validation.
**Security tests:** Authentication and access control.
**Manual testing:** Dashboard, CRUD flows, analytics, and reports.

---

## 16. Deployment Plan

**Local run:** `./mvnw spring-boot:run` with PostgreSQL connection in `application.properties`.
**Production deployment:**

- Package with `./mvnw package`.
- Deploy backend to cloud or container platform.
- Use PostgreSQL managed instance.
- Configure environment variables for JWT secret and DB credentials.

---

## 17. Future Enhancements

- React frontend.
- Docker and containerization.
- CI/CD pipeline.
- Cloud deployment on Azure / AWS.
- PDF/Excel export.
- AI-powered recommendations.
- Multi-currency support.
- Recurring transactions and subscription tracking.

---

## 18. Project Timeline

**Week 1:** Requirements, architecture, data model, authentication.
**Week 2:** Income/expense management and dashboard.
**Week 3:** Budgets, savings goals, analytics.
**Week 4:** Reports, notifications, admin features, testing.
**Week 5:** Polish UI, documentation, deployment readiness.

---

## 19. Risk Analysis

**Risks:**

- Authentication and security gaps.
- Incomplete data validation.
- Complexity of analytics implementation.
- PostgreSQL schema changes after development.

**Mitigations:**

- Use Spring Security and BCrypt.
- Add validation annotations and DTO checks.
- Start with minimal analytics and expand incrementally.
- Keep schema versioned and use migration scripts.

---

## 20. Budget Estimate

**Development effort:** 4-6 weeks for a polished MVP.
**Hosting:** PostgreSQL and backend hosting costs depend on target environment.
**Tools:** Free/open-source stack; optional paid design or CI services if desired.
