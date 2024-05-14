<?php

include "koneksi.php"; // You're including the 'koneksi.php' file.

// Check connection
if ($koneksi->connect_error) { // If there's a connection error...
  die("Connection failed: " . $koneksi->connect_error); // ...stop the script and print an error message.
}

if ($_SERVER["REQUEST_METHOD"] == "POST") { // If the request method is POST...
  $nama = $_POST["nama"]; // ...get the 'nama' value from the POST data...
  $nomor = $_POST["nomor"]; // ...and so on for the other values.
  $kopi = $_POST["kopi"];
  $beli = $_POST["beli"];
  $alamat = $_POST["alamat"];
  $harga = $beli * 20000;

  $sql = "INSERT INTO menu (Nama, NomorHP, Kopi, JumlahBeli, Alamat, Harga)
VALUES ('$nama', '$nomor', '$kopi', '$beli', '$alamat', '$harga')";

  if ($koneksi->query($sql) === TRUE) { // If the query is successful...
    echo "New record created successfully"; // ...print a success message.
  } else { // If the query is not successful...
    echo "Error: " . $sql . "<br>" . $koneksi->error; // ...print an error message.
  }
}

$koneksi->close(); // Close the connection.
?>
