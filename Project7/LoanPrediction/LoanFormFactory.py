from Client import Client
from LoanForm import LoanForm


class LoanFormFactory:

    @staticmethod
    async def create_loan_form(gender, loan_amount, loan_term_months, client: Client):
        loan_form_1 = LoanForm(gender, loan_amount, loan_term_months)

        from models.LoanFormModel import LoanFormModel
        await LoanFormModel.create(loan_id=loan_form_1.loan_id, gender=loan_form_1.gender,
                                   loan_amount=loan_form_1.loan_amount, loan_term_months=loan_form_1.loan_term_months)

        client.loan_id = loan_form_1.loan_id
        client.loanPredictionForm = loan_form_1

        from models.ClientModel import ClientModel
        client_model = await ClientModel.query.where(ClientModel.bank_id == client.bank_id).gino.first()
        if client_model:
            await client_model.update(loan_id=loan_form_1.loan_id).apply()
