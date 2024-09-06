/************************ boolean */
let isDone: boolean = true;
isDone = false;
console.log(typeof isDone);

let wrapper: Boolean = true;		// Wrapper class, primitive type과는 다르다

/************************ number */
let power: number = 10;
let base: number = 2;
console.log(base ** power);			// ES2016 부터 사용가능, 이전에는 Math.pow(2, 10)

const binary: number = 0b110100100;
const octal: number = 0o644;
const hexa: number = 0x1a4;
const notANumber: number = NaN;
const underScoreNum: number = 1_000_000;
console.log(binary, octal, hexa, notANumber, underScoreNum);

/************************ string */
let myName: string = 'James';
myName = "Maria";

/************************ symbol */
// 프리미티브 타입의 값을 담아서 사용
// 고유하고 수정불가능한 값으로 만들어줌
// 주로 접근을 제어하는데 많이 사용
console.log(typeof Symbol('foo'), Symbol('foo'));
console.log(Symbol('foo') === Symbol('foo'));			// false

/************************ undefined, null */
let u: undefined = undefined;
let n: null = null;
// let num: number = u;			// strictNullChecks option을 사용하면 number type에 undefined나 null을 할당할 수 없음
