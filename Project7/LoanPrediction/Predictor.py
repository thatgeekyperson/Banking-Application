import pickle
import sklearn
from sklearn import svm

class Predictor:

    def predict(data):

        svmodel=pickle.load(open('modelSVM.sav','rb'))
        result=svmodel.predict(data)

        return result[0]