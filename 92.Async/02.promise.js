// State: pending -> fulfilled or rejected
// Producer vs Consumer

// 1. Producer
// 새로운 Promise가 만들어질때 executor가 자덩으로 실행됨.
const promise = new Promise((resolve, reject) => {
    // doing some heavy work (network, read files)
    console.log('doing something...');
    setTimeout(() => {
        resolve('ellie');
        //reject(new Error('no network'));
    }, 2000);
});

// 2. Consumers: then, catch, finally
promise
    .then(value => {
        console.log(value);
    })
    .catch(error => {
        console.log(error);
    })
    .finally(() => {
        console.log('finally');
    });

// 3. Promise chaining
const fetchNumber = new Promise((resolve, reject) => {
    setTimeout(() => resolve(1), 1000);
});

fetchNumber
    .then(num => num * 2)
    .then(num => num * 3)
    .then(num => {
        return new Promise((resolve, reject) => {
            setTimeout(() => resolve(num - 1), 1000);
        });
    })
    .then(num => console.log(num));

// 4. Error handling
const getHen = () => {
    return new Promise((resolve, reject) => {
        setTimeout(() => resolve('hen'), 1000);
    });
}

const getEgg = hen =>
    new Promise((resolve, reject) => {
        //setTimeout(() => resolve(`${hen} --> egg`), 1000);
        setTimeout(() => reject(new Error(`${hen} --> egg`)), 1000);
    });

const cook = egg =>
    new Promise((resolve, reject) => {
        setTimeout(() => resolve(`${egg} --> egg fry`), 1000);
    });

/* getHen()
    .then(hen => getEgg(hen))
    .then(egg => cook(egg))
    .then(meal => console.log(meal)); */
// 아래와 같이 사용해도 됨
getHen()
    .then(getEgg)
    .catch(error => {
        return 'bread';
    })
    .then(cook)
    .then(console.log)
    .catch(console.log);