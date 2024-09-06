/*
 * primitive type: number, string, boolean, bigint, symbol, null, undefinde
 *
 * object type: non-primitive type
 */

const person1 = { name: 'James', age: 24 };
console.log(typeof person1);

const person2 = Object.create({ name: 'James', age: 24 });
console.log(typeof person2);
