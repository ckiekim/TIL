// Callback Hell example
class UserStorage {
    loginUser(id, pwd, onSuccess, onError) {
        setTimeout(() => {
            if (
                (id === 'ellie' && pwd === 'dream') ||
                (id === 'coder' && pwd === 'academy')
            ) {
                onSuccess(id);
            } else {
                onError(new Error('not found'));
            }
        }, 2000);
    }

    getRoles(user, onSuccess, onError) {
        setTimeout(() => {
            if (user === 'ellie') {
                onSuccess({name: 'ellie', role: 'admin'});
            } else {
                onError(new Error('no access'));
            }
        }, 1000);
    }
}

const userStorage = new UserStorage();
userStorage.loginUser(
    'ellie', 
    'dream',
    user => {
        userStorage.getRoles(
            user, 
            userWithRole => {
                console.log(`Hello ${userWithRole.name}, you have a ${userWithRole.role} role`);
                
            },
            error => {
                console.log(error);
            }
        );
    },
    error => {
        console.log(error);
    })