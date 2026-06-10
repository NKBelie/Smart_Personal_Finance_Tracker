package com.FinanceTracker.smartFinancePlatform.dto;

import com.FinanceTracker.smartFinancePlatform.model.*;
import com.FinanceTracker.smartFinancePlatform.service.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DtoMapper {

    private final RoleService roleService;
    private final UsersService usersService;
    private final IncomeCategoryService incomeCategoryService;
    private final ExpenseCategoryService expenseCategoryService;

    public RoleDto toDto(Role role) {
        return RoleDto.builder()
                .id(role.getId())
                .name(role.getName())
                .description(role.getDescription())
                .build();
    }

    public UsersDto toDto(Users user) {
        return UsersDto.builder()
                .id(user.getId())
                .fullName(user.getFullName())
                .username(user.getUsername())
                .email(user.getEmail())
                .profilePictureUrl(user.getProfilePictureUrl())
                .status(user.getStatus())
                .roleId(user.getRole() != null ? user.getRole().getId() : null)
                .build();
    }

    public IncomeCategoryDto toDto(IncomeCategory category) {
        return IncomeCategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public ExpenseCategoryDto toDto(ExpenseCategory category) {
        return ExpenseCategoryDto.builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }

    public IncomeDto toDto(Income income) {
        return IncomeDto.builder()
                .id(income.getId())
                .userId(income.getUser().getId())
                .categoryId(income.getCategory() != null ? income.getCategory().getId() : null)
                .amount(income.getAmount())
                .source(income.getSource())
                .description(income.getDescription())
                .date(income.getDate())
                .build();
    }

    public ExpenseDto toDto(Expense expense) {
        return ExpenseDto.builder()
                .id(expense.getId())
                .userId(expense.getUser().getId())
                .categoryId(expense.getCategory() != null ? expense.getCategory().getId() : null)
                .amount(expense.getAmount())
                .paymentMethod(expense.getPaymentMethod())
                .description(expense.getDescription())
                .date(expense.getDate())
                .build();
    }

    public BudgetDto toDto(Budget budget) {
        return BudgetDto.builder()
                .id(budget.getId())
                .userId(budget.getUser().getId())
                .budgetType(budget.getBudgetType())
                .categoryId(budget.getCategory() != null ? budget.getCategory().getId() : null)
                .amount(budget.getAmount())
                .periodStart(budget.getPeriodStart())
                .periodEnd(budget.getPeriodEnd())
                .status(budget.getStatus())
                .build();
    }

    public SavingsGoalDto toDto(SavingsGoal goal) {
        return SavingsGoalDto.builder()
                .id(goal.getId())
                .userId(goal.getUser().getId())
                .name(goal.getName())
                .targetAmount(goal.getTargetAmount())
                .currentAmount(goal.getCurrentAmount())
                .targetDate(goal.getTargetDate())
                .status(goal.getStatus())
                .build();
    }

    public TransactionDto toDto(Transaction transaction) {
        return TransactionDto.builder()
                .id(transaction.getId())
                .userId(transaction.getUser().getId())
                .transactionType(transaction.getTransactionType())
                .relatedId(transaction.getRelatedId())
                .relatedType(transaction.getRelatedType())
                .amount(transaction.getAmount())
                .category(transaction.getCategory())
                .date(transaction.getDate())
                .description(transaction.getDescription())
                .build();
    }

    public NotificationDto toDto(Notification notification) {
        return NotificationDto.builder()
                .id(notification.getId())
                .userId(notification.getUser().getId())
                .title(notification.getTitle())
                .message(notification.getMessage())
                .notificationType(notification.getNotificationType())
                .isRead(notification.getIsRead())
                .build();
    }

    public ReportDto toDto(Report report) {
        return ReportDto.builder()
                .id(report.getId())
                .userId(report.getUser().getId())
                .reportType(report.getReportType())
                .periodStart(report.getPeriodStart())
                .periodEnd(report.getPeriodEnd())
                .status(report.getStatus())
                .generatedAt(report.getGeneratedAt())
                .downloadUrl(report.getDownloadUrl())
                .build();
    }

    public AuditLogDto toDto(AuditLog auditLog) {
        return AuditLogDto.builder()
                .id(auditLog.getId())
                .userId(auditLog.getUser() != null ? auditLog.getUser().getId() : null)
                .eventType(auditLog.getEventType())
                .eventDetails(auditLog.getEventDetails())
                .ipAddress(auditLog.getIpAddress())
                .createdAt(auditLog.getCreatedAt())
                .build();
    }

    public Users toEntity(UsersDto dto) {
        Users user = new Users();
        user.setId(dto.getId());
        user.setFullName(dto.getFullName());
        user.setUsername(dto.getUsername());
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setProfilePictureUrl(dto.getProfilePictureUrl());
        user.setStatus(dto.getStatus());
        if (dto.getRoleId() != null) {
            Role role = roleService.findById(dto.getRoleId())
                    .orElseThrow(() -> new IllegalArgumentException("Role not found: " + dto.getRoleId()));
            user.setRole(role);
        }
        return user;
    }

    public Income toEntity(IncomeDto dto) {
        Income income = new Income();
        income.setId(dto.getId());
        income.setAmount(dto.getAmount());
        income.setSource(dto.getSource());
        income.setDescription(dto.getDescription());
        income.setDate(dto.getDate());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            income.setUser(user);
        }
        if (dto.getCategoryId() != null) {
            IncomeCategory category = incomeCategoryService.findById(dto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Income category not found: " + dto.getCategoryId()));
            income.setCategory(category);
        }
        return income;
    }

    public Expense toEntity(ExpenseDto dto) {
        Expense expense = new Expense();
        expense.setId(dto.getId());
        expense.setAmount(dto.getAmount());
        expense.setPaymentMethod(dto.getPaymentMethod());
        expense.setDescription(dto.getDescription());
        expense.setDate(dto.getDate());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            expense.setUser(user);
        }
        if (dto.getCategoryId() != null) {
            ExpenseCategory category = expenseCategoryService.findById(dto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Expense category not found: " + dto.getCategoryId()));
            expense.setCategory(category);
        }
        return expense;
    }

    public Budget toEntity(BudgetDto dto) {
        Budget budget = new Budget();
        budget.setId(dto.getId());
        budget.setBudgetType(dto.getBudgetType());
        budget.setAmount(dto.getAmount());
        budget.setPeriodStart(dto.getPeriodStart());
        budget.setPeriodEnd(dto.getPeriodEnd());
        budget.setStatus(dto.getStatus());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            budget.setUser(user);
        }
        if (dto.getCategoryId() != null) {
            ExpenseCategory category = expenseCategoryService.findById(dto.getCategoryId())
                    .orElseThrow(() -> new IllegalArgumentException("Expense category not found: " + dto.getCategoryId()));
            budget.setCategory(category);
        }
        return budget;
    }

    public SavingsGoal toEntity(SavingsGoalDto dto) {
        SavingsGoal goal = new SavingsGoal();
        goal.setId(dto.getId());
        goal.setName(dto.getName());
        goal.setTargetAmount(dto.getTargetAmount());
        goal.setCurrentAmount(dto.getCurrentAmount());
        goal.setTargetDate(dto.getTargetDate());
        goal.setStatus(dto.getStatus());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            goal.setUser(user);
        }
        return goal;
    }

    public Transaction toEntity(TransactionDto dto) {
        Transaction transaction = new Transaction();
        transaction.setId(dto.getId());
        transaction.setTransactionType(dto.getTransactionType());
        transaction.setRelatedId(dto.getRelatedId());
        transaction.setRelatedType(dto.getRelatedType());
        transaction.setAmount(dto.getAmount());
        transaction.setCategory(dto.getCategory());
        transaction.setDate(dto.getDate());
        transaction.setDescription(dto.getDescription());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            transaction.setUser(user);
        }
        return transaction;
    }

    public Notification toEntity(NotificationDto dto) {
        Notification notification = new Notification();
        notification.setId(dto.getId());
        notification.setTitle(dto.getTitle());
        notification.setMessage(dto.getMessage());
        notification.setNotificationType(dto.getNotificationType());
        notification.setIsRead(dto.getIsRead());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            notification.setUser(user);
        }
        return notification;
    }

    public Report toEntity(ReportDto dto) {
        Report report = new Report();
        report.setId(dto.getId());
        report.setReportType(dto.getReportType());
        report.setPeriodStart(dto.getPeriodStart());
        report.setPeriodEnd(dto.getPeriodEnd());
        report.setStatus(dto.getStatus());
        report.setDownloadUrl(dto.getDownloadUrl());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            report.setUser(user);
        }
        return report;
    }

    public AuditLog toEntity(AuditLogDto dto) {
        AuditLog log = new AuditLog();
        log.setId(dto.getId());
        log.setEventType(dto.getEventType());
        log.setEventDetails(dto.getEventDetails());
        log.setIpAddress(dto.getIpAddress());
        if (dto.getUserId() != null) {
            Users user = usersService.findById(dto.getUserId())
                    .orElseThrow(() -> new IllegalArgumentException("User not found: " + dto.getUserId()));
            log.setUser(user);
        }
        return log;
    }
}
