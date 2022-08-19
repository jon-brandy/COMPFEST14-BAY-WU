# Binary Pin

> Write-up author: jon-brandy (SOLVED)

## DESKRIPSI:
Ten digits pin is so troublesome. So I made a safe with only two digits pin.

[FILE]()

## HINT:
1. Sometimes we don't have to know how the function works.

## LANGKAH-LANGKAH:
1. Pertama, unduh file `.jar` yang diberikan.
2. Lalu saya menggunakan [online]() tools untuk melakukan *decompile*.
3. Di dapat terdapat 4 file `.class`, lalu saya mengubah keempat file tersebut menjadi `.java`.

> Binarypin.java

```java

import java.awt.LayoutManager;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JFrame;

// 
// Decompiled by Procyon v0.5.36
// 

public class Binarypin
{
    private JFrame frame;
    private JLabel output;
    
    Binarypin() {
        this.frame = new JFrame("Binary Pin");
        (this.output = new JLabel()).setBounds(20, 250, 360, 20);
        final JLabel comp = new JLabel("Your data:");
        comp.setBounds(20, 235, 100, 20);
        this.frame.add(comp);
        this.frame.add(this.output);
        this.frame.add(new PinButton(this, "0", 43, 10, 150, 150));
        this.frame.add(new PinButton(this, "1", 198, 10, 150, 150));
        this.frame.add(new ResetButton(this, 43, 165, 305, 50));
        this.frame.setSize(400, 350);
        this.frame.setLayout(null);
        this.frame.setVisible(true);
        this.frame.setDefaultCloseOperation(3);
    }
    
    public static void main(final String[] array) {
        new Binarypin();
    }
    
    public void clearOutput() {
        this.output.setText("");
    }
    
    public void updateOutput() {
        this.output.setText(Secret.getInstance().getData());
    }
}

```

> PinButton.java

```java


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// 
// Decompiled by Procyon v0.5.36
// 

class PinButton extends JButton implements ActionListener
{
    Binarypin app;
    
    PinButton(final Binarypin app, final String text, final int x, final int y, final int width, final int height) {
        super(text);
        this.app = app;
        this.addActionListener(this);
        this.setBounds(x, y, width, height);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        Secret.getInstance().process(this.getText().charAt(0));
        this.app.updateOutput();
    }
}


```

> Secret.java

```java


// 
// Decompiled by Procyon v0.5.36
// 

class Secret
{
    private int cnt;
    private int[] box;
    private int[] mydata;
    private static Secret instance;
    
    private Secret() {
        this.cnt = 1;
        this.mydata = new int[] { 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 1, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 1, 1, 0, 1, 1, 0, 0, 1, 1, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 1, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 0, 1, 0, 0, 1, 0, 0, 1, 1, 1, 0, 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 0, 1, 0, 1, 0, 0, 0, 1, 1, 1, 1, 1, 0, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1, 1, 1, 0, 1, 0, 1, 0, 0, 1, 1, 0, 1, 0, 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 1, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 0 };
        this.box = new int[this.mydata.length / 9];
    }
    
    public static Secret getInstance() {
        return Secret.instance;
    }
    
    public void resetInstance() {
        Secret.instance = new Secret();
    }
    
    public void process(final char c) {
        if (this.cnt > 9) {
            return;
        }
        for (int n = this.mydata.length / 9, i = 1; i <= n; ++i) {
            final int n2 = 9 * i - this.cnt;
            final int n3 = this.box[i - 1] + this.mydata[n2] + (c - '0');
            this.mydata[n2] = n3 % 2;
            if (n3 >= 2) {
                this.box[i - 1] = 1;
            }
            else {
                this.box[i - 1] = 0;
            }
        }
        ++this.cnt;
    }
    
    private String misteri(int i) {
        String s = "";
        int n = 0;
        int n2 = 1;
        while (i > 0) {
            n |= (i & 0x1) << n2 % 8 - 1;
            i >>= 1;
            if (n2 % 8 == 0) {
                if (32 <= n && n < 128) {
                    s = invokedynamic(makeConcatWithConstants:(CLjava/lang/String;)Ljava/lang/String;, (char)n, s);
                }
                n = 0;
            }
            ++n2;
        }
        return invokedynamic(makeConcatWithConstants:(CLjava/lang/String;)Ljava/lang/String;, (char)n, s);
    }
    
    public String getData() {
        final int n = this.mydata.length / 9;
        String s = "";
        int i = 5;
        int n2 = 0;
        for (int j = 1; j <= n; ++j) {
            int n3 = 0;
            int n4 = 1;
            for (int k = 1; k <= 8; ++k) {
                n3 += this.mydata[9 * j - k] * n4;
                n4 <<= 1;
            }
            --i;
            n2 += (int)((n3 - 33) * Math.pow(85.0, i));
            if (i == 0) {
                s = invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, s, this.misteri(n2));
                n2 = 0;
                i = 5;
            }
        }
        while (i > 0) {
            n2 += (int)(84.0 * Math.pow(85.0, --i));
        }
        return invokedynamic(makeConcatWithConstants:(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;, s, this.misteri(n2));
    }
    
    static {
        Secret.instance = new Secret();
    }
}


```

> ResetButton.java

```java


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

// 
// Decompiled by Procyon v0.5.36
// 

class PinButton extends JButton implements ActionListener
{
    Binarypin app;
    
    PinButton(final Binarypin app, final String text, final int x, final int y, final int width, final int height) {
        super(text);
        this.app = app;
        this.addActionListener(this);
        this.setBounds(x, y, width, height);
    }
    
    @Override
    public void actionPerformed(final ActionEvent actionEvent) {
        Secret.getInstance().process(this.getText().charAt(0));
        this.app.updateOutput();
    }
}


```

4. Berdasarkan keempat file `java` tersebut.
5. Saya menemukan hal yang unik pada file `Secret.java`, nampaknya kita harus memasukan binary strings (9 bit).
6. Maka dari saya menggunakan sebuah skrip `python` dengan memanfaatkan library **pyautogui**.

> SCRIPT EKSEKUSI

```py
import pyautogui
import time
inputs = [...]
f = open("idx.txt")
idx = int(f.read())
f.close()
print(idx)
pyautogui.moveTo(192, 370) # tombol reset
pyautogui.click()

string = inputs[idx]
for i in string:
    if i == '0':
        pyautogui.moveTo(100, 231) # tombol 0
        pyautogui.click()
    elif i == '1':
        pyautogui.moveTo(250, 231) # tombol 1
        pyautogui.click()

f = open("idx.txt", "w")
f.write(str(idx + 1))
f.close()
```

> SCRIPT MENDAPATKAN POSISI (COORDINATES)

```py
import pyautogui, sys
print('Press Ctrl-C to quit.')
try:
    while True:
        x, y = pyautogui.position()
        positionStr = 'X: ' + str(x).rjust(4) + ' Y: ' + str(y).rjust(4)
        print(positionStr, end='')
        print('\b' * len(positionStr), end='', flush=True)
except KeyboardInterrupt:
    print('\n')
```

7. Pertama jalankan *script* coordinates sembari juga menjalankan `Binarypin.jar`.

> NOTES

```
Jalankan -> chmod +x Binarypin.jar | Dengan tujuan membuat Binarypin.jar executeable.
```

8. Arahkan `button 0`, `button 1`, dan `button reset` untuk mendapatkan koordinatnya.

![Screenshot_2022-08-19_12_44_20](https://user-images.githubusercontent.com/70703371/185551369-086f4e47-3b28-46af-bf05-b794ea43c6c7.png)

9. Lalu isi semua koordinat dari setiap `button` ke dalam skrip python yg satunya.
10. Tidak lupa untuk membuat file `idx.txt` yang berisikan angka `0` saja.
11. Selanjutnya paste strings biner ke dalam variable `inputs`.

> CONTOH:

![image](https://user-images.githubusercontent.com/70703371/185551592-c08db2f6-1017-4de7-a813-afd7bcb6d207.png)

12. Namun dikarenakan dibutuhkan kombinasi 9 digit angka sebanyak 1024 kombinasi atau 2^9.
13. Maka dari itu saya membuat skrip kombinasi sebagai berikut:

```py
from itertools import chain, product
def bruteforce(charset, maxlength):
    return (''.join(candidate)
        for candidate in chain.from_iterable(product(charset, repeat=i)
        for i in range(9, maxlength + 1)))

print(list(bruteforce('01', 9)))
```

> HASIL

![image](https://user-images.githubusercontent.com/70703371/185551865-fd4d0bb3-253d-44da-8719-fd7da97f1db3.png)

14. Setelah melakukan bruteforcing satu satu dengan menggunakan skrip `eksekusi`.
15. Diketahui flag berada pada strings biner -> `010110100`.

> HASIL

![image](https://user-images.githubusercontent.com/70703371/185552028-25678cff-abea-4b6c-b62e-03d8b6fff5eb.png)

16. Flag di dapat!

## FLAG

```
COMPFEST14{bRutefoRc3_1s_e4zY_Af_6965d74c2e}
```


## REFERENCES:

```
https://pypi.org/project/PyAutoGUI/
https://github.com/raphael-lesmana (MY MASTER)
```

