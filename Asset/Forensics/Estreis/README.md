# Estreis

> Write-up author : jon-brandy | Q

## DESKRIPSI:
My friend had executed an strace command in our server whilst I was editing a CTF challenge there. Can you trace the output and find the flag for me?

[FILE](https://github.com/jon-brandy/COMPFEST14-BAY-WU/blob/f2c67b30aa30d83b965e480aeedf72d55707d18f/Asset/Forensics/Estreis/chall.zip)

## LANGKAH-LANGKAH
1. Pertama, unduh file `.zip` yang telah diberikan.
2. Lalu unzip file tersebut dengan command -> `unzip chall.zip`.

> HASIL

![image](https://user-images.githubusercontent.com/70703371/186599796-81ca60e1-5d5e-4951-9d8d-b9f90db21a27.png)

3. Pada file `soal.txt` saya melakukan teknik forensics sederhana yaitu menggunakan fungsi `grep`.

> COMMAND

```
strings soal.txt | grep COMPFEST14
```

> HASIL

![image](https://user-images.githubusercontent.com/70703371/186602982-f49f8acd-68a2-4072-8d57-e4f55b3c51df.png)

4. Nampaknya flag tidak dalam bentuk utuh, maka dari itu saya membuka file `soal.txt`.
5. Diketahui terdapat suatu pola unik.

![image](https://user-images.githubusercontent.com/70703371/186603219-bbd7c8c8-b5c9-45f1-a6ca-28659a9de802.png)

6. Arti dari `\33` menandakan karakter terseleksi dan untuk `\10` menandakan karakter akan mengalami perubahan.
7. Pada gambar di atas, karakter yang terseleksi adalah `_st` namun pada karakter `t` mengalami perubahan, sehingga hasil adalah sebagai berikut:

![image](https://user-images.githubusercontent.com/70703371/186603486-0bdcc4d6-1cda-4607-9aeb-8a2a4dcaf07d.png)

8. Menjadi karakter `T`
9. Pola ini saya perhatikan terus menerus sehingga flag menjadi satu kesatuan utuh.


## FLAG

```
COMPFEST14{J4NgaN_LUpA_M4Ti!n_sTRacE_nYa_ya_h3h3_c604dede56}
```


