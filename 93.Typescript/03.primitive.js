"use strict";
/************************ boolean */
let isDone = true;
isDone = false;
console.log(typeof isDone);
let wrapper = true; // Wrapper class, primitive type과는 다르다
/************************ number */
let power = 10;
let base = 2;
console.log(base ** power); // ES2016 부터 사용가능, 이전에는 Math.pow(2, 10)
const binary = 0b110100100;
const octal = 0o644;
const hexa = 0x1a4;
const notANumber = NaN;
const underScoreNum = 1000000;
console.log(binary, octal, hexa, notANumber, underScoreNum);
/************************ string */
let myName = 'James';
myName = "Maria";
/************************ symbol */
// 프리미티브 타입의 값을 담아서 사용
// 고유하고 수정불가능한 값으로 만들어줌
// 주로 접근을 제어하는데 많이 사용
console.log(typeof Symbol('foo'), Symbol('foo'));
console.log(Symbol('foo') === Symbol('foo')); // false
/************************ undefined, null */
let u = undefined;
let n = null;
// let num: number = u;			// strictNullChecks option을 사용하면 number type에 undefined나 null을 할당할 수 없음
