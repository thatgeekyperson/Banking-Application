class LoanForm:

    __loan_id_counter = 10001

    def __init__(self, gender, loan_amount, loan_term_months):
        self.loan_id = LoanForm.__loan_id_counter
        LoanForm.__loan_id_counter += 1
        self.gender = gender
        # self.married = married
        # self.dependents = dependents
        self.loan_amount = loan_amount
        self.loan_term_months = loan_term_months
        # education, self-employed, applicantIncome, coApplicantIncome,
        # creditHistory, propertyArea, loanStatus

    def __str__(self):
        return str(self.loan_id) + self.gender + str(self.loan_amount) + str(self.loan_term_months)
