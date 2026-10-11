const nim: string = "052664742";

console.log("===Soal 1===");

const tinggi: number = Number(nim.slice(-1));

for (let i = 1; i <= tinggi; i++) {
    let baris: string = "";

    for (let j = 1; j <= i; j++) {
        baris += j + " ";
    }

    console.log(baris.trim());
}

console.log("\n=== SOAL 2 ===");

const awal: number = Number (nim.slice(-2));
const beda: number = Number(nim.slice(-3, -2)) + 1;

let deret: number[] = [];

for (let i = 0; i < 10; i++) {
    deret.push(awal + i * beda);
}

console.log(deret.join(", "));

console.log("\n=== SOAL 3 ===");

const batas: number = Number(nim.slice(-2)) + 10;

let bilanganPrima: number[] = [];

for (let angka = 2; angka <= batas; angka++) {
    let prima: boolean = true;

    for (let pembagi = 2; pembagi < angka; pembagi++) {
        if (angka % pembagi === 0) {
            prima = false;
            break;
        }
    }

    if (prima) {
        bilanganPrima.push(angka);
    }
}

console.log(bilanganPrima.join(", "));