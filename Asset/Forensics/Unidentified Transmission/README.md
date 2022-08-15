# Unidentified Transmission
## DESKRIPSI:
I heard some eerie noises when I was streaming. I wonder what it is

[FILE](https://github.com/jon-brandy/COMPFEST14-BAY-WU/blob/6aff52a58eb10fc69f69ec63b1316c1a6ebbeea5/Asset/Forensics/Unidentified%20Transmission/transmission.tar.xz)

## HINTS:
1. For a while, I thought that the sound is particularly similar to the ones from amateur radio operator.
2. In fact, there's a rumour that those signals were used to transmit a static pictures to the recipient.
## LANGKAH-LANGKAH
1. Pertama, unduh file `.xz` yang diberikan.
2. Lalu decompress file tersebut dengan menjalankan command berikut -> `unxz transmission.tar.xz`.
3. Di dapat isi file adalah `transmission.tar`.
4. Selanjutnya extract file `.tar` dengan menjalankan command -> `tar -x -f transmission.tar`.
5. Di dapat isi file merupakan file `.pcap`.
6. Lalu saya menggunakan wireshark untuk melihat" packet.

> Wireshark

![image](https://user-images.githubusercontent.com/70703371/184568860-4f62f84d-9b5a-4a2e-9549-60897dbde1e0.png)

7. Setelah melihat", saya melihat protocol yang unik bernama `RTCP`.

![image](https://user-images.githubusercontent.com/70703371/184569017-6c2bb399-1a7d-4533-a4d7-e920cfae0466.png)


> NOTES

```
Real-Time Transport Control Protocol (RTCP) is a protocol that works with Real-Time Protocol (RTP) 
to monitor data delivery on large multicast networks.
```

8. Nampaknya pada protocol RTCP ini, terdapat data UDP yang terbilang uncommon atau tidak dapat teridentifikasi.

![image](https://user-images.githubusercontent.com/70703371/184569135-1b713bd3-d709-4fd2-9c73-81884d7595ce.png)

9. Maka dari itu saya mencoba untuk melakukan *decoding* pada udp.data sebelum protokol RTCP.

![image](https://user-images.githubusercontent.com/70703371/184569226-3033fef5-3ef4-4f31-913b-fd6b79bcaf81.png)

10. Tahapan decoding:

> Klik kanan -> decode As

![image](https://user-images.githubusercontent.com/70703371/184569269-1a4d5dc7-5a60-449e-9634-6d133eb436a1.png)

> Ubah value dari current menjadi RTP

![image](https://user-images.githubusercontent.com/70703371/184569310-97e29704-e957-4efa-bd97-7c3081718e36.png)

![image](https://user-images.githubusercontent.com/70703371/184569334-9a64640f-32dd-4b9b-aca8-2462509eafd2.png)

11. *Decoding* berhasil dilakukan.

![image](https://user-images.githubusercontent.com/70703371/184569384-c0a179cd-2627-42d2-93fe-5d1d37e3848b.png)

12. Lalu, diketahui packet merupakan sebuah audio.

![image](https://user-images.githubusercontent.com/70703371/184569428-ae7197fc-1d57-460e-b528-fa68d04d45dd.png)

13. Maka kita dapat mendengarkan audio tersebut dengan melakukan tahapan sebagai berikut:

> Telephony -> RTP -> RTP Stream Analysis

![image](https://user-images.githubusercontent.com/70703371/184569528-c898a7e7-c68b-420c-839c-251f2427ded5.png)

> HASIL

![image](https://user-images.githubusercontent.com/70703371/184569576-bbb6c3a1-e837-4153-b9f7-a98a4d08ea08.png)

14. Buka tab `graph`, lalu tekan tombol `Play Streams`.

![image](https://user-images.githubusercontent.com/70703371/184569625-bd7b494f-04d1-41ed-9592-ca633bd587d1.png)

15. Tekan button `play` pada bagian pojok kiri bawah.

![image](https://user-images.githubusercontent.com/70703371/184569657-61e1b0ce-1bc1-415d-b479-6dfe8bfb18a3.png)

16. After hearing the [audio](https://github.com/jon-brandy/COMPFEST14-BAY-WU/blob/c92e130f45de3ee219bbbac7fcf5edf04b2ea129/Asset/Forensics/Unidentified%20Transmission/foren.wav), based on the hint number 1 & 2, this might be a signals used to transmit data/pictures from moon landing to earth.



## REFERENCES

```
https://en.m.wikipedia.org/wiki/RTP_Control_Protocol
```
