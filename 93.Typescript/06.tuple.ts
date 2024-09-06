let x: [string, number] = ['James', 29];
console.log(typeof x);
console.log(x[0], x[1]);

const person: [string, number] = ['James', 29];
const [personName, age] = person;			// destructuring, 구조분해 할당
console.log(personName, age);
