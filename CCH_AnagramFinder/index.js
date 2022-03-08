console.log('Enter two check those words are Anagram.')
let rawString = 'act cap'
const rawSplit = rawString.split(' ')

const word1 = Array.from(rawSplit[0]).sort();
const word2 = Array.from(rawSplit[1]).sort();

console.log(JSON.stringify(word1) === JSON.stringify(word2));

let rawInt = [12, 43, 565, 21, 555, 677].sort();
console.log(rawInt[rawInt.length - 3]);