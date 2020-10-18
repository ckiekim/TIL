class UserStorage {
    delay(ms) {
        return new Promise(resolve => setTimeout(resolve, ms));
    }

    async loginUser(id, pwd) {
        await this.delay(2000);
        if (
            (id === 'ellie' && pwd === 'dream') ||
            (id === 'coder' && pwd === 'academy')
        ) {
            return id;
        } else {
            throw new Error('not found');
        }
    }

    async getRoles(user) {
        await this.delay(1000);
        if (user === 'ellie') {
            return {name: 'ellie', role: 'admin'};
        } else {
            throw new Error('not found');
        }
    }
}

const userStorage = new UserStorage();
async function userRole(id, pwd) {
    let user = await userStorage.loginUser(id, pwd);
    userStorage.getRoles(user)
        .then(userRole => {
            console.log(`Hello ${userRole.name}, you have a ${userRole.role} role`);
        })
        .catch(console.log);
}
userRole('ellie', 'dream');