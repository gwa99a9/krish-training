const readline = require('readline');

const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

rl.question('Please enter the number series to find the 3rd largest number, Please use , as the delimiter - ', (data) => {
    const splitString = data.split(",").sort();
    console.log(`3rd largest number in this series is ${splitString[splitString.length - 3]}`)
    rl.close()
});