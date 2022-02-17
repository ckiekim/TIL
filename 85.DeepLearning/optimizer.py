import numpy as np

# SGD(Stochastic Gradient Descent): 확률적 경사 하강법
class SGD:
    def __init__(self, lr=0.01):
        self.lr = lr
        
    def update(self, params, grads):
        for i in range(params.shape[0]):
            params[i] -= self.lr * grads[i]
            
