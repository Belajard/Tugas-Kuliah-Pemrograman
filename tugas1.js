var nim = "052664742";
console.log("===Soal 1===");
var tinggi = Number(nim.slice(-1));
for (var i = 1; i <= tinggi; i++) {
    var baris = "";
    for (var j = 1; j <= i; j++) {
        baris += j + " ";
    }
    console.log(baris.trim());
}
console.log("\n=== SOAL 2 ===");
var awal = Number(nim.slice(-2));
var beda = Number(nim.slice(-3, -2)) + 1;
var deret = [];
for (var i = 0; i < 10; i++) {
    deret.push(awal + i * beda);
}
console.log(deret.join(", "));
console.log("\n=== SOAL 3 ===");
var batas = Number(nim.slice(-2)) + 10;
var bilanganPrima = [];
for (var angka = 2; angka <= batas; angka++) {
    var prima = true;
    for (var pembagi = 2; pembagi < angka; pembagi++) {
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
