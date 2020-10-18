// async & await
// clear style of using promise

// 1. async
async function fetchUser() {
    return 'ellie';
}

const user = fetchUser();
user.then(console.log);

// 2. await
function delay(ms) {
    return new Promise(resolve => setTimeout(resolve, ms));
}

async function getApple() {
    await delay(2000);
    if (Math.random() > 0.5)
        throw 'error';
    else
        return 'apple';
}

async function getBanana() {
    await delay(1000);
    return 'banana';
}
/* function getBanana() {
    return delay(1000)
    .then(() => 'banana');
} */
/* function getBanana() {
    return new Promise((resolve, reject) => {
        setTimeout(() => {
            resolve('banana');
        }, 1000);
    });
} */

/* function pickFruits() {
    return getApple().then(apple => {
        return getBanana().then(banana => `${apple} + ${banana}`);
    });
} */
/* async function pickFruits() {
    let apple, banana;
    try {
        apple = await getApple();
        banana = await getBanana();
    } catch (e) {
        console.log(e);
    } 
    return `${apple} + ${banana}`;
}
pickFruits().then(console.log); */

// 병렬로 처리하고 싶으면
async function pickFruitsParallelly() {
    let apple, banana;
    try {
        let applePromise = getApple();
        let bananaPromise = getBanana();
        apple = await applePromise;
        banana = await bananaPromise;
    } catch (e) {
        console.log(e);
    } 
    return `${apple} + ${banana}`;
}
pickFruitsParallelly().then(console.log);

// 3. Useful Promise API's
function pickAllFruits() {
    return Promise.all([getApple(), getBanana()])
            .then(fruits => fruits.join(' + ')
            );
}
pickAllFruits() //
    .then(console.log)
    .catch(console.log);

function pickFirstFruit() {
    return Promise.race([getApple(), getBanana()]);
}
pickFirstFruit().then(console.log);