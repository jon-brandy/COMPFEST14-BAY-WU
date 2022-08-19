

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

