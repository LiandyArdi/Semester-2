<?php

ob_start();

session_start();

include "koneksi.php";

if ($koneksi->connect_error) {
  die("Connection failed: " . $koneksi->connect_error); 
}

if ($_SERVER["REQUEST_METHOD"] == "POST") {
  $nama = $_POST["nama"]; 
  $nomor = $_POST["nomor"]; 
  $kopi = $_POST["kopi"];
  $beli = $_POST["beli"];
  $alamat = $_POST["alamat"];
  $harga = $beli * 20000;

  $sql = "INSERT INTO menu (nama, nomor, kopi, beli, alamat, harga)
VALUES ('$nama', '$nomor', '$kopi', '$beli', '$alamat', '$harga')";

  if ($koneksi->query($sql) === TRUE) { 
    echo "<script>
            var win = window.open('', '_blank');
            win.document.write('<html><head><title>Payment</title><link rel=\"stylesheet\" href=\"https://fonts.googleapis.com/css2?family=Poppins&display=swap\"><style>body {display: flex; flex-direction: column; justify-content: center; align-items: center; height: 100vh; font-family: Poppins, sans-serif;}</style></head><body><h1>Total pembayaran Anda adalah Rp. $harga</h1><img src=\"bayar/gopay.jpg\" alt=\"Payment\" style=\"width:500px;height:500px;\"></body></html>');
          </script>";
  } else { 
    echo "Error: " . $sql . "<br>" . $koneksi->error; 
  }
}

$koneksi->close(); 

ob_end_flush(); 

?>








<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <title>Kopi & Co</title>

    <!-- Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Poppins:ital,wght@0,100;0,300;0,400;0,700;1,700&display=swap"
      rel="stylesheet"
    />

    <!-- Feather Icons -->
    <script src="https://unpkg.com/feather-icons"></script>

    <!-- My Style -->
    <link rel="stylesheet" href="css/style.css" />
  </head>

  <body>
    <!-- NAVBAR START -->
    <nav class="navbar">
      <img src="menu/Moreauo.png" class="image-logo" width="7%" height="7%">
      <a href="#" class="navbar-logo"> Moreauo<span>Coffee </span></a>

      <div class="navbar-nav">
        <a href="#home">Home</a>
        <a href="#about">Tentang Kami</a>
        <a href="#menu">Menu</a>
        <a href="#contact">Kontak</a>
      </div>

      <div class="navbar-extra">
        <!-- <a href="#" id="search"><i data-feather="search"></i></a> -->
        <a href="#contact" id="shop"><i data-feather="shopping-cart"></i></a>
        <a href="#" id="hamburger-menu"><i data-feather="menu"></i></a>
      </div>

    
    </nav>
    <!-- NAVBAR END -->

    <!-- Hero Section start -->
    <section class="hero" id="home">
      <main class="content">
        <h1>Mari Nikmati Secangkir <span>Kopi</span></h1>
        <p>Moreauo Coffee Selalu Menemani Harimu</p>
        <a href="#contact" class="cta">Beli Sekarang</a>
      </main>
    </section>
    <!-- Hero Section end -->

    <!-- About Section start -->
    <section id="about" class="about">
      <h2><span>Tentang</span> Kami</h2>

      <div class="row">
        <div class="about-img">
          <img src="img/tentangkami.jpg" alt="Tentang Kami" />
        </div>
        <div class="content">
          <h3>Kenapa Memilih Kopi Kami?</h3>
          <p>
            Kopi Kami merupakan resep yang sudah lama diturun temurunkan dari
            generasi ke generasi
          </p>
          <p>
            Kami Menggunakan Biji Kopi pilhan terbaik dari petani lokal
            Indonesia yang kualitasnya sudah berskala Internasional
          </p>
        </div>
      </div>
    </section>
    <!-- About Section end -->

    <!-- Menu Section start -->
    <section id="menu" class="menu">
      <h2><span>Menu</span> Kami</h2>
      <p>Our Favorite Choice</p>

      <div class="row">
        <div class="menu-card">
          <img
            src="menu/latte.jpg"
            width="70%"
            height="90%"
            alt="Latte"
            class="menu-card-img"
          />
          <h3 class="menu-card-title">- Latte (Hot/Cold) -</h3>
          <p class="menu-card-price">IDR 20k</p>
        </div>
        <div class="menu-card">
          <img
            src="menu/espresso.jpg"
            width="70%"
            height="90%"
            alt="Latte"
            class="menu-card-img"
          />
          <h3 class="menu-card-title">- Espresso (Hot/Cold) -</h3>
          <p class="menu-card-price">IDR 20k</p>
        </div>
        <div class="menu-card">
          <img
            src="menu/mocca.jpg"
            width="70%"
            height="90%"
            alt="Latte"
            class="menu-card-img"
          />
          <h3 class="menu-card-title">- Mocca (Hot/Cold) -</h3>
          <p class="menu-card-price">IDR 20k</p>
        </div>
        <div class="menu-card">
          <img
            src="menu/cappuccino.jpg"
            width="70%"
            height="90%"
            alt="Latte"
            class="menu-card-img"
          />
          <h3 class="menu-card-title">- Cappuccino (Hot/Cold) -</h3>
          <p class="menu-card-price">IDR 20k</p>
        </div>
        <div class="menu-card">
          <img
            src="menu/caramelmacchiato.jpg"
            width="70%"
            height="94%"
            alt="Latte"
            class="menu-card-img"
          />
          <h3 class="menu-card-title">- Caramel Macchiato (Cold) -</h3>
          <p class="menu-card-price">IDR 20k</p>
        </div>
      </div>
    </section>
    <!-- Menu Section end -->

    <!-- Pembayaran start -->
    <div class="container-content">
      <form action="" method="post">
          
      <table class="a-content">
          <caption> Moreauo <span class="delivery">Delivery</span> </caption>
          <tr>
              <td width="120"> Nama </td>
              <td> <input class="pilih_kopi" type="text" name="nama"> </td>
          </tr>
          <tr>
              <td> Nomor HP</td>
              <td> <input class="pilih_kopi" type="text" name="nomor"> </td>
          </tr>
          <tr>
              <td width="130">Pilih Kopi</td>
              <td><select class="pilih_kopi" name='kopi'>
                <option value='Latte'>Latte</option>
                <option value='Espresso'>Espresso</option>
                <option value='Mocca'>Mocca</option>
                <option value='Cappuccino'>Cappuccino</option>
                <option value='caramelmacchiato'>Caramel Macchiato</option>
                </select></td>
          </tr>
          <tr>
              <td width="130">Jumlah Beli</td>
              <td><input class="pilih_kopi" type="number" name="beli"></td>
          </tr>
          <tr>
              <td width="130">Alamat</td>
              <td><input class="pilih_kopi" type="text" name="alamat"</td>
          </tr>
          <tr>
              <td width="130"><input type="submit" name="proses" value="Simpan">
              <input type="reset" value="Reset"></td>
          </tr>
      </table>
              </a>
              </div>
              
      <!-- Pembayaran end -->
    

  
 

<!-- Contact Section start -->
<section id="contact" class="contact">
  <h2><span>Kontak</span> Kami</h2>
Whatsapp : 08161395395 <h2><span>Kontak</span> Kami</h2>
Instagram : @MoreauoCoffee.
</footer>
<!-- Footer end -->


    

    <!-- Feather Icons -->
    <script>
      feather.replace();
    </script>

    <!-- My Javascript -->
    <script src="js/script.js"></script>
  </body>
</html>



