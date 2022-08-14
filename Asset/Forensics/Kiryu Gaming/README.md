# Kiryu Gaming

> Write-up author: jon-brandy (SOLVED)

## DESKRIPSI:
Kiryu is trying his new purple gaming lamp in his room. What do you think?
[FILE](https://github.com/jon-brandy/COMPFEST14-BAY-WU/blob/9d6344e6648de4c4c77a170854e8fed48d8ab45c/Asset/Forensics/Kiryu%20Gaming/chall.png)
## LANGKAH-LANGKAH
1. Download file yang telah diberikan.
2. Diketahui file yang diberikan merupakan sebuah gambar dalam format `.png` dan file tersebut tidak memiliki header yang corrupt (dapat dibuka).
3. Pada mulanya saya menggunakan `stegsolve.jar` untuk mengganti bit plane gambar.
4. Saat mengganti pada colour inversion Xor, jika diperhatikan sepertinya terdapat sebuah text yang memutari kepala orang yang terdapat di gambar.

![image](https://user-images.githubusercontent.com/70703371/184531849-a6ac0d07-2dd8-458a-b66b-e4ee4a96c8a5.png)

![image](https://user-images.githubusercontent.com/70703371/184531858-0c120750-54d8-4666-854f-8446e65edacb.png)

5. Namun string yang mampu terlihat oleh mata hanyalah `COMPFEST`.
6. Lalu saya melakukan konversi bit plane menjadi `blue plane 3`.

![image](https://user-images.githubusercontent.com/70703371/184531910-66aaaa82-f73a-4694-81e7-6ae0f9b8f911.png)

7. Flag pun di dapat!

```
COMPFEST14{K1rYU_teCH_tIPs_e7cfef1847}
```
