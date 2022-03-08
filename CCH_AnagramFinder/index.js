
const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Enter two words to check if they are Anagram.Please use : as delimiter - ', (data) => {
    const rawString = data.toLowerCase().replace(/ /g, '');
    const rawSplit = rawString.split(':')
    const word1 = Array.from(rawSplit[0]).sort().join('')
    const word2 = Array.from(rawSplit[1]).sort().join('')
    if (word1 === word2) {
        console.log(`${word1} and ${word2} are anagram words.`);
    } else {
        console.log('These two words are not anagram.');
    }
    rl.close();
});